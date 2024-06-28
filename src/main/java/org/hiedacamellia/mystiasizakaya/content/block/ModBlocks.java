package org.hiedacamellia.mystiasizakaya.content.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.block.blocks.Bank;
import org.hiedacamellia.mystiasizakaya.content.block.blocks.CookingRange;

public class ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MystiasIzakaya.MODID);
	public static final RegistryObject<Block> COOKING_RANGE = REGISTRY.register("cooking_range", CookingRange::new);
	public static final RegistryObject<Block> BANK = REGISTRY.register("bank", Bank::new);
}
