package org.hiedacamellia.mystiasizakaya;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);


    public static final ModConfigSpec.BooleanValue SHOW_BALANCE = BUILDER
            .comment("Set to true to display balance in the hud ( deprecated ) ")
            .comment("设置为true以在hud中显示余额（弃用）")
            .define("show_balance", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean debug;

//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        debug = DEBUG.get();
    }
}
