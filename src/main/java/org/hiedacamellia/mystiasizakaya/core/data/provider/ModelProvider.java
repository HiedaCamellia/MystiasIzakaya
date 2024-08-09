package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MystiasIzakaya.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

}
