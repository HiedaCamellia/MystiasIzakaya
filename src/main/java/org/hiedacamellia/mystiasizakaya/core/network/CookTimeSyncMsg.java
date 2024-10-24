package org.hiedacamellia.mystiasizakaya.core.network;

import me.pepperbell.simplenetworking.S2CPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;

public class CookTimeSyncMsg implements S2CPacket {

    private final int cookTime;
    private final int total;
    private final BlockPos pos;

    public CookTimeSyncMsg(int cookTime, int total, BlockPos pos) {
        this.cookTime = cookTime;
        this.total = total;
        this.pos = pos;
    }

    @Override
    public void handle(Minecraft minecraft, ClientPacketListener clientPacketListener, PacketSender packetSender, SimpleChannel simpleChannel) {
        BlockEntity blockEntity = minecraft.level.getBlockEntity(pos);
        if(blockEntity instanceof CookingRangeEntity cookingRangeEntity){
            cookingRangeEntity.timeLeft = cookTime;
            cookingRangeEntity.totalTime = total;
        }
        if(blockEntity instanceof KitchenwaresEntity cookingRangeEntity){
            cookingRangeEntity.timeLeft = cookTime;
            cookingRangeEntity.totalTime = total;
        }
    }

    @Override
    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(cookTime);
        friendlyByteBuf.writeInt(total);
        friendlyByteBuf.writeBlockPos(pos);
    }

    public static void registerMessage() {
        MINetWork.addS2CNetworkMessage(CookTimeSyncMsg.class, CookTimeSyncMsg::decode);
    }

    private static CookTimeSyncMsg decode(FriendlyByteBuf friendlyByteBuf) {
        return new CookTimeSyncMsg(friendlyByteBuf.readInt(), friendlyByteBuf.readInt(), friendlyByteBuf.readBlockPos());
    }
}
