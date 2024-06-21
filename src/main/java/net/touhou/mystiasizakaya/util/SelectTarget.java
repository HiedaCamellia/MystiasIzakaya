package net.touhou.mystiasizakaya.util;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.content.cooking.Main;

public class SelectTarget {
	public static void set(LevelAccessor world, double x, double y, double z,int targetSlot) {
		Main.execute(world, x, y, z);
        SetSlotItem.setSlotItem(world, x, y, z, GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), targetSlot), 12, 1);
	}
}
