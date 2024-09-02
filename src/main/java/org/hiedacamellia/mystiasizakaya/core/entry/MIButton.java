package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.util.ItemStackHolder;
import org.hiedacamellia.mystiasizakaya.util.RateHolder;

import javax.annotation.Nullable;

public class MIButton extends Button {
    public final ItemStackHolder itemStack= new ItemStackHolder();
    public final int x;
    public final int y;
    public final RateHolder rate;

    protected MIButton(int x, int y, Component message, OnPress onPress, ItemStack itemStack, @Nullable Tooltip tooltip) {
        super(x, y, 16, 16, message, onPress, Button.DEFAULT_NARRATION);
        this.x = x;
        this.y = y;
        this.setTooltip(tooltip);
        this.itemStack.set(itemStack);
        this.rate = new RateHolder(0.6+0.4*Math.random());
    }

    public double getRate() {
        return rate.getRate();
    }

    public void setRate(double rate) {
        this.rate.setRate(rate);
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

}
