package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.solt.FakeSlot;
import org.hiedacamellia.immersiveui.client.gui.component.widget.toast.ComponentToastWidget;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MIItemButton;
import org.hiedacamellia.mystiasizakaya.common.item.KitchenwareBlockItem;
import org.hiedacamellia.mystiasizakaya.common.menu.CookingMenu;
import org.hiedacamellia.mystiasizakaya.content.cooking.CookingUtils;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.network.CookingStartS2SMessage;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareTypeUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CookingScreen extends AbstractContainerScreen<CookingMenu> {

    private final BlockPos pos;

    protected List<MIItemButton> buttons;
    protected ComponentToastWidget toast;

    protected CookingMenu menu;
    protected Inventory playerInventory;
    private int uHash;
    private int iHash;
    private final Level level;

    private ItemStack selected = ItemStack.EMPTY;
    private ItemStack working = ItemStack.EMPTY;
    private byte last=-1;

    private ContainerData data;

    public CookingScreen(CookingMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.pos = menu.pos;
        this.level = menu.level;
        this.imageWidth = 200;
        this.imageHeight = 180;
        this.menu = menu;
        this.playerInventory = playerInventory;
        this.data = menu.data;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.setShaderColor(1,1,1,1);
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        renderProcess(guiGraphics, mouseX, mouseY,partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean v = super.mouseClicked(mouseX, mouseY, button);
        if(!v) {
            selected = ItemStack.EMPTY;
            last = -1;
        }
        return v;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        ItemStack detail = selected;
        if(detail.isEmpty()) {
            for (MIItemButton button : buttons) {
                if (button.isHovered()) {
                    detail = button.getItemStack();
                }
            }
        }
        if(detail.isEmpty())return;
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(9,9,0);
        guiGraphics.drawString(font, detail.getHoverName(), 0, 0, 0xFFFFFF,false);
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, 0, font.lineHeight, font.width(detail.getHoverName()), 1, 0.05f, 0x80FFFFFF);
        RenderSystem.disableBlend();
        pose.translate(0,font.lineHeight+2,0);
        pose.pushPose();
        pose.scale(0.5f,0.5f,0);
        List<FormattedCharSequence> desc = getDesc(detail, 196);
        for (int i = 0; i < desc.size(); i++) {
            guiGraphics.drawString(font, desc.get(i), 0, i * font.lineHeight, 0xFFFFFF);
        }
        pose.popPose();

        pose.pushPose();
        pose.translate(0,3*font.lineHeight,0);
        pose.scale(0.5f,0.5f,0);
        MutableComponent tagComponent = Component.empty();
        MutableComponent ntagComponent = Component.empty();
        String tagprefix = "tag.mystias_izakaya.";
        for (String tag : MIItemStackUtil.getPositiveTags(detail)) {
            ntagComponent.append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.GOLD).append(" ");
        }
        for (String tag : MIItemStackUtil.getNegativeTags(detail)) {
            ntagComponent.append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.RED).append(" ");
        }
        List<FormattedCharSequence> list = new ArrayList<>();
        list.addAll(font.split(tagComponent, 196));
        list.addAll(font.split(ntagComponent, 196));
        for (int i = 0; i < list.size(); i++) {
            guiGraphics.drawString(font, list.get(i), 0, i * font.lineHeight, 0xFFFFFF);
        }

        pose.popPose();
        pose.popPose();
    }

    public List<FormattedCharSequence> getDesc(@NotNull ItemStack itemstack,int lineW) {
        List<FormattedCharSequence> list = new ArrayList<>();
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
        String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
        for (String line : description) {
            list.addAll(font.split(Component.literal(line), lineW));
        }
        return list;
    }

    private float process_scale = 0;

    private void renderProcess(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks){
        int cooktime = data.get(0);
        int total = data.get(1);

        if(total==0){
            process_scale =Math.max(0,process_scale-0.2f*partialTicks);
        }else {
            process_scale =Math.min(1,process_scale+0.2f*partialTicks);
        }
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(1,1,1,process_scale);
        String s = cooktime +"/"+ total;
        String percent = (int) (cooktime * 100.0 / total) + "%";
        if(process_scale>0){
            pose.translate(leftPos+152,topPos+36,0);
            pose.scale(process_scale,process_scale,0);
            guiGraphics.renderFakeItem(working, -8, -8);
            IUIGuiUtils.drawRing(guiGraphics, 0, 0, 0, 15, 0, 360, 0x80FFFFFF);
            IUIGuiUtils.drawRing(guiGraphics, 0, 0, 10, 15, 0, (float) (360 * cooktime) /total, 0xFFffaec9);
            if(total!=0) {
                if(mouseX>leftPos+152-font.width(percent)/2&&mouseX<leftPos+152+font.width(percent)/2&&mouseY>topPos+36-5&&mouseY<topPos+36+5) {
                    IUIGuiUtils.drawCenteredString(guiGraphics, font, s, 0, 0, 0xFFFFFF, true);
                }else {
                    IUIGuiUtils.drawCenteredString(guiGraphics, font, percent, 0, 0, 0xFFFFFF, true);
                }
            }
        }
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1,1,1,1);
        pose.popPose();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, leftPos - 1, topPos - 1, imageWidth, imageHeight, 0.05f, 0xFF725649);
        IUIGuiUtils.fillRoundRect(guiGraphics, leftPos + 1, topPos + 1, imageWidth, imageHeight, 0.05f, 0xFF321609);
        IUIGuiUtils.fillRoundRect(guiGraphics, leftPos, topPos, imageWidth, imageHeight, 0.05f, 0xFF523629);
        IUIGuiUtils.fillRoundRect(guiGraphics, leftPos + 114, topPos + 7, 4 * 18 + 4, 3 * 18 + 4, 0.05f, 0xFFf0e0b0);
        IUIGuiUtils.fillRoundRect(guiGraphics, leftPos+7, topPos+7, 100, 58, 0.05f, 0xFFf0e0b0);
        RenderSystem.disableBlend();
    }

    @Override
    public void containerTick() {
        super.containerTick();
        ItemStack util = menu.showKitchenWare() ? menu.customSlots.get(0).getItem() : KitchenwareTypeUtil.type2Stack(menu.getKitchenwareType());
        List<ItemStack> ingredients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ingredients.add(menu.customSlots.get(i).getItem());
        }
        if(!menu.customSlots.get(6).getItem().isEmpty()&&!working.isEmpty()){
            working = ItemStack.EMPTY;
        }
        int u = util.hashCode();
        int i = ingredients.hashCode();
        if (uHash != u || iHash != i) {
            uHash = u;
            iHash = i;
            if (util.isEmpty()) return;
            KitchenwareType type;
            if (util.getItem() instanceof KitchenwareBlockItem kitchenware) {
                type = kitchenware.getKitchenwareType();
            } else {
                return;
            }
            List<ItemStack> availableCuisines = CookingUtils.getAvailableCuisines(null,level, ingredients, type);
            for (int j = 0; j < 12; j++) {
                if (j < availableCuisines.size()) {
                    buttons.get(j).setItemStack(CookingUtils.buildTag(null,level,availableCuisines.get(j),util,ingredients));
                } else {
                    buttons.get(j).setItemStack(ItemStack.EMPTY);
                }
            }
        }
    }

    @Override
    public void init() {
        super.init();
        buttons = new ArrayList<>();


        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 4; j++) {
                byte finala = (byte) (j + i * 4);
                buttons.add(new MIItemButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.select"), e -> {
                    ItemStack stack = buttons.get(finala).getItemStack();
                    if(stack.isEmpty())return;

                    MystiasIzakaya.LOGGER.debug("selected: "+stack);

                    if (last==finala&&data.get(1)==0) {
                        ItemStack out = menu.customSlots.get(6).getItem();
                        if(out.isEmpty()&&ItemStack.isSameItem(stack,selected)){
                            MystiasIzakaya.LOGGER.debug("start cooking: "+stack);
                            PacketDistributor.sendToServer(new CookingStartS2SMessage(finala, pos));
                            selected = ItemStack.EMPTY;
                            working = stack;
                        }else {
                            toast.reset(Component.translatable("status.mystias_izakaya.outputblocked"));
                        }
                    }else {
                        if(data.get(0)>0){
                            toast.reset(Component.translatable("status.mystias_izakaya.working"));
                        }
                        selected = stack;
                    }
                    last = finala;
                }).pos(leftPos + 117 + 18 * j, topPos + 10 + 18 * i).disableBg().build());
            }
        }

        for (Button button : buttons) {
            this.addRenderableWidget(button);
        }

        int start_x = this.leftPos + imageWidth / 2 - 18 * 9 / 2;
        int start_y = this.topPos + imageHeight - 80;
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addRenderableWidget(new FakeSlot(start_x + sj * 18, start_y + si * 18, Component.empty()));
        for (int si = 0; si < 9; ++si)
            this.addRenderableWidget(new FakeSlot(start_x + si * 18, 2 + start_y + 3 * 18, Component.empty()));
        if(menu.showKitchenWare())
            this.addRenderableWidget(new FakeSlot(start_x + 7 * 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.kitchenwares")));
        this.addRenderableWidget(new FakeSlot(start_x + 9 * 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.output")));

        this.addRenderableWidget(new FakeSlot(start_x, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new FakeSlot(start_x + 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new FakeSlot(start_x + 2 * 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new FakeSlot(start_x + 3 * 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new FakeSlot(start_x + 4 * 18, start_y - 22, Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));

        this.toast = new ComponentToastWidget(leftPos+151,topPos+36, 75, 20,20.0f, Component.empty());
        this.addRenderableWidget(toast);
    }
}
