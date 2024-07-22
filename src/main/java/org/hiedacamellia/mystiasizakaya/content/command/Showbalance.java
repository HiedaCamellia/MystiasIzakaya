
package org.hiedacamellia.mystiasizakaya.content.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

@EventBusSubscriber
public class Showbalance {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("showbalance")

				.then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					if (entity == null)
						return 0;
					{
						boolean _setval = BoolArgumentType.getBool(arguments, "logic");

						Variables.PlayerVariables _vars = entity.getData(Variables.PLAYER_VARIABLES);
						_vars.showbalance = _setval;
						_vars.syncPlayerVariables(entity);

					}
					return 0;
				}))));
	}
}
