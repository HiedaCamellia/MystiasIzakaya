package org.hiedacamellia.mystiasizakaya.core.codec.record;

import com.mojang.serialization.Codec;
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
import org.hiedacamellia.mystiasizakaya.Config;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public record MITurnover(List<String> k, List<Double> v) implements CustomPacketPayload {

    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MITurnover(this.k, this.v));
    }

    public static final CustomPacketPayload.Type<MITurnover> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_turnover"));

    public static final StreamCodec<ByteBuf, MITurnover> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MITurnover::k,
            ByteBufCodecs.fromCodec(Codec.list(Codec.DOUBLE)),
            MITurnover::v,
            MITurnover::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final MITurnover data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(MIAttachment.MI_TURNOVER, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }

    public MITurnover addTurnover(String key, Double value){
        List<String> k = new ArrayList<>(this.k());
        k.add(key);
        List<Double> v = new ArrayList<>(this.v());
        v.add(value);
        return new MITurnover(k, v);
    }

    public MITurnover deleteTurnover(String key){
        List<String> k = new ArrayList<>(this.k());
        List<Double> v = new ArrayList<>(this.v());
        for(int i = 0; i < k.size(); i++){
            if(k.get(i).equals(key)){
                k.remove(i);
                v.remove(i);
                break;
            }
        }
        return new MITurnover(k, v);
    }

    public MITurnover deleteOverStack(){
        int stack = Config.MAX_OVERTURN.get();
        List<String> k = new ArrayList<>(this.k());
        List<Double> v = new ArrayList<>(this.v());
        while(k.size() > stack){
            k.remove(0);
            v.remove(0);
        }
        return new MITurnover(k, v);
    }
}
