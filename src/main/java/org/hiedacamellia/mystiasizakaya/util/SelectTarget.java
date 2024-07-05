package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.content.cooking.Main;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class SelectTarget {
	public static void set(LevelAccessor world, double x, double y, double z,int targetSlot) {
		Main.execute(world, x, y, z);
        SetSlotItem.setSlotItem(world, x, y, z, GetItemStack.getItemStack(world, Pos.get(x, y, z), targetSlot), 12, 1);
	}
}
