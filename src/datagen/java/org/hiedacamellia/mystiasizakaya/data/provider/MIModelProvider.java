package org.hiedacamellia.mystiasizakaya.data.provider;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.Optional;
import java.util.stream.Collectors;

public class MIModelProvider extends ModelProvider {
    public MIModelProvider(PackOutput output) {
        super(output, MystiasIzakaya.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {


        itemModels.generateFlatItem(MIItem.LEDGER.asItem(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(MIItem.CUTTING_BOARD.asItem(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MIItem.BOILING_POT.asItem(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MIItem.FRYING_PAN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MIItem.STEAMER.asItem(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MIItem.GRILL.asItem(), ModelTemplates.FLAT_ITEM);


        getKnownIngredients().forEach(item -> itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
        getKnownCuisines().forEach(item -> itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
        getKnownBeverages().forEach(item -> itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
        getKnownOthers().forEach(item -> itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM));


//
//        blockModels.createTrivialCube(MIBlock.CUTTING_BOARD.get());
//        blockModels.createTrivialCube(MIBlock.GRILL.get());
//        blockModels.createTrivialCube(MIBlock.BOILING_POT.get());
//        blockModels.createTrivialCube(MIBlock.STEAMER.get());
//        blockModels.createTrivialCube(MIBlock.FRYING_PAN.get());

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.CUTTING_BOARD.get(),
                        Variant.variant().with(VariantProperties.MODEL, modLocation("block/cutting_board"))
                )
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.BOILING_POT.get(),
                        Variant.variant().with(VariantProperties.MODEL, modLocation("block/boiling_pot"))
                )
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.FRYING_PAN.get(),
                        Variant.variant().with(VariantProperties.MODEL, modLocation("block/frying_pan"))
                )
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.STEAMER.get(),
                        Variant.variant().with(VariantProperties.MODEL, modLocation("block/steamer"))
                )
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.GRILL.get(),
                        Variant.variant().with(VariantProperties.MODEL, modLocation("block/grill"))
                )
        );




        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.COOKING_RANGE.get(),
                        Variant.variant()
                                .with(VariantProperties.MODEL, modLocation("block/cooking_range"))
                ).with(BlockModelGenerators.createHorizontalFacingDispatch())
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.DONATION.get(),
                        Variant.variant()
                                .with(VariantProperties.MODEL, modLocation("block/donation"))
                ).with(BlockModelGenerators.createHorizontalFacingDispatch())
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.TELEPHONE.get(),
                        Variant.variant()
                                .with(VariantProperties.MODEL, modLocation("block/telephone"))
                ).with(BlockModelGenerators.createHorizontalFacingDispatch())
        );

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        MIBlock.TABLE.get(),
                        Variant.variant()
                                .with(VariantProperties.MODEL, modLocation("block/table"))
                )
        );
    }

    private static Iterable<Item> getKnownIngredients() {
        return MIItem.Ingredients.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownCuisines() {
        return MIItem.Cuisines.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownBeverages() {
        return MIItem.Beverages.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownOthers() {
        return MIItem.Others.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
    }
}
