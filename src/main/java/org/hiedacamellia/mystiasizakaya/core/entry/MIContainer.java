package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MIContainer implements Container {

    private List<ItemStack> items;

    private final int size;


    public MIContainer(int size) {
        this.size = size;
        this.items = new ArrayList<>(size);
        this.items.forEach((itemStack) -> itemStack = ItemStack.EMPTY);
    }





    @Override
    public int getContainerSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemStack : items) {
            if(!itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int i) {
        return items.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        ItemStack itemStack = items.get(i);
        itemStack.setCount(itemStack.getCount() - j);
        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return items.set(i, ItemStack.EMPTY);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        items.set(i, itemStack);
    }

    @Override
    public void setChanged() {

    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        items.forEach((itemStack) -> itemStack = ItemStack.EMPTY);
    }
}
