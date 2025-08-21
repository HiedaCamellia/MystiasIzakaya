package org.hiedacamellia.mystiasizakaya.core.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.List;

public class MIItemUtil {


    public static Item fromString(String string){
        return fromResourceLocation(ResourceLocation.tryParse(string));
    }
    public static Item fromResourceLocation(ResourceLocation resourceLocation){
        return BuiltInRegistries.ITEM.getValue(resourceLocation);
    }
    public static String toString(Item item){
        return toResourceLocation(item).toString();
    }
    public static ResourceLocation toResourceLocation(Item item){
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
