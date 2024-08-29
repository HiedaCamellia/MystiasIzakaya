package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.List;
import java.util.Objects;

public class GetCuisinesTexture {
	public static ItemStack execute(double id, Player player) {
		List<String> orders_list = MIPlayerEvent.getOrders(player);
		if(orders_list.size()<=id)
			return ItemStack.EMPTY;

		String order = orders_list.get((int) id);
		TagKey<Item> tag = ItemTags.create(new ResourceLocation("mystias_izakaya:cuisines"));
		ItemStack now = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(order))));
		if (now.is(tag))
			return now;
		else
			return ItemStack.EMPTY;
	}
}
