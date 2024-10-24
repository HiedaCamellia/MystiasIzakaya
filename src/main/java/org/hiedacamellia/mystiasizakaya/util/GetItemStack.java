package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;

import java.util.concurrent.atomic.AtomicReference;

public class GetItemStack {
    public static ItemStack getItemStack(Level world, BlockPos pos, int slotid) {
        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            return getItemStack(_ent, slotid);
        return _retval.get();
    }
    public static ItemStack getItemStack(BlockEntity be, int slotid) {

        if (be != null) {
            if(be instanceof CookingRangeEntity entity)
                return entity.stacks.get(slotid);
            if(be instanceof KitchenwaresEntity entity)
                return entity.stacks.get(slotid);
            if(be instanceof TableEntity entity)
                return entity.stacks.get(slotid);

        }
        return ItemStack.EMPTY;
    }
}
