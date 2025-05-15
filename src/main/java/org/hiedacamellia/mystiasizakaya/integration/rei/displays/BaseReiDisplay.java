package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.Collections;

public abstract class BaseReiDisplay<T extends Recipe<?>> extends BasicDisplay {

    public BaseReiDisplay(RecipeHolder<T> recipe){
        super(EntryIngredients.ofIngredients(recipe.value().getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.value().getResultItem(BasicDisplay.registryAccess()))));
    }

}
