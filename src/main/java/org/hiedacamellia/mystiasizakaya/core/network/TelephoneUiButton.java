
package org.hiedacamellia.mystiasizakaya.core.network;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.Config;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITeleColddown;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.List;


public record TelephoneUiButton(List<ItemStack> out, BlockPos pos) implements CustomPacketPayload {

	public static final Type<TelephoneUiButton> TYPE = new Type<>( ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "telephone_ui_button"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TelephoneUiButton> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.fromCodec(Codec.list(ItemStack.CODEC)), TelephoneUiButton::out,
			BlockPos.STREAM_CODEC, TelephoneUiButton::pos,
			TelephoneUiButton::new
	);
	@Override
	public Type<TelephoneUiButton> type() {
		return TYPE;
	}

	public static void handleData(final TelephoneUiButton message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				handleButtonAction(context.player(), message.pos(), message.out());
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, BlockPos pos,List<ItemStack> out) {
		Level level = entity.level();
		int cost_all=0;
		for(ItemStack itemStack:out){
			cost_all += itemStack.getCount()*itemStack.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost();
		}
//		Debug.send("cost_all"+cost_all);
//		Debug.send(out.toString());

		int balance = entity.getData(MIAttachment.MI_BALANCE).balance();
		if(balance<cost_all){
			entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.fail").withStyle(ChatFormatting.RED));
        }else {
			MITurnover turnover = entity.getData(MIAttachment.MI_TURNOVER);
			turnover = turnover.addTurnover("to_telephone", (double) -cost_all);
			turnover =turnover.deleteOverStack();
			entity.setData(MIAttachment.MI_BALANCE,new MIBalance(balance-cost_all));
			entity.setData(MIAttachment.MI_TURNOVER,turnover);
			for(ItemStack itemStack:out){
				ItemHandlerHelper.giveItemToPlayer(entity, itemStack);
			}
			entity.sendSystemMessage(Component.translatable("message.mystiasizakaya.checkout.success").withStyle(ChatFormatting.GREEN));

			entity.setData(MIAttachment.MI_TELE_COLDDOWN,new MITeleColddown(Config.TELE_COOLDOWN.get()));

		}
		if(entity instanceof ServerPlayer player) {
			PacketDistributor.sendToPlayer(player, player.getData(MIAttachment.MI_BALANCE));
			PacketDistributor.sendToPlayer(player, player.getData(MIAttachment.MI_TURNOVER));
		}
	}
}
