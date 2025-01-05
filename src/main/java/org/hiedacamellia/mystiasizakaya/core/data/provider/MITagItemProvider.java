package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MITag;
import org.hiedacamellia.mystiasizakaya.integration.compact.IngredientCompact;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MITagItemProvider extends ItemTagsProvider {
    public MITagItemProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        System.out.println("Adding MITagItemProvider Ingredients tags");
        MIItem.Ingredients.getEntries().forEach(item -> this.tag(MITag.ingredientsKey).add(item.get()));
        System.out.println("Adding MITagItemProvider optional Ingredients tags");
        IngredientCompact.MAPPING.values().forEach(resourceLocation -> this.tag(MITag.ingredientsKey).addOptional(resourceLocation));
        System.out.println("Adding MITagItemProvider Cuisines tags");
        MIItem.Cuisines.getEntries().forEach(item -> this.tag(MITag.cuisinesKey).add(item.get()));
        System.out.println("Adding MITagItemProvider Beverages tags");
        MIItem.Beverages.getEntries().forEach(item -> this.tag(MITag.beveragesKey).add(item.get()));
        System.out.println("Adding MITagItemProvider Utensils tags");
        MIItem.Ingredients.getEntries().forEach(s -> {
            ResourceLocation resourceLocation = IngredientCompact.MAPPING.get(s.get());
            if(resourceLocation!=null)
                this.tag(MITag.ingredients.get(BuiltInRegistries.ITEM.getKey(s.get()).getPath())).add(s.get()).addOptional(resourceLocation);
            else
                this.tag(MITag.ingredients.get(BuiltInRegistries.ITEM.getKey(s.get()).getPath())).add(s.get());
        });
    }
}
