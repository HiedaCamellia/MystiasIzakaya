package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.mystiasizakaya.util.ItemStackHolder;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MIImageButton extends Button {

    private final ItemStackHolder itemStack= new ItemStackHolder();
    private final int x;
    private final int y;

    protected MIImageButton(int x, int y, Component message, OnPress onPress,ItemStack itemStack, @Nullable Tooltip tooltip) {
        super(x, y, 16, 16, message, onPress, Button.DEFAULT_NARRATION);
        this.x = x;
        this.y = y;
        this.setTooltip(tooltip);
        this.itemStack.set(itemStack);
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

        //guiGraphics.drawString(Minecraft.getInstance().font, String.valueOf(this.itemStack.get().getCount()), this.x+10, this.y+10, 0xFFFFFF,false);
        //guiGraphics.drawString(Minecraft.getInstance().font, FormattedCharSequence.forward(String.valueOf(this.itemStack.get().getCount()), Style.EMPTY), this.x+10, this.y+10, 0xFFFFFF);

    }

    public ItemStack getItemStack() {
        return this.itemStack.get();
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack.set(itemStack);
    }

    public void enableRender(){
        this.visible=true;
    }

    public void disableRender(){
        this.visible=false;
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

        public builder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public builder itemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public MIImageButton build(){
            return new MIImageButton(this.x, this.y, this.message, this.onPress, this.itemStack,this.tooltip);
        }
    }
}
