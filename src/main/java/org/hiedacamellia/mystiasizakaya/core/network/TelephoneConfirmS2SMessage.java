
package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIMessageUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

import java.util.List;


public record TelephoneConfirmS2SMessage(List<ItemStack> out, BlockPos pos, int cost) implements CustomPacketPayload {

    public static final Type<TelephoneConfirmS2SMessage> TYPE = new Type<>(MystiasIzakaya.rl( "telephone_ui_button"));
    public static final StreamCodec<RegistryFriendlyByteBuf, TelephoneConfirmS2SMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(ItemStack.CODEC)), TelephoneConfirmS2SMessage::out,
            BlockPos.STREAM_CODEC, TelephoneConfirmS2SMessage::pos,
            ByteBufCodecs.INT, TelephoneConfirmS2SMessage::cost,
            TelephoneConfirmS2SMessage::new
    );

    @Override
    public Type<TelephoneConfirmS2SMessage> type() {
        return TYPE;
    }

    public static void handleServer(final TelephoneConfirmS2SMessage message, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            int tick = MIPlayerUtil.getTeleCooldown(player);
            if(tick > 0){

                MIMessageUtil.send(Component.translatable("message.mystiasizakaya.telephone.colddown", tick / 20).withStyle(ChatFormatting.RED),player);
                return;
            }
            List<ItemStack> out = message.out();
            int cost = message.cost();

            int balance = MIBalanceUtil.getBalance(player);
            if (balance < cost) {
                MIMessageUtil.send(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED),player);
            } else {

                MIBalanceUtil.telephone(player, -cost);

                for (ItemStack itemStack : out) {
                    ItemHandlerHelper.giveItemToPlayer(player, itemStack);
                }
                MIMessageUtil.send(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN),player);

                MIPlayerUtil.setTeleCooldown(player, MICommonConfig.TELE_COOLDOWN.get());
                MIPlayerUtil.syncTeleCooldown(player);

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }

}
