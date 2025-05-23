package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.CookingCollectCuisineEvent;
import org.hiedacamellia.mystiasizakaya.api.event.CookingTagEvent;
import org.hiedacamellia.mystiasizakaya.api.kubejs.MIEventPoster;
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

    public static List<ItemStack> getAvailableCuisines(@Nullable CookingEntity entity,Level level, List<ItemStack> ingredients, KitchenwareType util) {
        RecipeManager recipes = level.getRecipeManager();
        MIRecipeInput miRecipeInput = new MIRecipeInput(new ArrayList<>(ingredients));
        List<ItemStack> targetI = new ArrayList<>();
        switch (util) {
            case BOILING_POT: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.BOILING_POT.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case FRYING_PAN: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.FRYING_PAN.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case GRILL: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.GRILL.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case CUTTING_BOARD: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.CUTTING_BOARD.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case STEAMER: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.STEAMER.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
        }
        CookingCollectCuisineEvent cookingCollectCuisineEvent = new CookingCollectCuisineEvent(entity, level, ingredients, util, targetI);
        NeoForge.EVENT_BUS.post(cookingCollectCuisineEvent);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(cookingCollectCuisineEvent);

        return targetI;
    }

    public static ItemStack buildTag(@Nullable CookingEntity entity, Level level, ItemStack target, ItemStack kitchenware, List<ItemStack> ingredients) {

        try {
            target.inventoryTick(null, null, 0, false);
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(target.getItem())));
            MystiasIzakaya.LOGGER.atTrace().log(e);
        }

        List<String> rawtags = getTag(level.getRecipeManager(),target, new ArrayList<>(ingredients),kitchenware);

        List<String> targettags = MIItemStackUtil.getPositiveTags(target);

        Set<String> set = new LinkedHashSet<>(rawtags);
        try {
            targettags.sort(Comparator.naturalOrder());
        }catch (Exception e){
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
        NeoForge.EVENT_BUS.post(build);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(build);

        MIItemStackUtil.setTags(target,resultList,ntags);
        MIItemStackUtil.setIngredientOriginal(target,rawslist);

        return target;
    }

    public static @NotNull ArrayList<String> getStrings(List<ItemStack> ingredients, Set<String> set) {
        ArrayList<String> resultList = new ArrayList<>(set);
        if(ingredients.size() >= 5){
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

    public static ItemStack check(@Nullable CookingEntity entity, Level level,ItemStack cuisine){

        CookingTagEvent.Check.Pre pre = new CookingTagEvent.Check.Pre(entity, level, cuisine);
        NeoForge.EVENT_BUS.post(pre);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(pre);

        List<String> tags = MIItemStackUtil.getPositiveTags(cuisine);
        List<String> ntags = MIItemStackUtil.getNegativeTags(cuisine);

        Set<String> seti = new HashSet<>(tags);
        for (String str : ntags) {
            if (seti.contains(str) && !Objects.equals(str, "")) {
                return new ItemStack(MIItem.HEI_AN_WU_ZHI.get());
            }
        }

        CookingTagEvent.Check.Post post = new CookingTagEvent.Check.Post(entity, level, cuisine);
        NeoForge.EVENT_BUS.post(post);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(post);

        return cuisine;
    }

    public static List<String> getTag(RecipeManager recipeManager, ItemStack target, List<ItemStack> ingredients, ItemStack Kitchenware) {
        List<ItemStack> restIngredient = getRestIngredient(recipeManager, target, ingredients, Kitchenware);
        List<String> list = collectTags(restIngredient);
        return new ArrayList<>(list);
    }

    public static List<String> collectTags(List<ItemStack> raws) {
        Set<String> set = new HashSet<>();
        raws.forEach((raw) -> set.addAll(raw.getOrDefault(MIDatacomponet.MI_POSITIVE_TAGS.get(),new ArrayList<>())));
        return new ArrayList<>(set);
    }

    public static List<ItemStack> getRestIngredient(RecipeManager recipes, ItemStack target, List<ItemStack> ingredients, ItemStack util){
        if(ingredients.isEmpty())
            return new ArrayList<>();


        if(ItemStack.isSameItem(util ,MIItem.BOILING_POT.get().getDefaultInstance())){
            var optionals = recipes.getAllRecipesFor(
                    MIRecipeType.BOILING_POT.get()
            );
            for(var optional : optionals){
                if(ItemStack.isSameItem(optional.value().getResult(),target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if(ItemStack.isSameItem(util ,MIItem.FRYING_PAN.get().getDefaultInstance())){
            var optionals = recipes.getAllRecipesFor(
                    MIRecipeType.FRYING_PAN.get()
            );
            for(var optional : optionals){
                if(ItemStack.isSameItem(optional.value().getResult(),target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if(ItemStack.isSameItem(util ,MIItem.GRILL.get().getDefaultInstance())){
            var optionals = recipes.getAllRecipesFor(
                    MIRecipeType.GRILL.get()
            );
            for(var optional : optionals){
                if(ItemStack.isSameItem(optional.value().getResult(),target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if(ItemStack.isSameItem(util ,MIItem.CUTTING_BOARD.get().getDefaultInstance())){
            var optionals = recipes.getAllRecipesFor(
                    MIRecipeType.CUTTING_BOARD.get()
            );
            for(var optional : optionals){
                if(ItemStack.isSameItem(optional.value().getResult(),target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }

        if(ItemStack.isSameItem(util ,MIItem.STEAMER.get().getDefaultInstance())){
            var optionals = recipes.getAllRecipesFor(
                    MIRecipeType.STEAMER.get()
            );
            for(var optional : optionals){
                if(ItemStack.isSameItem(optional.value().getResult(),target)) {
                    return optional.value().getRestItem(new MIRecipeInput(ingredients));
                }
            }
        }
        return new ArrayList<>();
    }
}
