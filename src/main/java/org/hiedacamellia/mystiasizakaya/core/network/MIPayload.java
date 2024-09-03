package org.hiedacamellia.mystiasizakaya.core.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MIPayload {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1.0.0");
        registrar.playBidirectional(
                MIOrders.TYPE,
                MIOrders.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIOrders::handleData,
                        MIOrders::handleData
                )
        );
        registrar.playBidirectional(
                MIMenu.TYPE,
                MIMenu.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIMenu::handleData,
                        MIMenu::handleData
                )
        );
        registrar.playBidirectional(
                MIBalance.TYPE,
                MIBalance.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIBalance::handleData,
                        MIBalance::handleData
                )
        );
        registrar.playBidirectional(
                DonationUiButton.TYPE,
                DonationUiButton.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        DonationUiButton::handleData,
                        DonationUiButton::handleData
                )
        );
        registrar.playBidirectional(
                CookingRangeUiButton.TYPE,
                CookingRangeUiButton.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        CookingRangeUiButton::handleData,
                        CookingRangeUiButton::handleData
                )
        );
        registrar.playBidirectional(
                MITurnover.TYPE,
                MITurnover.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MITurnover::handleData,
                        MITurnover::handleData
                )
        );
        registrar.playBidirectional(
                TelephoneUiButton.TYPE,
                TelephoneUiButton.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        TelephoneUiButton::handleData,
                        TelephoneUiButton::handleData
                )
        );
        registrar.playBidirectional(
                MIOnOpen.TYPE,
                MIOnOpen.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIOnOpen::handleData,
                        MIOnOpen::handleData
                )
        );



    }
}
