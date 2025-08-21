package org.hiedacamellia.mystiasizakaya.core.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.ArrayList;
import java.util.List;

public abstract class MIRecipe implements Recipe<MIRecipeInput> {

    protected final ItemStack output;
    protected final List<Ingredient> recipeItems;

    public MIRecipe(ItemStack output, List<Ingredient> recipeItems) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public List<ItemStack> getRestItem(MIRecipeInput recipeInput){
        List<ItemStack> restItems = new ArrayList<>(recipeInput.stack());
        try {
            for (ItemStack itemStack : recipeInput.stack()) {
                for (Ingredient ingredient : recipeItems) {

                    if (ingredient.isEmpty() || ingredient.getValues().get(0).is(MITag.ingredientsKey))
                        continue;
                    if (ingredient.test(itemStack)) {
                        restItems.remove(itemStack);
                    }
                }
            }
            return restItems;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public boolean matches(MIRecipeInput recipeInput, Level level) {
        for(Ingredient ingredient : recipeItems){
            if(ingredient.isEmpty())
                continue;
            boolean a=false;
            for(ItemStack itemStack :recipeInput.stack()){
                if(ingredient.test(itemStack)){
                    a=true;
                    break;
                }
            }
            if(!a){
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(MIRecipeInput recipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(recipeItems);
    }

    public List<Ingredient> getInputItems() {
        return recipeItems;
    }
    public ItemStack getResult() {
        return output;
    }
}
