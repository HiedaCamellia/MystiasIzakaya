package org.hiedacamellia.mystiasizakaya.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.mystiasizakaya.data.lang.EnglishLanguageProvider;
import org.hiedacamellia.mystiasizakaya.data.provider.*;

@EventBusSubscriber(modid = MystiasIzakaya.MODID)
public class Data {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        gen.addProvider(true, new MIModelProvider(packOutput));

        var vanillaPack = gen.getVanillaPack(true);
        var registries = event.getLookupProvider();
        gen.addProvider(true, new EnglishLanguageProvider(packOutput));
        gen.addProvider(true, new ChineseLanguageProvider(packOutput));
        event.createProvider(MIRecipeProvider.Runner::new);
        var blockTagsProvider = vanillaPack.addProvider(pack -> new MITagBlockProvider(pack, registries, MystiasIzakaya.MODID));
        vanillaPack.addProvider(pack -> new MITagItemProvider(pack, registries, blockTagsProvider.contentsGetter(), MystiasIzakaya.MODID));

    }
//    @SubscribeEvent
//    public static void onGatherData(GatherDataEvent.Server event) {
//        var gen = event.getGenerator();
//        var packOutput = gen.getPackOutput();
//        var vanillaPack = gen.getVanillaPack(true);
//        var registries = event.getLookupProvider();
//        gen.addProvider(true, new EnglishLanguageProvider(packOutput));
//        gen.addProvider(true, new ChineseLanguageProvider(packOutput));
//        event.createProvider(MIRecipeProvider.Runner::new);
//        var blockTagsProvider = vanillaPack.addProvider(pack -> new MITagBlockProvider(pack, registries, MystiasIzakaya.MODID));
//        vanillaPack.addProvider(pack -> new MITagItemProvider(pack, registries, blockTagsProvider.contentsGetter(), MystiasIzakaya.MODID));
//
//    }
}