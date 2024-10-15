package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;

import java.util.function.Supplier;

//@EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MIRecipeType {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
			DeferredRegister.create(Registries.RECIPE_TYPE, MystiasIzakaya.MODID);

	public static final DeferredHolder<RecipeType<?>,RecipeType<BoilingPotRecipe>> BOILING_POT =
			RECIPE_TYPES.register(
					"boiling_pot_type", () -> RecipeType.<BoilingPotRecipe>simple(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,
							"boiling_pot_type"))
			);
	public static final DeferredHolder<RecipeType<?>,RecipeType<CuttingBoardRecipe>> CUTTING_BOARD =
			RECIPE_TYPES.register(
					"cutting_board_type", () -> RecipeType.<CuttingBoardRecipe>simple(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,
							"cutting_board_type"))
			);
	public static final DeferredHolder<RecipeType<?>,RecipeType<FryingPanRecipe>> FRYING_PAN =
			RECIPE_TYPES.register(
					"frying_pan_type", () -> RecipeType.<FryingPanRecipe>simple(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,
							"frying_pan_type"))
			);
	public static final DeferredHolder<RecipeType<?>,RecipeType<GrillRecipe>> GRILL =
			RECIPE_TYPES.register(
					"grill_type", () -> RecipeType.<GrillRecipe>simple(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,
							"grill_type"))
			);
	public static final DeferredHolder<RecipeType<?>,RecipeType<SteamerRecipe>> STEAMER =
			RECIPE_TYPES.register(
					"streamer_type", () -> RecipeType.<SteamerRecipe>simple(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID,
							"streamer_type"))
			);


	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
			DeferredRegister.create(Registries.RECIPE_SERIALIZER, MystiasIzakaya.MODID);

	public static final Supplier<RecipeSerializer<BoilingPotRecipe>> BOILING_POT_SERIALIZER =
			RECIPE_SERIALIZERS.register("boiling_pot_type", BoilingPotRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<CuttingBoardRecipe>>CUTTING_BOARD_SERIALIZER =
			RECIPE_SERIALIZERS.register("cutting_board_type", CuttingBoardRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<FryingPanRecipe>> FRYING_PAN_SERIALIZER =
			RECIPE_SERIALIZERS.register("frying_pan_type", FryingPanRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<GrillRecipe>> GRILL_SERIALIZER =
			RECIPE_SERIALIZERS.register("grill_type", GrillRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<SteamerRecipe>> STEAMER_SERIALIZER =
			RECIPE_SERIALIZERS.register("streamer_type", SteamerRecipe.Serializer::new);

//
//	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "mystias_izakaya");
//
//	@SubscribeEvent
//	public static void register(FMLConstructModEvent event) {
//		event.enqueueWork(() -> {
//			SERIALIZERS.register("boiling_pot_type", () -> BoilingPotRecipe.Serializer.INSTANCE);
//			SERIALIZERS.register("cutting_board_type", () -> CuttingBoardRecipe.Serializer.INSTANCE);
//			SERIALIZERS.register("frying_pan_type", () -> FryingPanRecipe.Serializer.INSTANCE);
//			SERIALIZERS.register("grill_type", () -> GrillRecipe.Serializer.INSTANCE);
//			SERIALIZERS.register("streamer_type", () -> SteamerRecipe.Serializer.INSTANCE);
//		});
//	}
}
