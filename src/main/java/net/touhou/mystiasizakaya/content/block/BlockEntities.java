package net.touhou.mystiasizakaya.content.block;

import net.touhou.mystiasizakaya.content.block.entities.CookingRange;
import net.touhou.mystiasizakaya.content.block.entities.Bank;
import net.touhou.mystiasizakaya.MystiasIzakaya;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class BlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MystiasIzakaya.MODID);
	public static final RegistryObject<BlockEntityType<?>> COOKING_RANGE = register("cooking_range", ModBlocks.COOKING_RANGE, CookingRange::new);
	public static final RegistryObject<BlockEntityType<?>> BANK = register("bank", ModBlocks.BANK, Bank::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
