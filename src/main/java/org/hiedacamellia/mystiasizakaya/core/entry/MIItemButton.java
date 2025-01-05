package org.hiedacamellia.mystiasizakaya.core.entry;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.immersiveui.client.graphic.util.RenderUtils;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MIItemButton extends MIButton {


    protected MIItemButton(int x, int y, Component message, OnPress onPress, ItemStack itemStack, @Nullable Tooltip tooltip) {
        super(x, y,  message, onPress, itemStack, tooltip);
    }

    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(this.x,this.y, 0);
        RenderSystem.enableBlend();
        if(this.isFocused()) {
            RenderUtils.fillRoundRect(guiGraphics,  - 1,  - 1, 18, 18, 0.05f, 0xFFFFA54F);
            //guiGraphics.fill( - 1,  - 1,  + 17,  + 17, 0xFFFFA54F);
        }
        else {
            RenderUtils.fillRoundRect(guiGraphics,  - 1,  - 1, 18, 18, 0.05f, 0xFF8B4513);
            //guiGraphics.fill( - 1,  - 1,  + 17,  + 17, 0xFF8B4513);
        }

        if(this.isHovered()) {
            RenderUtils.fillRoundRect(guiGraphics,0 ,0 , 16, 16, 0.05f, 0xFFfbefcb);
            //guiGraphics.fill(, ,  + 16,  + 16, 0xFFfbefcb);
        }
        else {
            RenderUtils.fillRoundRect(guiGraphics, 0,0 , 16, 16, 0.05f, 0xFFf0e0b0);
            //guiGraphics.fill(, ,  + 16,  + 16, 0xFFf0e0b0);
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

        public MIItemButton build(){
            return new MIItemButton(this.x, this.y, this.message, this.onPress, this.itemStack,this.tooltip);
        }
    }

}
