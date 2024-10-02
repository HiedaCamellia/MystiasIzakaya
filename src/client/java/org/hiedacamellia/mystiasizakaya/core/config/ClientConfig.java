package org.hiedacamellia.mystiasizakaya.core.config;



public class ClientConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue SHOW_BALANCE = BUILDER
            .comment("Set to true to display balance in the hud")
            .comment("设置为true以在hud中显示余额")
            .define("show_balance", false);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
