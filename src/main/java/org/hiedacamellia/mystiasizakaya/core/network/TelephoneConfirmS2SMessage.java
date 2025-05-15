
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
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
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
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.telephone.colddown", tick / 20).withStyle(ChatFormatting.RED));
                return;
            }
            List<ItemStack> out = message.out();
            int cost = message.cost();
            int cost_all = 0;
            for (ItemStack itemStack : out) {
                cost_all += itemStack.getCount() * itemStack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost();
            }
            if ((double) cost / cost_all < 0.6) {
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.cheat").withStyle(ChatFormatting.RED));
                return;
            }

            int balance = BalanceUtil.getBalance(player);
            if (balance < cost) {
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED));
            } else {

                BalanceUtil.telephone(player, -cost);

                for (ItemStack itemStack : out) {
                    ItemHandlerHelper.giveItemToPlayer(player, itemStack);
                }
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN));

                player.setData(MIAttachment.MI_TELE_COLDDOWN, new MITeleColddown(MICommonConfig.TELE_COOLDOWN.get()));

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }

}
