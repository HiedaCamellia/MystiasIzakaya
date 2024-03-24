package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class GetBeveragesTextureProcedure {
	public static String execute(double id) {
		ItemStack i = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		String fm = "";
		InitordersProcedure.execute();
		target = (MystiasIzakayaModVariables.ordersbeverages.get((int) id) instanceof ItemStack _bs ? _bs : ItemStack.EMPTY);
		if (!target.is(ItemTags.create(new ResourceLocation("mystiasizakaya:beverages")))) {
			return "";
		}
		return GetTextureProcedure.execute(target);
	}
}
