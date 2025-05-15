package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.SteamerRecipe;

public class SteamerDisplay extends BaseReiDisplay<SteamerRecipe>{

    public static final CategoryIdentifier<SteamerDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "steamer");

    public SteamerDisplay(RecipeHolder<SteamerRecipe> recipe) {
        super(recipe);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }
}
