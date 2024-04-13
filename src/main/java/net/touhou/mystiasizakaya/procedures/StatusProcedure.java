package net.touhou.mystiasizakaya.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class StatusProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (GetValue.getDouble(world, new BlockPos(x, y, z), "timeleft") != 0) {
			return Component.translatable("status.mystias_izakaya.working").getString();
		}
		if (!GetItemStack.getItemStack(world, new BlockPos(x, y, z), 6).isEmpty())
			return Component.translatable("status.mystias_izakaya.outputblocked").getString();
		return Component.translatable("status.mystias_izakaya.free").getString();
	}
}
