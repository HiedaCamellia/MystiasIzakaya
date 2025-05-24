package org.hiedacamellia.mystiasizakaya.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.core.util.MIMessageUtil;

import java.util.Map;

public record ItemPriceAddonSyncBiMessage(Map<String, Integer> map) implements CustomPacketPayload {

    public static final Type<ItemPriceAddonSyncBiMessage> TYPE = new Type<>(MystiasIzakaya.rl( "item_price_addon_sync"));

    public static final StreamCodec<ByteBuf, ItemPriceAddonSyncBiMessage> STREAM_CODEC = StreamCodec.composite(
            ItemPriceAddon.STREAM_CODEC,
            ItemPriceAddonSyncBiMessage::map,
            ItemPriceAddonSyncBiMessage::new
    );

    @Override
    public Type<ItemPriceAddonSyncBiMessage> type() {
        return TYPE;
    }


    public static void handleServer(final ItemPriceAddonSyncBiMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    if (context.player().hasPermissions(4)) {
                        ItemPriceAddon.setItemPriceMap(data.map());
                        ItemPriceAddon.save();
                        ItemPriceAddon.sync2Client();
                        MIMessageUtil.send(Component.translatable("network.mystiasizakaya.item_price_addon.set_success").withStyle(ChatFormatting.GREEN), context.player());
                    }
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }

    public static void handleClient(final ItemPriceAddonSyncBiMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    ItemPriceAddon.setItemPriceMap(data.map());
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
