package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MIImageButton extends MIButton {


    protected MIImageButton(int x, int y, Component message, OnPress onPress,ItemStack itemStack, @Nullable Tooltip tooltip) {
        super(x, y,  message, onPress, itemStack, tooltip);
    }

    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

        if(this.isFocused())
            guiGraphics.fill(this.x-1, this.y-1, this.x + 17, this.y + 17, 0xFFFFA54F);
        else
            guiGraphics.fill(this.x-1, this.y-1, this.x + 17, this.y + 17, 0xFF8B4513);

        if(this.isHovered())
            guiGraphics.fill(this.x, this.y, this.x + 16, this.y + 16, 0xFFfbefcb);
        else
            guiGraphics.fill(this.x, this.y, this.x + 16, this.y + 16, 0xFFf0e0b0);

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

        public MIImageButton.builder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public MIImageButton.builder itemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public MIImageButton.builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public MIImageButton build(){
            return new MIImageButton(this.x, this.y, this.message, this.onPress, this.itemStack,this.tooltip);
        }
    }

}
