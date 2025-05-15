package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.BoilingPotRecipe;

public class BoilingPotDisplay extends BaseReiDisplay<BoilingPotRecipe>{

    public static final CategoryIdentifier<BoilingPotDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "boiling_pot");

    public BoilingPotDisplay(RecipeHolder<BoilingPotRecipe> recipe) {
        super(recipe);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }
}
