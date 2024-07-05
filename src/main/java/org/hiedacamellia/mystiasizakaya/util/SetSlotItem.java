package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class SetSlotItem {
    public static void setSlotItem(LevelAccessor world, double x, double y, double z, ItemStack itemStack, int slotid,
            int count) {
        BlockEntity _ent = world.getBlockEntity(Pos.get(x, y, z));
        if (_ent != null) {
            final int _slotid = slotid;
            final ItemStack _setstack = itemStack;
            _setstack.setCount(count);
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable)
                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack );
            });
        }
    }
    public static void setEmptySlot(LevelAccessor world, double x, double y, double z, int slotid) {
        BlockEntity _ent = world.getBlockEntity(Pos.get(x, y, z));
        if (_ent != null) {
            final int _slotid = slotid;
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable)
                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
            });
        }
    }
    public static void setEmptySlot(BlockEntity be, int slotid) {
        if (be != null) {
            final int _slotid = slotid;
            be.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable)
                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
            });
        }
    }
}