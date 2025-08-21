package org.hiedacamellia.mystiasizakaya.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.displays.ClientsidedCraftingDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.ShapedCraftingRecipeDisplay;
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
        registry.beginRecipeFiller(CuttingBoardDisplay.class)
                .filterType(CuttingBoardDisplay.TYPE)
                .fill(CuttingBoardDisplay::create);
        registry.beginRecipeFiller(BoilingPotDisplay.class)
                .filterType(BoilingPotDisplay.TYPE)
                .fill(BoilingPotDisplay::create);
        registry.beginRecipeFiller(FryingPanDisplay.class)
                .filterType(FryingPanDisplay.TYPE)
                .fill(FryingPanDisplay::create);
        registry.beginRecipeFiller(SteamerDisplay.class)
                .filterType(SteamerDisplay.TYPE)
                .fill(SteamerDisplay::create);
        registry.beginRecipeFiller(GrillDisplay.class)
                .filterType(GrillDisplay.TYPE)
                .fill(GrillDisplay::create);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerDraggableStackVisitor(new LedgerScreenDraggableStackVisitor());
        registry.registerDraggableStackVisitor(new ItemPriceAddonScreenDraggableStackVisitor());
    }
}
