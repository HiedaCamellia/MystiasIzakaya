
package net.touhou.mystiasizakaya.functionals.network;

import net.touhou.mystiasizakaya.MystiasIzakaya;
import net.touhou.mystiasizakaya.functionals.inventory.CookingRangeUiMenu;
import net.touhou.mystiasizakaya.content.cooking.Confirm;
import net.touhou.mystiasizakaya.util.SelectTarget;

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

			Confirm.execute(world, x, y, z);
		}
		if (buttonID == 1) {
			SelectTarget.set(world, x, y, z, 7);
		}
		if (buttonID == 2) {

			SelectTarget.set(world, x, y, z, 8);
		}
		if (buttonID == 3) {

			SelectTarget.set(world, x, y, z, 9);
		}
		if (buttonID == 4) {

			SelectTarget.set(world, x, y, z, 10);
		}
		if (buttonID == 5) {

			SelectTarget.set(world, x, y, z, 11);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MystiasIzakaya.addNetworkMessage(CookingRangeUiButton.class, CookingRangeUiButton::buffer,
				CookingRangeUiButton::new, CookingRangeUiButton::handler);
	}
}
