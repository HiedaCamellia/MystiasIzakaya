package org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;

public class IngredientsCompact {
	public static ItemStack execute(ItemStack itemstack) {
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:raw_lamprey")) {
			return new ItemStack(ItemRegistery.BA_MU_MAN.get());
		}
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:tofu")) {
			return new ItemStack(ItemRegistery.DOU_FU.get());
		}
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:butter")) {
			return new ItemStack(ItemRegistery.HUANG_YOU.get());
		}
		return itemstack;
	}
}
