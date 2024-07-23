package org.hiedacamellia.mystiasizakaya.functionals.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class Variables {

	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MystiasIzakaya.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MystiasIzakaya.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		//MystiasIzakaya.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar("1");
		registrar.playBidirectional(
				PlayerVariablesSyncMessage.TYPE,
				PlayerVariablesSyncMessage.STREAM_CODEC,
				new DirectionalPayloadHandler<>(
						PlayerVariablesSyncMessage::handleData,
						PlayerVariablesSyncMessage::handleData
				)
		);
		final PayloadRegistrar registrarsync = event.registrar("2");
		registrarsync.playBidirectional(
				SavedDataSyncMessage.TYPE,
				SavedDataSyncMessage.STREAM_CODEC,
				new DirectionalPayloadHandler<>(
						SavedDataSyncMessage::handleData,
						SavedDataSyncMessage::handleData
				)
		);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.orders= original.orders;
			clone.ordersbeverages= original.ordersbeverages;
			clone.showbalance= original.showbalance;
			clone.balance= original.balance;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public int balance = 0;
		public boolean showbalance = true;
		public List<String> orders = Arrays.asList("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
		public List<String> ordersbeverages = Arrays.asList("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");


		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putInt("balance", balance);
			nbt.putBoolean("showbalance", showbalance);
			String orders_string = String.join(",", orders);
			String ordersbeverages_string = String.join(",", ordersbeverages);
			nbt.putString("orders", orders_string);
			nbt.putString("ordersbeverages", ordersbeverages_string);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			balance = nbt.getInt("balance");
			showbalance = nbt.getBoolean("showbalance");
			String orders_string = nbt.getString("orders");
			String ordersbeverages_string = nbt.getString("ordersbeverages");
			orders = new ArrayList<>(List.of(orders_string.split(",")));
			ordersbeverages = new ArrayList<>(List.of(ordersbeverages_string.split(",")));
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this.balance, this.showbalance, String.join(",", this.orders), String.join(",", this.ordersbeverages)));
		}
	}

	public record PlayerVariablesSyncMessage(int balance,boolean showbalance,String orders,String ordersbeverages) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "player_variables_sync"));
		public static final StreamCodec<ByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((ByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeInt(message.balance);
			buffer.writeBoolean(message.showbalance);
			ByteBufCodecs.STRING_UTF8.encode(buffer, message.orders);
			ByteBufCodecs.STRING_UTF8.encode(buffer, message.ordersbeverages);
		}, (ByteBuf buffer) -> {
			int balance = buffer.readInt();
			boolean showbalance = buffer.readBoolean();
			String orders = ByteBufCodecs.STRING_UTF8.decode(buffer);
			String ordersbeverages = ByteBufCodecs.STRING_UTF8.decode(buffer);
			return new PlayerVariablesSyncMessage(balance, showbalance, orders, ordersbeverages);
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND) {
				if (Minecraft.getInstance().player != null) {
					PlayerVariables playerVariables = Minecraft.getInstance().player.getData(PLAYER_VARIABLES);
					playerVariables.balance = message.balance;
					playerVariables.showbalance = message.showbalance;
					playerVariables.orders = new ArrayList<>(List.of(message.orders.split(",")));
					playerVariables.ordersbeverages = new ArrayList<>(List.of(message.ordersbeverages.split(",")));
				}
			}
		}
	}


	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {

			}
		}
	}
}
