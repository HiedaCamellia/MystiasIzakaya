package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

import java.util.List;

public class Deleteorder {
	public static void execute(double id, Player player) {
		List<String> orders_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).orders;
		List<String> ordersbeverages_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).ordersbeverages;
		String cuisines_str = "minecraft:air";
		String beverages_str = "minecraft:air";
		orders_list.set((int) id, cuisines_str);
		ordersbeverages_list.set((int) id, beverages_str);
		player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.orders = orders_list;
			capability.ordersbeverages = ordersbeverages_list;
			capability.syncPlayerVariables(player);
		});
	}
}
