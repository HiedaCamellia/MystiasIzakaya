package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;

@Mod.EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MIRecipeType {


	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
			DeferredRegister.create(Registries.RECIPE_TYPE, MystiasIzakaya.MODID);

	public static final RegistryObject<RecipeType<BoilingPotRecipe>> BOILING_POT =
			RECIPE_TYPES.register(
					"boiling_pot_type", () -> RecipeType.<BoilingPotRecipe>simple(new ResourceLocation(MystiasIzakaya.MODID,
							"boiling_pot_type"))
			);
	public static final RegistryObject<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD =
			RECIPE_TYPES.register(
					"cutting_board_type", () -> RecipeType.<CuttingBoardRecipe>simple(new ResourceLocation(MystiasIzakaya.MODID,
							"cutting_board_type"))
			);
	public static final RegistryObject<RecipeType<FryingPanRecipe>> FRYING_PAN =
			RECIPE_TYPES.register(
					"frying_pan_type", () -> RecipeType.<FryingPanRecipe>simple(new ResourceLocation(MystiasIzakaya.MODID,
							"frying_pan_type"))
			);
	public static final RegistryObject<RecipeType<GrillRecipe>> GRILL =
			RECIPE_TYPES.register(
					"grill_type", () -> RecipeType.<GrillRecipe>simple(new  ResourceLocation(MystiasIzakaya.MODID,
							"grill_type"))
			);
	public static final RegistryObject<RecipeType<SteamerRecipe>> STEAMER =
			RECIPE_TYPES.register(
					"streamer_type", () -> RecipeType.<SteamerRecipe>simple(new ResourceLocation(MystiasIzakaya.MODID,
							"streamer_type"))
			);





	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "mystias_izakaya");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			SERIALIZERS.register("boiling_pot_type", () -> BoilingPotRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("cutting_board_type", () -> CuttingBoardRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("frying_pan_type", () -> FryingPanRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grill_type", () -> GrillRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("streamer_type", () -> SteamerRecipe.Serializer.INSTANCE);
		});
	}
}
