package org.hiedacamellia.mystiasizakaya.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;
import org.hiedacamellia.mystiasizakaya.integration.rei.categories.*;
import org.hiedacamellia.mystiasizakaya.integration.rei.displays.*;
import org.hiedacamellia.mystiasizakaya.integration.rei.draggable.ItemPriceAddonScreenDraggableStackVisitor;
import org.hiedacamellia.mystiasizakaya.integration.rei.draggable.LedgerScreenDraggableStackVisitor;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

@REIPluginClient
public class MIReiClientPlugin  implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        CuttingBoardReiCategory cuttingBoard = new CuttingBoardReiCategory();
        BoilingPotReiCategory boilingPot = new BoilingPotReiCategory();
        FryingPanReiCategory fryingPan = new FryingPanReiCategory();
        SteamerReiCategory steamer = new SteamerReiCategory();
        GrillReiCategory grill = new GrillReiCategory();

        registry.add(cuttingBoard);
        registry.add(boilingPot);
        registry.add(fryingPan);
        registry.add(steamer);
        registry.add(grill);

        registry.addWorkstations(cuttingBoard.getCategoryIdentifier(), EntryStacks.of(MIBlock.COOKING_RANGE));
        registry.addWorkstations(cuttingBoard.getCategoryIdentifier(), EntryStacks.of(MIItem.CUTTING_BOARD));
        registry.addWorkstations(boilingPot.getCategoryIdentifier(), EntryStacks.of(MIBlock.COOKING_RANGE));
        registry.addWorkstations(boilingPot.getCategoryIdentifier(), EntryStacks.of(MIItem.BOILING_POT));
        registry.addWorkstations(fryingPan.getCategoryIdentifier(), EntryStacks.of(MIBlock.COOKING_RANGE));
        registry.addWorkstations(fryingPan.getCategoryIdentifier(), EntryStacks.of(MIItem.FRYING_PAN));
        registry.addWorkstations(steamer.getCategoryIdentifier(), EntryStacks.of(MIBlock.COOKING_RANGE));
        registry.addWorkstations(steamer.getCategoryIdentifier(), EntryStacks.of(MIItem.STEAMER));
        registry.addWorkstations(grill.getCategoryIdentifier(), EntryStacks.of(MIBlock.COOKING_RANGE));
        registry.addWorkstations(grill.getCategoryIdentifier(), EntryStacks.of(MIItem.GRILL));

    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CuttingBoardRecipe.class, MIRecipeType.CUTTING_BOARD.get(), CuttingBoardDisplay::new);
        registry.registerRecipeFiller(BoilingPotRecipe.class, MIRecipeType.BOILING_POT.get(), BoilingPotDisplay::new);
        registry.registerRecipeFiller(FryingPanRecipe.class, MIRecipeType.FRYING_PAN.get(), FryingPanDisplay::new);
        registry.registerRecipeFiller(SteamerRecipe.class, MIRecipeType.STEAMER.get(), SteamerDisplay::new);
        registry.registerRecipeFiller(GrillRecipe.class, MIRecipeType.GRILL.get(), GrillDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerDraggableStackVisitor(new LedgerScreenDraggableStackVisitor());
        registry.registerDraggableStackVisitor(new ItemPriceAddonScreenDraggableStackVisitor());
    }
}
