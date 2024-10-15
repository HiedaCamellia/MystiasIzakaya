package org.hiedacamellia.mystiasizakaya.core.cooking.get;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.core.recipes.MIRecipeInput;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetTagFromItemStacks {

	public static List<String> get(RecipeManager recipeManager, ItemStack target, List<ItemStack> ingredients, ItemStack Kitchenware) {
		List<ItemStack> araws = getRest(recipeManager, target, ingredients, Kitchenware);
		List<String> list = newadd(araws);
		return new ArrayList<>(list);
	}

	public static List<String> newadd(List<ItemStack> raws) {
		Set<String> set = new HashSet<>();
		raws.forEach((raw) -> set.addAll(raw.getOrDefault(MIDatacomponet.MI_TAGS.get(),new MITags(new ArrayList<>(),new ArrayList<>())).tags()));
		return new ArrayList<>(set);
	}

	public static List<ItemStack> getRest(RecipeManager recipes, ItemStack target, List<ItemStack> ingredients, ItemStack util){
		if(ingredients.isEmpty())
			return new ArrayList<>();


		if(ItemStack.isSameItem(util ,MIItem.BOILING_POT.get().getDefaultInstance())){
			var optionals = recipes.getAllRecipesFor(
					MIRecipeType.BOILING_POT.get()
			);
			for(var optional : optionals){
				if(ItemStack.isSameItem(optional.value().getResult(),target)) {
					return optional.value().getRestItem(new MIRecipeInput(ingredients));
				}
			}
		}

		if(ItemStack.isSameItem(util ,MIItem.FRYING_PAN.get().getDefaultInstance())){
			var optionals = recipes.getAllRecipesFor(
					MIRecipeType.FRYING_PAN.get()
			);
			for(var optional : optionals){
				if(ItemStack.isSameItem(optional.value().getResult(),target)) {
					return optional.value().getRestItem(new MIRecipeInput(ingredients));
				}
			}
		}

		if(ItemStack.isSameItem(util ,MIItem.GRILL.get().getDefaultInstance())){
			var optionals = recipes.getAllRecipesFor(
					MIRecipeType.GRILL.get()
			);
			for(var optional : optionals){
				if(ItemStack.isSameItem(optional.value().getResult(),target)) {
					return optional.value().getRestItem(new MIRecipeInput(ingredients));
				}
			}
		}

		if(ItemStack.isSameItem(util ,MIItem.CUTTING_BOARD.get().getDefaultInstance())){
			var optionals = recipes.getAllRecipesFor(
					MIRecipeType.CUTTING_BOARD.get()
			);
			for(var optional : optionals){
				if(ItemStack.isSameItem(optional.value().getResult(),target)) {
					return optional.value().getRestItem(new MIRecipeInput(ingredients));
				}
			}
		}

		if(ItemStack.isSameItem(util ,MIItem.STEAMER.get().getDefaultInstance())){
			var optionals = recipes.getAllRecipesFor(
					MIRecipeType.STEAMER.get()
			);
			for(var optional : optionals){
				if(ItemStack.isSameItem(optional.value().getResult(),target)) {
					return optional.value().getRestItem(new MIRecipeInput(ingredients));
				}
			}
		}
		return new ArrayList<>();
	}
}
