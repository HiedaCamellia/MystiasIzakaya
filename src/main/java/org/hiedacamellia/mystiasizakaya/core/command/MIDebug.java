
package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EventBusSubscriber
public class MIDebug {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("debug")
				.then(Commands.literal("orders").then(
						Commands.argument("id", DoubleArgumentType.doubleArg()).then(Commands.literal("cuisines").then(Commands.literal("replace").then(Commands.argument("cuisines", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack cuisines = ItemArgument.getItem(arguments, "cuisines").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(cuisines.getItem())).toString();
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                orders_list = new ArrayList<>(miOrders.orders());
                                while (orders_list.size() < id+1) {
                                    orders_list.add("");
                                }
                                orders_list.set(id, order);
                                player.setData(MIAttachment.MI_ORDERS, new MIOrders(orders_list, miOrders.beverages(), miOrders.blockPos()));
                                PacketDistributor.sendToPlayer(player, new MIOrders(orders_list, miOrders.beverages(), miOrders.blockPos()));
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                orders_list = new ArrayList<>(miOrders.orders());
                                while (orders_list.size() < id+1) {
                                    orders_list.add("");
                                }
                                orders_list.set(id, "");
                                player.setData(MIAttachment.MI_ORDERS, new MIOrders(orders_list, miOrders.beverages(), miOrders.blockPos()));
                                PacketDistributor.sendToPlayer(player, new MIOrders(orders_list, miOrders.beverages(), miOrders.blockPos()));
                            }
                            return 0;
						}))).then(Commands.literal("beverages").then(Commands.literal("replace").then(Commands.argument("beverages", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack beverages = ItemArgument.getItem(arguments, "beverages").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(beverages.getItem())).toString();
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                ordersbeverages_list = new ArrayList<>(miOrders.beverages());
                                while (ordersbeverages_list.size() < id+1) {
                                    ordersbeverages_list.add("");
                                }
                                ordersbeverages_list.set(id, order);
                                player.setData(MIAttachment.MI_ORDERS, new MIOrders(miOrders.orders(), ordersbeverages_list, miOrders.blockPos()));
                                PacketDistributor.sendToPlayer(player, new MIOrders(miOrders.orders(), ordersbeverages_list, miOrders.blockPos()));
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                ordersbeverages_list = new ArrayList<>(miOrders.beverages());
                                while (ordersbeverages_list.size() < id+1) {
                                    ordersbeverages_list.add("");
                                }
                                ordersbeverages_list.set(id, "");
                                player.setData(MIAttachment.MI_ORDERS, new MIOrders(miOrders.orders(), ordersbeverages_list, miOrders.blockPos()));
                                PacketDistributor.sendToPlayer(player, new MIOrders(miOrders.orders(), ordersbeverages_list, miOrders.blockPos()));
                            }
                            return 0;
						}))))
                ).then(Commands.literal("telephone").then(Commands.literal("reset").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        player.setData(MIAttachment.MI_TELE_COLDDOWN, new MITeleColddown(0));
                    }
                    return 0;
                })))
        ));
	}
}
