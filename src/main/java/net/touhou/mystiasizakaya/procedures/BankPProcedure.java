package net.touhou.mystiasizakaya.procedures;

import org.checkerframework.checker.units.qual.s;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class BankPProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		double i = 0;
		double j = 0;
		i = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:input") ? ((EditBox) guistate.get("text:input")).getValue() : "");
		if (!(i < 0) && (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance >= i) {
			{
				double _setval = (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance - i;
				entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			j = Math.floor(i / 10);
			i = i - j * 10;
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(MystiasIzakayaModItems.EN_10.get());
				_setstack.setCount((int) j);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(MystiasIzakayaModItems.EN_1.get());
				_setstack.setCount((int) i);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
