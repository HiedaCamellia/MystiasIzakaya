package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.common.block.*;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;

public class MIBlock {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiasIzakaya.MODID);
	public static final DeferredBlock<Block> COOKING_RANGE = BLOCKS.register("cooking_range", (loc)-> new CookingRange(BlockBehaviour.Properties.of()
			.setId(ResourceKey.create(Registries.BLOCK, loc)).mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE)));
	public static final DeferredBlock<Block> DONATION = BLOCKS.register("donation", Donation::new);

	public static final DeferredBlock<Kitchenware> CUTTING_BOARD = BLOCKS.register("cutting_board",(loc)->new Kitchenware(KitchenwareType.CUTTING_BOARD,loc));
	public static final DeferredBlock<Kitchenware> BOILING_POT = BLOCKS.register("boiling_pot", (loc)->new Kitchenware(KitchenwareType.BOILING_POT,loc));
	public static final DeferredBlock<Kitchenware> FRYING_PAN = BLOCKS.register("frying_pan", (loc)->new Kitchenware(KitchenwareType.FRYING_PAN,loc));
	public static final DeferredBlock<Kitchenware> STEAMER = BLOCKS.register("steamer", (loc)->new Kitchenware(KitchenwareType.STEAMER,loc));
	public static final DeferredBlock<Kitchenware> GRILL = BLOCKS.register("grill", (loc)->new Kitchenware(KitchenwareType.GRILL,loc));

	public static final DeferredBlock<Block> TELEPHONE = BLOCKS.register("telephone", Telephone::new);
	public static final DeferredBlock<Block> TABLE = BLOCKS.register("table", TableBlock::new);
}
