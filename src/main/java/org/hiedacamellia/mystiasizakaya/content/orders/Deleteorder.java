package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

import java.util.List;

public class Deleteorder {
	public static void execute(double id, Player player) {
		Variables.PlayerVariables _vars = player.getData(Variables.PLAYER_VARIABLES);
		_vars.orders.set((int) id, "minecraft:air");
		_vars.ordersbeverages.set((int) id, "minecraft:air");
		_vars.syncPlayerVariables(player);
	}
}
