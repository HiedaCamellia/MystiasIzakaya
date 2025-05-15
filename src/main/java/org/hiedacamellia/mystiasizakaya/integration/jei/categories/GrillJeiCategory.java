
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.GrillRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class GrillJeiCategory extends BaseJeiCategory<GrillRecipe> {
	public final static ResourceLocation UID = MystiasIzakaya.rl("grill");

	public static mezz.jei.api.recipe.RecipeType<GrillRecipe> RECIPE_TYPE;
	public GrillJeiCategory(IGuiHelper helper) {
        super(helper,Component.translatable("xei.mystias_izakaya.grill"),MIItem.GRILL.asItem());
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<GrillRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}


}
