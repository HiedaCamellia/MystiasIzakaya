package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

public record OrderRemoveS2CMessage(byte id)implements CustomPacketPayload {

    public static final Type<OrderRemoveS2CMessage> TYPE = new Type<>(MystiasIzakaya.rl("order_remove_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OrderRemoveS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE, OrderRemoveS2CMessage::id,
            OrderRemoveS2CMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final OrderRemoveS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    LocalPlayer player = Minecraft.getInstance().player;
                    MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS.get());
                    BlockPos pos = miOrders.blockPos().get(data.id());
                    ClientLevel clientLevel = player.clientLevel;
                    if (clientLevel.isLoaded(pos)) {
                        if (clientLevel.getBlockEntity(pos) instanceof TableEntity tableEntity) {
                            tableEntity.removeW2S();
                        }
                    }


                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
