package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.SteamerDisplay;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class SteamerReiCategory extends BaseReiCategory<SteamerDisplay>{

    public SteamerReiCategory() {
        super(Component.translatable("xei.mystias_izakaya.steamer"), MIItem.STEAMER.asItem());
    }

    @Override
    public CategoryIdentifier<? extends SteamerDisplay> getCategoryIdentifier() {
        return SteamerDisplay.CATEGORY;
    }
}
