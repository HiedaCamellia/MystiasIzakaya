package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MIRecipeProvider extends RecipeProvider {
    public MIRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MIItem.TELEPHONE.get())
                .pattern("SXS")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('S', Items.IRON_INGOT)
                .define('X', Items.ENDER_PEARL)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,MIItem.TABLE.get())
                .pattern("#")
                .pattern("X")
                .define('#', ItemTags.WOODEN_SLABS)
                .define('X', ItemTags.WOODEN_FENCES)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MIItem.LEDGER.get())
                .requires(Items.BOOK)
                .requires(Items.PAPER)
                .requires(Items.PAPER)
                .unlockedBy("has_book", has(Items.BOOK))
                .save(consumer);
    }

}
