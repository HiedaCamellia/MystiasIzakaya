package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.KitchenwareEntity;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.TableEntity;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MIBlockEntitiy {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MystiasIzakaya.MODID);

	public static final Supplier<BlockEntityType<CookingRangeEntity>> COOKING_RANGE = REGISTRY.register("cooking_range", () -> BlockEntityType.Builder.of(CookingRangeEntity::new, MIBlock.COOKING_RANGE.get()).build(null));
	public static final Supplier<BlockEntityType<TableEntity>> TABLE = REGISTRY.register("table", () -> BlockEntityType.Builder.of(TableEntity::new, MIBlock.TABLE.get()).build(null));

	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> CUTTING_BOARD = REGISTRY.register("cutting_board", () -> BlockEntityType.Builder.of(KitchenwareEntity.CuttingBoard::new, MIBlock.CUTTING_BOARD.get()).build(null));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> BOILING_POT = REGISTRY.register("boiling_pot", () -> BlockEntityType.Builder.of(KitchenwareEntity.BoilingPot::new, MIBlock.BOILING_POT.get()).build(null));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> FRYING_PAN = REGISTRY.register("frying_pan", () -> BlockEntityType.Builder.of(KitchenwareEntity.FryingPan::new, MIBlock.FRYING_PAN.get()).build(null));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> STEAMER = REGISTRY.register("steamer", () -> BlockEntityType.Builder.of(KitchenwareEntity.Steamer::new, MIBlock.STEAMER.get()).build(null));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> GRILL = REGISTRY.register("grill", () -> BlockEntityType.Builder.of(KitchenwareEntity.Grill::new, MIBlock.GRILL.get()).build(null));


	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COOKING_RANGE.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TABLE.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CUTTING_BOARD.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOILING_POT.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FRYING_PAN.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STEAMER.get(), (blockEntity, side) -> blockEntity.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRILL.get(), (blockEntity, side) -> blockEntity.getItemHandler());
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
	}
}
