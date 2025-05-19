package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.component.UnderLineComponentWidget;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.LedgerItemWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MICustomButton;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MIFakeItemSlot;
import org.hiedacamellia.mystiasizakaya.common.menu.LedgerMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOnOpen;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

public class LedgerScreen extends AbstractContainerScreen<LedgerMenu> {


    private enum Page{
        LEDGER,
        MENU
    }

    private Page page = Page.LEDGER;
    private int iWidth;
    private int iHeight;
    private int tPos;
    private int lPos;

    //账单page
    private MICustomButton on_open;
    private MICustomButton changePage;
    private List<LedgerItemWidget> ledgerItemWidgets;
    private UnderLineComponentWidget balance;
    private UnderLineComponentWidget title;

    private List<AbstractWidget> renderables_ledger = new ArrayList<>();

    //菜单page
    private List<MIFakeItemSlot> fakeItemSlots = new ArrayList<>();

    private List<AbstractWidget> renderables_menu = new ArrayList<>();

    private boolean on_change = false;
    private float progress = 0;


    public LedgerScreen(LedgerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.iWidth = 120;
        this.iHeight = 166;
        this.imageWidth = 160;
        this.imageHeight = 166;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    }
    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    }
    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    protected void renderBackground(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.enableBlend();
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos-1, this.tPos-1, this.iWidth, this.iHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos+1, this.tPos+1, this.iWidth, this.iHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos, this.tPos, this.iWidth, this.iHeight, 0.05f, 0xFFc6c6c6);
        pose.translate(this.lPos+ (float) iWidth /2, this.tPos, 0);
        pose.mulPose(new Quaternionf().rotationY(Mth.DEG_TO_RAD*180));
        pose.translate(-this.lPos- (float) iWidth /2, -this.tPos, 0);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos-1, this.tPos-1, this.iWidth, this.iHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos+1, this.tPos+1, this.iWidth, this.iHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.lPos, this.tPos, this.iWidth, this.iHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
        pose.popPose();
    }

    public void tryAccept(ItemStack itemStack){
        if(page==Page.MENU){
            for(MIFakeItemSlot fakeItemSlot : fakeItemSlots){
                if(fakeItemSlot.isHovered()){
                    fakeItemSlot.setItemStack(itemStack);
                }
            }
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        this.renderBackground(guiGraphics,partialTick, mouseX, mouseY);

        if(page == Page.MENU || on_change){
            for(Renderable renderable : this.renderables_menu) {
                renderable.render(guiGraphics, mouseX, mouseY, partialTick);
            }
        }

        pose.translate(0, 0, 100);
        onchange(partialTick);
        pose.translate(this.leftPos, this.topPos, 0);
        pose.mulPose(new Quaternionf().rotationX(-0.1f*progress/180));
        pose.mulPose(new Quaternionf().rotationY(Mth.DEG_TO_RAD*progress));
        pose.translate(-this.leftPos, -this.topPos, 0);
        this.renderBackground(guiGraphics,partialTick, mouseX, mouseY);

        for(Renderable renderable : this.renderables_ledger) {
            renderable.render(guiGraphics, mouseX, mouseY, partialTick);
        }

        if(page == Page.LEDGER || on_change)
            on_open.render(guiGraphics, mouseX, mouseY, partialTick);

        pose.popPose();
        pose.pushPose();

        pose.translate(0, 0, 100);
        title.render(guiGraphics, mouseX, mouseY, partialTick);
        changePage.render(guiGraphics, mouseX, mouseY, partialTick);
        pose.popPose();

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private void onchange(float partialTick){
        float realtimeDeltaTicks = Minecraft.getInstance().getTimer().getRealtimeDeltaTicks();
        if(on_change){
            progress+= (page == Page.LEDGER ? realtimeDeltaTicks : -realtimeDeltaTicks)*8;
            if(progress>180 && page == Page.LEDGER){
                progress = 180;
                on_change = false;
                page = Page.MENU;
            }
            if(progress < 0 && page == Page.MENU){
                progress = 0;
                on_change = false;
                page = Page.LEDGER;
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean v = super.mouseClicked(mouseX, mouseY, button);
        if(page==Page.MENU){
            for(MIFakeItemSlot fakeItemSlot : fakeItemSlots){
                boolean b = fakeItemSlot.mouseClicked(mouseX, mouseY, button);
                v = v || b;
            }
        }
        if(page==Page.LEDGER){
            boolean b = on_open.mouseClicked(mouseX, mouseY, button);
            v = v || b;
        }
        boolean b = changePage.mouseClicked(mouseX, mouseY, button);
        return v || b;
    }

    @Override
    public void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.lPos = centerX - this.imageWidth / 2;
        this.tPos = centerY - this.imageHeight / 2;
        LocalPlayer player = Minecraft.getInstance().player;

        changePage = new MICustomButton.builder(Component.literal("翻页"), e -> {
            on_change = true;
        }).pos(this.lPos + iWidth + 10, this.tPos + iHeight - 16 ).size(22, 16).build();

        on_open = new MICustomButton.builder(getComponent(player.getData(MIAttachment.MI_ON_OPEN).open()), e ->{
            MystiasIzakaya.LOGGER.debug("on_open: "+player.getData(MIAttachment.MI_ON_OPEN).open());
            boolean open = player.getData(MIAttachment.MI_ON_OPEN).open();
            Debug.getLogger().debug("on_open: "+!open);
            player.setData(MIAttachment.MI_ON_OPEN,new MIOnOpen(!open));
            PacketDistributor.sendToServer(new MIOnOpen(!open));
            e.setMessage(getComponent(!open));
        }).pos(this.lPos+10,this.tPos+4).size(40,16).build();
        on_open.setTooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.ledger_ui.on_open")));

        ledgerItemWidgets = new ArrayList<>();
        MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
        for(int i = 0; i < miTurnover.k().size(); i++){
            LedgerItemWidget ledgerItemWidget = new LedgerItemWidget(this.lPos + 10, this.tPos + 20 + 14 * i, miTurnover.k().get(i), miTurnover.v().get(i));
            ledgerItemWidgets.add(ledgerItemWidget);
            renderables_ledger.add(ledgerItemWidget);
        }

        Component component = Component.translatable("gui.mystias_izakaya.balance").append(Component.literal(new java.text.DecimalFormat("#######")
                .format(BalanceUtil.getBalance(player))).append(Component.literal(" \u5186")));
        balance = new UnderLineComponentWidget(this.lPos+iWidth- font.width(component)-10, this.tPos +10, component);
        renderables_ledger.add(balance);

        Component titlec = Component.translatable("gui.mystias_izakaya.ledger_ui.ledger");
        title = new UnderLineComponentWidget(this.lPos + iWidth / 2 - font.width(titlec) / 2, this.tPos - 14, titlec);

        for (int i = 0; i < 8; i++) {
            MIFakeItemSlot fakeItemSlot = new MIFakeItemSlot(this.lPos + 10 + i * 18, this.tPos + 20, Component.empty());
            fakeItemSlots.add(fakeItemSlot);
            renderables_menu.add(fakeItemSlot);
        }
    }

    private Component getComponent(boolean open){
        if(open)
            return Component.translatable("gui.mystias_izakaya.ledger_ui.open");
        else
            return Component.translatable("gui.mystias_izakaya.ledger_ui.close");
    }
}
