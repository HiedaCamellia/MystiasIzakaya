package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;

public class AddordersProcedure {
	public static void execute(ItemStack beverages, ItemStack cuisines, double id) {
		MystiasIzakayaModVariables.orders.set((int) id, cuisines);
		MystiasIzakayaModVariables.ordersbeverages.set((int) id, beverages);
	}
}
