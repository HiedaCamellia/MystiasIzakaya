package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.hiedacamellia.mystiasizakaya.content.client.screen.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MIScreen {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MIMenu.COOKING_RANGE_UI.get(), CookingRangeUiScreen::new);
			MenuScreens.register(MIMenu.KITCHENWARES_UI.get(), KitchenwaresUiScreen::new);
			MenuScreens.register(MIMenu.Donation_UI.get(), DonationUiScreen::new);
			MenuScreens.register(MIMenu.LEDGER_UI.get(), LedgerUiScreen::new);
			MenuScreens.register(MIMenu.TABLE_UI.get(), TableUiScreen::new);
			MenuScreens.register(MIMenu.Telephone_UI.get(), TelephoneUiScreen::new);
		});
	}
}
