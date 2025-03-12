package org.hiedacamellia.mystiasizakaya.content.order;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.core.network.OrderAddS2CMessage;
import org.hiedacamellia.mystiasizakaya.core.network.OrderRemoveS2CMessage;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;

public class OrderUtils {
    public static void add(ItemStack beverages, ItemStack cuisines, int id, ServerPlayer player) {

        MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());

        List<String> orders = new ArrayList<>(miOrders.orders());
        List<String> ordersbeverages = new ArrayList<>(miOrders.beverages());

        NeoForge.EVENT_BUS.post(new OrderEvent.Add(player, cuisines, beverages, id));

        orders.set(id, BuiltInRegistries.ITEM.getKey(cuisines.getItem()).toString());
        ordersbeverages.set(id, BuiltInRegistries.ITEM.getKey(beverages.getItem()).toString());

        MIOrders miOrders1 = new MIOrders(orders, ordersbeverages, miOrders.blockPos());
        player.setData(MIAttachment.MI_ORDERS.get(), miOrders1);
        PacketDistributor.sendToPlayer(player, miOrders1);
        PacketDistributor.sendToPlayer(player,new OrderAddS2CMessage((byte) id,
                BuiltInRegistries.ITEM.getKey(cuisines.getItem()),
                BuiltInRegistries.ITEM.getKey(beverages.getItem())));
    }
    public static void remove(int id, ServerPlayer player) {

        MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());

        List<String> orders = new ArrayList<>(miOrders.orders());
        List<String> ordersbeverages = new ArrayList<>(miOrders.beverages());

        ItemStack beverages= ItemStack.EMPTY, cuisines= ItemStack.EMPTY;
        NeoForge.EVENT_BUS.post(new OrderEvent.Remove(player, cuisines,beverages,id));

        orders.set(id, "minecraft:air");
        ordersbeverages.set(id, "minecraft:air");

        MIOrders miOrders1 = new MIOrders(orders, ordersbeverages, miOrders.blockPos());
        player.setData(MIAttachment.MI_ORDERS.get(), miOrders1);
        PacketDistributor.sendToPlayer(player, miOrders1);
        PacketDistributor.sendToPlayer(player,new OrderRemoveS2CMessage((byte) id));
    }
}
