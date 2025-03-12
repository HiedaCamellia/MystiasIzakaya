package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;

public record CookingGetResultC2SMessage(BlockPos pos) implements CustomPacketPayload {

    public static final Type<CookingGetResultC2SMessage> TYPE = new Type<>(MystiasIzakaya.rl("cooking_result_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CookingGetResultC2SMessage> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, CookingGetResultC2SMessage::pos,
            CookingGetResultC2SMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final CookingGetResultC2SMessage data, final IPayloadContext context){
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(player instanceof ServerPlayer serverPlayer){
                        ServerLevel serverLevel = serverPlayer.serverLevel();
                        BlockPos pos1 = data.pos();
                        if (serverLevel.isLoaded(pos1)) {
                            BlockEntity blockEntity = serverLevel.getBlockEntity(pos1);
                            if(blockEntity instanceof CookingEntity cookingEntity){
                                ItemStack copy = cookingEntity.getItemHandler().getStackInSlot(6).copy();
                                cookingEntity.getItemHandler().setStackInSlot(6, ItemStack.EMPTY);
                                serverPlayer.addItem(copy);
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
