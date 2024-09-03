package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;

public class Addorder {
	public static void execute(ItemStack beverages, ItemStack cuisines, int id, ServerPlayer player) {

		MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());

		List<String> orders = new ArrayList<>(miOrders.orders());
		List<String> ordersbeverages = new ArrayList<>(miOrders.beverages());

		orders.set(id, BuiltInRegistries.ITEM.getKey(cuisines.getItem()).toString());
		ordersbeverages.set(id, BuiltInRegistries.ITEM.getKey(beverages.getItem()).toString());

		MIOrders miOrders1 = new MIOrders(orders, ordersbeverages, miOrders.blockPos());
		player.setData(MIAttachment.MI_ORDERS.get(), miOrders1);
		PacketDistributor.sendToPlayer(player, miOrders1);

	}
}
