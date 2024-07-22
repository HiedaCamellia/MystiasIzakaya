package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.ValueRecord;

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
		raws.forEach((raw) -> set.addAll(List.of(raw.getOrDefault(DataComponentsReg.Tags.get(),new ValueRecord("")).value().split(","))));
		return new ArrayList<>(set);
	}
}
