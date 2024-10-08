package org.hiedacamellia.mystiasizakaya.core.network;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.S2CPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MINetWork {
    private static final String PROTOCOL_VERSION = "1.0.0";
    public static final SimpleChannel PACKET_HANDLER = new SimpleChannel(new ResourceLocation(MystiasIzakaya.MODID, "channel"));
    private static int messageID = 0;

    public static <T extends C2SPacket> void addC2SNetworkMessage(Class<T> messageType,  Function<FriendlyByteBuf, T> decoder) {
        PACKET_HANDLER.registerC2SPacket(messageType,messageID, decoder);
        messageID++;
    }

    public static <T extends S2CPacket> void addS2CNetworkMessage(Class<T> messageType, Function<FriendlyByteBuf, T> decoder) {
        PACKET_HANDLER.registerS2CPacket(messageType,messageID, decoder);
        messageID++;
    }

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    public static void register() {
        TelephoneUiButton.registerMessage();
        CookingRangeUiButton.registerMessage();
        DonationUiButton.registerMessage();
    }

}
