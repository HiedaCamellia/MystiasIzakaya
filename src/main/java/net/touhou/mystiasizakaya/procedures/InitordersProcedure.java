package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;

public class InitordersProcedure {
	public static void execute() {
		if (MystiasIzakayaModVariables.orders.isEmpty()) {
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.orders.add(ItemStack.EMPTY);
		}
		if (MystiasIzakayaModVariables.ordersbeverages.isEmpty()) {
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
			MystiasIzakayaModVariables.ordersbeverages.add(ItemStack.EMPTY);
		}
	}
}
