
package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.List;
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
						})))))));
	}
}
