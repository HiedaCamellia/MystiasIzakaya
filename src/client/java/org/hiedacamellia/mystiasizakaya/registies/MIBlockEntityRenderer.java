package org.hiedacamellia.mystiasizakaya.registies;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import org.hiedacamellia.mystiasizakaya.client.blockentityrender.ProcessRender;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;

public class MIBlockEntityRenderer {

    public static void register() {
        BlockEntityRenderers.register(MIBlockEntitiy.GRILL, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.BOILING_POT, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.CUTTING_BOARD, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.FRYING_PAN, ProcessRender::new);
        BlockEntityRenderers.register(MIBlockEntitiy.STEAMER, ProcessRender::new);
    }
}
