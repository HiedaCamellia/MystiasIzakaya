package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public record TurnoverSyncS2CMessage(List<Pair<String,Double>> list) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<TurnoverSyncS2CMessage> TYPE = new CustomPacketPayload.Type<>(MystiasIzakaya.rl( "turnover_sync"));

    public static final StreamCodec<ByteBuf, TurnoverSyncS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.<ByteBuf,Pair<String,Double>>list().apply(MICodecUtil.TURNOVER_STREAM_CODEC),
            TurnoverSyncS2CMessage::list,
            TurnoverSyncS2CMessage::new
    );

    public static final Codec<TurnoverSyncS2CMessage> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    MICodecUtil.TURNOVER_CODEC.listOf().fieldOf("list").forGetter(TurnoverSyncS2CMessage::list)
            ).apply(instance, TurnoverSyncS2CMessage::new)
    );
    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public ArrayList<Pair<String,Double>> copy(){
        return new ArrayList<>(this.list());
    }

    public static void handleClient(final TurnoverSyncS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> MIPlayerUtil.setTurnover(context.player(), data.copy()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }

}

