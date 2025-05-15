package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;

@EventBusSubscriber
public class Currency {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
                .requires(s -> s.hasPermission(3)).then(Commands.literal("add")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int change = IntegerArgumentType.getInteger(arguments, "number");
                            BalanceUtil.command(player,change);
                            return 0;
                        }))))
                .then(Commands.literal("reduce")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int change = -IntegerArgumentType.getInteger(arguments, "number");
                            BalanceUtil.command(player,change);
                             return 0;
                        }))))
                .then(Commands.literal("set")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int set = IntegerArgumentType.getInteger(arguments, "number");
                            int change = set - BalanceUtil.getBalance(player);
                            BalanceUtil.command(player,change);
                            return 0;
                        }))))));
    }
}
