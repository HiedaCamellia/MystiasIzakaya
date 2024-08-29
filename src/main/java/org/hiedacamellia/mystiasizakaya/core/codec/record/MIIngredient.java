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

public record MIIngredient(List<String> ingredient)implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MIIngredient(this.ingredient));
    }

    public static final CustomPacketPayload.Type<MIIngredient> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_orders"));

    public static final StreamCodec<ByteBuf, MIIngredient> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MIIngredient::ingredient,
            MIIngredient::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}