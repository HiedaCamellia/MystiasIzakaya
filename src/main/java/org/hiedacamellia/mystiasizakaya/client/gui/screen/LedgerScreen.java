package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.component.UnderLineComponentWidget;
import org.hiedacamellia.immersiveui.client.gui.component.widget.toast.ComponentToastWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.LedgerItemWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MICustomButton;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MIFakeItemSlot;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MIFakeSlot;
import org.hiedacamellia.mystiasizakaya.common.menu.LedgerMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.core.network.OpenIzakayaBIMessage;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MITag;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class LedgerScreen extends AbstractContainerScreen<LedgerMenu> {


    private enum Page{
        LEDGER,
        MENU
    }

    private Page page = Page.LEDGER;
    private int imageWidth;

    private LedgerMenu menu;
    //账单page
    private MICustomButton on_open;
    private List<LedgerItemWidget> ledgerItemWidgets;
    private UnderLineComponentWidget balance;
    private UnderLineComponentWidget title;
    private ComponentToastWidget toastWidget;

    private List<AbstractWidget> renderables_ledger = new ArrayList<>();

    //菜单page
    private List<MIFakeItemSlot> fakeCuisinesSlots = new ArrayList<>();
    private List<MIFakeItemSlot> fakeBeveragesSlots = new ArrayList<>();

    private List<AbstractWidget> renderables_menu = new ArrayList<>();

    private boolean on_change = false;
    private float progress = 0;
    private boolean changed = false;

    public LedgerScreen(LedgerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.menu = menu;
        this.imageWidth = 120;
        this.imageHeight = 166;
    }

    @Override
    public void onClose() {
        if(changed){
            setChanged();
        }
        super.onClose();
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

    protected void renderPageBackground(GuiGraphics guiGraphics) {
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        pose.translate(this.leftPos+ (float) imageWidth /2, this.topPos, 0);
        pose.mulPose(new Quaternionf().rotationY(Mth.DEG_TO_RAD*180));
        pose.translate(-this.leftPos- (float) imageWidth /2, -this.topPos, 0);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
        pose.popPose();
    }

    public void tryAccept(ItemStack itemStack){
        boolean changed = false;
        if(page==Page.MENU){
            for(MIFakeItemSlot fakeItemSlot : fakeCuisinesSlots){
                if(fakeItemSlot.isHovered()){
                    if(itemStack.is(MITag.cuisinesKey)|| MICommonConfig.ENABLE_ALL_CUISINES.get()) {
                        fakeItemSlot.setItemStack(itemStack);
                        changed = true;
                    }
                }
            }
            for(MIFakeItemSlot fakeItemSlot : fakeBeveragesSlots){
                if(fakeItemSlot.isHovered()){
                    if(itemStack.is(MITag.beveragesKey)|| MICommonConfig.ENABLE_ALL_BEVERAGES.get()) {
                        fakeItemSlot.setItemStack(itemStack);
                        changed = true;
                    }
                }
            }
        }
        if(changed){
            setChanged();
        }
    }

    protected void setChanged(){
        List<String> cuisines = new ArrayList<>();
        List<String> beverages = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cuisines.add(BuiltInRegistries.ITEM.getKey(fakeCuisinesSlots.get(i).getItemStack().getItem()).toString());
            beverages.add(BuiltInRegistries.ITEM.getKey(fakeBeveragesSlots.get(i).getItemStack().getItem()).toString());
        }
        IzakayaMenu izakayaMenu = new IzakayaMenu(cuisines, beverages);
        MIPlayerUtil.setIzakayaMenu(minecraft.player, izakayaMenu);
        MIPlayerUtil.syncIzakayaMenu(minecraft.player);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        onchange();

        super.renderTransparentBackground(guiGraphics);

        this.renderPageBackground(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, partialTick);

        PoseStack pose = guiGraphics.pose();
        pose.pushPose();

        if(page == Page.MENU || on_change){
            for(Renderable renderable : this.renderables_menu) {
                renderable.render(guiGraphics, mouseX, mouseY, partialTick);
            }
        }

        pose.translate(0, 0, 1000);
        pose.translate(this.leftPos, this.topPos, 0);
        pose.mulPose(new Quaternionf().rotationX(-0.1f*progress/180));
        pose.mulPose(new Quaternionf().rotationY(Mth.DEG_TO_RAD*progress));
        pose.translate(-this.leftPos, -this.topPos, 0);
        this.renderPageBackground(guiGraphics);


        if(page == Page.LEDGER || on_change) {
            for(Renderable renderable : this.renderables_ledger) {
                renderable.render(guiGraphics, mouseX, mouseY, partialTick);
            }
            on_open.render(guiGraphics, mouseX, mouseY, partialTick);
            toastWidget.render(guiGraphics, mouseX, mouseY, partialTick);
        }

        pose.popPose();
        pose.pushPose();

        pose.translate(0, 0, 100);
        title.render(guiGraphics, mouseX, mouseY, partialTick);
        pose.popPose();

    }

    @Override
    protected void renderSlotHighlight(GuiGraphics guiGraphics, Slot slot, int mouseX, int mouseY, float partialTick) {
        if (page==Page.MENU&& !on_change&&slot.isHighlightable()) {
            renderSlotHighlight(guiGraphics, slot.x, slot.y, 0, this.getSlotColor(slot.index));
        }
    }

    @Override
    protected void renderSlot(GuiGraphics guiGraphics, Slot slot) {
        if(page==Page.MENU || on_change){
            MIFakeSlot.renderSlotBackground(guiGraphics,slot.x,slot.y);
            super.renderSlot(guiGraphics, slot);
        }
    }

    private void onchange(){
        if(on_change){
            float realtimeDeltaTicks = Minecraft.getInstance().getTimer().getRealtimeDeltaTicks();
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
                if(changed){
                    setChanged();
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if(page==Page.LEDGER){
            boolean b = on_open.mouseClicked(mouseX, mouseY, button);
            if(b){
                return true;
            }
            int x1 = leftPos;
            int x2 = leftPos + imageWidth;
            int y1 = topPos;
            int y2 = topPos + imageHeight;
            if(mouseX > x1 && mouseX < x2 && mouseY > y1 && mouseY < y2){
                on_change = true;
                return true;
            }
        }
        if(page==Page.MENU){
            int x1 = leftPos-imageWidth;
            int x2 = leftPos;
            int y1 = topPos;
            int y2 = topPos + imageHeight;
            if(mouseX > x1 && mouseX < x2 && mouseY > y1 && mouseY < y2){
                on_change = true;
                return true;
            }
        }

        boolean v = super.mouseClicked(mouseX, mouseY, button);

        ItemStack draggingItem = menu.getCarried();
        tryAccept(draggingItem.copy());


        if(page==Page.MENU){
            for(MIFakeItemSlot fakeItemSlot : fakeCuisinesSlots){
                boolean b = fakeItemSlot.mouseClicked(mouseX, mouseY, button);
                if(b){
                    changed = true;
                }
                v = v || b;
            }
            for(MIFakeItemSlot fakeItemSlot : fakeBeveragesSlots){
                boolean b = fakeItemSlot.mouseClicked(mouseX, mouseY, button);
                if(b){
                    changed = true;
                }
                v = v || b;
            }
        }
        return v;
    }

    @Override
    public void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.leftPos = centerX - this.imageWidth / 2;
        this.topPos = centerY - this.imageHeight / 2;
        LocalPlayer player = Minecraft.getInstance().player;


        on_open = new MICustomButton.builder(getComponent(MIPlayerUtil.getOnOpen(player)), e ->{
            boolean open = MIPlayerUtil.getOnOpen(player);
            boolean f=false;
            if(open){
                f=true;
            }
            if(!open && checkOpen()){
                f=true;
            }
            if(f) {
                MIPlayerUtil.setOnOpen(player, !open);
                PacketDistributor.sendToServer(new OpenIzakayaBIMessage(!open));
                e.setMessage(getComponent(!open));
            }
        }).pos(this.leftPos+10,this.topPos+4).size(40,16).build();

        toastWidget = new ComponentToastWidget(leftPos+imageWidth/2,topPos+imageHeight/2,imageWidth,20,40f,Component.empty());

        ledgerItemWidgets = new ArrayList<>();
        List<Pair<String, Double>> list = MIPlayerUtil.getTurnover(player);
        for(int i = 0; i < list.size(); i++){
            LedgerItemWidget ledgerItemWidget = new LedgerItemWidget(this.leftPos + 10, this.topPos + 20 + 14 * i, list.get(i).getFirst(), list.get(i).getSecond());
            ledgerItemWidgets.add(ledgerItemWidget);
            renderables_ledger.add(ledgerItemWidget);
        }

        Component component = Component.translatable("gui.mystias_izakaya.balance").append(Component.literal(new java.text.DecimalFormat("#######")
                .format(MIBalanceUtil.getBalance(player))).append(Component.literal(" \u5186")));
        balance = new UnderLineComponentWidget(this.leftPos+imageWidth- font.width(component)-10, this.topPos +10, component);
        renderables_ledger.add(balance);

        Component titlec = Component.translatable("gui.mystias_izakaya.ledger_ui.ledger");
        title = new UnderLineComponentWidget(this.leftPos + imageWidth / 2 - font.width(titlec) / 2, this.topPos - 14, titlec);

        IzakayaMenu data = player.getData(MIAttachment.IZAKAYA_MENU);
        List<String> cuisineList = data.cuisines();
        List<String> beverageList = data.beverages();

        for (int i = 0; i < 8 ; i++) {
            ItemStack cuisine = i<cuisineList.size()?BuiltInRegistries.ITEM.get(ResourceLocation.parse((cuisineList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance():ItemStack.EMPTY;
            ItemStack beverage = i<beverageList.size()?BuiltInRegistries.ITEM.get(ResourceLocation.parse((beverageList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance():ItemStack.EMPTY;
            MIFakeItemSlot cuisineSlot = new MIFakeItemSlot(this.leftPos + 79 , this.topPos + 10 + i * 18, Component.translatable("gui.mystias_izakaya.ledger_ui.cuisine",i+1));
            cuisineSlot.setItemStack(cuisine);
            fakeCuisinesSlots.add(cuisineSlot);
            MIFakeItemSlot beverageSlot = new MIFakeItemSlot(this.leftPos + 79 + 18, this.topPos + 10 + i * 18, Component.translatable("gui.mystias_izakaya.ledger_ui.beverage",i+1));
            beverageSlot.setItemStack(beverage);
            fakeBeveragesSlots.add(beverageSlot);
            renderables_menu.add(cuisineSlot);
            renderables_menu.add(beverageSlot);
        }
    }

    private Component getComponent(boolean open){
        if(open)
            return Component.translatable("gui.mystias_izakaya.ledger_ui.open");
        else
            return Component.translatable("gui.mystias_izakaya.ledger_ui.close");
    }

    private boolean checkOpen(){
        LocalPlayer player = Minecraft.getInstance().player;
        IzakayaMenu data1 = player.getData(MIAttachment.IZAKAYA_MENU);
        List<BlockPos> blockPosList = MIPlayerUtil.getTables(player);
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for (BlockPos blockPos : blockPosList) {
            if(!Objects.equals(blockPos, new BlockPos(-1, -1, -1))){
                flag1 = true;
                break;
            }
        }
        for(String s:data1.cuisines()){
            if(!s.equals("minecraft:air")){
                flag2 = true;
                break;
            }
        }
        for(String s:data1.beverages()){
            if(!s.equals("minecraft:air")){
                flag3 = true;
                break;
            }
        }
        if(flag1 && flag2 && flag3){
            toastWidget.reset(Component.translatable("network.mystiasizakaya.ledger.success").withStyle(ChatFormatting.GREEN));
            return true;
        }else {
            if(!flag1){
                toastWidget.reset(Component.translatable("network.mystiasizakaya.ledger.failed.table").withStyle(ChatFormatting.GRAY));
                return false;
            }
            if(!flag2){
                toastWidget.reset(Component.translatable("network.mystiasizakaya.ledger.failed.cuisines").withStyle(ChatFormatting.GRAY));
                return false;
            }
            if(!flag3){
                toastWidget.reset(Component.translatable("network.mystiasizakaya.ledger.failed.beverages").withStyle(ChatFormatting.GRAY));
                return false;
            }
        }
        return false;
    }
}
