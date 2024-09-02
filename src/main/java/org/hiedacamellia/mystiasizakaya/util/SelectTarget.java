package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class SelectTarget {
	public static void set(LevelAccessor world, double x, double y, double z,int targetSlot) {
		//Main.execute(world, x, y, z);
		set(world, Pos.get(x, y, z), targetSlot);
	}
	public static void set(LevelAccessor world, BlockPos pos, int targetSlot) {
		//Debug.getLogger().debug("SelectTarget.set");
		SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, targetSlot), 12, 1);
	}
}
