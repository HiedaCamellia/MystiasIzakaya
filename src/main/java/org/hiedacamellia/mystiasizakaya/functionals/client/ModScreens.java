package org.hiedacamellia.mystiasizakaya.functionals.client;

import net.minecraft.client.gui.screens.MenuScreens;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.hiedacamellia.mystiasizakaya.functionals.Menus;
import org.hiedacamellia.mystiasizakaya.functionals.client.gui.BankUiScreen;
import org.hiedacamellia.mystiasizakaya.functionals.client.gui.CookingRangeUiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(Menus.COOKING_RANGE_UI.get(), CookingRangeUiScreen::new);
		event.register(Menus.BANK_UI.get(), BankUiScreen::new);
	}
}
