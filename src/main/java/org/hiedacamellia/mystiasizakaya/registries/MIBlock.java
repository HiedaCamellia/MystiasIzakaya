package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.blocks.*;

public class MIBlock {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiasIzakaya.MODID);
	public static final DeferredBlock<Block> COOKING_RANGE = BLOCKS.register("cooking_range", ()-> new CookingRange("cooking_range"));
	public static final DeferredBlock<Block> DONATION = BLOCKS.register("donation", Donation::new);

	public static final DeferredBlock<Kitchenwares> CUTTING_BOARD = BLOCKS.register("cutting_board", Kitchenwares::new);
	public static final DeferredBlock<Kitchenwares> BOILING_POT = BLOCKS.register("boiling_pot", Kitchenwares::new);
	public static final DeferredBlock<Kitchenwares> FRYING_PAN = BLOCKS.register("frying_pan", Kitchenwares::new);
	public static final DeferredBlock<Kitchenwares> STEAMER = BLOCKS.register("steamer", Kitchenwares::new);
	public static final DeferredBlock<Kitchenwares> GRILL = BLOCKS.register("grill", Kitchenwares::new);

	public static final DeferredBlock<Block> TELEPHONE = BLOCKS.register("telephone", Telephone::new);
}
