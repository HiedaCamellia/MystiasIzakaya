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
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;


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

                boolean donation = BalanceUtil.donation(player, -count);
                if (donation && count > 0 && BalanceUtil.getBalance(player) >= count) {
                    j = count / 10;
                    count = count - j * 10;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10.get());
                    _setstack.setCount(j);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    ItemStack setstack = new ItemStack(MIItem.EN_1.get());
                    setstack.setCount(count);
                    ItemHandlerHelper.giveItemToPlayer(player, setstack);
                }

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }


}
