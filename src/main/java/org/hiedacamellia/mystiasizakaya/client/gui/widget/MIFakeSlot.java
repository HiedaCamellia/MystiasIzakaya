package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;

public class MIFakeSlot extends AbstractWidget {
    private static final Font font = Minecraft.getInstance().font;

    public MIFakeSlot(int x, int y, Component tooltip) {
        super(x, y, 16, 16, tooltip);
    }

    @Override
    protected boolean clicked(double mouseX, double mouseY) {
        return false;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        renderSlotBackground(guiGraphics, getX(), getY());
        RenderSystem.enableBlend();
        if(isHovered()&&!getMessage().equals(Component.empty())){
            int w = font.width(getMessage());
            int h = font.lineHeight;
            int x = getX() - w;
            int y = getY() - h;
            PoseStack pose = guiGraphics.pose();
            pose.pushPose();
            pose.translate(0,0,500);
            IUIGuiUtils.fillRoundRect(guiGraphics, x - 1, y - 1, w + 1, h + 1, 0.2f, 0x80DDDDDD);
            guiGraphics.drawString(font, getMessage(), x, y, 0xFFFFFF);
            pose.popPose();
        }
        RenderSystem.disableBlend();
    }

    public static void renderSlotBackground(GuiGraphics guiGraphics, int x, int y) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, x - 1, y - 1, 18, 18, 0.05f, 0xFF8B4513);
        IUIGuiUtils.fillRoundRect(guiGraphics, x, y, 16, 16, 0.05f, 0xFFf0e0b0);
        RenderSystem.disableBlend();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
