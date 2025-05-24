package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

public record OrderRemoveS2CMessage(byte id)implements CustomPacketPayload {

    public static final Type<OrderRemoveS2CMessage> TYPE = new Type<>(MystiasIzakaya.rl("order_remove_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OrderRemoveS2CMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE, OrderRemoveS2CMessage::id,
            OrderRemoveS2CMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final OrderRemoveS2CMessage data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    Player player = context.player();
                    BlockPos pos = MIPlayerUtil.getTables(player).get(data.id());
                    Level clientLevel = player.level();
                    if (clientLevel.isLoaded(pos)) {
                        if (clientLevel.getBlockEntity(pos) instanceof TableEntity tableEntity) {
                            tableEntity.removeW2S();
                        }
                    }
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
