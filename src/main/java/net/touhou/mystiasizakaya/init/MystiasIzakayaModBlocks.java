
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.touhou.mystiasizakaya.init;

import net.touhou.mystiasizakaya.block.CookingRangeBlock;
import net.touhou.mystiasizakaya.block.BankBlock;
import net.touhou.mystiasizakaya.MystiasIzakayaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class MystiasIzakayaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MystiasIzakayaMod.MODID);
	public static final RegistryObject<Block> COOKING_RANGE = REGISTRY.register("cooking_range", () -> new CookingRangeBlock());
	public static final RegistryObject<Block> BANK = REGISTRY.register("bank", () -> new BankBlock());
}
