package org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class IngredientsCompact {
	public static ItemStack execute(ItemStack itemstack) {
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:raw_lamprey")) {
			return new ItemStack(MIItem.BA_MU_MAN.get());
		}
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:tofu")) {
			return new ItemStack(MIItem.DOU_FU.get());
		}
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).equals("youkaihomecoming:butter")) {
			return new ItemStack(MIItem.HUANG_YOU.get());
		}
		return itemstack;
	}
}
