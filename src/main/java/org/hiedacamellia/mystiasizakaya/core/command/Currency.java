package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

@EventBusSubscriber
public class Currency {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
                .requires(s -> s.hasPermission(3)).then(Commands.literal("add")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int change = IntegerArgumentType.getInteger(arguments, "number");
                            player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() + change));
                            PacketDistributor.sendToPlayer(player, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
                            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
                            miTurnover = miTurnover.addTurnover("from_command", (double)change);
                            miTurnover = miTurnover.deleteOverStack();
                            player.setData(MIAttachment.MI_TURNOVER, miTurnover);
                            PacketDistributor.sendToPlayer(player, miTurnover);

                            return 0;
                        }))))
                .then(Commands.literal("query")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int change = IntegerArgumentType.getInteger(arguments, "number");
                            player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() - change));
                            PacketDistributor.sendToPlayer(player, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
                            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
                            miTurnover = miTurnover.addTurnover("from_command", (double)change);
                            miTurnover = miTurnover.deleteOverStack();
                            player.setData(MIAttachment.MI_TURNOVER, miTurnover);
                            PacketDistributor.sendToPlayer(player, miTurnover);
                             return 0;
                        }))))
                .then(Commands.literal("set")
                        .then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
                            ServerPlayer player = EntityArgument.getPlayer(arguments, "player");
                            int set = IntegerArgumentType.getInteger(arguments, "number");
                            double change = set - player.getData(MIAttachment.MI_BALANCE).balance();
                            player.setData(MIAttachment.MI_BALANCE, new MIBalance(set));
                            PacketDistributor.sendToPlayer(player, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
                            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
                            miTurnover = miTurnover.addTurnover("from_command",change);
                            miTurnover = miTurnover.deleteOverStack();
                            player.setData(MIAttachment.MI_TURNOVER, miTurnover);
                            PacketDistributor.sendToPlayer(player, miTurnover);
                            return 0;
                        }))))));
    }
}
