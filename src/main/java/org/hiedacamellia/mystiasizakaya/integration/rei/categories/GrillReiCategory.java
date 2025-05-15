package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.FryingPanDisplay;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class GrillReiCategory extends BaseReiCategory<FryingPanDisplay>{

    public GrillReiCategory() {
        super(Component.translatable("xei.mystias_izakaya.grill"), MIItem.GRILL.asItem());
    }


    @Override
    public CategoryIdentifier<? extends FryingPanDisplay> getCategoryIdentifier() {
        return FryingPanDisplay.CATEGORY;
    }
}
