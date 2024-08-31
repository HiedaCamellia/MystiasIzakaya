package org.hiedacamellia.mystiasizakaya.registries;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.hiedacamellia.mystiasizakaya.content.client.screen.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MIScreen {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MIMenu.COOKING_RANGE_UI.get(), CookingRangeUiScreen::new);
		event.register(MIMenu.KITCHENWARES_UI.get(), KitchenwaresUiScreen::new);
		event.register(MIMenu.Donation_UI.get(), DonationUiScreen::new);
		event.register(MIMenu.LEDGER_UI.get(), LedgerUiScreen::new);
		event.register(MIMenu.Telephone_UI.get(), TelephoneUiScreen::new);
	}
}
