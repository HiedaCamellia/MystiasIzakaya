package org.hiedacamellia.mystiasizakaya.content.cooking.ui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class Status {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (GetValue.getDouble(world, Pos.get(x, y, z), "timeleft") != 0) {
			return Component.translatable("status.mystias_izakaya.working").getString();
		}
		if (!GetItemStack.getItemStack(world, Pos.get(x, y, z), 6).isEmpty())
			return Component.translatable("status.mystias_izakaya.outputblocked").getString();
		return Component.translatable("status.mystias_izakaya.free").getString();
	}
}
