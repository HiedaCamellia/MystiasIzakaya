
package org.hiedacamellia.mystiasizakaya.core.network;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.content.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Confirm;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.util.SelectTarget;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.HashMap;
import java.util.function.Supplier;

public class CookingRangeUiButton implements C2SPacket {
	private final int buttonID, x, y, z;


	public CookingRangeUiButton(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public CookingRangeUiButton(int buttonID, BlockPos pos) {
		this.buttonID = buttonID;
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}

	public static CookingRangeUiButton decode(FriendlyByteBuf buffer) {
		return new CookingRangeUiButton(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void handleButtonAction(Player entity, int buttonID, BlockPos pos) {
		Level world = entity.level();
		Debug.getLogger().debug("Button{}",buttonID);

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
			if (!world.isClientSide()) {
                BlockEntity _blockEntity = world.getBlockEntity(pos);
				BlockState _bs = world.getBlockState(pos);
				int page =0;
				if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
					page = cookingRangeEntity.page;
				if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
					page = kitchenwaresEntity.page;

				int targets = 0;
				if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
					targets = cookingRangeEntity.targets;
				if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
					targets = kitchenwaresEntity.targets;

				if (_blockEntity != null && page + 5 < targets)
				{
					if(_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
						cookingRangeEntity.page = page + 1;
					if(_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
						kitchenwaresEntity.page = page + 1;
				}
				world.sendBlockUpdated(pos, _bs, _bs, 3);
			}
		}
		if (buttonID == 7) {
			if (!world.isClientSide()) {
				BlockPos _bp = pos;
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				int page =0;
				if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
					page = cookingRangeEntity.page;
				if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
					page = kitchenwaresEntity.page;
				if (_blockEntity != null && page > 0) {
					if(_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
						cookingRangeEntity.page = page - 1;
					if(_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
						kitchenwaresEntity.page = page - 1;
				}
				world.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	public static void registerMessage() {
		MINetWork.addC2SNetworkMessage(CookingRangeUiButton.class, CookingRangeUiButton::decode);
	}

	@Override
	public void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl listener, PacketSender responseSender, SimpleChannel channel) {

		Player entity = player;
		int buttonID = this.buttonID;
		int x = this.x;
		int y = this.y;
		int z = this.z;
		handleButtonAction(entity, buttonID, Pos.get(x, y, z));
	}

	@Override
	public void encode(FriendlyByteBuf buffer) {

		buffer.writeInt(buttonID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}
}
