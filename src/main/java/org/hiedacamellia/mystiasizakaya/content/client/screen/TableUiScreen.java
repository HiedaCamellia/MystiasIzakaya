package org.hiedacamellia.mystiasizakaya.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.TableUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.ui.Lefttime;
import org.hiedacamellia.mystiasizakaya.core.cooking.ui.Status;
import org.hiedacamellia.mystiasizakaya.core.network.CookingRangeUiButton;
import org.hiedacamellia.mystiasizakaya.util.ButtunShow;
import org.hiedacamellia.mystiasizakaya.util.TargetsText;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.HashMap;

public class TableUiScreen extends AbstractContainerScreen<TableUiMenu> {
	private static final HashMap<String, Object> guistate = TableUiMenu.guistate;
	private final Level world;
	private final int x,y,z;
	private final BlockPos pos;
	private final Player entity;

	public TableUiScreen(TableUiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.pos = Pos.get(x,y,z);
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture =ResourceLocation.parse(
			"mystias_izakaya:textures/screens/base_ui.png");

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

		int start_x = this.leftPos + imageWidth / 2 - 18 * 9 / 2 - 7;
		int start_y = this.topPos + 84;
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				renderSlot(guiGraphics, start_x + 8 + sj * 18, 2 + start_y + si * 18);
		for (int si = 0; si < 9; ++si)
			renderSlot(guiGraphics, start_x + 8 + si * 18, 6 +  start_y + 3 * 18);

		renderSlot(guiGraphics, this.leftPos + 70, this.topPos + 30);
		renderSlot(guiGraphics, this.leftPos + 100, this.topPos + 30);

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

	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}

	private void renderSlot(GuiGraphics guiGraphics, int x, int y) {
		guiGraphics.fill(x - 1, y - 1, x + 17, y + 17, 0xFF8B4513);
		guiGraphics.fill(x, y, x + 16, y + 16, 0xFFfbefcb);
	}
}
