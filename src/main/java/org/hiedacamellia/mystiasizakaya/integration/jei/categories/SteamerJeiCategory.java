
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.SteamerRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class SteamerJeiCategory extends BaseJeiCategory<SteamerRecipe> {
	public final static ResourceLocation UID = MystiasIzakaya.rl("steamer");

	public static IRecipeType<SteamerRecipe> RECIPE_TYPE;
	public SteamerJeiCategory(IGuiHelper helper) {
        super(helper,Component.translatable("xei.mystias_izakaya.steamer"),MIItem.STEAMER.asItem());
	}

	@Override
	public IRecipeType<SteamerRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}

}
