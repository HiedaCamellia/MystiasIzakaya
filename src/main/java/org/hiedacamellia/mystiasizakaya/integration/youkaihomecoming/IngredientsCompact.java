package org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;

public class IngredientsCompact {
	public static ItemStack execute(ItemStack itemstack) {
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:raw_lamprey")) {
			return new ItemStack(ItemRegistery.BA_MU_MAN.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:tofu")) {
			return new ItemStack(ItemRegistery.DOU_FU.get());
		}
		if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:butter")) {
			return new ItemStack(ItemRegistery.HUANG_YOU.get());
		}
		return itemstack;
	}
}
