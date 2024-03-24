package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;

public class FDProcedure {
	public static ItemStack execute(ItemStack itemstack) {
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("farmersdelight:onion")) {
			return new ItemStack(MystiasIzakayaModItems.YANG_CONG.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("farmersdelight:rice")) {
			return new ItemStack(MystiasIzakayaModItems.NUO_MI.get());
		}
		return itemstack;
	}
}
