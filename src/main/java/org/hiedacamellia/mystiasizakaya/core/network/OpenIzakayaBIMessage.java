package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public record OpenIzakayaBIMessage(boolean open) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<OpenIzakayaBIMessage> TYPE = new CustomPacketPayload.Type<>(MystiasIzakaya.rl("open_izakaya"));

    public static final StreamCodec<ByteBuf, OpenIzakayaBIMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            OpenIzakayaBIMessage::open,
            OpenIzakayaBIMessage::new
    );

    public static final Codec<OpenIzakayaBIMessage> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf("open").forGetter(OpenIzakayaBIMessage::open)
            ).apply(instance, OpenIzakayaBIMessage::new)
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final OpenIzakayaBIMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(data.open()) {
                        IzakayaMenu data1 = player.getData(MIAttachment.IZAKAYA_MENU);
                        List<BlockPos> blockPosList = MIPlayerUtil.getTables(player);
                        boolean flag1 = false;
                        boolean flag2 = false;
                        boolean flag3 = false;
                        for (BlockPos blockPos : blockPosList) {
                            if(!Objects.equals(blockPos, new BlockPos(-1, -1, -1))){
                                flag1 = true;
                                break;
                            }
                        }
                        for(String s:data1.cuisines()){
                            if(!s.equals("minecraft:air")){
                                flag2 = true;
                                break;
                            }
                        }
                        for(String s:data1.beverages()){
                            if(!s.equals("minecraft:air")){
                                flag3 = true;
                                break;
                            }
                        }
                        if(flag1 && flag2 && flag3){
                            player.setData(MIAttachment.MI_ON_OPEN, data.open());
                        }
                    }else {
                        player.setData(MIAttachment.MI_ON_OPEN, data.open());
                    }
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }

    public static void handleClient(final OpenIzakayaBIMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> MIPlayerUtil.setOnOpen(context.player(),data.open()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
