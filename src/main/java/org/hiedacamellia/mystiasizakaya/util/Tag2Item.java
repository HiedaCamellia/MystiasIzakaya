package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.*;


public class Tag2Item {

    public static Map<TagKey<Item>,Item> regs = get();

    public static Map<TagKey<Item>,Item> get() {
            Collection<DeferredHolder<Item, ? extends Item>> knownIngredients = MIItem.Ingredients.getEntries();
            Map<TagKey<Item>,Item> regs = new HashMap<>();
            Map<String,TagKey<Item>> ingredients = MITag.getKnownIngredients();
            for(DeferredHolder<Item, ? extends Item> item: knownIngredients){
                regs.put(ingredients.get(BuiltInRegistries.ITEM.getKey(item.get()).getPath()),item.get());
            }
            return regs;
    }
}
