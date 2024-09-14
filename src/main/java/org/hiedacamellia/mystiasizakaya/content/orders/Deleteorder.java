package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.server.level.ServerPlayer;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.ArrayList;
import java.util.List;

public class Deleteorder {
	public static void execute(int id, ServerPlayer player) {


		List<String> orders = MIPlayerEvent.getOrders(player);
		List<String> ordersbeverages = MIPlayerEvent.getOrdersBeverages(player);

		orders.set(id, "minecraft:air");
		ordersbeverages.set(id, "minecraft:air");

		MIPlayerEvent.setOrders(player, orders);
		MIPlayerEvent.setOrdersBeverages(player, ordersbeverages);

	}
}
