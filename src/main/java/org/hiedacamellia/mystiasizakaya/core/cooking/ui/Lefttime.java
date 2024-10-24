package org.hiedacamellia.mystiasizakaya.core.cooking.ui;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;

public class Lefttime {
	public static String execute(LevelAccessor world, BlockPos pos) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if(blockEntity instanceof CookingRangeEntity cookingRangeEntity)
			return new java.text.DecimalFormat("#.#").format((cookingRangeEntity.timeLeft) / 20) + "s";
		if(blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
			return new java.text.DecimalFormat("#.#").format((kitchenwaresEntity.timeLeft) / 20) + "s";
		return "";
	}
	public static String execute(int time) {
		return new java.text.DecimalFormat("#.#").format(time / 20) + "s";
	}
}
