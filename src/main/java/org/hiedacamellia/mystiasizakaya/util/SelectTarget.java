package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class SelectTarget {
	public static void set(LevelAccessor world, BlockPos pos, int targetSlot) {
		//Main.execute(world, pos);
        SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, targetSlot), 12, 1);
	}
}
