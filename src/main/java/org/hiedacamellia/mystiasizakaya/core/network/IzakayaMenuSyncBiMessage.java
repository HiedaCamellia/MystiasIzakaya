package org.hiedacamellia.mystiasizakaya.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record IzakayaMenuSyncBiMessage(List<String> cuisines, List<String> beverages)implements CustomPacketPayload {

    private IzakayaMenu toIzakayaMenu() {
        return new IzakayaMenu(cuisines, beverages);
    }
    public static IzakayaMenuSyncBiMessage fromIzakayaMenu(IzakayaMenu izakayaMenu) {
        return new IzakayaMenuSyncBiMessage(izakayaMenu.cuisines(), izakayaMenu.beverages());
    }

    public static final StreamCodec<ByteBuf, IzakayaMenuSyncBiMessage> STREAM_CODEC = StreamCodec.composite(
            MICodecUtil.LIST_STRING_STREAM_CODEC,
            IzakayaMenuSyncBiMessage::cuisines,
            MICodecUtil.LIST_STRING_STREAM_CODEC,
            IzakayaMenuSyncBiMessage::beverages,
            IzakayaMenuSyncBiMessage::new
    );

    public static final Type<IzakayaMenuSyncBiMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "izakaya_menu_sync"));

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final IzakayaMenuSyncBiMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> MIPlayerUtil.setIzakayaMenu(context.player(), data.toIzakayaMenu()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
