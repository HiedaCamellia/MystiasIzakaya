package org.hiedacamellia.mystiasizakaya.integration.jei;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.integration.jei.recipes.*;

@EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD)
public class RecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "mystias_izakaya");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			SERIALIZERS.register("boiling_pot_type", () -> BoilingPotTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("cutting_board_type", () -> CuttingBoardTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("frying_pan_type", () -> FryingPanTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grill_type", () -> GrillTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("streamer_type", () -> StreamerTypeRecipe.Serializer.INSTANCE);
		});
	}
}
