
package net.touhou.mystiasizakaya.command;

import org.checkerframework.checker.units.qual.s;

import net.touhou.mystiasizakaya.procedures.CommandPSProcedure;
import net.touhou.mystiasizakaya.procedures.CommandPProcedure;
import net.touhou.mystiasizakaya.procedures.CommandPMProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import java.util.HashMap;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class AddcurrencycommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mi_currency").requires(s -> s.hasPermission(3)).then(Commands.literal("add")
				.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();
					HashMap<String, String> cmdparams = new HashMap<>();
					int index = -1;
					for (String param : arguments.getInput().split("\\s+")) {
						if (index >= 0)
							cmdparams.put(Integer.toString(index), param);
						index++;
					}

					CommandPProcedure.execute(arguments);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();
					HashMap<String, String> cmdparams = new HashMap<>();
					int index = -1;
					for (String param : arguments.getInput().split("\\s+")) {
						if (index >= 0)
							cmdparams.put(Integer.toString(index), param);
						index++;
					}

					CommandPProcedure.execute(arguments);
					return 0;
				})))).then(Commands.literal("query")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							CommandPMProcedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							CommandPMProcedure.execute(arguments);
							return 0;
						}))))
				.then(Commands.literal("set")
						.then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							CommandPSProcedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							CommandPSProcedure.execute(arguments);
							return 0;
						})))));
	}
}
