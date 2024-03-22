package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;

public class DeleteordersProcedure {
	public static void execute(double id) {
		MystiasIzakayaModVariables.orders.set((int) id, ItemStack.EMPTY);
		MystiasIzakayaModVariables.ordersbeverages.set((int) id, ItemStack.EMPTY);
	}
}
