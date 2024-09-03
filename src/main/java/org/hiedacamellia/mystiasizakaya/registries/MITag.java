package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MITag {

    public static TagKey<Item> cuisinesKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:cuisines"));
    public static TagKey<Item> beveragesKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:beverages"));
    public static TagKey<Item> ingredientsKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients"));
    public static TagKey<Item> kitchenwaresKey = ItemTags.create(ResourceLocation.parse("mystias_izakaya:kitchenwares"));

}
