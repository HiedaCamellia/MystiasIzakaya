
package org.hiedacamellia.mystiasizakaya.core.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.core.config.ClientConfig;

public class Showbalance {
	public static void registerCommands() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("mystiasizakaya")
					.then(Commands.literal("showbalance")
							.then(Commands.argument("logic", BoolArgumentType.bool())
									.executes(context -> {
										Level world = context.getSource().getLevel();
										Entity entity = context.getSource().getEntity();

										if (entity == null && world instanceof ServerLevel _servLevel) {
											entity = FakePlayerFactory.getMinecraft(_servLevel);
										}
										if (entity == null) {
											return 0;
										}

										{
											boolean set = BoolArgumentType.getBool(context, "logic");
											ClientConfig.SHOW_BALANCE.set(set);
										}

										return 0; // 命令成功执行
									}))));
		});
	}
}
