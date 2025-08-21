package org.hiedacamellia.mystiasizakaya.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.integration.compact.IngredientCompact;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.concurrent.CompletableFuture;

public class MITagItemProvider extends ItemTagsProvider {
    public MITagItemProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId) {
        super(pOutput, pLookupProvider, pBlockTags, modId);
    }

    private static final Logger LOGGER = LogManager.getLogger(MITagItemProvider.class);
    
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        LOGGER.info("Adding MITagItemProvider Ingredients tags");
        MIItem.Ingredients.getEntries().forEach(item -> this.tag(MITag.ingredientsKey).add(item.get()));
        LOGGER.info("Adding MITagItemProvider optional Ingredients tags");
        IngredientCompact.MAPPING.values().forEach(resourceLocation -> this.tag(MITag.ingredientsKey).addOptional(resourceLocation));
        LOGGER.info("Adding MITagItemProvider Cuisines tags");
        MIItem.Cuisines.getEntries().forEach(item -> this.tag(MITag.cuisinesKey).add(item.get()));
        LOGGER.info("Adding MITagItemProvider Beverages tags");
        MIItem.Beverages.getEntries().forEach(item -> this.tag(MITag.beveragesKey).add(item.get()));
        LOGGER.info("Adding MITagItemProvider Compact tags");
        MIItem.Ingredients.getEntries().forEach(s -> {
            ResourceLocation resourceLocation = IngredientCompact.MAPPING.get(s.get());
            if(resourceLocation!=null)
                this.tag(MITag.ingredients.get(BuiltInRegistries.ITEM.getKey(s.get()).getPath())).add(s.get()).addOptional(resourceLocation);
            else
                this.tag(MITag.ingredients.get(BuiltInRegistries.ITEM.getKey(s.get()).getPath())).add(s.get());
        });
    }
}
