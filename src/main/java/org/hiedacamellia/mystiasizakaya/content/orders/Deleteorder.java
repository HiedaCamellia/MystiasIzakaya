package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;

public class Deleteorder {
	public static void execute(int id, ServerPlayer player) {

		MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());

		List<String> orders = new ArrayList<>(miOrders.orders());
		List<String> ordersbeverages = new ArrayList<>(miOrders.beverages());

		orders.set(id, "minecraft:air");
		ordersbeverages.set(id, "minecraft:air");

		MIOrders miOrders1 = new MIOrders(orders, ordersbeverages, miOrders.blockPos());
		player.setData(MIAttachment.MI_ORDERS.get(), miOrders1);
		PacketDistributor.sendToPlayer(player, miOrders1);

	}
}
