
package org.hiedacamellia.mystiasizakaya.functionals.client.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.functionals.network.Variables;

@Mod.EventBusSubscriber({ Dist.CLIENT })
public class BalanceOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Player entity = Minecraft.getInstance().player;
		String text = Component.translatable("gui.mystias_izakaya.balance").getString() + ""
				+ new java.text.DecimalFormat("#######")
						.format((entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Variables.PlayerVariables())).balance)
				+ "\u5186";
		int strlength = Minecraft.getInstance().font.width(text);

		if ((entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables())).showbalance)
			Minecraft.getInstance().font.draw(event.getPoseStack(), text, w - 20 - strlength, h - 11, -1);

	}
}
