package org.hiedacamellia.mystiasizakaya.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.immersiveui.client.graphic.util.RenderUtils;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingUiMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItemButton;
import org.hiedacamellia.mystiasizakaya.core.entry.RenderSlot;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.ArrayList;
import java.util.List;

public class CookingUiScreen extends AbstractContainerScreen<CookingUiMenu> {

    private final BlockPos pos;

    protected List<MIItemButton> buttons;

    public CookingUiScreen(CookingUiMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.pos = menu.pos;
        this.imageWidth = 200;
        this.imageHeight = 180;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.enableBlend();
        RenderUtils.fillRoundRect(guiGraphics,leftPos-1, topPos-1, imageWidth, imageHeight, 0.05f, 0xFF725649);
        RenderUtils.fillRoundRect(guiGraphics,leftPos+1, topPos+1, imageWidth, imageHeight, 0.05f, 0xFF321609);
        RenderUtils.fillRoundRect(guiGraphics,leftPos, topPos, imageWidth, imageHeight, 0.05f, 0xFF523629);
        RenderUtils.fillRoundRect(guiGraphics,leftPos+114, topPos+7, 4*18+4, 3*18+4, 0.05f, 0xFFf0e0b0);
        RenderSystem.disableBlend();
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    private void renderSlotBg(GuiGraphics guiGraphics, int x, int y) {
        RenderSystem.enableBlend();
        RenderUtils.fillRoundRect(guiGraphics,  x- 1,  y- 1, 18, 18, 0.05f, 0xFF8B4513);
        RenderUtils.fillRoundRect(guiGraphics, x,y , 16, 16, 0.05f, 0xFFf0e0b0);
        RenderSystem.disableBlend();
    }


    @Override
    public void init() {
        super.init();
        buttons = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int finala = j + i * 4;
                buttons.add(new MIItemButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.select"), e -> {
                    ItemStack itemStack = buttons.get(finala).getItemStack();

                }).pos(leftPos + 117 + 18 * j, topPos + 10 + 18 * i).disableBg().build());
            }
        }

        for (Button button : buttons) {
            this.addRenderableWidget(button);
        }

        int start_x = this.leftPos + imageWidth / 2 - 18 * 9 / 2;
        int start_y = this.topPos + imageHeight - 80;
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addRenderableWidget(new RenderSlot(start_x + sj * 18, start_y + si * 18,Component.empty()));
        for (int si = 0; si < 9; ++si)
            this.addRenderableWidget(new RenderSlot(start_x + si * 18, 2 + start_y + 3 * 18,Component.empty()));

        this.addRenderableWidget(new RenderSlot(start_x + 7 * 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.kitchenwares")));
        this.addRenderableWidget(new RenderSlot(start_x + 9 * 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.output")));

        this.addRenderableWidget(new RenderSlot(start_x, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new RenderSlot(start_x + 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new RenderSlot(start_x + 2 * 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new RenderSlot(start_x + 3 * 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));
        this.addRenderableWidget(new RenderSlot(start_x + 4 * 18, start_y - 22,Component.translatable("gui.mystias_izakaya.cooking_ui.ingerdients")));

    }
}
