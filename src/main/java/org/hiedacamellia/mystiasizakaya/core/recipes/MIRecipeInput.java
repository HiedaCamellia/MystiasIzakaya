package org.hiedacamellia.mystiasizakaya.core.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record MIRecipeInput(List<ItemStack> stack) implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        return this.stack().get(slot);
    }

    @Override
    public int size() {
        return 5;
    }
}
