package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SelectTarget {
	public static void set(Level world, BlockPos pos, int targetSlot) {
		//Main.execute(world, pos);
        SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, targetSlot), 12, 1);
	}
}
