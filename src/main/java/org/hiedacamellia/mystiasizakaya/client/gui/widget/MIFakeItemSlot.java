package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.util.ItemStackHolder;

public class MIFakeItemSlot extends RenderSlot {

    private ItemStackHolder holder = new ItemStackHolder();

    public ItemStack getItemStack() {
        return holder.get();
    }
    public void setItemStack(ItemStack itemStack) {
        holder.set(itemStack);
    }

    public MIFakeItemSlot(int x, int y, Component message) {
        super(x, y, message);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        super.renderWidget(guiGraphics, mouseX, mouseY, v);
        guiGraphics.renderItem(holder.get(), getX(), getY());
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
