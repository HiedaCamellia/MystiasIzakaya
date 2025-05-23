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
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.jetbrains.annotations.NotNull;

public record TelephoneCooldownSyncS2CMessage(int tick) implements CustomPacketPayload {
    
    public static final CustomPacketPayload.Type<TelephoneCooldownSyncS2CMessage> TYPE = new CustomPacketPayload.Type<>(MystiasIzakaya.rl("mi_tele_cooldown"));

    public static final StreamCodec<ByteBuf, TelephoneCooldownSyncS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            TelephoneCooldownSyncS2CMessage::tick,
            TelephoneCooldownSyncS2CMessage::new
    );

    public static final Codec<TelephoneCooldownSyncS2CMessage> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("tick").forGetter(TelephoneCooldownSyncS2CMessage::tick)
            ).apply(instance, TelephoneCooldownSyncS2CMessage::new)
    );
    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(TelephoneCooldownSyncS2CMessage data, IPayloadContext context) {
        context.enqueueWork(() -> MIPlayerUtil.setTeleCooldown(context.player(), data.tick()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
