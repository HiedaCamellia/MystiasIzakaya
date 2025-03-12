package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MIItemButton extends MIButton {

    private final boolean renderBg;

    protected MIItemButton(int x, int y, Component message, OnPress onPress, ItemStack itemStack, @Nullable Tooltip tooltip,boolean renderBg) {
        super(x, y,  message, onPress, itemStack, tooltip);
        this.renderBg = renderBg;
    }

    public void renderBg(GuiGraphics guiGraphics){
        if(!this.renderBg) return;
        IUIGuiUtils.fillRoundRect(guiGraphics,  - 1,  - 1, 18, 18, 0.05f, 0xFF8B4513);
        IUIGuiUtils.fillRoundRect(guiGraphics, 0,0 , 16, 16, 0.05f, 0xFFf0e0b0);
    }

    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        if(getItemStack().isEmpty())return;

        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(this.x,this.y, 0);
        RenderSystem.enableBlend();
        renderBg(guiGraphics);
        if(this.isFocused()) {
            IUIGuiUtils.fillRoundRect(guiGraphics,  - 1,  - 1, 18, 18, 0.05f, 0x40FFA54F);
        }
        if(this.isHovered()) {
            IUIGuiUtils.fillRoundRect(guiGraphics,0 ,0 , 16, 16, 0.05f, 0x80fbefcb);
        }
        RenderSystem.disableBlend();

        pose.popPose();
        guiGraphics.renderItem(this.itemStack.get(),this.x, this.y);
    }
    public static class builder {
        private ItemStack itemStack=ItemStack.EMPTY;
        private int x;
        private int y;
        private final Component message ;
        private final OnPress onPress ;
        private Tooltip tooltip;
        private boolean renderBg = true;

        public builder(Component message, OnPress onPress) {
            this.message = message;
            this.onPress = onPress;
        }

        public MIItemButton.builder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public MIItemButton.builder itemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public MIItemButton.builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public MIItemButton.builder disableBg(){
            this.renderBg = false;
            return this;
        }

        public MIItemButton build(){
            return new MIItemButton(this.x, this.y, this.message, this.onPress, this.itemStack,this.tooltip,this.renderBg);
        }
    }

}
