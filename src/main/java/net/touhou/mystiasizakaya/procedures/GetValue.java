package net.touhou.mystiasizakaya.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetValue {
    public static double getDouble(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null)
            return blockEntity.getPersistentData().getDouble(tag);
        return -1;
    }
    public static boolean getBoolean(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null)
            return blockEntity.getPersistentData().getBoolean(tag);
        return false;
    }
}
