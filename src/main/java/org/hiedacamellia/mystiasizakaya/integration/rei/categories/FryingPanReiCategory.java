package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.GrillDisplay;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class FryingPanReiCategory extends BaseReiCategory<GrillDisplay>{

    public FryingPanReiCategory() {
        super(Component.translatable("xei.mystias_izakaya.frying_pan"), MIItem.FRYING_PAN.asItem());
    }


    @Override
    public CategoryIdentifier<? extends GrillDisplay> getCategoryIdentifier() {
        return GrillDisplay.CATEGORY;
    }
}
