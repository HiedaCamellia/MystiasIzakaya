package org.hiedacamellia.mystiasizakaya.functionals.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.hiedacamellia.mystiasizakaya.functionals.Menus;
import org.hiedacamellia.mystiasizakaya.functionals.client.gui.BankUiScreen;
import org.hiedacamellia.mystiasizakaya.functionals.client.gui.CookingRangeUiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(Menus.COOKING_RANGE_UI.get(), CookingRangeUiScreen::new);
			MenuScreens.register(Menus.BANK_UI.get(), BankUiScreen::new);
		});
	}
}
