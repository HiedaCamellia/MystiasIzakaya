package net.touhou.mystiasizakaya.client.gui;

import net.touhou.mystiasizakaya.world.inventory.CookingRangeUiMenu;
import net.touhou.mystiasizakaya.procedures.TargetsText;
import net.touhou.mystiasizakaya.procedures.ButtunShow;
import net.touhou.mystiasizakaya.procedures.StatusProcedure;
import net.touhou.mystiasizakaya.procedures.LefttimeProcedure;
import net.touhou.mystiasizakaya.network.BankUiButtonMessage;
import net.touhou.mystiasizakaya.network.CookingRangeUiButtonMessage;
import net.touhou.mystiasizakaya.MystiasIzakayaMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

public class CookingRangeUiScreen extends AbstractContainerScreen<CookingRangeUiMenu> {
	private final static HashMap<String, Object> guistate = CookingRangeUiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_confirm;
	Button button_select;
	Button button_select1;
	Button button_select2;
	Button button_select3;
	Button button_select4;

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

	private static final ResourceLocation texture = new ResourceLocation(
			"mystias_izakaya:textures/screens/cooking_range_ui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth,
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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, TargetsText.get(world, x, y, z,0), 44, 29, -1);
		this.font.draw(poseStack, TargetsText.get(world, x, y, z,1), 44, 56, -1);
		this.font.draw(poseStack, TargetsText.get(world, x, y, z,2), 44, 83, -1);
		this.font.draw(poseStack, TargetsText.get(world, x, y, z,3), 44, 110, -1);
		this.font.draw(poseStack, TargetsText.get(world, x, y, z,4), 44, 137, -1);
		this.font.draw(poseStack, StatusProcedure.execute(world, x, y, z), 233, 26, -1);
		this.font.draw(poseStack, LefttimeProcedure.execute(world, x, y, z), 238, 65, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_confirm = new Button(this.leftPos + 94, this.topPos + 60, 90, 20,
				Component.translatable("gui.mystias_izakaya.cooking_range_ui.button_confirm"), e -> {
					if (true) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(0, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				});
		guistate.put("button:button_confirm", button_confirm);
		this.addRenderableWidget(button_confirm);

		button_select = new Button(this.leftPos + 40, this.topPos + 24, 45, 20,
				Component.literal(""), e -> {
					if (ButtunShow.get(entity,7)) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(1, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,7))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		button_select1 = new Button(this.leftPos + 40, this.topPos + 51, 45, 20,
				Component.literal(""), e -> {
					if (ButtunShow.get(entity,8)) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(2, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,8))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_select1", button_select1);
		this.addRenderableWidget(button_select1);

		button_select2 = new Button(this.leftPos + 40, this.topPos + 78, 45, 20,
				Component.literal(""), e -> {
					if (ButtunShow.get(entity,9)) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(3, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,9))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_select2", button_select2);
		this.addRenderableWidget(button_select2);
		button_select3 = new Button(this.leftPos + 40, this.topPos + 105, 45, 20,
				Component.literal(""), e -> {
					if (ButtunShow.get(entity,10)) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(4, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,10))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_select3", button_select3);
		this.addRenderableWidget(button_select3);
		button_select4 = new Button(this.leftPos + 40, this.topPos + 132, 45, 20,
				Component.literal(""), e -> {
					if (ButtunShow.get(entity,11)) {
						MystiasIzakayaMod.PACKET_HANDLER.sendToServer(new CookingRangeUiButtonMessage(5, x, y, z));
						CookingRangeUiButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ButtunShow.get(entity,11))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_select4", button_select4);
		this.addRenderableWidget(button_select4);
	}
}
