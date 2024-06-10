package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.Variables;

import net.minecraft.world.item.ItemStack;

public class AddordersProcedure {
	public static void execute(ItemStack beverages, ItemStack cuisines, double id) {
		Variables.orders.set((int) id, cuisines);
		Variables.ordersbeverages.set((int) id, beverages);
	}
}
