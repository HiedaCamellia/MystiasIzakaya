package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

public class Addorder {
	public static void execute(ItemStack beverages, ItemStack cuisines, double id, Player player) {
		Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
		_vars.orders.set((int) id, BuiltInRegistries.ITEM.getKey(cuisines.getItem()).toString());
		_vars.ordersbeverages.set((int) id, BuiltInRegistries.ITEM.getKey(beverages.getItem()).toString());
		_vars.syncPlayerVariables(player);
	}
}
