
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.touhou.mystiasizakaya.functionals.client.screens;

import net.touhou.mystiasizakaya.functionals.client.gui.CookingRangeUiScreen;
import net.touhou.mystiasizakaya.functionals.client.gui.BankUiScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModMenus;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MystiasIzakayaModMenus.COOKING_RANGE_UI.get(), CookingRangeUiScreen::new);
			MenuScreens.register(MystiasIzakayaModMenus.BANK_UI.get(), BankUiScreen::new);
		});
	}
}
