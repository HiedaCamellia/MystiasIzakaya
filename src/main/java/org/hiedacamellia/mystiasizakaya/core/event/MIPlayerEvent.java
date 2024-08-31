package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.HashMap;
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
        if (event.getOriginal().hasData(MIAttachment.MI_TURNOVER)) {
            MITurnover miTurnover = event.getOriginal().getData(MIAttachment.MI_TURNOVER);
            event.getEntity().setData(MIAttachment.MI_TURNOVER, miTurnover);
        }

    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!event.getEntity().hasData(MIAttachment.MI_ORDERS)) {
            event.getEntity().setData(MIAttachment.MI_ORDERS, new MIOrders(new ArrayList<>(10), new ArrayList<>(10)));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_BALANCE)) {
            event.getEntity().setData(MIAttachment.MI_BALANCE, new MIBalance(0));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_TURNOVER)) {
            event.getEntity().setData(MIAttachment.MI_TURNOVER, new MITurnover(new ArrayList<>(),new ArrayList<>()));
        }
        if(player instanceof ServerPlayer){
            MIBalance miBalance = player.getData(MIAttachment.MI_BALANCE);
            miBalance.sync(player);
            MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
            miOrders.sync(player);
            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
            miTurnover.sync(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        int tick = player.getData(MIAttachment.MI_TELE_COLDDOWN).tick();
        if(tick>0)
            player.setData(MIAttachment.MI_TELE_COLDDOWN,new MITeleColddown(tick-1));
    }

}
