package org.hiedacamellia.mystiasizakaya.content.client.blockentityrender;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;

public class TableRender implements BlockEntityRenderer<TableEntity> {
    private final ItemRenderer itemRenderer;
    private final EntityRenderDispatcher entityRenderDispatcher;

    public TableRender(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
        this.entityRenderDispatcher = ctx.getEntityRenderer();
    }

    @Override
    public void render(TableEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        //Debug.getLogger().debug("Rendering table block entity");
        if (pBlockEntity.getItems().get(0).getItem() instanceof MIItem cookedMealItem) {
            //Debug.getLogger().debug("Rendering item: " + cookedMealItem.getDescriptionId());
            pPoseStack.pushPose();
            pPoseStack.translate(0.2, 0.7, 0.5);
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
        }
        if (pBlockEntity.getItems().get(1).getItem() instanceof MIItem cookedMealItem) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.8, 0.7, 0.5);
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
        }
    }

}
