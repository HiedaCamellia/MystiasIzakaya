
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.FryingPanRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class FryingPanJeiCategory extends BaseJeiCategory<FryingPanRecipe> {
	public final static ResourceLocation UID = MystiasIzakaya.rl("frying_pan");

	public static mezz.jei.api.recipe.RecipeType<FryingPanRecipe> RECIPE_TYPE;

	public FryingPanJeiCategory(IGuiHelper helper) {
        super(helper,Component.translatable("xei.mystias_izakaya.frying_pan"),MIItem.FRYING_PAN.asItem());
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<FryingPanRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}

}
