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

import java.util.HashMap;
import java.util.Map;

public record MITurnover(Map<String,Double> turnover) implements CustomPacketPayload {

    public MITurnover(){
        this(new HashMap<>());
    }

    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MITurnover(this.turnover));
    }

    public static final CustomPacketPayload.Type<MITurnover> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_turnover"));

    public static final StreamCodec<ByteBuf, MITurnover> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.unboundedMap(Codec.STRING, Codec.DOUBLE)),
            MITurnover::turnover,
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

    public void addTurnover(String key, Double value){
        this.turnover.put(key, value);
    }

    public void deleteTurnover(String key){
        this.turnover.remove(key);
    }

    public MITurnover deleteOverStack(){
        int stack = Config.MAX_OVERTURN.get();
        MITurnover miTurnover = new MITurnover();
        for(int i = this.turnover.size() - stack; i < this.turnover.size(); i++){
            miTurnover.addTurnover(this.turnover.keySet().toArray()[i].toString(), (Double) this.turnover.values().toArray()[i]);
        }
        return miTurnover;
    }
}
