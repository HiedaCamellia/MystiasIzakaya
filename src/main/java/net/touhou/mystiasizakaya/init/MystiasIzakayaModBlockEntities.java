
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.touhou.mystiasizakaya.init;

import net.touhou.mystiasizakaya.block.entity.CookingRangeBlockEntity;
import net.touhou.mystiasizakaya.block.entity.BankBlockEntity;
import net.touhou.mystiasizakaya.MystiasIzakayaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class MystiasIzakayaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MystiasIzakayaMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> COOKING_RANGE = register("cooking_range", MystiasIzakayaModBlocks.COOKING_RANGE, CookingRangeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BANK = register("bank", MystiasIzakayaModBlocks.BANK, BankBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
