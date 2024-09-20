
package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.network.NetworkEvent;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.util.ItemUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TelephoneUiButton {

    private final Map<String, Integer> out;
    private final BlockPos pos;
    private final int cost;

    public TelephoneUiButton(FriendlyByteBuf buffer) {
        this.out = buffer.readMap(FriendlyByteBuf::readUtf, FriendlyByteBuf::readInt);
        this.pos = buffer.readBlockPos();
        this.cost = buffer.readInt();
    }

    public TelephoneUiButton(Map<String, Integer> out, BlockPos pos, int cost) {
        this.out = out;
        this.pos = pos;
        this.cost = cost;
    }

    public static void buffer(TelephoneUiButton message, FriendlyByteBuf buffer) {
        buffer.writeMap(message.out, FriendlyByteBuf::writeUtf, FriendlyByteBuf::writeInt);
        buffer.writeBlockPos(message.pos);
        buffer.writeInt(message.cost);
    }

    public static void handler(TelephoneUiButton message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            List<ItemStack> out = ItemUtil.mapGetStacks(message.out);
            BlockPos pos = message.pos;
            int cost = message.cost;
            handleButtonAction(entity, pos, out, cost);
        });
        context.setPacketHandled(true);
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
                ItemHandlerHelper.giveItemToPlayer(entity, itemStack);
            }
            if (entity instanceof ServerPlayer player)
                player.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN));

            MIPlayerEvent.setTelecolddown(entity, CommonConfig.TELE_COOLDOWN.get());

        }

    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        MINetWork.addNetworkMessage(TelephoneUiButton.class, TelephoneUiButton::buffer, TelephoneUiButton::new, TelephoneUiButton::handler);
    }
}
