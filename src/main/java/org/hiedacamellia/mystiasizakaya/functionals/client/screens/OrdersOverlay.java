
package org.hiedacamellia.mystiasizakaya.functionals.client.screens;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.content.orders.GetBeveragesTexture;
import org.hiedacamellia.mystiasizakaya.content.orders.GetCuisinesTexture;
import org.hiedacamellia.mystiasizakaya.content.orders.Initorders;

@Mod.EventBusSubscriber({ Dist.CLIENT })
public class OrdersOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int h = event.getWindow().getGuiScaledHeight();
		Player entity = Minecraft.getInstance().player;
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
				GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		String fm = "";
		String fmb = "";
		int reali = 0;
		Initorders.init(entity);
		for (int i = 0; i < 7; i++) {
			fm = GetCuisinesTexture.execute(i, entity);
			fmb = GetBeveragesTexture.execute(i, entity);
			if (fm != "" || fmb != "") {
				RenderSystem.setShaderTexture(0, new ResourceLocation("mystias_izakaya:textures/screens/page.png"));
				GuiComponent.blit(event.getPoseStack(), 0 + reali * 34, h - 32, 0, 0, 36, 32, 36, 32);

				if (fm != "") {

					RenderSystem.setShaderTexture(0,
							new ResourceLocation("mystias_izakaya:textures/item/" + fm + ".png"));
					GuiComponent.blit(event.getPoseStack(), 2 + reali * 34, h - 30, 0, 0, 16, 16, 16,
							16);
				}
				if (fmb != "") {
					RenderSystem.setShaderTexture(0,
							new ResourceLocation("mystias_izakaya:textures/item/" + fmb + ".png"));
					GuiComponent.blit(event.getPoseStack(), 18 + reali * 34, h - 30, 0, 0, 16, 16, 16,
							16);
				}
				Minecraft.getInstance().font.draw(event.getPoseStack(), new java.text.DecimalFormat("#######").format(i) + "\u53f7\u684c", 8 + reali * 34, h - 10,
						-16777216);
				reali++;
			}
			fm = "";

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
