package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MIRecipeProvider extends FabricRecipeProvider {


    public MIRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MIItem.TELEPHONE)
                .pattern("SXS")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('S', Items.IRON_INGOT)
                .define('X', Items.ENDER_PEARL)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,MIItem.TABLE)
                .pattern("#")
                .pattern("X")
                .define('#', ItemTags.WOODEN_SLABS)
                .define('X', ItemTags.WOODEN_FENCES)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MIItem.LEDGER)
                .requires(Items.BOOK)
                .requires(Items.PAPER)
                .requires(Items.PAPER)
                .unlockedBy("has_book", has(Items.BOOK))
                .save(consumer);
    }

}
