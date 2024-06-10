package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.Variables;

import net.minecraft.world.item.ItemStack;

public class DeleteordersProcedure {
	public static void execute(double id) {
		Variables.orders.set((int) id, ItemStack.EMPTY);
		Variables.ordersbeverages.set((int) id, ItemStack.EMPTY);
	}
}
