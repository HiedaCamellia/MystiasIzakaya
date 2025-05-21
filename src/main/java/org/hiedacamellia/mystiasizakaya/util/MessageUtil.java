package org.hiedacamellia.mystiasizakaya.util;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.loading.FMLEnvironment;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageUtil {

    private static String prefix = "[§a夜雀食堂§r]";
    private static Boolean debugConfig = MICommonConfig.DEBUG.get();
    private static Logger logger = LoggerFactory.getLogger(MystiasIzakaya.class);

    public static Logger getLogger(){
        return logger;
    }

    public static void sendDebug(String string) {
        sendDebug(Component.literal(string));
    }
    public static void sendDebug(Component component) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix).append(component));
            }
        }
    }
    public static void send(String string) {
        send(Component.literal(string));
    }
    public static void send(Component component) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix).append(component));
            }
        }
    }

    public static void sendDebug(String string, Player player) {
        sendDebug(Component.literal(string), player);
    }
    public static void sendDebug(Component string, Player player) {
        if(!player.isLocalPlayer() && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix  + string));
        }
    }
    public static void send(String string, Player player) {
        send(Component.literal(string), player);
    }
    public static void send(Component component, Player player) {
        if(!player.isLocalPlayer() && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix).append(component));
        }
    }
}

