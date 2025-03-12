package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.CookingProcessW2SWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.ExistW2SWidget;

import java.util.UUID;

public record CookingProgressS2SMessage(UUID uuid,int cook,int total) implements CustomPacketPayload {

    public static final Type<CookingProgressS2SMessage> TYPE = new Type<>(MystiasIzakaya.rl("cooking_progress_s2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CookingProgressS2SMessage> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, CookingProgressS2SMessage::uuid,
            ByteBufCodecs.INT, CookingProgressS2SMessage::cook,
            ByteBufCodecs.INT, CookingProgressS2SMessage::total,
            CookingProgressS2SMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final CookingProgressS2SMessage data, final IPayloadContext context){
        context.enqueueWork(() -> {
                    if (ExistW2SWidget.get(data.uuid()) instanceof CookingProcessW2SWidget widget) {
                        widget.setCookTime(data.cook(), data.total());
                    }
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
