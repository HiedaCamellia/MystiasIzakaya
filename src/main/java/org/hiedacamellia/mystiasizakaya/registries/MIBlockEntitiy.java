package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.client.blockentityrender.ProcessRender;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.*;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MIBlockEntitiy {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MystiasIzakaya.MODID);
	public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> COOKING_RANGE = register("cooking_range", MIBlock.COOKING_RANGE, CookingRange::new);

	public static final Supplier<BlockEntityType<CuttingBoard>> CUTTING_BOARD = REGISTRY.register("cutting_board", () -> BlockEntityType.Builder.of(CuttingBoard::new, MIBlock.CUTTING_BOARD.get()).build(null));
	public static final Supplier<BlockEntityType<BoilingPot>> BOILING_POT = REGISTRY.register("boiling_pot", () -> BlockEntityType.Builder.of(BoilingPot::new, MIBlock.BOILING_POT.get()).build(null));
	public static final Supplier<BlockEntityType<FryingPan>> FRYING_PAN = REGISTRY.register("frying_pan", () -> BlockEntityType.Builder.of(FryingPan::new, MIBlock.FRYING_PAN.get()).build(null));
	public static final Supplier<BlockEntityType<Steamer>> STEAMER = REGISTRY.register("steamer", () -> BlockEntityType.Builder.of(Steamer::new, MIBlock.STEAMER.get()).build(null));
	public static final Supplier<BlockEntityType<Grill>> GRILL = REGISTRY.register("grill", () -> BlockEntityType.Builder.of(Grill::new, MIBlock.GRILL.get()).build(null));


	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block,? extends Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COOKING_RANGE.get(), (blockEntity, side) -> ((CookingRange ) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CUTTING_BOARD.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOILING_POT.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FRYING_PAN.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STEAMER.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRILL.get(), (blockEntity, side) -> blockEntity.getItemHandler());
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(GRILL.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(BOILING_POT.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(CUTTING_BOARD.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(FRYING_PAN.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(STEAMER.get(), ProcessRender::new);
	}
}
