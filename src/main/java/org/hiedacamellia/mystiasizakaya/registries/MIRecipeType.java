package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;

@EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MIRecipeType {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "mystias_izakaya");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			SERIALIZERS.register("boiling_pot_type", () -> BoilingPotRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("cutting_board_type", () -> CuttingBoardRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("frying_pan_type", () -> FryingPanRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grill_type", () -> GrillRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("streamer_type", () -> StreamerRecipe.Serializer.INSTANCE);
		});
	}
}
