package org.hiedacamellia.mystiasizakaya.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.jetbrains.annotations.NotNull;

public record MITeleColddown(int tick) implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MITeleColddown(this.tick));
    }

    public static final CustomPacketPayload.Type<MITeleColddown> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_cost"));

    public static final StreamCodec<ByteBuf, MITeleColddown> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            MITeleColddown::tick,
            MITeleColddown::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
