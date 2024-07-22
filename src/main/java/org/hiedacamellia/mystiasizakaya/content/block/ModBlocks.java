package org.hiedacamellia.mystiasizakaya.content.block;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.block.blocks.Bank;
import org.hiedacamellia.mystiasizakaya.content.block.blocks.CookingRange;

public class ModBlocks {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiasIzakaya.MODID);
	public static final DeferredBlock<Block> COOKING_RANGE = BLOCKS.register("cooking_range", CookingRange::new);
	public static final DeferredBlock<Block> BANK = BLOCKS.register("bank", Bank::new);
}
