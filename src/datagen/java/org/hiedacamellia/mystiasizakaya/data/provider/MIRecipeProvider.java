package org.hiedacamellia.mystiasizakaya.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.concurrent.CompletableFuture;

public class MIRecipeProvider extends RecipeProvider {


    protected MIRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Add your recipe here.
        shaped(RecipeCategory.MISC,MIItem.TELEPHONE)
                .pattern("SXS")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('S', Items.IRON_INGOT)
                .define('X', Items.ENDER_PEARL)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(output);
        shaped(RecipeCategory.MISC,MIItem.TABLE)
                .pattern("#")
                .pattern("X")
                .define('#', ItemTags.WOODEN_SLABS)
                .define('X', ItemTags.WOODEN_FENCES)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(output);
        shapeless(RecipeCategory.MISC,MIItem.LEDGER)
                .requires(Items.BOOK)
                .requires(Items.PAPER)
                .requires(Items.PAPER)
                .unlockedBy("has_book", has(Items.BOOK))
                .save(output);

    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected MIRecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new MIRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return MystiasIzakaya.MODID+"_recipes";
        }
    }
}
