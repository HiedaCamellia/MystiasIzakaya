package org.hiedacamellia.mystiasizakaya.content.cooking.ui;

import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class Lefttime {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (GetValue.getDouble(world, Pos.get(x, y, z), "timeleft") != 0) {
			return new java.text.DecimalFormat("#.#")
					.format((GetValue.getDouble(world, Pos.get(x, y, z), "timeleft")) / 20) + "s";
		}
		return "";
	}
}
