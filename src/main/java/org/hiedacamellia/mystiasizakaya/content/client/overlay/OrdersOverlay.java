
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.util.ItemUtil;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber({ Dist.CLIENT })
public class OrdersOverlay {
	private static List<ItemStack> last_orders;
	private static List<ItemStack> last_beverage;
	private static int tick;
	private static boolean statical;
	private static int flag;
	private static int now_orders;
	private static boolean add;
	private static ItemStack flag_cuisine;
	private static ItemStack flag_beverage;


	private final static int x_mid = 20 + 34 * 4;


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
		if (entity != null) {

			if(flag_cuisine==null)
				flag_cuisine = ItemStack.EMPTY;
			if(flag_beverage==null)
				flag_beverage = ItemStack.EMPTY;

			List<ItemStack> cuisinesorders_list = ItemUtil.getStacks(MIPlayerEvent.getOrders(entity));
			List<ItemStack> beveragesorders_list = ItemUtil.getStacks(MIPlayerEvent.getOrdersBeverages(entity));
			List<ItemStack> last_orders = getLast_orders();
			List<ItemStack> last_beverage = getLast_beverage();

			if (!statical) {
				int reali;
				int start_x;
				int axis;
				if (tick >= 16) {
					tick = 0;
					statical = true;
				}else {
					boolean left=false;
					boolean right=false;
					boolean middle=false;
					refreshNowOrders(cuisinesorders_list);
					for (int i = 0; i < 8; i++) {
						if(!cuisinesorders_list.get(i).isEmpty()||!beveragesorders_list.get(i).isEmpty()){
							if(i<flag)
								right = true;
							if(i>flag)
								left = true;
						}
						if(left&&right){
							middle = true;
							left = false;
							right = false;
							break;
						}
					}
					reali = 0;
					//Debug.getLogger().debug(String.valueOf(now_orders));
					if (add) {
						axis = 16 - tick;
						if(now_orders==1) {
							//Debug.getLogger().debug("1");
							start_x = x_mid - 17;
						}else {
							if (middle) {
								start_x = x_mid - now_orders * 17 - 17;
							}else {
								start_x = x_mid - now_orders * 17;
							}
						}
					} else {
						axis = tick;
						if(now_orders==0) {
							start_x = x_mid - 17;
						}else {
							if (middle) {
								start_x = x_mid - now_orders * 17 - 34;
							}else {
								start_x = x_mid - now_orders * 17 - 17;
							}
						}
					}
					for (int i = 0; i < flag; i++) {
						cuisines = cuisinesorders_list.get(i);
						beverages = beveragesorders_list.get(i);
						if (!cuisines.isEmpty() || !beverages.isEmpty()) {
							renderPart(guiGraphics, start_x + reali * 34 + axis, h - 30, i, cuisines, beverages);
							reali++;
						}
					}
					if (add) {
						cuisines = cuisinesorders_list.get(flag);
						beverages = beveragesorders_list.get(flag);
					} else {
						cuisines = flag_cuisine;
						beverages = flag_beverage;
					}
					if (!cuisines.isEmpty() || !beverages.isEmpty()) {
						renderPart(guiGraphics, start_x + reali * 34, h - 30 + axis * 2, flag, cuisines, beverages);
						reali++;
					}
					for (int i = flag + 1; i < 8; i++) {
						cuisines = cuisinesorders_list.get(i);
						beverages = beveragesorders_list.get(i);
						if (!cuisines.isEmpty() || !beverages.isEmpty()) {
							renderPart(guiGraphics, start_x + reali * 34 - axis, h - 30, i, cuisines, beverages);
							reali++;
						}
					}
					tick++;
				}
			}
			if (statical) {
				refreshNowOrders(cuisinesorders_list);
				for (int i = 0; i < 8; i++) {
					if (!(ItemStack.isSameItem(cuisinesorders_list.get(i), last_orders.get(i)))) {
						if (last_orders.get(i).isEmpty()) {
							//Debug.getLogger().debug("add");
							flag_cuisine = last_orders.get(i);
							flag_beverage = last_beverage.get(i);
							add = true;
						} else {
							flag_cuisine = last_orders.get(i);
							flag_beverage = last_beverage.get(i);
							//Debug.getLogger().debug("delete");
							add = false;
						}
						last_beverage.set(i, beveragesorders_list.get(i));
						last_orders.set(i, cuisinesorders_list.get(i));
						statical = false;
						flag = i;


						break;
					}
				}
			}
			if (statical) {
				int reali = 0;
				int start_x = x_mid - now_orders * 17;
				for (int i = 0; i < 8; i++) {
					cuisines = cuisinesorders_list.get(i);
					beverages = beveragesorders_list.get(i);
					if (!cuisines.isEmpty() || !beverages.isEmpty()) {
						renderPart(guiGraphics, start_x + reali * 34, h - 30, i, cuisines, beverages);
						reali++;
					}
				}
			}

			setLast_orders(last_orders);
			setLast_beverage(last_beverage);
		}

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

	private static void renderPart(GuiGraphics guiGraphics, int x, int y, int i, ItemStack cuisine, ItemStack beverage) {
		guiGraphics.blit(new ResourceLocation("mystias_izakaya:textures/screens/page.png"),
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
				new java.text.DecimalFormat("#######").format(i+1) + "\u53f7\u684c", x + 8, y + 22,
				-16777216,
				false);

	}

	public static void setLast_orders(List<ItemStack> last_orders) {
		OrdersOverlay.last_orders = last_orders;
	}

	public static List<ItemStack> getLast_orders() {
		if (last_orders == null)
			return new ArrayList<>(List.of(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY));
		return last_orders;
	}

	public static void setLast_beverage(List<ItemStack> last_beverage) {
		OrdersOverlay.last_beverage = last_beverage;
	}

	public static List<ItemStack> getLast_beverage() {
		if (last_beverage == null)
			return new ArrayList<>(List.of(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY));
		return last_beverage;
	}

	private static void refreshNowOrders(List<ItemStack> list) {
		now_orders = 0;
		for (int i = 0; i < 8; i++) {
			if (!list.get(i).isEmpty()) {
				now_orders++;
			}
		}

	}

}