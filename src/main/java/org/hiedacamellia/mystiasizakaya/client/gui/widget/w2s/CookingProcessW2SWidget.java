package org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.w2s.World2ScreenWidget;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.core.network.CookingGetResultC2SMessage;
import org.joml.Vector3f;

import java.util.UUID;

public class CookingProcessW2SWidget extends World2ScreenWidget {

    private static final ResourceLocation TEXTURE = MystiasIzakaya.rl("textures/gui/correct.png");

    protected final CookingEntity cookingEntity;

    private int cook,total;

    private ItemStack result;

    public void setCookTime(int cooktime, int totaltime){
        this.cook = cooktime;
        this.total = totaltime;
    }

    public CookingProcessW2SWidget(UUID uuid, CookingEntity cookingEntity, ResourceLocation location) {
        super(uuid);
        this.cookingEntity = cookingEntity;
        this.scale = 1;
        this.result = BuiltInRegistries.ITEM.get(location).getDefaultInstance();
    }

    @Override
    public void calculateRenderScale(float distanceSqr) {
        this.scale = 2/(float)Math.sqrt(distanceSqr);
        if (distanceSqr > 64 && !shouldRemove) {
            ExistW2SWidget.remove(uuid);
        }
    }

    @Override
    public boolean click(int button) {
        if(cook==total&&total!=0){
            PacketDistributor.sendToServer(new CookingGetResultC2SMessage(cookingEntity.getBlockPos()));
            ExistW2SWidget.remove(uuid);
            return true;
        }
        return false;
    }

    @Override
    public boolean scroll(double mouseX, double mouseY, double scrollX, double scrollY) {
        return false;
    }

    @Override
    public void getWorldPos(Vector3f out) {
        out.set(cookingEntity.getBlockPos().getCenter().toVector3f().add(0,0.8f,0));
    }

    @Override
    public void render(GuiGraphics guiGraphics, boolean highlight, float value, DeltaTracker deltaTracker) {
        RenderSystem.setShaderColor(1,1,1,alpha);

        float x1 = x - (float) 200 / 2;
        float y1 = y - (float) 150 / 2;
        float x2 =  200 + x1;
        float y2 =  150 + y1;

        float centerX = (x1 + x2) / 2;
        float centerY = (y1 + y2) / 2;

        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        RenderSystem.enableBlend();
        pose.translate(centerX, centerY, 0);
        if(cook!=total) {
            pose.pushPose();
            pose.scale(scale, scale, 1);
            if (total != 0)
                IUIGuiUtils.fillRoundRect(guiGraphics, -50, -5, 100 * cook / total, 10, 0.05f, 0xffffaec9);
            IUIGuiUtils.borderRoundRectCentered(guiGraphics, 100, 10, 0.05f, 0x10FFFFFF, 0.02f, 0xFFFFFFFF);
            pose.popPose();
        }

        pose.pushPose();
        pose.scale(scale, scale, 1);
        pose.translate(0, 30, 0);
        pose.scale(2f, 2f, 1f);
        guiGraphics.renderItem(result,-8,-8);
        pose.translate(0, 0, 200);
        if(cook==total&&total!=0){
            guiGraphics.blit(TEXTURE,0,0,8,8,0,0,32,32,32,32);
        }

        pose.popPose();

        RenderSystem.disableBlend();
        pose.popPose();
        RenderSystem.setShaderColor(1,1,1,1);
    }
}
