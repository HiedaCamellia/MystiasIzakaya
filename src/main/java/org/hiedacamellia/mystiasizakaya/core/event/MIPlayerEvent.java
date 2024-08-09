package org.hiedacamellia.mystiasizakaya.core.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber
public class MIPlayerEvent {

    @SubscribeEvent
    public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
    }

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        if (event.getOriginal().hasData(MIAttachment.MI_ORDERS)) {
            MIOrders miOrders = event.getOriginal().getData(MIAttachment.MI_ORDERS);
            event.getEntity().setData(MIAttachment.MI_ORDERS, miOrders);
        }
        if (event.getOriginal().hasData(MIAttachment.MI_BALANCE)) {
            MIBalance miBalance = event.getOriginal().getData(MIAttachment.MI_BALANCE);
            event.getEntity().setData(MIAttachment.MI_BALANCE, miBalance);
        }

    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().hasData(MIAttachment.MI_ORDERS)) {
            event.getEntity().setData(MIAttachment.MI_ORDERS, new MIOrders(new ArrayList<>(10),new ArrayList<>(10)));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_BALANCE)) {
            event.getEntity().setData(MIAttachment.MI_BALANCE, new MIBalance(0));
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
    }

}
