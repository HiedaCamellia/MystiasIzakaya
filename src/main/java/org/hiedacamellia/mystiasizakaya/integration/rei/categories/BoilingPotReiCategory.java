package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.BoilingPotDisplay;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class BoilingPotReiCategory extends BaseReiCategory<BoilingPotDisplay>{

    public BoilingPotReiCategory() {
        super(Component.translatable("xei.mystias_izakaya.boiling_pot"), MIItem.BOILING_POT.asItem());
    }


    @Override
    public CategoryIdentifier<? extends BoilingPotDisplay> getCategoryIdentifier() {
        return BoilingPotDisplay.CATEGORY;
    }
}
