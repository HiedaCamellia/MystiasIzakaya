package org.hiedacamellia.mystiasizakaya.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.common.blockentity.KitchenwareEntity;
import org.hiedacamellia.mystiasizakaya.content.cooking.IKitchenware;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.util.KitchenwareTypeUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class Kitchenware extends BaseEntityBlock implements IKitchenware {

    public static final MapCodec<Kitchenware> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(propertiesCodec(),
                    KitchenwareType.CODEC.fieldOf("KitchenwareType").forGetter(Kitchenware::getKitchenwareType)
            ).apply(instance, Kitchenware::new));

    public KitchenwareType getKitchenwareType() {
        return type;
    }

    private final KitchenwareType type;

    public Kitchenware(BlockBehaviour.Properties properties,KitchenwareType type) {
        super(properties);
        this.type = type;
    }

    public Kitchenware(KitchenwareType type) {
        this(Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f)
                .requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE).noOcclusion(),type);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTicker(level, blockEntityType, KitchenwareTypeUtil.type2BE(getKitchenwareType()));
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(
            Level level, BlockEntityType<T> serverType, BlockEntityType<? extends CookingEntity> clientType
    ) {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, KitchenwareEntity::serverTick);
    }


    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new KitchenwareEntity(pos,state, getKitchenwareType());
    }

    @Override
    protected MapCodec<Kitchenware> codec() {
        return CODEC;
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player entity, @NotNull BlockHitResult hit) {
        super.useWithoutItem(blockstate, level, pos, entity, hit);
        if (entity instanceof ServerPlayer player) {
            player.openMenu(Objects.requireNonNull(getMenuProvider(blockstate, level, pos)), pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CookingEntity be) {
                be.dropItems();
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        //Debug.send(state.getBlock().getDescriptionId());
        return switch (getKitchenwareType()) {
            case CUTTING_BOARD -> Shapes.join(box(1,0,3,15,1,13),box(0,0,0,0,0,0),BooleanOp.FIRST);
            case BOILING_POT -> Shapes.join(box(3,0,3,13,6,13),box(0,0,0,0,0,0), BooleanOp.FIRST);
            case FRYING_PAN -> Shapes.join(box(3,0,1,13,2,11),box(7.25,1,11,8.75,2,17), BooleanOp.OR);
            case STEAMER -> Shapes.join(box(2,0,3,14,4,14),box(0,0,0,0,0,0), BooleanOp.FIRST);
            case GRILL -> Shapes.join(box(1,0,3,15,4,14),box(0,0,0,0,0,0), BooleanOp.FIRST);
            default -> Shapes.block();
        };
    }
}
