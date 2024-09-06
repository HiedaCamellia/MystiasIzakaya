package org.hiedacamellia.mystiasizakaya.core.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue SHOW_BALANCE = BUILDER
            .comment("Set to true to display balance in the hud")
            .comment("设置为true以在hud中显示余额")
            .define("show_balance", false);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
