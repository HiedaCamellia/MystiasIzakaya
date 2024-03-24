
package net.touhou.mystiasizakaya.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.touhou.mystiasizakaya.procedures.ShowbalanceLProcedure;
import net.touhou.mystiasizakaya.procedures.ShowBalanceProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class BalanceOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (ShowbalanceLProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ShowBalanceProcedure.execute(entity), w - 58, h - 11, -1, false);
		}
	}
}
