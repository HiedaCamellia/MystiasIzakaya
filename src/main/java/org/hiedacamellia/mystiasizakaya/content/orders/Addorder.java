package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.List;

public class Addorder {
	public static void execute(ItemStack beverages, ItemStack cuisines, int id, ServerPlayer player) {


		List<String> orders = MIPlayerEvent.getOrders(player);
		List<String> ordersbeverages = MIPlayerEvent.getOrdersBeverages(player);

		orders.set(id, BuiltInRegistries.ITEM.getKey(cuisines.getItem()).toString());
		ordersbeverages.set(id, BuiltInRegistries.ITEM.getKey(beverages.getItem()).toString());

		MIPlayerEvent.setOrders(player, orders);
		MIPlayerEvent.setOrdersBeverages(player, ordersbeverages);
	}
}
