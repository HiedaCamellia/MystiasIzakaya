package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.ItemStack;

public class ItemStackHolder {
    private ItemStack itemStack;

    public ItemStackHolder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
    public ItemStackHolder() {
        this.itemStack = ItemStack.EMPTY;
    }

    public void set(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack get() {
        return this.itemStack;
    }
}
