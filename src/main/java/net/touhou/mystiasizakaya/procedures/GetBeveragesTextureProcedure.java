package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;

public class GetBeveragesTextureProcedure {
	public static String execute(double id) {
		ItemStack i = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		String fm = "";
		InitordersProcedure.execute();
		target = (MystiasIzakayaModVariables.ordersbeverages.get((int) id) instanceof ItemStack _bs ? _bs : ItemStack.EMPTY);
		return GetTextureProcedure.execute(target);
	}
}
