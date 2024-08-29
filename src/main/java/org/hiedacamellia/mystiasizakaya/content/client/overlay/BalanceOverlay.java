
package org.hiedacamellia.mystiasizakaya.content.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.Config;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

@Mod.EventBusSubscriber({ Dist.CLIENT })
public class BalanceOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {

		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Player entity = Minecraft.getInstance().player;
        assert entity != null;
        String text = Component.translatable("gui.mystias_izakaya.balance").getString() + new java.text.DecimalFormat("#######")
						.format((entity.getCapability(MIPlayerEvent.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MIPlayerEvent.PlayerVariables())).balance) + "\u5186";
		int strlength = Minecraft.getInstance().font.width(text);

		if (Config.SHOW_BALANCE.get())
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, text, w - 20 - strlength, h - 11, -1,
					false);

	}
}
