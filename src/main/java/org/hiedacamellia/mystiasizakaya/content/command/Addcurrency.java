
package org.hiedacamellia.mystiasizakaya.content.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.content.command.sub.Add;
import org.hiedacamellia.mystiasizakaya.content.command.sub.Qurey;
import org.hiedacamellia.mystiasizakaya.content.command.sub.Set;

import java.util.HashMap;

@Mod.EventBusSubscriber
public class Addcurrency {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("currency")
				.requires(s -> s.hasPermission(3)).then(Commands.literal("add")
				.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
					HashMap<String, String> cmdparams = new HashMap<>();
					int index = -1;
					for (String param : arguments.getInput().split("\\s+")) {
						if (index >= 0)
							cmdparams.put(Integer.toString(index), param);
						index++;
					}

					Add.execute(arguments);
					return 0;
				})).executes(arguments -> {
					HashMap<String, String> cmdparams = new HashMap<>();
					int index = -1;
					for (String param : arguments.getInput().split("\\s+")) {
						if (index >= 0)
							cmdparams.put(Integer.toString(index), param);
						index++;
					}
					Add.execute(arguments);
					return 0;
				})))).then(Commands.literal("query")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							Qurey.execute(arguments);
							return 0;
						})).executes(arguments -> {
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							Qurey.execute(arguments);
							return 0;
						}))))
				.then(Commands.literal("set")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							Set.execute(arguments);
							return 0;
						})).executes(arguments -> {
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							Set.execute(arguments);
							return 0;
						}))))));
	}
}
