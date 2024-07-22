
package org.hiedacamellia.mystiasizakaya.functionals.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.cooking.Confirm;
import org.hiedacamellia.mystiasizakaya.functionals.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.util.SelectTarget;

import java.util.HashMap;
import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record CookingRangeUiButton (int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<CookingRangeUiButton> TYPE = new Type<>( ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "cookingrangeui_button"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CookingRangeUiButton> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CookingRangeUiButton message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CookingRangeUiButton(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<CookingRangeUiButton> type() {
		return TYPE;
	}

	public static void handleData(final CookingRangeUiButton message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
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
		MystiasIzakaya.addNetworkMessage(CookingRangeUiButton.TYPE, CookingRangeUiButton.STREAM_CODEC, CookingRangeUiButton::handleData);
	}
}
