package org.hiedacamellia.mystiasizakaya.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.core.network.BankUiButton;

import java.util.HashMap;

public class DonationUiScreen extends AbstractContainerScreen<DonationUiMenu> {
	private final static HashMap<String, Object> guistate = DonationUiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox input;
	Button button_take_out;

	public DonationUiScreen(DonationUiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("mystias_izakaya:textures/screens/donation_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics,mouseX,mouseY,partialTicks);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,
				Component.translatable("gui.mystias_izakaya.donation_ui.donation").getString(), 66, 24, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		input = new EditBox(this.font, this.leftPos + 25, this.topPos + 53, 124, 18, Component.translatable("gui.mystias_izakaya.donation_ui.input")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos,boolean selected) {
				super.moveCursorTo(pos,selected);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
				else
					setSuggestion(null);
			}
		};
		input.setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
		input.setMaxLength(32767);
		guistate.put("text:input", input);
		this.addWidget(this.input);

		button_take_out = Button.builder(Component.translatable("gui.mystias_izakaya.donation_ui.button_take_out"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new BankUiButton(0, x, y, z));
				BankUiButton.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 31, this.topPos + 100, 110, 20).build();
		guistate.put("button:button_take_out", button_take_out);
		this.addRenderableWidget(button_take_out);
	}
}
