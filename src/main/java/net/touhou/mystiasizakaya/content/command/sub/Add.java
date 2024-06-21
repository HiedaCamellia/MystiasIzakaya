package net.touhou.mystiasizakaya.content.command.sub;

import net.touhou.mystiasizakaya.functionals.network.Variables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class Add {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			double _setval = ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables())).balance + DoubleArgumentType.getDouble(arguments, "number");
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.balance = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
	}
}
