package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import org.hiedacamellia.mystiasizakaya.client.blockentityrender.ProcessRender;

public class MIBlockEntityRenderer {

    public static void register() {
        BlockEntityRenderers.register(MIBlockEntitiy.GRILL, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.BOILING_POT, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.CUTTING_BOARD, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.FRYING_PAN, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.STEAMER, ProcessRender::new);
    }
}
