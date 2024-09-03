package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.concurrent.CompletableFuture;

public class MIRecipeProvider extends RecipeProvider {
    public MIRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Add your recipe here.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,MIItem.TELEPHONE)
                .pattern("SXS")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('S', Items.IRON_INGOT)
                .define('X', Items.ENDER_PEARL)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,MIItem.TABLE)
                .pattern("#")
                .pattern("X")
                .define('#', ItemTags.WOODEN_SLABS)
                .define('X', ItemTags.WOODEN_FENCES)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MIItem.LEDGER)
                .requires(Items.BOOK)
                .requires(Items.PAPER)
                .requires(Items.PAPER)
                .unlockedBy("has_book", has(Items.BOOK))
                .save(output);

    }
}
