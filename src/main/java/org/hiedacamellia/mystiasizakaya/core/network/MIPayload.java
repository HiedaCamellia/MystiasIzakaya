package org.hiedacamellia.mystiasizakaya.core.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MIPayload {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                MIOrders.TYPE,
                MIOrders.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        MIOrders::handleData,
                        MIOrders::handleData
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
                BankUiButton.TYPE,
                BankUiButton.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        BankUiButton::handleData,
                        BankUiButton::handleData
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

    }
}
