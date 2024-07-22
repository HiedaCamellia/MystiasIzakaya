package org.hiedacamellia.mystiasizakaya.functionals.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.cooking.ui.Lefttime;
import org.hiedacamellia.mystiasizakaya.content.cooking.ui.Status;
import org.hiedacamellia.mystiasizakaya.functionals.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.functionals.network.CookingRangeUiButton;
import org.hiedacamellia.mystiasizakaya.util.ButtunShow;
import org.hiedacamellia.mystiasizakaya.util.TargetsText;

import java.util.HashMap;

public class CookingRangeUiScreen extends AbstractContainerScreen<CookingRangeUiMenu> {
	private static final HashMap<String, Object> guistate = CookingRangeUiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_confirm;
	Button button_select;
	Button button_select1;
	Button button_select2;
	Button button_select3;
	Button button_select4;
//	List<Button> buttons;

	public CookingRangeUiScreen(CookingRangeUiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture =ResourceLocation.parse(
			"mystias_izakaya:textures/screens/cooking_range_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth,
				this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, TargetsText.get(world, x, y, z, 7), 44, 29, -1, false);
		guiGraphics.drawString(this.font, TargetsText.get(world, x, y, z, 8), 44, 56, -1, false);
		guiGraphics.drawString(this.font, TargetsText.get(world, x, y, z, 9), 44, 83, -1, false);
		guiGraphics.drawString(this.font, TargetsText.get(world, x, y, z, 10), 44, 110, -1, false);
		guiGraphics.drawString(this.font, TargetsText.get(world, x, y, z, 11), 44, 137, -1, false);
		guiGraphics.drawString(this.font, Status.execute(world, x, y, z), 233, 26, -1, false);
		guiGraphics.drawString(this.font, Lefttime.execute(world, x, y, z), 238, 65, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_confirm = Button
				.builder(Component.translatable("gui.mystias_izakaya.cooking_range_ui.button_confirm"), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CookingRangeUiButton(0, x, y, z));
						CookingRangeUiButton.handleButtonAction(entity, 0, x, y, z);
					}
				}).bounds(this.leftPos + 94, this.topPos + 60, 90, 20).build();
		guistate.put("button:button_confirm", button_confirm);
		this.addRenderableWidget(button_confirm);


		button_select = Button.builder(Component.literal(""), e -> {
			if (ButtunShow.get(entity, 7)) {
				PacketDistributor.sendToServer(new CookingRangeUiButton(1, x, y, z));
				CookingRangeUiButton.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 24, 45, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,7))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		button_select1 = Button.builder(Component.literal(""), e -> {
			if (ButtunShow.get(entity, 8)) {
				PacketDistributor.sendToServer(new CookingRangeUiButton(2, x, y, z));
				CookingRangeUiButton.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 51, 45, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,8))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select1", button_select1);
		this.addRenderableWidget(button_select1);
		button_select2 = Button.builder(Component.literal(""), e -> {
			if (ButtunShow.get(entity, 9)) {
				PacketDistributor.sendToServer(new CookingRangeUiButton(3, x, y, z));
				CookingRangeUiButton.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 78, 45, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,9))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select2", button_select2);
		this.addRenderableWidget(button_select2);
		button_select3 = Button.builder(Component.literal(""), e -> {
			if (ButtunShow.get(entity, 10)) {
				PacketDistributor.sendToServer(new CookingRangeUiButton(4, x, y, z));
				CookingRangeUiButton.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 105, 45, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,10))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select3", button_select3);
		this.addRenderableWidget(button_select3);
		button_select4 = Button.builder(Component.literal(""), e -> {
			if (ButtunShow.get(entity, 11)) {
				PacketDistributor.sendToServer(new CookingRangeUiButton(5, x, y, z));
				CookingRangeUiButton.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 132, 45, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,11))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select4", button_select4);
		this.addRenderableWidget(button_select4);
	}
}
