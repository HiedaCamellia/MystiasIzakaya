package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

@EventBusSubscriber
public class Currency {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
				.requires(s -> s.hasPermission(3)).then(Commands.literal("add")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
							Player player = arguments.getSource().getPlayer();
							int change = IntegerArgumentType.getInteger(arguments, "number");
							if (player != null) {
								player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() + change));
							}
							return 0;
						}))))
				.then(Commands.literal("query")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
									Player player = arguments.getSource().getPlayer();
									int change = IntegerArgumentType.getInteger(arguments, "number");
									if (player != null) {
										player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() - change));
									}
									return 0;
								})
						)))
				.then(Commands.literal("set")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", IntegerArgumentType.integer(0)).executes(arguments -> {
							Player player = arguments.getSource().getPlayer();
							int change = IntegerArgumentType.getInteger(arguments, "number");
							if (player != null) {
								player.setData(MIAttachment.MI_BALANCE, new MIBalance(change));
							}
							return 0;
						}))))));
    }
}
