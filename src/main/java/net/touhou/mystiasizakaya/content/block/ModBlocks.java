
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.touhou.mystiasizakaya.content.block;

import net.touhou.mystiasizakaya.MystiasIzakaya;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.touhou.mystiasizakaya.content.block.blocks.Bank;
import net.touhou.mystiasizakaya.content.block.blocks.CookingRange;

public class ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MystiasIzakaya.MODID);
	public static final RegistryObject<Block> COOKING_RANGE = REGISTRY.register("cooking_range", CookingRange::new);
	public static final RegistryObject<Block> BANK = REGISTRY.register("bank", Bank::new);
}
