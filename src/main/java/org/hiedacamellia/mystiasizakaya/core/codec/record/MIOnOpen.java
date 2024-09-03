package org.hiedacamellia.mystiasizakaya.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.jetbrains.annotations.NotNull;

public record MIOnOpen(boolean open) implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MIOnOpen(this.open));
    }

    public static final CustomPacketPayload.Type<MIOnOpen> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_on_open"));

    public static final StreamCodec<ByteBuf, MIOnOpen> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            MIOnOpen::open,
            MIOnOpen::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final MIOnOpen data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(MIAttachment.MI_ON_OPEN, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
