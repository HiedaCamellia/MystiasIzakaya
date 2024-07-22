
package org.hiedacamellia.mystiasizakaya.content.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

@EventBusSubscriber
public class Debug {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("debug")

				.then(Commands.literal("orders").then(
						Commands.argument("id", DoubleArgumentType.doubleArg()).then(Commands.literal("cuisines").then(Commands.literal("replace").then(Commands.argument("cuisines", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack cuisines = ItemArgument.getItem(arguments, "cuisines").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(cuisines.getItem())).toString();
							Player player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                orders_list = player.getData(Variables.PLAYER_VARIABLES).orders;
                            } else {
                                orders_list = null;
                            }
                            if (orders_list != null) {
                                orders_list.set(id, order);
                            }
                            if (player != null) {
                                Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
                                _vars.orders = orders_list;
                                _vars.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							Player player = arguments.getSource().getPlayer();
                            List<String> orders_list;
                            if (player != null) {
                                orders_list = player.getData(Variables.PLAYER_VARIABLES).orders;
                            } else {
                                orders_list = null;
                            }
                            if (orders_list != null) {
                                orders_list.set(id, "minecraft:air");
                            }
                            if (player != null) {
                                Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
                                _vars.orders = orders_list;
                                _vars.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("beverages").then(Commands.literal("replace").then(Commands.argument("beverages", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							ItemStack beverages = ItemArgument.getItem(arguments, "beverages").getItem().getDefaultInstance();
							String order = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(beverages.getItem())).toString();
							Player player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                ordersbeverages_list = player.getData(Variables.PLAYER_VARIABLES).ordersbeverages;
                            } else {
                                ordersbeverages_list = null;
                            }
                            if (ordersbeverages_list != null) {
                                ordersbeverages_list.set(id, order);
                            }
                            if (player != null) {
                                Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
                                _vars.ordersbeverages = ordersbeverages_list;
                                _vars.syncPlayerVariables(player);
                            }
                            return 0;
						}))).then(Commands.literal("clean").executes(arguments -> {
							int id = (int) DoubleArgumentType.getDouble(arguments, "id");
							Player player = arguments.getSource().getPlayer();
                            List<String> ordersbeverages_list;
                            if (player != null) {
                                ordersbeverages_list = player.getData(Variables.PLAYER_VARIABLES).ordersbeverages;
                            } else {
                                ordersbeverages_list = null;
                            }
                            if (ordersbeverages_list != null) {
                                ordersbeverages_list.set(id, "minecraft:air");
                            }
                            if (player != null) {
                                Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
                                _vars.ordersbeverages = ordersbeverages_list;
                                _vars.syncPlayerVariables(player);
                            }
                            return 0;
						})))))));
	}
}
