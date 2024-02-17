package net.touhou.mystiasizakaya.init;

import net.touhou.mystiasizakaya.jei_recipes.StreamerTypeRecipe;
import net.touhou.mystiasizakaya.jei_recipes.GrillTypeRecipe;
import net.touhou.mystiasizakaya.jei_recipes.FryingPanTypeRecipe;
import net.touhou.mystiasizakaya.jei_recipes.CuttingBoardTypeRecipe;
import net.touhou.mystiasizakaya.jei_recipes.BoilingPotTypeRecipe;
import net.touhou.mystiasizakaya.MystiasIzakayaMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

@Mod.EventBusSubscriber(modid = MystiasIzakayaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MystiasIzakayaModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "mystias_izakaya");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("boiling_pot_type", () -> BoilingPotTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("cutting_board_type", () -> CuttingBoardTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("frying_pan_type", () -> FryingPanTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grill_type", () -> GrillTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("streamer_type", () -> StreamerTypeRecipe.Serializer.INSTANCE);
		});
	}
}
