
package org.hiedacamellia.mystiasizakaya;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Tuple;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.content.block.BlockEntities;
import org.hiedacamellia.mystiasizakaya.content.block.ModBlocks;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.content.item.ModTab;
import org.hiedacamellia.mystiasizakaya.content.trades.Professions;
import org.hiedacamellia.mystiasizakaya.functionals.Menus;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;
import org.hiedacamellia.mystiasizakaya.integration.jei.RecipeTypes;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("mystias_izakaya")
public class MystiasIzakaya {
	public static final Logger LOGGER = LogManager.getLogger(MystiasIzakaya.class);
	public static final String MODID = "mystias_izakaya";

	public MystiasIzakaya(IEventBus modEventBus, ModContainer modContainer)
	{
		NeoForge.EVENT_BUS.register(this);

		ModBlocks.BLOCKS.register(modEventBus);
		BlockEntities.REGISTRY.register(modEventBus);
		ItemRegistery.REGISTRY.register(modEventBus);
		ModTab.REGISTRY.register(modEventBus);
		Professions.PROFESSIONS.register(modEventBus);
		Menus.REGISTRY.register(modEventBus);
		RecipeTypes.SERIALIZERS.register(modEventBus);
		DataComponentsReg.REGISTRAR.register(modEventBus);
		Variables.ATTACHMENT_TYPES.register(modEventBus);
	}

	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
