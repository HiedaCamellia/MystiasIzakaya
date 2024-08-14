package org.hiedacamellia.mystiasizakaya.content.common.block.blocks;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRange;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.*;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.KitchenwaresUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Init;
import org.hiedacamellia.mystiasizakaya.core.cooking.Main;
import org.jetbrains.annotations.NotNull;

public class Kitchenwares extends RotatedPillarBlock implements EntityBlock {
    public Kitchenwares() {
        super(Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f)
                .requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE).noOcclusion());
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return switch (state.getBlock().getDescriptionId()) {
            case "block.mystias_izakaya.cutting_board" -> new CuttingBoard(pos, state);
            case "block.mystias_izakaya.boiling_pot" -> new BoilingPot(pos, state);
            case "block.mystias_izakaya.frying_pan" -> new FryingPan(pos, state);
            case "block.mystias_izakaya.steamer" -> new Steamer(pos, state);
            case "block.mystias_izakaya.grill" -> new Grill(pos, state);
            default -> new CookingRange(pos, state);
        };
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
        if (!world.isClientSide()) {
            BlockEntity _blockEntity = world.getBlockEntity(pos);
            BlockState _bs = world.getBlockState(pos);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putBoolean("breaking", false);
            world.sendBlockUpdated(pos, _bs, _bs, 3);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 1);
        Init.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRange be) {
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        Main.execute(world, pos,blockstate);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        //Debug.send(state.getBlock().getDescriptionId());
        return switch (state.getBlock().getDescriptionId()) {
            case "block.mystias_izakaya.cutting_board" -> Shapes.join(box(1,0,3,15,1,13),box(0,0,0,0,0,0),BooleanOp.FIRST);
            case "block.mystias_izakaya.boiling_pot" -> Shapes.block();
            case "block.mystias_izakaya.frying_pan" -> Shapes.join(box(3,0,1,13,2,11),box(7.25,1,11,8.75,2,17), BooleanOp.OR);
            case "block.mystias_izakaya.steamer" -> Shapes.block();
            case "block.mystias_izakaya.grill" -> Shapes.join(box(1,0,3,15,4,14),box(0,0,0,0,0,0), BooleanOp.FIRST);
            default -> Shapes.block();
        };
    }
}
