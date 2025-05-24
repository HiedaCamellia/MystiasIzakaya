package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.ExistW2SWidget;

import java.util.UUID;

public record CookingRemoveS2SMessage(UUID uuid) implements CustomPacketPayload {

    public static final Type<CookingRemoveS2SMessage> TYPE = new Type<>(MystiasIzakaya.rl("cooking_remove_s2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CookingRemoveS2SMessage> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, CookingRemoveS2SMessage::uuid,
            CookingRemoveS2SMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final CookingRemoveS2SMessage data, final IPayloadContext context){
        context.enqueueWork(() -> ExistW2SWidget.remove(data.uuid()))
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
