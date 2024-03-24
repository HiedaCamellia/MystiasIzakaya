package net.touhou.mystiasizakaya.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;

public class GetTextureProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack i = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		String fm = "";
		String rn = "";
		target = itemstack;
		if (ItemStack.EMPTY.getItem() == target.getItem()) {
			return fm;
		}
		fm = ForgeRegistries.ITEMS.getKey(target.getItem()).toString();
		fm = fm.split(":")[1];
		fm += "_";
		return fm;
	}
}
