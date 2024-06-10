package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.Variables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ShowbalancePProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = BoolArgumentType.getBool(arguments, "logic");
			entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.showbalance = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
