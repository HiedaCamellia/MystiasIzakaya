package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class TargetsText {
	public static String get(Level world, BlockPos pos, int slotid) {
		String str = "";
		if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, pos, slotid).getItem()) {
			return "";
		}
		str = (GetItemStack.getItemStack(world, pos, slotid)).getDisplayName().getString();
		str = str.replace("[", "").replace("]", "");
		return str;
	}
}
