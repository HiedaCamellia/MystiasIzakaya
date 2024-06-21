package net.touhou.mystiasizakaya.functionals.client.gui;

import net.touhou.mystiasizakaya.functionals.inventory.BankUiMenu;
import net.touhou.mystiasizakaya.functionals.network.BankUiButton;
import net.touhou.mystiasizakaya.MystiasIzakaya;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BankUiScreen extends AbstractContainerScreen<BankUiMenu> {
	private final static HashMap<String, Object> guistate = BankUiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox input;
	Button button_take_out;

	public BankUiScreen(BankUiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mystias_izakaya:textures/screens/bank_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		input.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (input.isFocused())
			return input.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		input.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				Component.translatable("gui.mystias_izakaya.bank_ui.bank").getString(), 66, 24, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		input = new EditBox(this.font, this.leftPos + 25, this.topPos + 53, 124, 18, Component.translatable("gui.mystias_izakaya.bank_ui.input")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mystias_izakaya.bank_ui.input").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mystias_izakaya.bank_ui.input").getString());
				else
					setSuggestion(null);
			}
		};
		input.setSuggestion(Component.translatable("gui.mystias_izakaya.bank_ui.input").getString());
		input.setMaxLength(32767);
		guistate.put("text:input", input);
		this.addWidget(this.input);
		button_take_out = Button.builder(Component.translatable("gui.mystias_izakaya.bank_ui.button_take_out"), e -> {
			if (true) {
				MystiasIzakaya.PACKET_HANDLER.sendToServer(new BankUiButton(0, x, y, z));
				BankUiButton.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 31, this.topPos + 100, 110, 20).build();
		guistate.put("button:button_take_out", button_take_out);
		this.addRenderableWidget(button_take_out);
	}
}
