package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MITag {

    public static TagKey<Item> cuisinesKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:cuisines"));
    public static TagKey<Item> beveragesKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:beverages"));
    public static TagKey<Item> ingredientsKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients"));
    public static TagKey<Item> kitchenwaresKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:kitchenwares"));

    public static Map<String,TagKey<Item>> ingredients = getKnownIngredients();

    public static Map<String,TagKey<Item>> getKnownIngredients(){
        Collection<DeferredHolder<Item, ? extends Item>> knownIngredients = MIItem.Ingredients.getEntries();
        List<String> regs =new ArrayList<>();
        for(DeferredHolder<Item, ? extends Item> item: knownIngredients){
            regs.add(BuiltInRegistries.ITEM.getKey(item.get()).getPath());
        }
        return regs.stream().collect(Collectors.toMap(s->s,s-> ItemTags.create(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,s))));
    }
}
