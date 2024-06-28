package org.hiedacamellia.mystiasizakaya.integration.jei;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.integration.jei.recipes.*;

@Mod.EventBusSubscriber(modid = MystiasIzakaya.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeTypes {
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
