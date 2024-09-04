
package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Mod.EventBusSubscriber
public class MIDebug {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("debug")

				.then(Commands.literal("orders").then(
						Commands.argument("id", DoubleArgumentType.doubleArg()).then(Commands.literal("cuisines").then(Commands.literal("replace").then(Commands.argument("cuisines", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack cuisines = ItemArgument.getItem(arguments, "cuisines").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(cuisines.getItem())).toString();
							Player player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                orders_list = MIPlayerEvent.getOrders(player);
                                orders_list.set(id, order);
                                MIPlayerEvent.setOrders(player, orders_list);
                                MIPlayerEvent.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							Player player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                orders_list = MIPlayerEvent.getOrders(player);
                                orders_list.set(id, "minecraft:air");
                                MIPlayerEvent.setOrders(player, orders_list);
                                MIPlayerEvent.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("beverages").then(Commands.literal("replace").then(Commands.argument("beverages", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack beverages = ItemArgument.getItem(arguments, "beverages").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(beverages.getItem())).toString();
							Player player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                ordersbeverages_list = MIPlayerEvent.getOrdersBeverages(player);
                                ordersbeverages_list.set(id, order);
                                MIPlayerEvent.setOrdersBeverages(player, ordersbeverages_list);
                                MIPlayerEvent.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							Player player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                ordersbeverages_list = MIPlayerEvent.getOrdersBeverages(player);
                                ordersbeverages_list.set(id, "minecraft:air");
                                MIPlayerEvent.setOrdersBeverages(player, ordersbeverages_list);
                                MIPlayerEvent.syncPlayerVariables(player);
                            }
                            return 0;
                        }))))
                ).then(Commands.literal("telephone").then(Commands.literal("reset").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        player.setData(MIAttachment.MI_TELE_COLDDOWN, new MITeleColddown(0));
                                    }
                                    return 0;
                                }))).then(Commands.literal("menu").then(Commands.literal("dump").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        MIMenu miMenu = player.getData(MIAttachment.MI_MENU);
                                        Component component = Component.empty().append("Menu:[ ");
                                        for(int i=0;i<8;i++){
                                            ItemStack cuisine = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miMenu.orders().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                                            ItemStack beverage = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miMenu.beverages().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                                            Component component1 = Component.empty().append(cuisine.getDisplayName()).append(" ").append(beverage.getDisplayName());
                                            component = Component.empty().append(component).append(Component.literal(i+" ").withStyle(style -> style
                                                    .withColor(ChatFormatting.GREEN)
                                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                                        }
                                        player.sendSystemMessage(Component.empty().append(component).append("]"));

                                        Debug.getLogger().debug(miMenu.toString());
                                    }
                                    return 0;
                                })).then(Commands.literal("reset").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        player.setData(MIAttachment.MI_MENU, new MIMenu(new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
                                    }
                                    return 0;
                                }))).then(Commands.literal("order").then(Commands.literal("dump").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        MIOrders miMenu = player.getData(MIAttachment.MI_ORDERS);
                                        Component component = Component.empty().append("Order:[ ");
                                        for(int i=0;i<miMenu.orders().size();i++){
                                            ItemStack cuisine = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miMenu.orders().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                                            ItemStack beverage = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miMenu.beverages().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                                            Component component1 = Component.empty().append(cuisine.getDisplayName()).append(" ").append(beverage.getDisplayName());
                                            component = Component.empty().append(component).append(Component.literal(i+" ").withStyle(style -> style
                                                    .withColor(ChatFormatting.GREEN)
                                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                                        }
                                        player.sendSystemMessage(Component.empty().append(component).append("]"));
                                        Debug.getLogger().debug(miMenu.toString());
                                    }
                                    return 0;
                                })).then(Commands.literal("reset").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                        player.setData(MIAttachment.MI_ORDERS, new MIOrders(new ArrayList<>(), new ArrayList<>(), miOrders.blockPos()));
                                    }
                                    return 0;
                                }))).then(Commands.literal("table").then(Commands.literal("dump").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        MIOrders miMenu = player.getData(MIAttachment.MI_ORDERS);
                                        Component component = Component.empty().append("Table:[ ");
                                        for(int i=0;i<8;i++){
                                            BlockPos blockPos = miMenu.blockPos().get(i);
                                            Component component1 = Component.empty().append(blockPos.toShortString());
                                            component = Component.empty().append(component).append(Component.literal(i+" ").withStyle(style -> style
                                                    .withColor(ChatFormatting.GREEN)
                                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, component1))));
                                        }
                                        player.sendSystemMessage(Component.empty().append(component).append("]"));
                                        Debug.getLogger().debug(miMenu.toString());
                                    }
                                    return 0;
                                })).then(Commands.literal("reset").executes(arguments -> {
                                    ServerPlayer player = arguments.getSource().getPlayer();
                                    if (player != null) {
                                        MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
                                        player.setData(MIAttachment.MI_ORDERS, new MIOrders(miOrders.orders(), miOrders.beverages(), new ArrayList<>()));
                                    }
                                    return 0;
                                })))
                )
        );
    }
}
