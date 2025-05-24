package org.hiedacamellia.mystiasizakaya.registries;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.mystiasizakaya.core.network.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MIPayload {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1.0.0");
        registrar.playToServer(
                CookingStartS2SMessage.TYPE,
                CookingStartS2SMessage.STREAM_CODEC,
                CookingStartS2SMessage::handleServer
        );
        registrar.playToServer(
                CookingGetResultC2SMessage.TYPE,
                CookingGetResultC2SMessage.STREAM_CODEC,
                CookingGetResultC2SMessage::handleServer
        );
        registrar.playToClient(
                CookingStartS2CMessage.TYPE,
                CookingStartS2CMessage.STREAM_CODEC,
                CookingStartS2CMessage::handleClient
        );
        registrar.playToClient(
                CookingProgressS2SMessage.TYPE,
                CookingProgressS2SMessage.STREAM_CODEC,
                CookingProgressS2SMessage::handleClient
        );
        registrar.playToClient(
                CookingRemoveS2SMessage.TYPE,
                CookingRemoveS2SMessage.STREAM_CODEC,
                CookingRemoveS2SMessage::handleClient
        );
        registrar.playToClient(
                OrderAddS2CMessage.TYPE,
                OrderAddS2CMessage.STREAM_CODEC,
                OrderAddS2CMessage::handleClient
        );
        registrar.playToServer(
                OrderFeedC2SMessage.TYPE,
                OrderFeedC2SMessage.STREAM_CODEC,
                OrderFeedC2SMessage::handleServer
        );
        registrar.playToClient(
                OrderRemoveS2CMessage.TYPE,
                OrderRemoveS2CMessage.STREAM_CODEC,
                OrderRemoveS2CMessage::handleClient
        );
        registrar.playToClient(
                IzakayaOrderSyncS2CMessage.TYPE,
                IzakayaOrderSyncS2CMessage.STREAM_CODEC,
                IzakayaOrderSyncS2CMessage::handleClient
        );
        registrar.playBidirectional(
                IzakayaMenuSyncBiMessage.TYPE,
                IzakayaMenuSyncBiMessage.STREAM_CODEC,
                IzakayaMenuSyncBiMessage::handleData
        );
        registrar.playBidirectional(
                IzakayaTableSyncBiMessage.TYPE,
                IzakayaTableSyncBiMessage.STREAM_CODEC,
                IzakayaTableSyncBiMessage::handleData
        );
        registrar.playToClient(
                BalanceSyncS2CMessage.TYPE,
                BalanceSyncS2CMessage.STREAM_CODEC,
                BalanceSyncS2CMessage::handleClient
        );
        registrar.playToClient(
                TelephoneCooldownSyncS2CMessage.TYPE,
                TelephoneCooldownSyncS2CMessage.STREAM_CODEC,
                TelephoneCooldownSyncS2CMessage::handleClient
        );
        registrar.playToServer(
                DonationTakeOutS2SMessage.TYPE,
                DonationTakeOutS2SMessage.STREAM_CODEC,
                DonationTakeOutS2SMessage::handleServer
        );
        registrar.playToClient(
                TurnoverSyncS2CMessage.TYPE,
                TurnoverSyncS2CMessage.STREAM_CODEC,
                TurnoverSyncS2CMessage::handleClient
        );
        registrar.playToServer(
                TelephoneConfirmS2SMessage.TYPE,
                TelephoneConfirmS2SMessage.STREAM_CODEC,
                TelephoneConfirmS2SMessage::handleServer
        );
        registrar.playBidirectional(
                OpenIzakayaBIMessage.TYPE,
                OpenIzakayaBIMessage.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        OpenIzakayaBIMessage::handleClient,
                        OpenIzakayaBIMessage::handleServer
                )
        );



    }
}
