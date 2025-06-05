package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;


public record DonationTakeOutS2SMessage(int count) implements CustomPacketPayload {

    public static final Type<DonationTakeOutS2SMessage> TYPE = new Type<>(MystiasIzakaya.rl( "donation_takeout_s2s"));
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
                if(MIBalanceUtil.getBalance(player) >= count && count > 0) {
                    boolean donation = MIBalanceUtil.donation(player, -count);
                    if (donation) {
                        j = count / 10;
                        int i = count - j * 10;
                        MIPlayerUtil.giveItemToPlayer(MIItem.EN_10, j, player);
                        MIPlayerUtil.giveItemToPlayer(MIItem.EN_1, i, player);
                    }
                }

            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
            return null;
        });

    }


}
