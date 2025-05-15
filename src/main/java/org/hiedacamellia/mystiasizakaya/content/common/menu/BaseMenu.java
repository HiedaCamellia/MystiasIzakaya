package org.hiedacamellia.mystiasizakaya.content.common.menu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public abstract class BaseMenu extends AbstractContainerMenu {

    protected abstract int getSize();

    protected BaseMenu(@Nullable MenuType<?> menuType, int containerId) {
        super(menuType, containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < getSize()) {
                if (!this.moveItemStackTo(itemstack1, getSize(), this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, getSize(), false)) {
                if (index < getSize() + 27) {
                    if (!this.moveItemStackTo(itemstack1, getSize() + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, getSize(), getSize() + 27, false))
                        return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0)
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
        boolean flag = false;
        int i = p_38905_;
        if (p_38907_) {
            i = p_38906_ - 1;
        }
        if (p_38904_.isStackable()) {
            while (!p_38904_.isEmpty() && (p_38907_ ? i >= p_38905_ : i < p_38906_)) {
                Slot slot = this.slots.get(i);
                ItemStack itemstack = slot.getItem();
                if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(p_38904_, itemstack)) {
                    int j = itemstack.getCount() + p_38904_.getCount();
                    int k = slot.getMaxStackSize(itemstack);
                    if (j <= k) {
                        p_38904_.setCount(0);
                        itemstack.setCount(j);
                        slot.set(itemstack);
                        flag = true;
                    } else if (itemstack.getCount() < k) {
                        p_38904_.shrink(k - itemstack.getCount());
                        itemstack.setCount(k);
                        slot.set(itemstack);
                        flag = true;
                    }
                }
                if (p_38907_) {
                    i--;
                } else {
                    i++;
                }
            }
        }
        if (!p_38904_.isEmpty()) {
            if (p_38907_) {
                i = p_38906_ - 1;
            } else {
                i = p_38905_;
            }
            while (p_38907_ ? i >= p_38905_ : i < p_38906_) {
                Slot slot1 = this.slots.get(i);
                ItemStack itemstack1 = slot1.getItem();
                if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
                    int l = slot1.getMaxStackSize(p_38904_);
                    slot1.setByPlayer(p_38904_.split(Math.min(p_38904_.getCount(), l)));
                    slot1.setChanged();
                    flag = true;
                    break;
                }
                if (p_38907_) {
                    i--;
                } else {
                    i++;
                }
            }
        }
        return flag;
    }

}
