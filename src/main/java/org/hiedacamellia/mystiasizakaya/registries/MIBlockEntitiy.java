package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.hiedacamellia.mystiasizakaya.content.client.blockentityrender.ProcessRender;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.*;

public class MIBlockEntitiy {
	
	public static final BlockEntityType<CookingRangeEntity> COOKING_RANGE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"cooking_range", BlockEntityType.Builder.of(CookingRangeEntity::new, MIBlock.COOKING_RANGE).build(null));
	public static final BlockEntityType<TableEntity> TABLE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"table", BlockEntityType.Builder.of(TableEntity::new, MIBlock.TABLE).build(null));

	public static final BlockEntityType<CuttingBoard> CUTTING_BOARD = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"cutting_board", BlockEntityType.Builder.of(CuttingBoard::new, MIBlock.CUTTING_BOARD).build(null));
	public static final BlockEntityType<BoilingPot> BOILING_POT = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"boiling_pot", BlockEntityType.Builder.of(BoilingPot::new, MIBlock.BOILING_POT).build(null));
	public static final BlockEntityType<FryingPan> FRYING_PAN = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"frying_pan", BlockEntityType.Builder.of(FryingPan::new, MIBlock.FRYING_PAN).build(null));
	public static final BlockEntityType<Steamer> STEAMER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"steamer", BlockEntityType.Builder.of(Steamer::new, MIBlock.STEAMER).build(null));
	public static final BlockEntityType<Grill> GRILL = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,"grill", BlockEntityType.Builder.of(Grill::new, MIBlock.GRILL).build(null));


//	@SubscribeEvent
//	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//		event.registerBlockEntityRenderer(GRILL, ProcessRender::new);
//		event.registerBlockEntityRenderer(BOILING_POT, ProcessRender::new);
//		event.registerBlockEntityRenderer(CUTTING_BOARD, ProcessRender::new);
//		event.registerBlockEntityRenderer(FRYING_PAN, ProcessRender::new);
//		event.registerBlockEntityRenderer(STEAMER, ProcessRender::new);
//	}
	public static void register(){
	}
}
