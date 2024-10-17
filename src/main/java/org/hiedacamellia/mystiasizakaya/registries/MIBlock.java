package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.blocks.*;

public class MIBlock {

	public static final CookingRange COOKING_RANGE = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "cooking_range"), new CookingRange());
	public static final Block DONATION = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "donation"), new Donation());

	public static final Kitchenwares CUTTING_BOARD = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "cutting_board"), new Kitchenwares());
	public static final Kitchenwares BOILING_POT = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "boiling_pot"), new Kitchenwares());
	public static final Kitchenwares FRYING_PAN = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "frying_pan"), new Kitchenwares());
	public static final Kitchenwares STEAMER = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "steamer"), new Kitchenwares());
	public static final Kitchenwares GRILL = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "grill"), new Kitchenwares());

	public static final Block TELEPHONE = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "telephone"), new Telephone());
	public static final Block TABLE = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MystiasIzakaya.MODID, "table"), new TableBlock());

	public static void register(){

	}
}
