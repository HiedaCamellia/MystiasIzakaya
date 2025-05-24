package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractContainerWidget;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;

import java.util.List;

public class MIItemPriceWidget extends AbstractContainerWidget {

    private static final int width = 80;
    private static final int height = 20;

    private MIFakeItemSlot slot;
    private MINumberEditBox editBox;

    public MIItemPriceWidget(int x, int y) {
        this(x,y,ItemStack.EMPTY,0);
    }

    public boolean tryAccept(ItemStack itemStack){
        if(slot.isHovered()){
            slot.setItemStack(itemStack);
            slot.setMessage(itemStack.getDisplayName());
            return true;
        }
        return false;
    }

    public MIItemPriceWidget(int x, int y, ItemStack itemStack, int price) {
        super(x, y, width, height, Component.empty());
        slot = new MIFakeItemSlot(x+12,y+2, itemStack.getDisplayName());
        slot.setItemStack(itemStack);
        editBox = new MINumberEditBox(x+40,y+2, 30, 16, Component.empty());
        editBox.setInt(price);
    }

    public ItemStack getItemStack() {
        return slot.getItemStack();
    }

    public int getPrice() {
        return editBox.getInt();
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, getX(), getY(), width, height, 0.05f, 0xFFFEEBD1);
        RenderSystem.disableBlend();
        slot.render(guiGraphics, mouseX, mouseY, v);
        editBox.render(guiGraphics, mouseX, mouseY, v);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }

    @Override
    public List<? extends GuiEventListener> children() {
        return List.of(slot,editBox);
    }
}
