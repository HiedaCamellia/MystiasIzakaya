package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class TargetsText {
	public static String get(LevelAccessor world, double x, double y, double z, int slotid) {
		String str = "";
		if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), slotid).getItem()) {
			return "";
		}
		str = (GetItemStack.getItemStack(world, Pos.get(x, y, z), slotid)).getDisplayName().getString();
		str = str.replace("[", "").replace("]", "");
		return str;
	}
}
