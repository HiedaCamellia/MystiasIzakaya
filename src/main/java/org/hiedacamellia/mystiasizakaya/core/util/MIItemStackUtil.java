package org.hiedacamellia.mystiasizakaya.core.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.List;

public class MIItemStackUtil {


    public static int getCost(ItemStack itemStack){
        Integer i = itemStack.get(MIDatacomponet.MI_COST.get());
        if(i!=null)
            return i;
        else if(ItemPriceAddon.hasPrice(itemStack)){
            return ItemPriceAddon.getPrice(itemStack);
        }else return 0;
    }

    public static void setCost(ItemStack itemStack, int cost){
        itemStack.set(MIDatacomponet.MI_COST.get(),cost);
    }

    public static int getCookTime(ItemStack itemStack){
        return itemStack.getOrDefault(MIDatacomponet.MI_COOKTIME.get(),0);
    }

    public static void setCookTime(ItemStack itemStack, int cost){
        itemStack.set(MIDatacomponet.MI_COOKTIME.get(),cost);
    }

    public static List<String> getIngredientOriginal(ItemStack itemStack){
        return itemStack.getOrDefault(MIDatacomponet.MI_INGREDIENT.get(),new ArrayList<>());
    }
    public static void setIngredientOriginal(ItemStack itemStack, List<String> ingredient){
        itemStack.set(MIDatacomponet.MI_INGREDIENT.get(),ingredient);
    }
    public static List<ItemStack> getIngredient(ItemStack itemStack){
        return itemStack.getOrDefault(MIDatacomponet.MI_INGREDIENT.get(),new ArrayList<String>()).stream().map(MIItemStackUtil::fromString).toList();
    }
    public static void setIngredient(ItemStack itemStack, List<ItemStack> ingredient){
        itemStack.set(MIDatacomponet.MI_INGREDIENT.get(),ingredient.stream().map(MIItemStackUtil::toString).toList());
    }

    public static List<String> getPositiveTags(ItemStack itemStack){
        return itemStack.getOrDefault(MIDatacomponet.MI_POSITIVE_TAGS.get(),new ArrayList<>());
    }
    public static void setPositiveTags(ItemStack itemStack, List<String> tags){
        itemStack.set(MIDatacomponet.MI_POSITIVE_TAGS.get(),tags);
    }
    public static List<String> getNegativeTags(ItemStack itemStack){
        return itemStack.getOrDefault(MIDatacomponet.MI_NEGATIVE_TAGS.get(),new ArrayList<>());
    }
    public static void setNegativeTags(ItemStack itemStack, List<String> tags){
        itemStack.set(MIDatacomponet.MI_NEGATIVE_TAGS.get(),tags);
    }
    public static void setTags(ItemStack itemStack, List<String> positive, List<String> negative){
        itemStack.set(MIDatacomponet.MI_POSITIVE_TAGS.get(),positive);
        itemStack.set(MIDatacomponet.MI_NEGATIVE_TAGS.get(),negative);
    }



    public static ItemStack fromString(String string){
        return fromResourceLocation(ResourceLocation.tryParse(string));
    }
    public static ItemStack fromResourceLocation(ResourceLocation resourceLocation){
        return BuiltInRegistries.ITEM.getValue(resourceLocation).getDefaultInstance();
    }
    public static String toString(ItemStack itemStack){
        return toResourceLocation(itemStack).toString();
    }
    public static ResourceLocation toResourceLocation(ItemStack itemStack){
        return BuiltInRegistries.ITEM.getKey(itemStack.getItem());
    }
}
