
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

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
            Player entity = context.player();
            int tick = entity.getData(MIAttachment.MI_TELE_COLDDOWN).tick();
            if(tick > 0){
                entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.telephone.colddown", tick / 20).withStyle(ChatFormatting.RED));
                return;
            }
            List<ItemStack> out = message.out();
            int cost = message.cost();
            int cost_all = 0;
            for (ItemStack itemStack : out) {
                cost_all += itemStack.getCount() * itemStack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost();
            }
            if ((double) cost / cost_all < 0.6) {
                entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.cheat").withStyle(ChatFormatting.RED));
                return;
            }

            int balance = entity.getData(MIAttachment.MI_BALANCE).balance();
            if (balance < cost) {
                entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED));
            } else {
                MITurnover turnover = entity.getData(MIAttachment.MI_TURNOVER);
                turnover = turnover.addTurnover("to_telephone", (double) -cost);
                turnover = turnover.deleteOverStack();
                entity.setData(MIAttachment.MI_BALANCE, new MIBalance(balance - cost));
                entity.setData(MIAttachment.MI_TURNOVER, turnover);
                for (ItemStack itemStack : out) {
                    ItemHandlerHelper.giveItemToPlayer(entity, itemStack);
                }
                entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN));

                entity.setData(MIAttachment.MI_TELE_COLDDOWN, new MITeleColddown(MICommonConfig.TELE_COOLDOWN.get()));

            }
            if (entity instanceof ServerPlayer player) {
                PacketDistributor.sendToPlayer(player, player.getData(MIAttachment.MI_BALANCE));
                PacketDistributor.sendToPlayer(player, player.getData(MIAttachment.MI_TURNOVER));
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }

}
