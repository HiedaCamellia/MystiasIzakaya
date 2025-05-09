package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.stream.Collectors;

public class MIModelProvider extends ItemModelProvider {
    public MIModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MystiasIzakaya.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        singleTexture("ledger", this.mcLoc("item/generated"), "layer0", modLoc("item/ledger"));
        singleTexture("cutting_board",this.mcLoc("item/generated"), "layer0",modLoc("item/liao_li_tai"));
        singleTexture("grill",this.mcLoc("item/generated"), "layer0",modLoc("item/shao_kao_jia"));
        singleTexture("boiling_pot",this.mcLoc("item/generated"), "layer0",modLoc("item/zhu_guo"));
        singleTexture("steamer",this.mcLoc("item/generated"), "layer0",modLoc("item/zheng_guo"));
        singleTexture("frying_pan",this.mcLoc("item/generated"), "layer0",modLoc("item/you_guo"));

        getKnownIngredients().forEach(item -> {
            String path = ForgeRegistries.ITEMS.getKey(item).getPath();
            this.singleTexture(path, this.mcLoc("item/generated"), "layer0", this.modLoc("item/" + path));
        });
        getKnownCuisines().forEach(item -> {
            String path = ForgeRegistries.ITEMS.getKey(item).getPath();
            this.singleTexture(path, this.mcLoc("item/generated"), "layer0", this.modLoc("item/" + path));
        });
        getKnownBeverages().forEach(item -> {
            String path = ForgeRegistries.ITEMS.getKey(item).getPath();
            this.singleTexture(path, this.mcLoc("item/generated"), "layer0", this.modLoc("item/" + path));
        });
        getKnownOthers().forEach(item -> {
            String path = ForgeRegistries.ITEMS.getKey(item).getPath();
            this.singleTexture(path, this.mcLoc("item/generated"), "layer0", this.modLoc("item/" + path));
        });



    }

    private static Iterable<Item> getKnownIngredients() {
        return MIItem.Ingredients.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownCuisines() {
        return MIItem.Cuisines.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownBeverages() {
        return MIItem.Beverages.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }
    private static Iterable<Item> getKnownOthers() {
        return MIItem.Others.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }
}
