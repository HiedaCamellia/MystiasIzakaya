package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class GetTagsFromNbt {
	public static ArrayList execute(ItemStack itemstack) {
		String s = "";
		s = itemstack.getOrCreateTag().getString("tags");
		ArrayList<String> a;
		if (s != "") {
			String[] tags = s.split(",");
			a = new ArrayList<>(Arrays.asList(tags));
		} else {
			a = new ArrayList<>();
		}
		return a;
	}
}
