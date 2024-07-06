package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTagFromItemStacks;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BuildTags {
    public static ItemStack execute(ItemStack target, ItemStack Kitchenware, List<ItemStack> ingredients) {

        try {
            target.inventoryTick(null, null, 0, false);
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(target.getItem())));
            MystiasIzakaya.LOGGER.atTrace().log(e);
        }

        List<String> rawtags = GetTagFromItemStacks.get(target, ingredients);
        List<String> targettags = target.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("tags").split(","));
        //List<String> targetntags = target.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("ntags").split(","));

        Set<String> set = new LinkedHashSet<>(rawtags);
        targettags.sort(Comparator.naturalOrder());
        set.addAll(targettags);
        ArrayList<String> resultList = getStrings(ingredients, set);
        resultList.addAll(Kitchenware.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : List.of(Kitchenware.getOrCreateTag().getString("tags").split(",")));

        ArrayList<String> rawslist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rawslist.add(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ingredients.get(i).getItem())).toString());
        }
        rawslist.sort(Comparator.naturalOrder());

        target.getOrCreateTag().putString("tags", String.join(",", resultList));
        //target.getOrCreateTag().putString("ntags", String.join(",", targetntags));
        target.getOrCreateTag().putString("ingredients", String.join(",", rawslist));

        return target;
    }

    private static @NotNull ArrayList<String> getStrings(List<ItemStack> ingredients, Set<String> set) {
        ArrayList<String> resultList = new ArrayList<>(set);


        if (ingredients.get(4) != ItemStack.EMPTY) {
            resultList.add("tag.mystias_izakaya.Large_Portion");
            resultList.remove("tag.mystias_izakaya.Small_Portion");
        }
        if (resultList.contains("tag.mystias_izakaya.Meat")) {
            resultList.remove("tag.mystias_izakaya.Vegetarian");
        }
        if (resultList.contains("tag.mystias_izakaya.Filling")) {
            resultList.remove("tag.mystias_izakaya.Good_With_Alcohol");
        }
        if (resultList.contains("tag.mystias_izakaya.Greasy")) {
            resultList.remove("tag.mystias_izakaya.Mild");
        }
        if (resultList.contains("tag.mystias_izakaya.Hot")) {
            resultList.remove("tag.mystias_izakaya.Refreshing");
        }
        return resultList;
    }

    public static ItemStack check(ItemStack cuisine){
        String[] tags = cuisine.getOrCreateTag().getString("tags").split(",");
        String[] ntags = cuisine.getOrCreateTag().getString("ntags").split(",");
        Set<String> seti = new HashSet<>(List.of(tags));
        for (String str : ntags) {
            if (seti.contains(str)) {
                return new ItemStack(ItemRegistery.HEI_AN_WU_ZHI.get());
            }
        }
        return cuisine;
    }
}
