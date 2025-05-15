package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.CuttingBoardDisplay;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class CuttingBoardReiCategory extends BaseReiCategory<CuttingBoardDisplay>{

    public CuttingBoardReiCategory() {
        super(Component.translatable("xei.mystias_izakaya.cutting_board"), MIItem.CUTTING_BOARD.asItem());
    }


    @Override
    public CategoryIdentifier<? extends CuttingBoardDisplay> getCategoryIdentifier() {
        return CuttingBoardDisplay.CATEGORY;
    }
}
