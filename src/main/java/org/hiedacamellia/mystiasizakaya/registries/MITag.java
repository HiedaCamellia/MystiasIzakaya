package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MITag {

    public static TagKey<Item> cuisinesKey = TagKey.create(Registries.ITEM,new ResourceLocation("mystias_izakaya:cuisines"));
    public static TagKey<Item> beveragesKey = TagKey.create(Registries.ITEM,new ResourceLocation("mystias_izakaya:beverages"));
    public static TagKey<Item> ingredientsKey = TagKey.create(Registries.ITEM,new ResourceLocation("mystias_izakaya:ingredients"));
    public static TagKey<Item> kitchenwaresKey = TagKey.create(Registries.ITEM,new ResourceLocation("mystias_izakaya:kitchenwares"));

}
