package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

import java.util.List;

public class Initorders {
	public static void init(Player player) {
		Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
		if (_vars.orders.size() < 8) {
			for (int i = 0; i < 10; i++) {
				_vars.orders.add("minecraft:air");
			}
		}
		if (_vars.ordersbeverages.size() < 8) {
			for (int i = 0; i < 10; i++) {
				_vars.ordersbeverages.add("minecraft:air");
			}
		}
		_vars.syncPlayerVariables(player);
	}
}
