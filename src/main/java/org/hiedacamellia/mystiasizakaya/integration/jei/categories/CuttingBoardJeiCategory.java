
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.CuttingBoardRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class CuttingBoardJeiCategory extends BaseJeiCategory<CuttingBoardRecipe> {
	public final static ResourceLocation UID = MystiasIzakaya.rl( "cutting_board");

	public static mezz.jei.api.recipe.RecipeType<CuttingBoardRecipe> RECIPE_TYPE;
	public CuttingBoardJeiCategory(IGuiHelper helper) {
        super(helper,Component.translatable("xei.mystias_izakaya.cutting_board"),MIItem.CUTTING_BOARD.asItem());
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<CuttingBoardRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}

}
