
package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.network.IzakayaOrderSyncS2CMessage;
import org.hiedacamellia.mystiasizakaya.core.util.MIMessageUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EventBusSubscriber
public class MIDebug {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("debug")
				.then(Commands.literal("order_set").then(
						Commands.argument("id", DoubleArgumentType.doubleArg()).then(Commands.literal("cuisines").then(Commands.literal("replace").then(Commands.argument("cuisines", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack cuisines = ItemArgument.getItem(arguments, "cuisines").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(cuisines.getItem())).toString();
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                                orders_list = new ArrayList<>(izakayaOrder.cuisines());
                                while (orders_list.size() < id+1) {
                                    orders_list.add("");
                                }
                                orders_list.set(id, order);
                                player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(orders_list, izakayaOrder.beverages()));
                                PacketDistributor.sendToPlayer(player,new IzakayaOrderSyncS2CMessage(orders_list, izakayaOrder.beverages()));
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                                orders_list = new ArrayList<>(izakayaOrder.cuisines());
                                while (orders_list.size() < id+1) {
                                    orders_list.add("");
                                }
                                orders_list.set(id, "");
                                player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(orders_list, izakayaOrder.beverages()));
                                PacketDistributor.sendToPlayer(player, new IzakayaOrderSyncS2CMessage(orders_list, izakayaOrder.beverages()));
                            }
                            return 0;
						}))).then(Commands.literal("beverages").then(Commands.literal("replace").then(Commands.argument("beverages", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack beverages = ItemArgument.getItem(arguments, "beverages").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(beverages.getItem())).toString();
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                                ordersbeverages_list = new ArrayList<>(izakayaOrder.beverages());
                                while (ordersbeverages_list.size() < id+1) {
                                    ordersbeverages_list.add("");
                                }
                                ordersbeverages_list.set(id, order);
                                player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(izakayaOrder.cuisines(), ordersbeverages_list));
                                PacketDistributor.sendToPlayer(player, new IzakayaOrderSyncS2CMessage(izakayaOrder.cuisines(), ordersbeverages_list));
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
                            ServerPlayer player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                                ordersbeverages_list = new ArrayList<>(izakayaOrder.beverages());
                                while (ordersbeverages_list.size() < id+1) {
                                    ordersbeverages_list.add("");
                                }
                                ordersbeverages_list.set(id, "");
                                player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(izakayaOrder.cuisines(), ordersbeverages_list));
                                PacketDistributor.sendToPlayer(player, new IzakayaOrderSyncS2CMessage(izakayaOrder.cuisines(), ordersbeverages_list));
                            }
                            return 0;
						}))))
                ).then(Commands.literal("telephone").then(Commands.literal("reset").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        MIPlayerUtil.setTeleCooldown(player,-1);
                    }
                    return 0;
                }))).then(Commands.literal("menu").then(Commands.literal("dump").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        IzakayaMenu izakayaMenu = player.getData(MIAttachment.IZAKAYA_MENU);
                        List<ItemStack> cuisineStacks = izakayaMenu.toCuisineStacks();
                        List<ItemStack> beverageStacks = izakayaMenu.toBeverageStacks();
                        Component component = Component.empty().append("Menu:[ ");
                        for(int i=0;i<8;i++){
                            ItemStack cuisine = cuisineStacks.get(i);
                            ItemStack beverage = beverageStacks.get(i);
                            Component component1 = Component.empty().append(cuisine.getDisplayName()).append(" ").append(beverage.getDisplayName());
                            component = Component.empty().append(component).append(Component.literal((i+1)+" ").withStyle(style -> style
                                    .withColor(ChatFormatting.GREEN)
                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                        }
                        MIMessageUtil.sendDebug(Component.empty().append(component).append("]"),player);
                        MystiasIzakaya.LOGGER.debug(izakayaMenu.toString());
                    }
                    return 0;
                })).then(Commands.literal("reset").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        player.setData(MIAttachment.IZAKAYA_MENU, IzakayaMenu.init());
                    }
                    return 0;
                }))).then(Commands.literal("order").then(Commands.literal("dump").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                        List<ItemStack> cuisineStacks = izakayaOrder.toCuisineStacks();
                        List<ItemStack> beverageStacks = izakayaOrder.toBeverageStacks();
                        Component component = Component.empty().append("Order:[ ");
                        for(int i = 0; i<izakayaOrder.cuisines().size(); i++){
                            ItemStack cuisine = cuisineStacks.get(i);
                            ItemStack beverage = beverageStacks.get(i);
                            Component component1 = Component.empty().append(cuisine.getDisplayName()).append(" ").append(beverage.getDisplayName());
                            component = Component.empty().append(component).append(Component.literal((i+1)+" ").withStyle(style -> style
                                    .withColor(ChatFormatting.GREEN)
                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                        }
                        MIMessageUtil.sendDebug(Component.empty().append(component).append("]"),player);
                        MystiasIzakaya.LOGGER.debug(izakayaOrder.toString());
                    }
                    return 0;
                })).then(Commands.literal("reset").executes(arguments -> {
                    ServerPlayer player = arguments.getSource().getPlayer();
                    if (player != null) {
                        IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                        player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(new ArrayList<>(), new ArrayList<>()));
                    }
                    return 0;
                }))).then(Commands.literal("table").then(Commands.literal("dump").executes(arguments -> {
                            ServerPlayer player = arguments.getSource().getPlayer();
                            if (player != null) {
                                List<BlockPos> tables = MIPlayerUtil.getTables(player);
                                Component component = Component.empty().append("Table:[ ");
                                for(int i=0;i<8;i++){
                                    BlockPos blockPos = tables.get(i);
                                    Component component1 = Component.empty().append(blockPos.toShortString());
                                    component = Component.empty().append(component).append(Component.literal((i+1)+" ").withStyle(style -> style
                                            .withColor(ChatFormatting.GREEN)
                                            .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                                }
                                MIMessageUtil.sendDebug(Component.empty().append(component).append("]"),player);
                                MystiasIzakaya.LOGGER.debug(tables.toString());
                            }
                            return 0;
                        })).then(Commands.literal("reset").executes(arguments -> {
                            ServerPlayer player = arguments.getSource().getPlayer();
                            if (player != null) {
                                IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER);
                                player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(izakayaOrder.cuisines(), izakayaOrder.beverages()));
                            }
                            return 0;
                        })))
                )
        );
	}
}
