package org.hiedacamellia.mystiasizakaya.core.config;


import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_ALL_INGREDIENTS = BUILDER
            .comment("Set to true to enable put any ingredients in kitchenware")
            .comment("设置为true以允许厨具放入任何食材")
            .define("enable_all_ingredients", false);

    public static final ForgeConfigSpec.BooleanValue ENABLE_ALL_CUISINES = BUILDER
            .comment("Set to true to enable put any cuisines in table")
            .comment("设置为true以允许餐桌放入任何料理")
            .define("enable_all_cuisines", false);

    public static final ForgeConfigSpec.BooleanValue ENABLE_ALL_BEVERAGES = BUILDER
            .comment("Set to true to enable put any beverages in table")
            .comment("设置为true以允许餐桌放入任何饮品")
            .define("enable_all_beverages", false);


    public static final ForgeConfigSpec.IntValue MAX_OVERTURN = BUILDER
            .comment("The maximum number of turnovers to store")
            .comment("要存储的最大流水次数")
            .defineInRange("max_overturn", 10, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue TELE_COOLDOWN = BUILDER
            .comment("The cooldown time for the telephone(tick)")
            .comment("电话的冷却时间(刻)")
            .defineInRange("tele_cooldown", 12000, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.DoubleValue ORDER_REFRESH_PROBABILITY = BUILDER
            .comment("The probability of refreshing the order")
            .comment("每次尝试刷新订单的概率")
            .defineInRange("order_refresh_probability", 0.1, 0, 1);

    public static final ForgeConfigSpec.IntValue ORDER_REFRESH_INTERVAL = BUILDER
            .comment("The interval of refreshing the order(tick)")
            .comment("尝试刷新订单的间隔(游戏刻)")
            .defineInRange("order_refresh_interval", 100, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
