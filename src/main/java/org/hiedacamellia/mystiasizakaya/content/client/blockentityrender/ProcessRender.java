package org.hiedacamellia.mystiasizakaya.content.client.blockentityrender;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;

import java.nio.ByteBuffer;

//感谢https://github.com/Crystal1921/mystias_izakaya

public class ProcessRender implements BlockEntityRenderer<KitchenwaresEntity> {
    private final ItemRenderer itemRenderer;
    private final EntityRenderDispatcher entityRenderDispatcher;
    private static final ResourceLocation TEXTURE_IN = new ResourceLocation(MystiasIzakaya.MODID, "textures/entity/process_inside.png");
    private static final ResourceLocation TEXTURE_OUT = new ResourceLocation(MystiasIzakaya.MODID, "textures/entity/process_side.png");
    private static final RenderType RENDER_TYPE_IN = RenderType.entityCutoutNoCull(TEXTURE_IN);
    private static final RenderType RENDER_TYPE_OUT = RenderType.entityCutoutNoCull(TEXTURE_OUT);

    public ProcessRender(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
        this.entityRenderDispatcher = ctx.getEntityRenderer();
    }

    @Override
    public void render(KitchenwaresEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getItems().get(12).getItem() instanceof MIItem cookedMealItem) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.5, 0.7, 0.5);
            pPoseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            pPoseStack.scale(1.2F, 1.2F, 1.2F);
            this.itemRenderer
                    .renderStatic(
                            cookedMealItem.getDefaultInstance(),
                            ItemDisplayContext.GROUND,
                            pPackedLight,
                            OverlayTexture.NO_OVERLAY,
                            pPoseStack,
                            pBuffer,
                            pBlockEntity.getLevel(),
                            (int) pBlockEntity.getBlockPos().asLong()
                    );
            pPoseStack.translate(0, 0.8, 0);
            PoseStack.Pose poseStack = pPoseStack.last();
            float process;
            if(pBlockEntity.getPersistentData().getDouble("timeleft")==0)
                process = 0;
            else
                process = (float) (1 -  pBlockEntity.getPersistentData().getDouble("timeleft") / pBlockEntity.getPersistentData().getDouble("totaltime"));
            VertexConsumer vertexconsumerIn = pBuffer.getBuffer(RENDER_TYPE_IN);
            renderImage(pPackedLight, vertexconsumerIn, poseStack, process);
            VertexConsumer vertexconsumerOut = pBuffer.getBuffer(RENDER_TYPE_OUT);
            renderImage(pPackedLight, vertexconsumerOut, poseStack, 1);
            pPoseStack.popPose();
        }
    }

    private static void renderImage(int pPackedLight, VertexConsumer vertexconsumer, PoseStack.Pose pose, float length) {
        vertex(vertexconsumer, pose, pPackedLight, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, pose, pPackedLight, length, 0, 1, 1);
        vertex(vertexconsumer, pose, pPackedLight, length, 0.125F, 1, 0);
        vertex(vertexconsumer, pose, pPackedLight, 0.0F, 0.125F, 0, 0);
    }

    private static void vertex(VertexConsumer pConsumer, PoseStack.Pose pPose, int pPackedLight, float pX, float pY, float pU, float pV) {
        pConsumer.vertex(pPose.pose(), pX - 0.5F, pY - 0.25F, 0.0F)
                .color(-1)
                .uv(pU, pV)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .normal(pPose.normal(), 0.0F, 1.0F, 0.0F);
    }
}
