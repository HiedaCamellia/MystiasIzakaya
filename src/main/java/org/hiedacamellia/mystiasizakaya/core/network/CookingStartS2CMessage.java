package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingEntity;

import java.util.UUID;

public record CookingStartS2CMessage(BlockPos pos, UUID uuid, ResourceLocation result) implements CustomPacketPayload {

    public static final Type<CookingStartS2CMessage> TYPE = new Type<>(MystiasIzakaya.rl("cooking_start_s2c"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CookingStartS2CMessage> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, CookingStartS2CMessage::pos,
            UUIDUtil.STREAM_CODEC, CookingStartS2CMessage::uuid,
            ResourceLocation.STREAM_CODEC, CookingStartS2CMessage::result,
            CookingStartS2CMessage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(final CookingStartS2CMessage data, final IPayloadContext context){
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(player instanceof LocalPlayer localPlayer){
                        ClientLevel clientLevel = localPlayer.clientLevel;
                        BlockPos pos1 = data.pos();
                        BlockEntity blockEntity = clientLevel.getBlockEntity(pos1);
                        if (blockEntity instanceof CookingEntity cookingEntity) {
                            cookingEntity.setW2sUUID(data.uuid());
                            cookingEntity.addW2S(data.result);
                        }
                    }
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
