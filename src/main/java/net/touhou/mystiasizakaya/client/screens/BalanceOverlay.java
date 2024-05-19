
package net.touhou.mystiasizakaya.client.screens;

import net.touhou.mystiasizakaya.procedures.ShowbalanceLProcedure;
import net.touhou.mystiasizakaya.network.MystiasIzakayaModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber({ Dist.CLIENT })
public class BalanceOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Player entity = Minecraft.getInstance().player;
		String text = Component.translatable("gui.mystias_izakaya.balance").getString() + ""
				+ new java.text.DecimalFormat("#######")
						.format((entity.getCapability(MystiasIzakayaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MystiasIzakayaModVariables.PlayerVariables())).balance)
				+ "\u5186";
		int strlength = Minecraft.getInstance().font.width(text);

		if (ShowbalanceLProcedure.execute(entity))
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, text, w - 20 - strlength, h - 11, -1,
					false);

	}
}
