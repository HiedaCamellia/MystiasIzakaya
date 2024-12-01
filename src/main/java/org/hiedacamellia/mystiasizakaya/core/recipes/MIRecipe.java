package org.hiedacamellia.mystiasizakaya.core.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public abstract class MIRecipe implements Recipe<MIRecipeInput> {

    protected final ItemStack output;
    protected final NonNullList<Ingredient> recipeItems;

    public MIRecipe(ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    public List<ItemStack> getRestItem(MIRecipeInput recipeInput){
        List<ItemStack> restItems = recipeInput.stacks();
        try {
            for (ItemStack itemStack : recipeInput.stacks()) {
                for (Ingredient ingredient : recipeItems) {
                    if (ingredient.isEmpty() || ingredient == Ingredient.EMPTY)
                        continue;
                    if (ingredient.test(itemStack)) {
                        restItems.remove(itemStack);
                        break;
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
            if(ingredient.isEmpty()||ingredient==Ingredient.EMPTY)
                continue;
            boolean a=false;
            for(ItemStack itemStack :recipeInput.stacks()){
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
    public ItemStack assemble(MIRecipeInput recipeInput, RegistryAccess access) {
        return output.copy();
    }
    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return output.copy();
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public List<Ingredient> getInputItems() {
        return recipeItems;
    }
    public ItemStack getResult() {
        return output;
    }
}
