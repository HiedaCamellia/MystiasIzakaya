package org.hiedacamellia.mystiasizakaya.core.network;

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
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;


public record DonationTakeOutS2SMessage(int count) implements CustomPacketPayload {

    public static final Type<DonationTakeOutS2SMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "donation_takeout_s2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, DonationTakeOutS2SMessage> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, DonationTakeOutS2SMessage::count, DonationTakeOutS2SMessage::new);

    @Override
    public Type<DonationTakeOutS2SMessage> type() {
        return TYPE;
    }

    public static void handleServer(final DonationTakeOutS2SMessage message, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player entity = context.player();
            int j;
            int count = message.count();
            if (entity instanceof ServerPlayer player) {
                MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
                miTurnover = miTurnover.addTurnover("to_donation", (double) -count);
                miTurnover = miTurnover.deleteOverStack();
                player.setData(MIAttachment.MI_TURNOVER, miTurnover);
                PacketDistributor.sendToPlayer(player, miTurnover);
                if (count > 0 && player.getData(MIAttachment.MI_BALANCE).balance() >= count) {
                    player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() - count));
                    j = count / 10;
                    count = count - j * 10;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10.get());
                    _setstack.setCount(j);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    ItemStack setstack = new ItemStack(MIItem.EN_1.get());
                    setstack.setCount(count);
                    ItemHandlerHelper.giveItemToPlayer(player, setstack);
                    PacketDistributor.sendToPlayer(player, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
                }

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }


}
