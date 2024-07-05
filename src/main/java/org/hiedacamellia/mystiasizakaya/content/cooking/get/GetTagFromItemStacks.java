package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.item.ingredients.*;

import java.util.*;

public class GetTagFromItemStacks {
	public static List<String> get(LevelAccessor world, double x, double y, double z) {
        List<ItemStack> araws = GetRawsFromSelectedFood.execute(world, x, y, z);
  		List<String> list = newadd(araws);
        return new ArrayList<>(list);
	}

	public static List<String> newadd(List<ItemStack> raws) {
		Set<String> set = new HashSet<>();
		raws.forEach((raw) -> set.addAll(List.of(raw.getOrCreateTag().getString("tags").split(","))));
		return new ArrayList<>(set);
	}
}
