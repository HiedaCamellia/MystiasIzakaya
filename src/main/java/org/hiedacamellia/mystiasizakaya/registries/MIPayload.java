package org.hiedacamellia.mystiasizakaya.registries;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;
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
        registrar.playBidirectional(
                MIOrders.TYPE,
                MIOrders.STREAM_CODEC,
                MIOrders::handleData
        );
        registrar.playBidirectional(
                org.hiedacamellia.mystiasizakaya.core.codec.record.MIMenu.TYPE,
                org.hiedacamellia.mystiasizakaya.core.codec.record.MIMenu.STREAM_CODEC,
                MIMenu::handleData
        );
        registrar.playBidirectional(
                MIBalance.TYPE,
                MIBalance.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIBalance::handleClient,
                        MIBalance::handleServer
                )
        );
        registrar.playToServer(
                DonationTakeOutS2SMessage.TYPE,
                DonationTakeOutS2SMessage.STREAM_CODEC,
                DonationTakeOutS2SMessage::handleServer
        );
        registrar.playBidirectional(
                MITurnover.TYPE,
                MITurnover.STREAM_CODEC,
                MITurnover::handleData
        );
        registrar.playToServer(
                TelephoneConfirmS2SMessage.TYPE,
                TelephoneConfirmS2SMessage.STREAM_CODEC,
                TelephoneConfirmS2SMessage::handleServer
        );
        registrar.playBidirectional(
                MIOnOpen.TYPE,
                MIOnOpen.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIOnOpen::handleClient,
                        MIOnOpen::handleServer
                )
        );



    }
}
