package org.hiedacamellia.mystiasizakaya.content.common.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.HashMap;
import java.util.Map;

public class CookingUiMenu extends AbstractContainerMenu {

    private int size = 6;
    private BlockEntity boundEntity;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    public BlockPos pos;

    public CookingUiMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
        this(containerId, inventory, ContainerLevelAccess.NULL,buf.readBlockPos());
    }

    public CookingUiMenu(int containerId, Inventory inventory, BlockPos pos) {
        this(containerId, inventory, ContainerLevelAccess.NULL,pos);
    }

    public CookingUiMenu(int containerId, Inventory inventory, ContainerLevelAccess access,BlockPos pos) {
        this(containerId, inventory, access, new ItemStackHandler(10), new SimpleContainerData(9),pos);
    }

    public CookingUiMenu(int id, Inventory inv, ContainerLevelAccess access, IItemHandler itemHandler, ContainerData containerData,BlockPos pos) {
        super(MIMenu.COOKING_UI.get(), id);
        boundEntity = inv.player.level().getBlockEntity(pos);
        this.pos = pos;

        int start_x =  200 / 2 - 18 * 9 / 2 ;
        int start_y = 100;

        if(showKitchenWare())
            this.customSlots.put(0, this.addSlot(new SlotItemHandler(itemHandler, 0, start_x + 7 * 18, start_y - 22){
                @Override public boolean mayPlace(ItemStack stack) {
                    return stack.is(MITag.kitchenwaresKey);
                }
            }));

        this.customSlots.put(1, this.addSlot(new SlotItemHandler(itemHandler, 1, start_x, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey);
            }
        }));
        this.customSlots.put(2, this.addSlot(new SlotItemHandler(itemHandler, 2, start_x + 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey);
            }
        }));
        this.customSlots.put(3, this.addSlot(new SlotItemHandler(itemHandler, 3, start_x + 2 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey);
            }
        }));
        this.customSlots.put(4, this.addSlot(new SlotItemHandler(itemHandler, 4, start_x + 3 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey);
            }
        }));
        this.customSlots.put(5, this.addSlot(new SlotItemHandler(itemHandler, 5, start_x + 4 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey);
            }
        }));

        this.customSlots.put(6, this.addSlot(new SlotItemHandler(itemHandler, 6, start_x + 9 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return false;
            }
        }));


        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(inv, sj + (si + 1) * 9, start_x + sj * 18,  start_y + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(inv, si, start_x + si * 18, 2 + start_y + 3 * 18));

    }

    protected boolean showKitchenWare() {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < size) {
                if (!this.moveItemStackTo(itemstack1, size, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, size, false)) {
                if (index < size + 27) {
                    if (!this.moveItemStackTo(itemstack1, size + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, size, size + 27, false))
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
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack itemStack, int from, int to, boolean p_38907_) {
        boolean flag = false;
        int i = from;
        if (p_38907_) {
            i = to - 1;
        }
        if (itemStack.isStackable()) {
            while (!itemStack.isEmpty() && (p_38907_ ? i >= from : i < to)) {
                Slot slot = this.slots.get(i);
                ItemStack itemstack = slot.getItem();
                if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(itemStack, itemstack)) {
                    int j = itemstack.getCount() + itemStack.getCount();
                    int k = slot.getMaxStackSize(itemstack);
                    if (j <= k) {
                        itemStack.setCount(0);
                        itemstack.setCount(j);
                        slot.set(itemstack);
                        flag = true;
                    } else if (itemstack.getCount() < k) {
                        itemStack.shrink(k - itemstack.getCount());
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
        if (!itemStack.isEmpty()) {
            if (p_38907_) {
                i = to - 1;
            } else {
                i = from;
            }
            while (p_38907_ ? i >= from : i < to) {
                Slot slot1 = this.slots.get(i);
                ItemStack itemstack1 = slot1.getItem();
                if (itemstack1.isEmpty() && slot1.mayPlace(itemStack)) {
                    int l = slot1.getMaxStackSize(itemStack);
                    slot1.setByPlayer(itemStack.split(Math.min(itemStack.getCount(), l)));
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

    @Override
    public boolean stillValid(Player player) {
        return !this.boundEntity.isRemoved();
    }
}
