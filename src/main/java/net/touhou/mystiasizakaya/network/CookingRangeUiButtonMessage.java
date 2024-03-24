
package net.touhou.mystiasizakaya.network;

import net.touhou.mystiasizakaya.world.inventory.CookingRangeUiMenu;
import net.touhou.mystiasizakaya.procedures.Select5Procedure;
import net.touhou.mystiasizakaya.procedures.Select4Procedure;
import net.touhou.mystiasizakaya.procedures.Select3Procedure;
import net.touhou.mystiasizakaya.procedures.Select2Procedure;
import net.touhou.mystiasizakaya.procedures.Select1Procedure;
import net.touhou.mystiasizakaya.procedures.ConfirmProcedure;
import net.touhou.mystiasizakaya.MystiasIzakayaMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CookingRangeUiButtonMessage {
	private final int buttonID, x, y, z;

	public CookingRangeUiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CookingRangeUiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CookingRangeUiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CookingRangeUiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CookingRangeUiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConfirmProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			Select1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Select2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			Select3Procedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			Select4Procedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			Select5Procedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MystiasIzakayaMod.addNetworkMessage(CookingRangeUiButtonMessage.class, CookingRangeUiButtonMessage::buffer, CookingRangeUiButtonMessage::new, CookingRangeUiButtonMessage::handler);
	}
}
