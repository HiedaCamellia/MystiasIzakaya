package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.List;

public class Deleteorder {
	public static void execute(double id, Player player) {

		MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());

		List<String> orders = miOrders.orders();
		List<String> ordersbeverages = miOrders.beverages();

		orders.set((int) id, "minecraft:air");
		ordersbeverages.set((int) id, "minecraft:air");

		player.setData(MIAttachment.MI_ORDERS.get(), new MIOrders(orders, ordersbeverages));
	}
}
