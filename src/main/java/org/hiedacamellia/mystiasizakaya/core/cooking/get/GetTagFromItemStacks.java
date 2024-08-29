package org.hiedacamellia.mystiasizakaya.core.cooking.get;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetTagFromItemStacks {

	public static List<String> get(ItemStack target,List<ItemStack> ingredients) {
		List<ItemStack> araws = GetRawsFromSelectedFood.execute(target,ingredients);
		List<String> list = newadd(araws);
		return new ArrayList<>(list);
	}

	public static List<String> newadd(List<ItemStack> raws) {
		Set<String> set = new HashSet<>();
		raws.forEach((raw) -> set.addAll(raw.getOrDefault(MIDatacomponet.MI_TAGS.get(),new MITags(new ArrayList<>(),new ArrayList<>())).tags()));
		return new ArrayList<>(set);
	}
}
