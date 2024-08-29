package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.blocks.*;

public class MIBlock {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,MystiasIzakaya.MODID);
	public static final RegistryObject<Block> COOKING_RANGE = BLOCKS.register("cooking_range", CookingRange::new);
	public static final RegistryObject<Block> DONATION = BLOCKS.register("donation", Donation::new);

	public static final RegistryObject<Kitchenwares> CUTTING_BOARD = BLOCKS.register("cutting_board", Kitchenwares::new);
	public static final RegistryObject<Kitchenwares> BOILING_POT = BLOCKS.register("boiling_pot", Kitchenwares::new);
	public static final RegistryObject<Kitchenwares> FRYING_PAN = BLOCKS.register("frying_pan", Kitchenwares::new);
	public static final RegistryObject<Kitchenwares> STEAMER = BLOCKS.register("steamer", Kitchenwares::new);
	public static final RegistryObject<Kitchenwares> GRILL = BLOCKS.register("grill", Kitchenwares::new);
}
