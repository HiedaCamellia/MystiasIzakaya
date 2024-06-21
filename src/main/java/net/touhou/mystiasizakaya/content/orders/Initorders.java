package net.touhou.mystiasizakaya.content.orders;

import net.minecraft.world.entity.player.Player;
import net.touhou.mystiasizakaya.functionals.network.Variables;

import java.util.List;

public class Initorders {
	public static void init(Player player) {
		List<String> orders_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).orders;
		List<String> ordersbeverages_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).ordersbeverages;
		if (orders_list.size() < 8) {
			for (int i = 0; i < 10; i++) {
				orders_list.add("minecraft:air");
			}
		}
		if (ordersbeverages_list.size() < 8) {
			for (int i = 0; i < 10; i++) {
				ordersbeverages_list.add("minecraft:air");
			}
		}
		player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.orders = orders_list;
			capability.ordersbeverages = ordersbeverages_list;
			capability.syncPlayerVariables(player);
		});
	}
}
