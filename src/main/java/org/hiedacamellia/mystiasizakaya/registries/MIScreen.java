package org.hiedacamellia.mystiasizakaya.registries;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.CookingScreen;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.TableScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MIScreen {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MIMenu.TABLE_UI.get(), TableScreen::new);
		event.register(MIMenu.COOKING_UI.get(), CookingScreen::new);
	}
}
