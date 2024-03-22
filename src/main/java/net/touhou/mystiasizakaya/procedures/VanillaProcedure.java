package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;

public class VanillaProcedure {
	public static ItemStack execute(ItemStack itemstack) {
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("minecraft:potato")) {
			return new ItemStack(MystiasIzakayaModItems.TU_DOU.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("minecraft:beef")) {
			return new ItemStack(MystiasIzakayaModItems.NIU_ROU.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("minecraft:pockchop")) {
			return new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("minecraft:pufferfish")) {
			return new ItemStack(MystiasIzakayaModItems.HE_TUN.get());
		}
		return itemstack;
	}
}
