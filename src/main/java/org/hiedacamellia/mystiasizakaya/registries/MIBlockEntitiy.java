package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.client.blockentityrender.ProcessRender;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.*;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MIBlockEntitiy {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MystiasIzakaya.MODID);
	public static final RegistryObject<BlockEntityType<CookingRangeEntity>> COOKING_RANGE = REGISTRY.register("cooking_range",() -> BlockEntityType.Builder.of(CookingRangeEntity::new, MIBlock.COOKING_RANGE.get()).build(null));
	public static final RegistryObject<BlockEntityType<TableEntity>> TABLE = REGISTRY.register("table", () -> BlockEntityType.Builder.of(TableEntity::new, MIBlock.TABLE.get()).build(null));

	public static final Supplier<BlockEntityType<CuttingBoard>> CUTTING_BOARD = REGISTRY.register("cutting_board", () -> BlockEntityType.Builder.of(CuttingBoard::new, MIBlock.CUTTING_BOARD.get()).build(null));
	public static final Supplier<BlockEntityType<BoilingPot>> BOILING_POT = REGISTRY.register("boiling_pot", () -> BlockEntityType.Builder.of(BoilingPot::new, MIBlock.BOILING_POT.get()).build(null));
	public static final Supplier<BlockEntityType<FryingPan>> FRYING_PAN = REGISTRY.register("frying_pan", () -> BlockEntityType.Builder.of(FryingPan::new, MIBlock.FRYING_PAN.get()).build(null));
	public static final Supplier<BlockEntityType<Steamer>> STEAMER = REGISTRY.register("steamer", () -> BlockEntityType.Builder.of(Steamer::new, MIBlock.STEAMER.get()).build(null));
	public static final Supplier<BlockEntityType<Grill>> GRILL = REGISTRY.register("grill", () -> BlockEntityType.Builder.of(Grill::new, MIBlock.GRILL.get()).build(null));


	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(GRILL.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(BOILING_POT.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(CUTTING_BOARD.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(FRYING_PAN.get(), ProcessRender::new);
		event.registerBlockEntityRenderer(STEAMER.get(), ProcessRender::new);
	}
}
