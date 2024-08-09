package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.items.IItemHandler;

public class GetItemStack {
    public static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
        if (world instanceof ILevelExtension _ext) {
            IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
            if (_itemHandler != null)
                return _itemHandler.getStackInSlot(slotid).copy();
        }
        return ItemStack.EMPTY;
    }
}
