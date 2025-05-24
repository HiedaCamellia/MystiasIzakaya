package org.hiedacamellia.mystiasizakaya.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record IzakayaTableSyncBiMessage(List<BlockPos> blockPos)implements CustomPacketPayload {


    public static final StreamCodec<ByteBuf, IzakayaTableSyncBiMessage> STREAM_CODEC = StreamCodec.composite(
            MICodecUtil.LIST_BLOCK_POS_STREAM_CODEC,
            IzakayaTableSyncBiMessage::blockPos,
            IzakayaTableSyncBiMessage::new
    );

    public static final Type<IzakayaTableSyncBiMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "izakaya_table_sync"));

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final IzakayaTableSyncBiMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    MIPlayerUtil.setTables(context.player(), data.blockPos());
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
