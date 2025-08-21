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
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.common.blockentity.KitchenwareEntity;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;

import java.util.function.Supplier;

@EventBusSubscriber
public class MIBlockEntitiy {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MystiasIzakaya.MODID);

	public static final Supplier<BlockEntityType<CookingRangeEntity>> COOKING_RANGE = REGISTRY.register("cooking_range", () -> new BlockEntityType<>(CookingRangeEntity::new, MIBlock.COOKING_RANGE.get()));
	public static final Supplier<BlockEntityType<TableEntity>> TABLE = REGISTRY.register("table", () -> new BlockEntityType<>(TableEntity::new, MIBlock.TABLE.get()));

	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> CUTTING_BOARD = REGISTRY.register("cutting_board", () -> new BlockEntityType<>(KitchenwareEntity.CuttingBoard::new, MIBlock.CUTTING_BOARD.get()));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> BOILING_POT = REGISTRY.register("boiling_pot", () -> new BlockEntityType<>(KitchenwareEntity.BoilingPot::new, MIBlock.BOILING_POT.get()));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> FRYING_PAN = REGISTRY.register("frying_pan", () -> new BlockEntityType<>(KitchenwareEntity.FryingPan::new, MIBlock.FRYING_PAN.get()));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> STEAMER = REGISTRY.register("steamer", () -> new BlockEntityType<>(KitchenwareEntity.Steamer::new, MIBlock.STEAMER.get()));
	public static final Supplier<BlockEntityType<? extends KitchenwareEntity>> GRILL = REGISTRY.register("grill", () -> new BlockEntityType<>(KitchenwareEntity.Grill::new, MIBlock.GRILL.get()));


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
