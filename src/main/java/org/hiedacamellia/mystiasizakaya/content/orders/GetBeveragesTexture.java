package org.hiedacamellia.mystiasizakaya.content.orders;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.List;
import java.util.Objects;

public class GetBeveragesTexture {
	public static ItemStack execute(double id, Player player) {
		List<String> orders_list = MIPlayerEvent.getOrdersBeverages(player);
		if(orders_list.size()<=id)
			return ItemStack.EMPTY;

		String order = orders_list.get((int) id);
		ItemStack now = new ItemStack(Objects.requireNonNull(BuiltInRegistries.ITEM.get(new ResourceLocation(order))));
		if (now.is(MITag.beveragesKey))
			return now;
		else
			return ItemStack.EMPTY;
	}
}
