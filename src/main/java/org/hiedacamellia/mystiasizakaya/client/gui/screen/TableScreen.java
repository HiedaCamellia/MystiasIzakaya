package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Inventory;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MIFakeSlot;
import org.hiedacamellia.mystiasizakaya.common.menu.TableMenu;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.List;

public class TableScreen extends AbstractContainerScreen<TableMenu> {
    private final BlockPos pos;

    public TableScreen(TableMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.pos = container.pos;
        this.imageWidth = 180;
        this.imageHeight = 166;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
    }

    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        List<BlockPos> blockPosList = Minecraft.getInstance().player.getData(MIAttachment.MI_ORDERS).blockPos();
        int index = blockPosList.indexOf(pos);
        if (index != -1) {
            MutableComponent component = Component.translatable("gui.mystias_izakaya.table.title", index + 1);
            guiGraphics.drawString(this.font, component, this.imageWidth / 2 - font.width(component) / 2, 6, 0x404040, false);
        }
    }


    @Override
    public void init() {
        super.init();

        int start_x = this.leftPos + imageWidth / 2 - 18 * 9 / 2 - 7;
        int start_y = this.topPos + 84;
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addRenderableWidget(new MIFakeSlot(start_x + 8 + sj * 18, 2 + start_y + si * 18, Component.empty()));
        for (int si = 0; si < 9; ++si)
            this.addRenderableWidget(new MIFakeSlot(start_x + 8 + si * 18, 6 + start_y + 3 * 18, Component.empty()));

        this.addRenderableWidget(new MIFakeSlot( this.leftPos + 70, this.topPos + 30, Component.empty()));
        this.addRenderableWidget(new MIFakeSlot(this.leftPos + 100, this.topPos + 30, Component.empty()));
    }

}
