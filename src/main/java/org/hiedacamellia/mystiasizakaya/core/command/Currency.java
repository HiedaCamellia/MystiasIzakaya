package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

@Mod.EventBusSubscriber
public class Currency {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
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
    }
}
