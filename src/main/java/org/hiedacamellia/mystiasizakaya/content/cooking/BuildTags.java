package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTagFromItemStacks;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.ValueRecord;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BuildTags {
    public static ItemStack execute(ItemStack target, ItemStack Kitchenware, List<ItemStack> ingredients) {

        try {
            target.inventoryTick(null, null, 0, false);
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(target.getItem())));
            MystiasIzakaya.LOGGER.atTrace().log(e);
        }

        List<String> rawtags = GetTagFromItemStacks.get(target, ingredients);

        List<String> targettags = target.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).toString().isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).value().split(","));
        //List<String> targetntags = target.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("ntags").split(","));

        Set<String> set = new LinkedHashSet<>(rawtags);
        targettags.sort(Comparator.naturalOrder());
        set.addAll(targettags);
        ArrayList<String> resultList = getStrings(ingredients, set);

        resultList.addAll(Kitchenware.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).toString().isEmpty() ? new ArrayList<>() : Arrays.asList(Kitchenware.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).value().split(",")));

        ArrayList<String> rawslist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rawslist.add(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(ingredients.get(i).getItem())).toString());
        }
        rawslist.sort(Comparator.naturalOrder());

        target.set(DataComponentsReg.Tags.get(), new ValueRecord(String.join(",", resultList)));

        //target.getOrCreateTag().putString("ntags", String.join(",", targetntags));

        target.set(DataComponentsReg.Ingredients.get(), new ValueRecord(String.join(",", rawslist)));

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
        String[] tags = cuisine.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).value().split(",");
        String[] ntags = cuisine.getOrDefault(DataComponentsReg.nTags.get(),  new ValueRecord("")).value().split(",");

        Set<String> seti = new HashSet<>(List.of(tags));
        for (String str : ntags) {
            if (seti.contains(str)) {
                return new ItemStack(ItemRegistery.HEI_AN_WU_ZHI.get());
            }
        }
        return cuisine;
    }
}
