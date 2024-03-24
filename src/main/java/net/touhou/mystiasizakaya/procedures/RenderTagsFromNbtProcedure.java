package net.touhou.mystiasizakaya.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.ArrayList;

public class RenderTagsFromNbtProcedure {
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
