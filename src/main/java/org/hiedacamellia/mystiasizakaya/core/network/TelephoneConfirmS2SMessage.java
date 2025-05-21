
package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.util.MessageUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;

import java.util.List;


public record TelephoneConfirmS2SMessage(List<ItemStack> out, BlockPos pos, int cost) implements CustomPacketPayload {

    public static final Type<TelephoneConfirmS2SMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "telephone_ui_button"));
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
            int tick = player.getData(MIAttachment.MI_TELE_COLDDOWN).tick();
            if(tick > 0){

                MessageUtil.send(Component.translatable("message.mystiasizakaya.telephone.colddown", tick / 20).withStyle(ChatFormatting.RED),player);
                return;
            }
            List<ItemStack> out = message.out();
            int cost = message.cost();

            int balance = BalanceUtil.getBalance(player);
            if (balance < cost) {
                MessageUtil.send(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED),player);
            } else {

                BalanceUtil.telephone(player, -cost);

                for (ItemStack itemStack : out) {
                    ItemHandlerHelper.giveItemToPlayer(player, itemStack);
                }
                MessageUtil.send(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN),player);

                player.setData(MIAttachment.MI_TELE_COLDDOWN, new MITeleColddown(MICommonConfig.TELE_COOLDOWN.get()));

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }

}
