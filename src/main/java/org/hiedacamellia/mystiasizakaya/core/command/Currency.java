package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;


public class Currency {
    public static void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
                    .requires(s -> s.hasPermission(3)).then(Commands.literal("add")
                            .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                                ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                                int change = IntegerArgumentType.getInteger(arguments, "number");
                                MIPlayerEvent.setBalance(player, MIPlayerEvent.getBalance(player) + change);
                                MIPlayerEvent.addTurnover(player, "from_command", change);
                                MIPlayerEvent.deleteOverTurnover(player);
                                MIPlayerEvent.syncPlayerVariables(player);
                                return 0;
                            }))))
                    .then(Commands.literal("query")
                            .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                                ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                                int change = IntegerArgumentType.getInteger(arguments, "number");
                                MIPlayerEvent.setBalance(player, MIPlayerEvent.getBalance(player) - change);
                                MIPlayerEvent.addTurnover(player, "from_command", -change);
                                MIPlayerEvent.deleteOverTurnover(player);
                                MIPlayerEvent.syncPlayerVariables(player);
                                return 0;
                            }))))
                    .then(Commands.literal("set")
                            .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                                ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                                int set = IntegerArgumentType.getInteger(arguments, "number");
                                int change = (int) (set - MIPlayerEvent.getBalance(player));
                                MIPlayerEvent.setBalance(player, set);
                                MIPlayerEvent.addTurnover(player, "from_command", change);
                                MIPlayerEvent.deleteOverTurnover(player);
                                MIPlayerEvent.syncPlayerVariables(player);
                                return 0;
                            }))))));
        });
    }
}

