package org.hiedacamellia.mystiasizakaya.core.cooking.ui;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class Lefttime {
	public static String execute(LevelAccessor world, BlockPos pos) {
		if (GetValue.getDouble(world, pos, "timeleft") != 0) {
			return new java.text.DecimalFormat("#.#")
					.format((GetValue.getDouble(world, pos, "timeleft")) / 20) + "s";
		}
		return "";
	}
}
