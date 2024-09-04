package org.hiedacamellia.mystiasizakaya;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);

    public static final ForgeConfigSpec.BooleanValue SHOW_BALANCE = BUILDER
            .comment("Set to true to display balance in the hud ( deprecated ) ")
            .comment("设置为true以在hud中显示余额（弃用）")
            .define("show_balance", false);

    public static final ForgeConfigSpec.IntValue MAX_OVERTURN = BUILDER
            .comment("The maximum number of turnovers to store")
            .comment("要存储的最大流水次数")
            .defineInRange("max_overturn", 10, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue TELE_COOLDOWN = BUILDER
            .comment("The cooldown time for the telephone(tick)")
            .comment("电话的冷却时间(刻)")
            .defineInRange("tele_cooldown", 12000, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean debug;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        debug = DEBUG.get();
    }
}
