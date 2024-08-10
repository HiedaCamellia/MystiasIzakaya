package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.blocks.Donation;
import org.hiedacamellia.mystiasizakaya.content.common.block.blocks.CookingRange;

public class MIBlock {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiasIzakaya.MODID);
	public static final DeferredBlock<Block> COOKING_RANGE = BLOCKS.register("cooking_range", CookingRange::new);
	public static final DeferredBlock<Block> DONATION = BLOCKS.register("donation", Donation::new);
}
