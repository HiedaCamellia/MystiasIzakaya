package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.CookingCollectCuisineEvent;
import org.hiedacamellia.mystiasizakaya.api.event.CookingTagEvent;
import org.hiedacamellia.mystiasizakaya.client.util.MIClientUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIEventUtil;
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.core.recipes.MIRecipeInput;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CookingUtils {

    public static List<ItemStack> getAvailableCuisines(@Nullable CookingEntity entity, Level level, List<ItemStack> ingredients, KitchenwareType util) {
        MIRecipeInput miRecipeInput = new MIRecipeInput(new ArrayList<>(ingredients));
        RecipeMap recipeMap = level instanceof ServerLevel ? level.getServer().getRecipeManager().recipeMap() : MIClientUtil.getRecipeMap();
        List<ItemStack> targetI = getCuisines(level, util, recipeMap, miRecipeInput);
        CookingCollectCuisineEvent cookingCollectCuisineEvent = new CookingCollectCuisineEvent(entity, level, ingredients, util, targetI);
        MIEventUtil.post(cookingCollectCuisineEvent);
        return targetI;
    }

    private static List<ItemStack> getCuisines(Level level, KitchenwareType util, RecipeMap recipeMap, MIRecipeInput miRecipeInput) {
        List<ItemStack> targetI = new ArrayList<>();
        switch (util) {
            case BOILING_POT: {
                var optionals = recipeMap.getRecipesFor(MIRecipeType.BOILING_POT.get(), miRecipeInput, level);
                optionals.forEach(optional -> {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                });
                break;
            }
            case FRYING_PAN: {
                var optionals = recipeMap.getRecipesFor(MIRecipeType.FRYING_PAN.get(), miRecipeInput, level);
                optionals.forEach(optional -> {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                });
                break;
            }
            case GRILL: {
                var optionals = recipeMap.getRecipesFor(MIRecipeType.GRILL.get(), miRecipeInput, level);
                optionals.forEach(optional -> {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                });
                break;
            }
            case CUTTING_BOARD: {
                var optionals = recipeMap.getRecipesFor(MIRecipeType.CUTTING_BOARD.get(), miRecipeInput, level);
                optionals.forEach(optional -> {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                });
                break;
            }
            case STEAMER: {
                var optionals = recipeMap.getRecipesFor(MIRecipeType.STEAMER.get(), miRecipeInput, level);
                optionals.forEach(optional -> {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                });
                break;
            }
        }
        return targetI;
    }

    public static ItemStack buildTag(@Nullable CookingEntity entity, Level level, ItemStack target, ItemStack kitchenware, List<ItemStack> ingredients) {

        try {
            target.inventoryTick(null, null, 0, false);
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(target.getItem())));
            MystiasIzakaya.LOGGER.atTrace().log(e);
        }

        List<String> rawtags = getTag(level, target, new ArrayList<>(ingredients), kitchenware);

        List<String> targettags = MIItemStackUtil.getPositiveTags(target);

        Set<String> set = new LinkedHashSet<>(rawtags);
        try {
            targettags.sort(Comparator.naturalOrder());
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.atTrace().log("Failed to sort targettags for {}", Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(target.getItem())));
            MystiasIzakaya.LOGGER.atTrace().log(e);
        }
        //烧香！本来这是有问题的，但是改了后再回滚，它就好了
        set.addAll(targettags);
        ArrayList<String> resultList = getStrings(ingredients, set);

        resultList.addAll(MIItemStackUtil.getPositiveTags(kitchenware));

        ArrayList<String> rawslist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rawslist.add(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(ingredients.get(i).getItem())).toString());
        }
        rawslist.sort(Comparator.naturalOrder());

        List<String> ntags = new ArrayList<>(MIItemStackUtil.getNegativeTags(target));

        CookingTagEvent.Build build = new CookingTagEvent.Build(entity, level, target, kitchenware, ingredients, resultList, ntags);
        MIEventUtil.post(build);

        MIItemStackUtil.setTags(target, resultList, ntags);
        MIItemStackUtil.setIngredientOriginal(target, rawslist);

        return target;
    }

    public static @NotNull ArrayList<String> getStrings(List<ItemStack> ingredients, Set<String> set) {
        ArrayList<String> resultList = new ArrayList<>(set);
        if (ingredients.size() >= 5) {
            if (ingredients.get(4) != ItemStack.EMPTY) {
                resultList.add("Large_Portion");
                resultList.remove("Small_Portion");
            }
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

    public static ItemStack check(@Nullable CookingEntity entity, Level level, ItemStack cuisine) {

        CookingTagEvent.Check.Pre pre = new CookingTagEvent.Check.Pre(entity, level, cuisine);
        MIEventUtil.post(pre);

        List<String> tags = MIItemStackUtil.getPositiveTags(cuisine);
        List<String> ntags = MIItemStackUtil.getNegativeTags(cuisine);

        Set<String> seti = new HashSet<>(tags);
        for (String str : ntags) {
            if (seti.contains(str) && !Objects.equals(str, "")) {
                return new ItemStack(MIItem.HEI_AN_WU_ZHI.get());
            }
        }

        CookingTagEvent.Check.Post post = new CookingTagEvent.Check.Post(entity, level, cuisine);
        MIEventUtil.post(post);

        return cuisine;
    }

    public static List<String> getTag(Level level, ItemStack target, List<ItemStack> ingredients, ItemStack Kitchenware) {
        List<ItemStack> restIngredient = getRestIngredient(level, target, ingredients, Kitchenware);
        List<String> list = collectTags(restIngredient);
        return new ArrayList<>(list);
    }

    public static List<String> collectTags(List<ItemStack> raws) {
        Set<String> set = new HashSet<>();
        raws.forEach((raw) -> set.addAll(raw.getOrDefault(MIDatacomponet.MI_POSITIVE_TAGS.get(), new ArrayList<>())));
        return new ArrayList<>(set);
    }

    public static List<ItemStack> getRestIngredient(Level level, ItemStack target, List<ItemStack> ingredients, ItemStack util) {
        if (ingredients.isEmpty()) return new ArrayList<>();


        RecipeMap recipeMap = level instanceof ServerLevel ? level.getServer().getRecipeManager().recipeMap() : MIClientUtil.getRecipeMap();


        MIRecipeInput miRecipeInput = new MIRecipeInput(new ArrayList<>(ingredients));

        if (ItemStack.isSameItem(util, MIItem.BOILING_POT.get().getDefaultInstance())) {
            var optionals = recipeMap.getRecipesFor(MIRecipeType.BOILING_POT.get(), miRecipeInput, level);
            for (var optional : optionals.toList()) {
                if (ItemStack.isSameItem(optional.value().getResult(), target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if (ItemStack.isSameItem(util, MIItem.FRYING_PAN.get().getDefaultInstance())) {
            var optionals = recipeMap.getRecipesFor(MIRecipeType.FRYING_PAN.get(), miRecipeInput, level);
            for (var optional : optionals.toList()) {
                if (ItemStack.isSameItem(optional.value().getResult(), target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if (ItemStack.isSameItem(util, MIItem.GRILL.get().getDefaultInstance())) {
            var optionals = recipeMap.getRecipesFor(MIRecipeType.GRILL.get(), miRecipeInput, level);
            for (var optional : optionals.toList()) {
                if (ItemStack.isSameItem(optional.value().getResult(), target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if (ItemStack.isSameItem(util, MIItem.CUTTING_BOARD.get().getDefaultInstance())) {
            var optionals = recipeMap.getRecipesFor(MIRecipeType.CUTTING_BOARD.get(), miRecipeInput, level);
            for (var optional : optionals.toList()) {
                if (ItemStack.isSameItem(optional.value().getResult(), target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if (ItemStack.isSameItem(util, MIItem.STEAMER.get().getDefaultInstance())) {
            var optionals = recipeMap.getRecipesFor(MIRecipeType.STEAMER.get(), miRecipeInput, level);
            for (var optional : optionals.toList()) {
                if (ItemStack.isSameItem(optional.value().getResult(), target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }
        return new ArrayList<>();

    }
}
