package org.hiedacamellia.mystiasizakaya.content.common.block;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
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
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.*;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.KitchenwaresUiMenu;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class Kitchenwares extends BaseEntityBlock {

    public static final MapCodec<Kitchenwares> CODEC = simpleCodec(Kitchenwares::new);

    public Kitchenwares(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public Kitchenwares() {
        this(Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f)
                .requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE).noOcclusion());
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return switch (state.getBlock().getDescriptionId()) {
            case "block.mystias_izakaya.cutting_board" -> createTicker(level, blockEntityType, MIBlockEntitiy.CUTTING_BOARD.get());
            case "block.mystias_izakaya.boiling_pot" -> createTicker(level, blockEntityType, MIBlockEntitiy.BOILING_POT.get());
            case "block.mystias_izakaya.frying_pan" ->createTicker(level, blockEntityType, MIBlockEntitiy.FRYING_PAN.get());
            case "block.mystias_izakaya.steamer" -> createTicker(level, blockEntityType, MIBlockEntitiy.STEAMER.get());
            case "block.mystias_izakaya.grill" -> createTicker(level, blockEntityType, MIBlockEntitiy.GRILL.get());
            default -> null;
        };
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(
            Level level, BlockEntityType<T> serverType, BlockEntityType<? extends KitchenwaresEntity> clientType
    ) {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, KitchenwaresEntity::serverTick);
    }


    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return switch (state.getBlock().getDescriptionId()) {
            case "block.mystias_izakaya.cutting_board" -> new CuttingBoard(pos, state);
            case "block.mystias_izakaya.boiling_pot" -> new BoilingPot(pos, state);
            case "block.mystias_izakaya.frying_pan" -> new FryingPan(pos, state);
            case "block.mystias_izakaya.steamer" -> new Steamer(pos, state);
            case "block.mystias_izakaya.grill" -> new Grill(pos, state);
            default -> new CookingRangeEntity(pos, state);
        };
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull BlockHitResult hit) {
        super.useWithoutItem(blockstate, world, pos, entity, hit);
        if (entity instanceof ServerPlayer player) {
            player.openMenu(new MenuProvider() {
                @Override
                public @NotNull Component getDisplayName() {
                    return Component.literal("Kitchenware");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
                    return new KitchenwaresUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                }
            }, pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof KitchenwaresEntity be) {
                be.dropItems();
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        //Debug.send(state.getBlock().getDescriptionId());
        return switch (state.getBlock().getDescriptionId()) {
            case "block.mystias_izakaya.cutting_board" -> Shapes.join(box(1,0,3,15,1,13),box(0,0,0,0,0,0),BooleanOp.FIRST);
            case "block.mystias_izakaya.boiling_pot" -> Shapes.join(box(3,0,3,13,6,13),box(0,0,0,0,0,0), BooleanOp.FIRST);
            case "block.mystias_izakaya.frying_pan" -> Shapes.join(box(3,0,1,13,2,11),box(7.25,1,11,8.75,2,17), BooleanOp.OR);
            case "block.mystias_izakaya.steamer" -> Shapes.join(box(2,0,3,14,4,14),box(0,0,0,0,0,0), BooleanOp.FIRST);
            case "block.mystias_izakaya.grill" -> Shapes.join(box(1,0,3,15,4,14),box(0,0,0,0,0,0), BooleanOp.FIRST);
            default -> Shapes.block();
        };
    }
}
