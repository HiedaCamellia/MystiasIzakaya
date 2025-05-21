package org.hiedacamellia.mystiasizakaya.core.codec.record;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
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

import java.util.ArrayList;
import java.util.List;

public record MIMenu(List<String> cuisines, List<String> beverages, List<BlockPos> blockPos)implements CustomPacketPayload  {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, this);
    }

    public static final Type<MIMenu> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "mi_menu"));

    public static final StreamCodec<ByteBuf, MIMenu> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MIMenu::cuisines,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)),
            MIMenu::beverages,
            ByteBufCodecs.fromCodec(Codec.list(BlockPos.CODEC)),
            MIMenu::blockPos,
            MIMenu::new
    );

    public static MIMenu init(){
        List<BlockPos> tables = new ArrayList<>();
        List<String> cuisineList = new ArrayList<>();
        List<String> beverageList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tables.add(new BlockPos(-1, -1, -1));
            cuisineList.add("minecraft:air");
            beverageList.add("minecraft:air");
        }
        return new MIMenu(cuisineList,beverageList,tables);
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final MIMenu data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(MIAttachment.MI_MENU, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.mystiasizakaya.failed", e.getMessage()));
                    return null;
                });
    }
}
