package org.hiedacamellia.mystiasizakaya.integration.compact;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.registries.MITag;
import org.hiedacamellia.mystiasizakaya.util.Tag2Item;

public class IngredientsCompact {
	public static ItemStack execute(ItemStack itemstack) {
		for(TagKey<Item> key:MITag.ingredients.values()){
			if(itemstack.is(key)){
				return Tag2Item.regs.get(key).getDefaultInstance();
			}
		}
		return itemstack;
	}
}
