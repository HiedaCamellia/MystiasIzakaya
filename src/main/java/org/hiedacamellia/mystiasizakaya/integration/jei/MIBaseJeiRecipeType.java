package org.hiedacamellia.mystiasizakaya.integration.jei;

import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.core.recipes.MIRecipe;

public class MIBaseJeiRecipeType<T extends MIRecipe> implements IRecipeType<T> {

    private final ResourceLocation id;
    private final Class<T> recipeClass;

    public MIBaseJeiRecipeType(ResourceLocation id, Class<T> recipeClass) {
        this.id = id;
        this.recipeClass = recipeClass;
    }

    @Override
    public ResourceLocation getUid() {
        return id;
    }

    @Override
    public Class<T> getRecipeClass() {
        return recipeClass;
    }
}
