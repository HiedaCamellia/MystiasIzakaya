package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class SetSlotItem {
    public static void setSlotItem(LevelAccessor world, BlockPos pos, ItemStack itemStack, int slotid, int count) {
        if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos , null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
            itemStack.setCount(count);
            _itemHandlerModifiable.setStackInSlot(slotid, itemStack);
        }
    }

    public static void setEmptySlot(LevelAccessor world, BlockPos pos, int slotid) {
        if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos , null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
            _itemHandlerModifiable.setStackInSlot(slotid,  ItemStack.EMPTY);
        }
    }

    public static void setEmptySlot(LevelAccessor world, BlockPos pos,int[] slotid) {
        if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos , null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
            for (int i : slotid) {
                _itemHandlerModifiable.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }
}