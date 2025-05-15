package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.FryingPanRecipe;

public class FryingPanDisplay extends BaseReiDisplay<FryingPanRecipe>{

    public static final CategoryIdentifier<FryingPanDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "frying_pan");

    public FryingPanDisplay(RecipeHolder<FryingPanRecipe> recipe) {
        super(recipe);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }
}
