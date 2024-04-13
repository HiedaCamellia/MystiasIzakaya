package net.touhou.mystiasizakaya.procedures;

import java.util.concurrent.atomic.AtomicReference;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class GetItemStack {
    public static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
        return _retval.get();
    }
}
