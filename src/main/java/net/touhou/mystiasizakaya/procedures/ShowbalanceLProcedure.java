package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.Variables;

import net.minecraft.world.entity.Entity;

public class ShowbalanceLProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables())).showbalance;
	}
}
