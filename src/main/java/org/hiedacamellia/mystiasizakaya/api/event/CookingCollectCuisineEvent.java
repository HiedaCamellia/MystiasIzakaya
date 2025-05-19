package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CookingCollectCuisineEvent extends CookingEvent{

    private final List<ItemStack> ingredients;
    private final KitchenwareType util;
    private final List<ItemStack> result;

    public CookingCollectCuisineEvent(@Nullable CookingEntity entity, Level level, List<ItemStack> ingredients, KitchenwareType util, List<ItemStack> result) {
        super(entity, level);
        this.ingredients = ingredients;
        this.util = util;
        this.result = result;
    }

    public List<ItemStack> getIngredients() {
        return ingredients;
    }

    public KitchenwareType getUtil() {
        return util;
    }

    public List<ItemStack> getResult() {
        return result;
    }

}
