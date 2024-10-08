
package org.hiedacamellia.mystiasizakaya.core.network;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.util.ItemUtil;

import java.util.List;
import java.util.Map;


public class TelephoneUiButton implements C2SPacket {

    private final Map<String, Integer> out;
    private final BlockPos pos;
    private final int cost;

    public TelephoneUiButton(Map<String, Integer> out, BlockPos pos, int cost) {
        this.out = out;
        this.pos = pos;
        this.cost = cost;
    }

    public static TelephoneUiButton decode(FriendlyByteBuf buffer) {
        return new TelephoneUiButton(buffer.readMap(FriendlyByteBuf::readUtf, FriendlyByteBuf::readInt), buffer.readBlockPos(), buffer.readInt());
    }

    public static void handleButtonAction(Player entity, BlockPos pos, List<ItemStack> out, int cost) {
        int cost_all = 0;
        for (ItemStack itemStack : out) {
            cost_all += itemStack.getCount() * itemStack.getOrCreateTag().getInt("cost");
        }
        if ((double) cost / cost_all < 0.6) {
            if (entity instanceof ServerPlayer player)
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.cheat").withStyle(ChatFormatting.RED));
            return;
        }

        int balance = (int) MIPlayerEvent.getBalance(entity);
        if (balance < cost) {
            if (entity instanceof ServerPlayer player)
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED));
        } else {
            MIPlayerEvent.addTurnover(entity, "to_telephone", -cost);
            MIPlayerEvent.deleteOverTurnover(entity);
            MIPlayerEvent.setBalance(entity, balance - cost);
            for (ItemStack itemStack : out) {
                entity.addItem(itemStack);
            }
            if (entity instanceof ServerPlayer player)
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN));

            MIPlayerEvent.setTelecolddown(entity, CommonConfig.TELE_COOLDOWN.get());

        }

    }

    public static void registerMessage() {
        MINetWork.addC2SNetworkMessage(TelephoneUiButton.class, TelephoneUiButton::decode);
    }

    @Override
    public void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl listener, PacketSender responseSender, SimpleChannel channel) {
            Player entity = player;
            List<ItemStack> out = ItemUtil.mapGetStacks(this.out);
            BlockPos pos = this.pos;
            int cost = this.cost;
            handleButtonAction(entity, pos, out, cost);
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeMap(out, FriendlyByteBuf::writeUtf, FriendlyByteBuf::writeInt);
        buf.writeBlockPos(pos);
        buf.writeInt(cost);
    }
}
