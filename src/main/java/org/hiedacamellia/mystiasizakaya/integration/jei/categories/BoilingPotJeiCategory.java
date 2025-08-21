
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.BoilingPotRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class BoilingPotJeiCategory extends BaseJeiCategory<BoilingPotRecipe> {
	public final static ResourceLocation UID = MystiasIzakaya.rl("boiling_pot");

	public static IRecipeType<BoilingPotRecipe> RECIPE_TYPE;

	public BoilingPotJeiCategory(IGuiHelper helper) {
        super(helper,Component.translatable("xei.mystias_izakaya.boiling_pot"),MIItem.BOILING_POT.asItem() );
	}

	@Override
	public IRecipeType<BoilingPotRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}

}
