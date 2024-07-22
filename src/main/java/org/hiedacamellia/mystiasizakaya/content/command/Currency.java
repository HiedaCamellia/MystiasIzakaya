package org.hiedacamellia.mystiasizakaya.content.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

@EventBusSubscriber
public class Currency {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
                .requires(s -> s.hasPermission(3)).then(Commands.literal("add")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            Player player = arguments.getSource().getPlayer();
                            int change = IntegerArgumentType.getInteger(arguments, "number");
                            Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
                            _vars.balance += change;
                            _vars.syncPlayerVariables(player);
                            return 0;
						}))))
				.then(Commands.literal("query")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
									Player player = arguments.getSource().getPlayer();
									int change = IntegerArgumentType.getInteger(arguments, "number");
									Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
									_vars.balance -= change;
									_vars.syncPlayerVariables(player);
									return 0;
								})
						)))
                .then(Commands.literal("set")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
							Player player = arguments.getSource().getPlayer();
							int change = IntegerArgumentType.getInteger(arguments, "number");
							Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
							_vars.balance = change;
							_vars.syncPlayerVariables(player);
                            return 0;
                        }))))));
    }
}
