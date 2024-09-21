package org.hiedacamellia.mystiasizakaya.core.data.provider;

import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MIModelProvider extends FabricModelProvider {
    public MIModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/cutting_board"), MIBlock.CUTTING_BOARD);
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/grill"), MIBlock.GRILL);
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/boiling_pot"), MIBlock.BOILING_POT);
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/steamer"), MIBlock.STEAMER);
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/frying_pan"), MIBlock.FRYING_PAN);

        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/telephone"), MIBlock.TELEPHONE);
        blockStateModelGenerator.blockEntityModels(new ResourceLocation(MystiasIzakaya.MODID, "block/table"), MIBlock.TABLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

        itemModelGenerator.generateFlatItem(MIItem.LEDGER, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/ledger")), Optional.empty(), TextureSlot.LAYER0));
        itemModelGenerator.generateFlatItem(MIItem.CUTTING_BOARD, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/liao_li_tai")), Optional.empty(), TextureSlot.LAYER0));
        itemModelGenerator.generateFlatItem(MIItem.GRILL, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/shao_kao_jia")), Optional.empty(), TextureSlot.LAYER0));
        itemModelGenerator.generateFlatItem(MIItem.BOILING_POT, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/zhu_guo")), Optional.empty(), TextureSlot.LAYER0));
        itemModelGenerator.generateFlatItem(MIItem.STEAMER, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/zheng_guo")), Optional.empty(), TextureSlot.LAYER0));
        itemModelGenerator.generateFlatItem(MIItem.FRYING_PAN, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/you_guo")), Optional.empty(), TextureSlot.LAYER0));

        getKnownIngredients().forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            itemModelGenerator.generateFlatItem(item, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/"+path)), Optional.empty(), TextureSlot.LAYER0));
        });
        getKnownCuisines().forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            itemModelGenerator.generateFlatItem(item, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/"+path)), Optional.empty(), TextureSlot.LAYER0));
        });
        getKnownBeverages().forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            itemModelGenerator.generateFlatItem(item, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/"+path)), Optional.empty(), TextureSlot.LAYER0));
        });
        getKnownOthers().forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            itemModelGenerator.generateFlatItem(item, new ModelTemplate(Optional.of(new ResourceLocation(MystiasIzakaya.MODID, "item/"+path)), Optional.empty(), TextureSlot.LAYER0));
        });
    }

    private static Iterable<Item> getKnownIngredients() {
        return new HashSet<>(MIItem.ingredients);
    }
    private static Iterable<Item> getKnownCuisines() {
        return new HashSet<>(MIItem.cuisines);
    }
    private static Iterable<Item> getKnownBeverages() {
        return new HashSet<>(MIItem.beverages);
    }
    private static Iterable<Item> getKnownOthers() {
        return new HashSet<>(MIItem.others);
    }
}
