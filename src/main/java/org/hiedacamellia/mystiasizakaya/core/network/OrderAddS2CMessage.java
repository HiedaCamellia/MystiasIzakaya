package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

public record OrderAddS2CMessage(byte id, ResourceLocation c, ResourceLocation b)implements CustomPacketPayload {

    public static final Type<OrderAddS2CMessage> TYPE = new Type<>(MystiasIzakaya.rl("order_add_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OrderAddS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE,OrderAddS2CMessage::id,
            ResourceLocation.STREAM_CODEC,OrderAddS2CMessage::c,
            ResourceLocation.STREAM_CODEC,OrderAddS2CMessage::b,
            OrderAddS2CMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final OrderAddS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    LocalPlayer player = Minecraft.getInstance().player;
                    BlockPos pos = MIPlayerUtil.getTables(player).get(data.id());
                    ClientLevel clientLevel = player.clientLevel;
                    if (clientLevel.isLoaded(pos)) {
                        if (clientLevel.getBlockEntity(pos) instanceof TableEntity tableEntity) {
                            tableEntity.addW2S(data.c(), data.b(), data.id());
                        }
                    }


                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
