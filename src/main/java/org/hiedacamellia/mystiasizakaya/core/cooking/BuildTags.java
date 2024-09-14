package org.hiedacamellia.mystiasizakaya.core.cooking;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.cooking.get.GetTagFromItemStacks;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BuildTags {
    public static ItemStack execute(ItemStack target, ItemStack Kitchenware, List<ItemStack> ingredients) {

        try {
            target.inventoryTick(null, null, 0, false);
        } catch (Exception e) {
            Debug.getLogger().atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(target.getItem())));
        }

        List<String> rawtags = GetTagFromItemStacks.get(target, ingredients);
        List<String> targettags = target.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("tags").split(","));

        //List<String> targetntags = target.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("ntags").split(","));

        //Debug.send(target.toString());
        Set<String> set = new LinkedHashSet<>(rawtags);
        try {
            targettags.sort(Comparator.naturalOrder());
        }catch (Exception e){
            Debug.getLogger().atTrace().log("Failed to sort targettags for {}", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(target.getItem())));
        }
        //烧香！本来这是有问题的，但是改了后再回滚，它就好了
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
            resultList.add("Large_Portion");
            resultList.remove("Small_Portion");
        }
        if (resultList.contains("Meat")) {
            resultList.remove("Vegetarian");
        }
        if (resultList.contains("Filling")) {
            resultList.remove("Good_With_Alcohol");
        }
        if (resultList.contains("Greasy")) {
            resultList.remove("Mild");
        }
        if (resultList.contains("Hot")) {
            resultList.remove("Refreshing");
        }
        return resultList;
    }

    public static ItemStack check(ItemStack cuisine){
        String[] tags = cuisine.getOrCreateTag().getString("tags").split(",");
        String[] ntags = cuisine.getOrCreateTag().getString("ntags").split(",");
        Set<String> seti = new HashSet<>(List.of(tags));
        for (String str : ntags) {
            if (seti.contains(str)&& !Objects.equals(str, "")) {
                return new ItemStack(MIItem.HEI_AN_WU_ZHI.get());
            }
        }
        return cuisine;
    }
}
