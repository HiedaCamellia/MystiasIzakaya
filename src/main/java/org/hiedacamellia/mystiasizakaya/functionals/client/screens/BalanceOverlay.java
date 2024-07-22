
package org.hiedacamellia.mystiasizakaya.functionals.client.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

@EventBusSubscriber({ Dist.CLIENT })
public class BalanceOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {

		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Player entity = Minecraft.getInstance().player;
		String text = Component.translatable("gui.mystias_izakaya.balance").getString() + ""
				+ new java.text.DecimalFormat("#######")
						.format(entity.getData(Variables.PLAYER_VARIABLES).balance)
				+ "\u5186";
		int strlength = Minecraft.getInstance().font.width(text);

		if (entity.getData(Variables.PLAYER_VARIABLES).showbalance)
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, text, w - 20 - strlength, h - 11, -1,
					false);

	}
}
