package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

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
    public static int getInt(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null)
            return blockEntity.getPersistentData().getInt(tag);
        return 0;
    }
}
