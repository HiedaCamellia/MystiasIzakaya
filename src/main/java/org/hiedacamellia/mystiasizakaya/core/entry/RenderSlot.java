package org.hiedacamellia.mystiasizakaya.core.entry;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;

public class RenderSlot extends AbstractWidget {
    private final Component tooltip;
    private static final Font font = Minecraft.getInstance().font;

    public RenderSlot(int x, int y, Component tooltip) {
        super(x, y, 16, 16, tooltip);
        this.tooltip = tooltip;
    }

    @Override
    protected boolean clicked(double mouseX, double mouseY) {
        return false;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics,  getX()- 1,  getY()- 1, 18, 18, 0.05f, 0xFF8B4513);
        IUIGuiUtils.fillRoundRect(guiGraphics, getX(),getY() , 16, 16, 0.05f, 0xFFf0e0b0);
        RenderSystem.disableBlend();
        if(isHovered()&&!tooltip.equals(Component.empty())){
            guiGraphics.drawString(font, tooltip, getX()-font.width(tooltip), getY(), 0xFFFFFF);
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
