package org.hiedacamellia.mystiasizakaya.core.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.hiedacamellia.mystiasizakaya.core.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.mystiasizakaya.core.data.lang.EnglishLanguageProvider;
import org.hiedacamellia.mystiasizakaya.core.data.provider.MIModelProvider;
import org.hiedacamellia.mystiasizakaya.core.data.provider.MIRecipeProvider;

public class Data implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ChineseLanguageProvider::new);
        pack.addProvider(EnglishLanguageProvider::new);
        pack.addProvider(MIModelProvider::new);
        pack.addProvider(MIRecipeProvider::new);
    }
}