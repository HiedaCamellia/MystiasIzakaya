package net.touhou.mystiasizakaya.orders;

import net.minecraft.world.entity.player.Player;
import net.touhou.mystiasizakaya.network.Variables;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public class Initorders {
	public static void init(Player player) {
		List<String> orders_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).orders;
		List<String> ordersbeverages_list = player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables()).ordersbeverages;
		if (orders_list.size() == 0) {
			for (int i = 0; i < 10; i++) {
				orders_list.add("");
			}
		}
		if (ordersbeverages_list.size() == 0) {
			for (int i = 0; i < 10; i++) {
				ordersbeverages_list.add("");
			}
		}
		player.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.orders = orders_list;
			capability.ordersbeverages = ordersbeverages_list;
			capability.syncPlayerVariables(player);
		});
	}
}
