package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MystiasIzakaya.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture("ledger",
                ResourceLocation.withDefaultNamespace("item/generated"), "layer0",
                ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "item/" + "ledger"));

    }

}
