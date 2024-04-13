package net.touhou.mystiasizakaya.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.procedures.GetValue;

public class LefttimeProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (GetValue.getDouble(world, BlockPos.containing(x, y, z), "timeleft") != 0) {
			return new java.text.DecimalFormat("#.#")
					.format((GetValue.getDouble(world, BlockPos.containing(x, y, z), "timeleft")) / 20) + "s";
		}
		return "";
	}
}
