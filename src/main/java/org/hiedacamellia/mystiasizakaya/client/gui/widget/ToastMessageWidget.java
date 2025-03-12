package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;

public class ToastMessageWidget extends AbstractWidget {

    private final float time;
    private float count=0;

    public ToastMessageWidget(int x, int y, int width, int height, float time, Component message) {
        super(x-width/2, y-height/2, width, height, message);
        this.time = time;
    }

    public void reset(Component message){
        if(count>time)
            count = 0;
        this.setMessage(message);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int i, int i1, float v) {
        RenderSystem.setShaderColor(1,1,1,1);
        if (count >time) return;
        if(getMessage().getString().isEmpty())return;
        count+=v;
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(getX()+ (double) getWidth() /2,getY()+ (double) getHeight() /2,1000.0);
        //smoothstep alpha
        float alpha;
        if(count<time*0.5f){
            alpha = smoothStep(0,time*0.1f,count);
        }else {
            alpha = 1-smoothStep(time*0.9f,time,count);
        }
        pose.scale(alpha,alpha,0);
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,alpha);
        IUIGuiUtils.fillRoundRectCentered(guiGraphics,width,height,0.05f,0x80000000);
        IUIGuiUtils.drawCenteredString(guiGraphics, Minecraft.getInstance().font, getMessage(),0,0,0xFFFFFFFF,false);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        pose.popPose();
        RenderSystem.disableBlend();
    }

    private float smoothStep(float start,float end,float v){
        v = Math.max(0,Math.min(1,(v-start)/(end-start)));
        return v*v*(3-2*v);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
