package org.hiedacamellia.mystiasizakaya.client.util;

import net.minecraft.world.item.crafting.RecipeMap;

public class MIClientUtil {

    private static RecipeMap recipeMap = RecipeMap.EMPTY;

    public static RecipeMap getRecipeMap() {
        return recipeMap;
    }

    public static void setRecipeMap(RecipeMap recipeMap) {
        MIClientUtil.recipeMap = recipeMap;
    }


}
