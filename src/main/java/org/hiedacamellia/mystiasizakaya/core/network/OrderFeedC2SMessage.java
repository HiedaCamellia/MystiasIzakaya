package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

public record OrderFeedC2SMessage(byte id, byte n, ItemStack itemStack)implements CustomPacketPayload {

    public static final Type<OrderFeedC2SMessage> TYPE = new Type<>(MystiasIzakaya.rl("order_feed_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OrderFeedC2SMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE, OrderFeedC2SMessage::id,
            ByteBufCodecs.BYTE, OrderFeedC2SMessage::n,
            ItemStack.STREAM_CODEC, OrderFeedC2SMessage::itemStack,
            OrderFeedC2SMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final OrderFeedC2SMessage data, final IPayloadContext context){
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(player instanceof ServerPlayer serverPlayer){
                        BlockPos pos = MIPlayerUtil.getTables(player).get(data.id());
                        ServerLevel serverLevel = serverPlayer.serverLevel();
                        if(serverLevel.isLoaded(pos)){
                            if (serverLevel.getBlockEntity(pos) instanceof TableEntity tableEntity){
                                if(data.n() < tableEntity.getItemHandler().getSlots())
                                    tableEntity.getItemHandler().setStackInSlot(data.n(), data.itemStack());
                            }
                        }
                    }


                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
