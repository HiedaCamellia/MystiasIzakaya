
package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Confirm;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.util.SelectTarget;
import org.hiedacamellia.mystiasizakaya.util.GetValue;

import java.util.HashMap;


public record CookingRangeUiButton (int buttonID, BlockPos pos) implements CustomPacketPayload {

	public static final Type<CookingRangeUiButton> TYPE = new Type<>( ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "cookingrangeui_button"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CookingRangeUiButton> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CookingRangeUiButton message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeBlockPos(message.pos);
	}, (RegistryFriendlyByteBuf buffer) -> new CookingRangeUiButton(buffer.readInt(), buffer.readBlockPos()));
	@Override
	public Type<CookingRangeUiButton> type() {
		return TYPE;
	}

	public static void handleData(final CookingRangeUiButton message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				handleButtonAction(entity, buttonID, message.pos);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, BlockPos pos) {
		Level world = entity.level();
		HashMap guistate = CookingRangeUiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (buttonID == 0) {

			Confirm.execute(world, pos);
		}
		if (buttonID == 1) {
			SelectTarget.set(world, pos, 7);
		}
		if (buttonID == 2) {

			SelectTarget.set(world, pos, 8);
		}
		if (buttonID == 3) {

			SelectTarget.set(world, pos, 9);
		}
		if (buttonID == 4) {

			SelectTarget.set(world, pos, 10);
		}
		if (buttonID == 5) {

			SelectTarget.set(world, pos, 11);
		}
		if (buttonID == 6) {
			Debug.getLogger().debug("Set data");
			if (!world.isClientSide()) {
				BlockPos _bp = pos;
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);

				int page = GetValue.getInt(world, pos, "page");
				int targets = GetValue.getInt(world, pos, "targets");
				if (_blockEntity != null && page + 5 < targets)
					_blockEntity.getPersistentData().putInt("page", page + 1);
				world.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (buttonID == 7) {
			Debug.getLogger().debug("Set data");
			if (!world.isClientSide()) {
				BlockPos _bp = pos;
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				int page = GetValue.getInt(world, pos, "page");
				if (_blockEntity != null && page > 0)
					_blockEntity.getPersistentData().putInt("page", page - 1);
				world.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

}
