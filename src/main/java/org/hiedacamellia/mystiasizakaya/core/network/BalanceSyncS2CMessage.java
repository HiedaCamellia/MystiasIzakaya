package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.jetbrains.annotations.NotNull;

public record BalanceSyncS2CMessage(int balance) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<BalanceSyncS2CMessage> TYPE = new CustomPacketPayload.Type<>(MystiasIzakaya.rl("mi_balance"));

    public static final StreamCodec<ByteBuf, BalanceSyncS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            BalanceSyncS2CMessage::balance,
            BalanceSyncS2CMessage::new
    );
    public static final Codec<BalanceSyncS2CMessage> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("balance").forGetter(BalanceSyncS2CMessage::balance)
            ).apply(instance, BalanceSyncS2CMessage::new)
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final BalanceSyncS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(MIAttachment.MI_BALANCE, data.balance());
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}