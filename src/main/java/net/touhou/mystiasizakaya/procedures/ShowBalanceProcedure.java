package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ShowBalanceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.mystias_izakaya.balance").getString() + ""
				+ new java.text.DecimalFormat("#######").format((entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance) + "\u5186";
	}
}
