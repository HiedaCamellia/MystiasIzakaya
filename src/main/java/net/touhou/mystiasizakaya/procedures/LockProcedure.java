package net.touhou.mystiasizakaya.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LockProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(0 == new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "timeleft"))) {
			return false;
		}
		return true;
	}
}
