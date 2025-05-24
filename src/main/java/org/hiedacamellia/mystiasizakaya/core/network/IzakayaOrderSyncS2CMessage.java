package org.hiedacamellia.mystiasizakaya.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record IzakayaOrderSyncS2CMessage(List<String> cuisines, List<String> beverages)implements CustomPacketPayload {

    private IzakayaOrder toIzakayaOrder() {
        return new IzakayaOrder(cuisines, beverages);
    }
    public static IzakayaOrderSyncS2CMessage fromIzakayaOrder(IzakayaOrder izakayaMenu) {
        return new IzakayaOrderSyncS2CMessage(izakayaMenu.cuisines(), izakayaMenu.beverages());
    }

    public static final StreamCodec<ByteBuf, IzakayaOrderSyncS2CMessage> STREAM_CODEC = StreamCodec.composite(
            MICodecUtil.LIST_STRING_STREAM_CODEC,
            IzakayaOrderSyncS2CMessage::cuisines,
            MICodecUtil.LIST_STRING_STREAM_CODEC,
            IzakayaOrderSyncS2CMessage::beverages,
            IzakayaOrderSyncS2CMessage::new
    );

    public static final Type<IzakayaOrderSyncS2CMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "izakaya_order_sync"));

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final IzakayaOrderSyncS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> MIPlayerUtil.setIzakayaOrder(context.player(), data.toIzakayaOrder()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
