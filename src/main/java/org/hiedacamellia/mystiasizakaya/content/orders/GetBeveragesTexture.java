package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.List;

public class GetBeveragesTexture {
	public static ItemStack execute(double id, Player player) {
		List<String> orders_list = player.getData(MIAttachment.MI_ORDERS).beverages();
		if(orders_list.size()<=id) return ItemStack.EMPTY;
		String order = orders_list.get((int) id);
		TagKey<Item> tag = ItemTags.create(ResourceLocation.parse("mystias_izakaya:beverages"));
		ItemStack now = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(order)));
		if (!now.is(tag))
			return ItemStack.EMPTY;
		else
			return now;
	}
}
