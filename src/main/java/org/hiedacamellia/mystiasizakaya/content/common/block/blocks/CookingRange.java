
package org.hiedacamellia.mystiasizakaya.content.common.block.blocks;

import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Main;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CookingRange extends Block implements EntityBlock {
    public CookingRange() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE));
    }


	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		if (!Screen.hasShiftDown()) {
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			String[] description = Component.translatable("tooltip.mystias_izakaya.cooking_range").getString().split("§n");
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        if(world.getBlockEntity(pos)instanceof CookingRangeEntity cookingRangeEntity){
            cookingRangeEntity.tick(world);
        }
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion e) {
        super.wasExploded(world, pos, e);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        clean(blockEntity);
    }

    @Override
    public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
        super.attack(blockstate, world, pos, entity);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        clean(blockEntity);
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        super.use(blockstate, world, pos, entity, hand, hit);
        if (entity instanceof ServerPlayer player) {
            player.openMenu(getMenuProvider(blockstate,world,pos));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CookingRangeEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CookingRangeEntity be) {
                Containers.dropContents(world, pos, be);
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }


    private static void clean(BlockEntity be) {
        SetSlotItem.setEmptySlot(be, 7);
        SetSlotItem.setEmptySlot(be, 8);
        SetSlotItem.setEmptySlot(be, 9);
        SetSlotItem.setEmptySlot(be, 10);
        SetSlotItem.setEmptySlot(be, 11);
        SetSlotItem.setEmptySlot(be, 12);
    }
}
