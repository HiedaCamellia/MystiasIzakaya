package org.hiedacamellia.mystiasizakaya.core.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);

    public static final ModConfigSpec.IntValue MAX_OVERTURN = BUILDER
            .comment("The maximum number of turnovers to store")
            .comment("要存储的最大流水次数")
            .defineInRange("max_overturn", 10, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue TELE_COOLDOWN = BUILDER
            .comment("The cooldown time for the telephone(tick)")
            .comment("电话的冷却时间(刻)")
            .defineInRange("tele_cooldown", 12000, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
