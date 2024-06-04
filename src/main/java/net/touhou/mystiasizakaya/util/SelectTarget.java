package net.touhou.mystiasizakaya.util;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.cooking.Main;

public class SelectTarget {
	public static void set(LevelAccessor world, int x, int y, int z, int targetSlot) {
		Main.execute(world, x, y, z);
		SetSlotItem.setSlotItem(world, x, y, z, GetItemStack.getItemStack(world, new BlockPos(x, y, z), targetSlot), 12,
				1);
	}
}
