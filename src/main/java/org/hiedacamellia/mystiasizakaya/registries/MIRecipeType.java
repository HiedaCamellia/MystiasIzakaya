package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.integration.jei.recipes.*;

public class MIRecipeType {

	public static void register() {
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MystiasIzakaya.MODID, "boiling_pot_type"), BoilingPotTypeRecipe.Serializer.INSTANCE);
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MystiasIzakaya.MODID, "cutting_board_type"), CuttingBoardTypeRecipe.Serializer.INSTANCE);
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MystiasIzakaya.MODID, "frying_pan_type"), FryingPanTypeRecipe.Serializer.INSTANCE);
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MystiasIzakaya.MODID, "grill_type"), GrillTypeRecipe.Serializer.INSTANCE);
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MystiasIzakaya.MODID, "streamer_type"), StreamerTypeRecipe.Serializer.INSTANCE);

	}
}
