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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;

public record CookingStartS2SMessage(byte id, BlockPos pos) implements CustomPacketPayload {

    public static final Type<CookingStartS2SMessage> TYPE = new Type<>(MystiasIzakaya.rl("cooking_start_s2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CookingStartS2SMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE, CookingStartS2SMessage::id,
            BlockPos.STREAM_CODEC, CookingStartS2SMessage::pos,
            CookingStartS2SMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final CookingStartS2SMessage data, final IPayloadContext context){
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(player instanceof ServerPlayer serverPlayer){
                        ServerLevel serverLevel = serverPlayer.serverLevel();
                        BlockPos pos1 = data.pos();
                        if (serverLevel.isLoaded(pos1)) {
                            BlockEntity blockEntity = serverLevel.getBlockEntity(pos1);
                            if(blockEntity instanceof CookingEntity cookingEntity){
                                MystiasIzakaya.LOGGER.debug("Server received cooking start message for cooking entity at {}", pos1);
                                cookingEntity.applyRecipe(data.id());
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
