package org.hiedacamellia.mystiasizakaya.content.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.cooking.IKitchenware;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;

public class CookingRangeEntity extends CookingEntity {
	public CookingRangeEntity(BlockPos position, BlockState state) {
		super(MIBlockEntitiy.COOKING_RANGE.get(),position, state);
	}

	@Override
	public KitchenwareType getKitchenwareType() {
		ItemStack itemStack = stacks.get(0);
		if(itemStack.getItem() instanceof IKitchenware kitchenware){
			return kitchenware.getKitchenwareType();
		}
		return KitchenwareType.NONE;
	}
}
