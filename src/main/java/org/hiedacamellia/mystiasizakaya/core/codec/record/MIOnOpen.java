package org.hiedacamellia.mystiasizakaya.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public record MIOnOpen(boolean open) implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new MIOnOpen(this.open));
    }

    public static final CustomPacketPayload.Type<MIOnOpen> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_on_open"));

    public static final StreamCodec<ByteBuf, MIOnOpen> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            MIOnOpen::open,
            MIOnOpen::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final MIOnOpen data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    Player player = context.player();
                    if(data.open()) {
                        MIMenu data1 = player.getData(MIAttachment.MI_MENU);
                        List<BlockPos> blockPosList = player.getData(MIAttachment.MI_ORDERS).blockPos();
                        boolean flag1 = false;
                        boolean flag2 = false;
                        boolean flag3 = false;
                        for (BlockPos blockPos : blockPosList) {
                            if(!Objects.equals(blockPos, new BlockPos(-1, -1, -1))){
                                flag1 = true;
                                break;
                            }
                        }
                        for(String s:data1.orders()){
                            if(!s.equals("minecraft:air")){
                                flag2 = true;
                                break;
                            }
                        }
                        for(String s:data1.beverages()){
                            if(!s.equals("minecraft:air")){
                                flag3 = true;
                                break;
                            }
                        }
                        if(flag1 && flag2 && flag3){
                            player.setData(MIAttachment.MI_ON_OPEN, data);
                            player.sendSystemMessage(Component.translatable("network.mystiasizakaya.ledger.success").withStyle(ChatFormatting.GREEN));
                        }else {
                            player.sendSystemMessage(Component.translatable("network.mystiasizakaya.ledger.failed").withStyle(ChatFormatting.RED));
                            if(!flag1){
                                player.sendSystemMessage(Component.translatable("network.mystiasizakaya.ledger.failed.table").withStyle(ChatFormatting.GRAY));
                            }
                            if(!flag2){
                                player.sendSystemMessage(Component.translatable("network.mystiasizakaya.ledger.failed.cuisines").withStyle(ChatFormatting.GRAY));
                            }
                            if(!flag3){
                                player.sendSystemMessage(Component.translatable("network.mystiasizakaya.ledger.failed.beverages").withStyle(ChatFormatting.GRAY));
                            }
                        }
                    }else {
                        player.setData(MIAttachment.MI_ON_OPEN, data);
                    }
                    player.getData(MIAttachment.MI_TURNOVER).sync(player);



                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
    public static void handleClient(final MIOnOpen data, final IPayloadContext context) {
        context.enqueueWork(() -> {
            context.player().setData(MIAttachment.MI_ON_OPEN, data);
        });
    }
}
