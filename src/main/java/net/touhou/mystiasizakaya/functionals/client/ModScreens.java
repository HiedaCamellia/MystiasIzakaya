package net.touhou.mystiasizakaya.functionals.client;

import net.touhou.mystiasizakaya.functionals.client.gui.CookingRangeUiScreen;
import net.touhou.mystiasizakaya.functionals.client.gui.BankUiScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;
import net.touhou.mystiasizakaya.functionals.Menus;

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
