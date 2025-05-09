package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MICustomButton extends Button {

    public final int x;
    public final int y;
    public final int w;
    public final int h;

    protected MICustomButton(int x, int y,int w,int h, Component message, OnPress onPress, @Nullable Tooltip tooltip) {
        super(x, y,w,h,  message, onPress, Button.DEFAULT_NARRATION);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setTooltip(tooltip);
    }

    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(this.x,this.y, 0);
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics,  - 1,  - 1, w+1, h+1, 0.05f, 0xFFFEEBD1);

        if(this.isHovered()) {
            IUIGuiUtils.fillRoundRect(guiGraphics,0 ,0 , w-1, h-1, 0.05f, 0xFFfbefcb);
        }
        else {
            IUIGuiUtils.fillRoundRect(guiGraphics, 0,0 , w-1, h-1, 0.05f, 0xFFf0e0b0);
        }
        RenderSystem.disableBlend();
        pose.popPose();
        this.renderString(guiGraphics, Minecraft.getInstance().font, 0xFFFFFFFF);

    }
    public static class builder {
        private int x;
        private int y;
        private int w;
        private int h;
        private final Component message ;
        private final OnPress onPress ;
        private Tooltip tooltip;

        public builder(Component message, OnPress onPress) {
            this.message = message;
            this.onPress = onPress;
        }

        public MICustomButton.builder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public MICustomButton.builder size(int w, int h) {
            this.w = w;
            this.h = h;
            return this;
        }

        public MICustomButton.builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public MICustomButton build(){
            return new MICustomButton(this.x, this.y,this.w,this.h, this.message, this.onPress,this.tooltip);
        }
    }

}
