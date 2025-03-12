package org.hiedacamellia.mystiasizakaya.content.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
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
        if(isHovered()&&!tooltip.equals(Component.empty())){
            int w = font.width(tooltip);
            int h = font.lineHeight;
            int x = getX() - w;
            int y = getY() - h;
            PoseStack pose = guiGraphics.pose();
            pose.pushPose();
            pose.translate(0,0,500);
            IUIGuiUtils.fillRoundRect(guiGraphics, x - 1, y - 1, w + 1, h + 1, 0.2f, 0x80DDDDDD);
            guiGraphics.drawString(font, tooltip, x, y, 0xFFFFFF);
            pose.popPose();
        }
        RenderSystem.disableBlend();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
