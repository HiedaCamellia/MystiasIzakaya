package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

import java.util.List;

public class GetBeveragesTexture {
	public static String execute(double id, Player player) {
		Initorders.init(player);
		List<String> orders_list = player.getData(Variables.PLAYER_VARIABLES).orders;
		if(orders_list.size()<=id) return "";
		String order = orders_list.get((int) id);
		TagKey<Item> tag = ItemTags.create(ResourceLocation.parse("mystias_izakaya:beverages"));
		if (!new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(order))).is(tag)) {
			return "";
		}
		return order.split(":")[1]+ "_";
	}
}
