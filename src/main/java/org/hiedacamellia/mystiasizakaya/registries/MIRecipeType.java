package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.integration.jei.recipes.*;

@Mod.EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MIRecipeType {
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
