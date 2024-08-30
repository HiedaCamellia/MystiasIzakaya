
package org.hiedacamellia.mystiasizakaya.content.client.overlay;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.hiedacamellia.mystiasizakaya.content.orders.GetBeveragesTexture;
import org.hiedacamellia.mystiasizakaya.content.orders.GetCuisinesTexture;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@EventBusSubscriber({ Dist.CLIENT })
public class OrdersOverlay {

	private static List<Boolean> last_orders;


	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		GuiGraphics guiGraphics = event.getGuiGraphics();
		int h = guiGraphics.guiHeight();
		Player entity = Minecraft.getInstance().player;
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
				GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		ItemStack cuisines;
		ItemStack beverages;
		int reali = 0;
        MIOrders miOrders = null;
        if (entity != null) {
            miOrders = entity.getData(MIAttachment.MI_ORDERS);
			List<ItemStack> cuisinesorders_list = getStacks(miOrders.orders());
			List<ItemStack> beveragesorders_list = getStacks(miOrders.beverages());


			for(int i: IntStream.range(0, 7).toArray()){ {
				if(cuisinesorders_list.isEmpty()&&(!last_orders.get(i)))
					continue;
				else {
					last_orders.set(i, true);
					break;
				}
			}





//			for (int i = 0; i < 7; i++) {
//				cuisines = GetCuisinesTexture.execute(i, entity);
//				beverages = GetBeveragesTexture.execute(i, entity);
//				if (!cuisines.isEmpty() || !beverages.isEmpty()) {
//					renderPart(guiGraphics, reali * 34,h - 30,i,cuisines,beverages);
//					reali++;
//				}
			}
        }

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

	private static void renderPart(GuiGraphics guiGraphics,int x,int y,int i,ItemStack cuisine,ItemStack beverage){
		guiGraphics.blit(ResourceLocation.parse("mystias_izakaya:textures/overlay/page.png"),
				x,
				y, 0, 0, 36, 32, 36, 32);
		if (!cuisine.isEmpty()) {
			guiGraphics.renderItem(cuisine,
					x + 2, y + 2, 0, 0);
		}
		if (!beverage.isEmpty()) {
			guiGraphics.renderItem(beverage,
					x + 18, y + 2, 0, 0);
		}
		guiGraphics.drawString(Minecraft.getInstance().font,
				new java.text.DecimalFormat("#######").format(i) + "\u53f7\u684c", x + 8, y + 22,
				-16777216,
				false);

	}

	private static List<ItemStack> getStacks(List<String> orders_list) {
		List<ItemStack> stacks = new ArrayList<>();
		for (String order : orders_list) {
			stacks.add(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(order))));
		}
		return stacks;
	}

}
