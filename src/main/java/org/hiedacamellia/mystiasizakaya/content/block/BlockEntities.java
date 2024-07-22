package org.hiedacamellia.mystiasizakaya.content.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.block.entities.Bank;
import org.hiedacamellia.mystiasizakaya.content.block.entities.CookingRange;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MystiasIzakaya.MODID);
	public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> COOKING_RANGE = register("cooking_range", ModBlocks.COOKING_RANGE, CookingRange::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BANK = register("bank", ModBlocks.BANK, Bank::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COOKING_RANGE.get(), (blockEntity, side) -> ((CookingRange ) blockEntity).getItemHandler());
	}
}
