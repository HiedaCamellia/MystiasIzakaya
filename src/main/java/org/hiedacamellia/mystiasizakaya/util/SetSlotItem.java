package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.Arrays;
import java.util.List;

public class SetSlotItem {
    public static void setSlotItem(LevelAccessor world, double x, double y, double z, ItemStack itemStack, int slotid, int count) {
        BlockEntity _ent = world.getBlockEntity(Pos.get(x, y, z));
        if (_ent != null) {
            setSlotItem(_ent, itemStack, slotid, count);
        }
    }
    public static void setSlotItem(BlockEntity be, ItemStack itemStack, int slotid, int count) {
        if (be != null) {
            final int _slotid = slotid;
            final ItemStack _setstack = itemStack;
            _setstack.setCount(count);
            be.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable)
                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack );
            });
        }
    }
    public static void querySlotItem(LevelAccessor world, double x, double y, double z, int slotid,int count) {
        BlockEntity _ent = world.getBlockEntity(Pos.get(x, y, z));
        if (_ent != null) {
            querySlotItem(_ent, slotid, count);
        }
    }
    public static void querySlotItem(BlockEntity be,  int slotid,int count) {
        if (be != null) {
            ItemStack item = GetItemStack.getItemStack(be, slotid);
            setSlotItem(be, item, slotid, item.getCount()-count);
        }
    }
    public static void querySlotItem(BlockEntity be, int[] slotid,int[] count) {
        if (be != null) {
            for (int i = 0; i < slotid.length; i++) {
                querySlotItem(be, slotid[i], count[i]);
            }
        }
    }


    public static void setEmptySlot(LevelAccessor world, double x, double y, double z, int slotid) {
        BlockEntity _ent = world.getBlockEntity(Pos.get(x, y, z));
        if (_ent != null) {
            setEmptySlot(_ent, slotid);
        }
    }
    public static void setEmptySlot(BlockEntity be, int slotid) {
        if (be != null) {
            be.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable)
                    ((IItemHandlerModifiable) capability).setStackInSlot(slotid, ItemStack.EMPTY);
            });
        }
    }
    public static void setEmptySlot(BlockEntity be, int[] slotid) {
        if (be != null) {
            for (int slot : slotid) {
                setEmptySlot(be, slot);
            };
        }
    }
}