
package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.content.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Confirm;
import org.hiedacamellia.mystiasizakaya.util.SelectTarget;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.HashMap;
import java.util.function.Supplier;

public class CookingRangeUiButton {
	private final int buttonID, x, y, z;

	public CookingRangeUiButton(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

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

	public static void buffer(CookingRangeUiButton message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CookingRangeUiButton message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, Pos.get(x, y, z));
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, BlockPos pos) {
		Level world = entity.level();
		HashMap guistate = CookingRangeUiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(pos))
			return;
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

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MINetWork.addNetworkMessage(CookingRangeUiButton.class, CookingRangeUiButton::buffer,
				CookingRangeUiButton::new, CookingRangeUiButton::handler);
	}
}
