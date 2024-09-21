package org.hiedacamellia.mystiasizakaya.core.config;

import io.github.fabricators_of_create.porting_lib.config.ConfigTracker;
import io.github.fabricators_of_create.porting_lib.config.ConfigType;
import io.github.fabricators_of_create.porting_lib.config.ModConfig;
import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            ConfigTracker.INSTANCE.loadConfigs(ConfigType.SERVER, getServerConfigPath(server));
        });
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            ConfigTracker.INSTANCE.unloadConfigs(ConfigType.SERVER, getServerConfigPath(server));
        });

        ServerPlayConnectionEvents.JOIN.addPhaseOrdering(CONFIG_SYNC, AFTER_CONFIG_SYNC);
        ServerPlayConnectionEvents.JOIN.register(CONFIG_SYNC, (handler, sender, server) -> {
            ServerPlayer player = handler.player;
            if (server.isSingleplayerOwner(player.getGameProfile()))
                return; // don't sync to self

            ConfigTracker.INSTANCE.configSets().get(ConfigType.SERVER).forEach(config -> {
                try {
                    String name = config.getFileName();
                    byte[] data = Files.readAllBytes(config.getFullPath());

                    FriendlyByteBuf buf = PacketByteBufs.create();
                    buf.writeUtf(name);
                    buf.writeByteArray(data);
                    sender.sendPacket(CONFIG_SYNC, buf);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
}
