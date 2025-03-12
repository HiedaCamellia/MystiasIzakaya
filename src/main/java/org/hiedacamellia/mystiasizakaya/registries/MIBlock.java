package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.*;

public class MIBlock {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiasIzakaya.MODID);
	public static final DeferredBlock<Block> COOKING_RANGE = BLOCKS.register("cooking_range", ()-> new CookingRange(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE)));
	public static final DeferredBlock<Block> DONATION = BLOCKS.register("donation", Donation::new);

	public static final DeferredBlock<Kitchenwares> CUTTING_BOARD = BLOCKS.register("cutting_board",()->new Kitchenwares());
	public static final DeferredBlock<Kitchenwares> BOILING_POT = BLOCKS.register("boiling_pot", ()->new Kitchenwares());
	public static final DeferredBlock<Kitchenwares> FRYING_PAN = BLOCKS.register("frying_pan", ()->new Kitchenwares());
	public static final DeferredBlock<Kitchenwares> STEAMER = BLOCKS.register("steamer", ()->new Kitchenwares());
	public static final DeferredBlock<Kitchenwares> GRILL = BLOCKS.register("grill", ()->new Kitchenwares());

	public static final DeferredBlock<Block> TELEPHONE = BLOCKS.register("telephone", Telephone::new);
	public static final DeferredBlock<Block> TABLE = BLOCKS.register("table", TableBlock::new);
}
