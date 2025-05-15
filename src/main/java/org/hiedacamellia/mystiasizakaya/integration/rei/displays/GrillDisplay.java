package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.GrillRecipe;

public class GrillDisplay extends BaseReiDisplay<GrillRecipe>{

    public static final CategoryIdentifier<GrillDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "grill");

    public GrillDisplay(RecipeHolder<GrillRecipe> recipe) {
        super(recipe);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }
}
