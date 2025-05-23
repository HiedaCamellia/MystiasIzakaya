package org.hiedacamellia.mystiasizakaya.core.util;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.immersiveui.client.util.holder.IValueHolder;

public class ItemStackHolder implements IValueHolder<ItemStack> {
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
