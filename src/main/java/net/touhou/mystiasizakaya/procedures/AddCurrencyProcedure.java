package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class AddCurrencyProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == MystiasIzakayaModItems.EN_1.get()) {
			{
				double _setval = itemstack.getCount() + (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance;
				entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (itemstack.getItem() == MystiasIzakayaModItems.EN_5.get()) {
			{
				double _setval = 5 * itemstack.getCount() + (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance;
				entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (itemstack.getItem() == MystiasIzakayaModItems.EN_10.get()) {
			{
				double _setval = 10 * itemstack.getCount() + (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance;
				entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (itemstack.getItem() == MystiasIzakayaModItems.EN_10K.get()) {
			{
				double _setval = 10000 * itemstack.getCount() + (entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance;
				entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		itemstack.shrink(itemstack.getCount());
	}
}
