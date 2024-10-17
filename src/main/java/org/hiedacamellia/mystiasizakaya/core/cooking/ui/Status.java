package org.hiedacamellia.mystiasizakaya.core.cooking.ui;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;

public class Status {
	public static String execute(LevelAccessor world, BlockPos pos) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		int time=0;
		if(blockEntity instanceof CookingRangeEntity cookingRangeEntity)
			time = cookingRangeEntity.timeLeft;
		if(blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
			time = kitchenwaresEntity.timeLeft;
		if (time != 0) {
			return Component.translatable("status.mystias_izakaya.working").getString();
		}
		if (!GetItemStack.getItemStack(world, pos, 6).isEmpty())
			return Component.translatable("status.mystias_izakaya.outputblocked").getString();
		return Component.translatable("status.mystias_izakaya.free").getString();
	}
	public static String execute(int time,boolean blocked) {
		if (time != 0) {
			return Component.translatable("status.mystias_izakaya.working").getString();
		}
		if (blocked)
			return Component.translatable("status.mystias_izakaya.outputblocked").getString();
		return Component.translatable("status.mystias_izakaya.free").getString();
	}
}
