package org.hiedacamellia.mystiasizakaya.api.kubejs;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.api.event.CookingCollectCuisineEvent;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;

import java.util.List;

public class CookingCollectCuisineEventJS extends CookingEventJS{

    public CookingCollectCuisineEventJS(CookingCollectCuisineEvent event) {
        super(event);
    }

    public List<ItemStack> getIngredients() {
        return ((CookingCollectCuisineEvent)event).getIngredients();
    }

    public KitchenwareType getUtil() {
        return ((CookingCollectCuisineEvent)event).getUtil();
    }

    public List<ItemStack> getResult() {
        return ((CookingCollectCuisineEvent)event).getResult();
    }
}
