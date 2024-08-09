package org.hiedacamellia.mystiasizakaya.core.codec.record;

import com.mojang.serialization.Codec;
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

import java.util.List;

public record MITags(List<String> tags,List<String> ntags)implements CustomPacketPayload {

    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MITags(this.tags, this.ntags));
    }

    public static final CustomPacketPayload.Type<MITags> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_tags"));

    public static final StreamCodec<ByteBuf, MITags> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MITags::tags,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MITags::ntags,
            MITags::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}
