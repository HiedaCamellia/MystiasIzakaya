package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MystiasIzakaya.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture("ledger",
                new ResourceLocation("item/generated"), "layer0",
                new ResourceLocation(MystiasIzakaya.MODID, "item/" + "ledger"));

    }

}
