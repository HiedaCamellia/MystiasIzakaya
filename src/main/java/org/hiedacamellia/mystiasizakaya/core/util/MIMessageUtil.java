package org.hiedacamellia.mystiasizakaya.core.util;


import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.loading.FMLEnvironment;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class MIMessageUtil {


    private static MutableComponent prefixComponent = Component.literal("[")
            .append(Component.translatable("item_group.mystias_izakaya.mystiass_izakaya").withStyle(ChatFormatting.GREEN))
            .append("]");

    public static void sendDebug(String string) {
        sendDebug(Component.literal(string));
    }

    public static void sendDebug(Component component) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && MystiasIzakaya.isDebugMode()) {
                mc.player.sendSystemMessage(prefixComponent.append(component));
            }
        }
    }
    public static void send(String string) {
        send(Component.literal(string));
    }
    public static void send(Component component) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null) {
                mc.player.sendSystemMessage(prefixComponent.append(component));
            }
        }
    }

    public static void sendDebug(String string, Player player) {
        sendDebug(Component.literal(string), player);
    }
    public static void sendDebug(Component string, Player player) {
        if(!player.isLocalPlayer() && MystiasIzakaya.isDebugMode()) {
            player.sendSystemMessage(prefixComponent.append(string));
        }
    }
    public static void send(String string, Player player) {
        send(Component.literal(string), player);
    }
    public static void send(Component component, Player player) {
        if(!player.isLocalPlayer()) {
            player.sendSystemMessage(prefixComponent.append(component));
        }
    }
}

