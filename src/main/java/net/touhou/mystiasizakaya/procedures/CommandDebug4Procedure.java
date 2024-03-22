package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandDebug4Procedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		MystiasIzakayaModVariables.ordersbeverages.set((int) DoubleArgumentType.getDouble(arguments, "id"), ItemStack.EMPTY);
	}
}
