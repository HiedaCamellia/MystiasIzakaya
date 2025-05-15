package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.CuttingBoardRecipe;

public class CuttingBoardDisplay extends BaseReiDisplay<CuttingBoardRecipe>{

    public static final CategoryIdentifier<CuttingBoardDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "cutting_board");

    public CuttingBoardDisplay(RecipeHolder<CuttingBoardRecipe> recipe) {
        super(recipe);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }
}
