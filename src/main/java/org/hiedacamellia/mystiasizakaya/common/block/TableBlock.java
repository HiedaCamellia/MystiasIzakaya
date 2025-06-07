
package org.hiedacamellia.mystiasizakaya.common.block;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.core.util.MIMessageUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TableBlock extends Block implements EntityBlock {

	public TableBlock() {
		super(Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		if (!Screen.hasShiftDown()) {
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			String[] description = Component.translatable("tooltip.mystias_izakaya.table").getString().split("§n");
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
	public MenuProvider getMenuProvider(@NotNull BlockState state, Level level, @NotNull BlockPos pos) {
		BlockEntity tileEntity = level.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player entity, @NotNull BlockHitResult hit) {
		super.useWithoutItem(blockstate, level, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			if(!ItemStack.isSameItem(player.getMainHandItem(),MIItem.LEDGER.get().getDefaultInstance())) {
				player.openMenu(Objects.requireNonNull(getMenuProvider(blockstate, level, pos)), pos);
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {

		if (player instanceof ServerPlayer serverPlayer) {
			if(ItemStack.isSameItem(serverPlayer.getMainHandItem(),MIItem.LEDGER.get().getDefaultInstance())) {
				List<BlockPos> blockPosList = MIPlayerUtil.getTables(player);
				if (blockPosList.size() < 8) {
					blockPosList.add(new BlockPos(-1, -1, -1));
				}

				for (int i = 0; i < blockPosList.size(); i++) {
					BlockPos pos = blockPosList.get(i);
					if (pos.equals(blockPos)) {
						blockPosList.set(i, new BlockPos(-1, -1, -1));
						MIMessageUtil.send(Component.translatable("message.mystias_izakaya.table.unbound",i+1,blockPos.getX(),blockPos.getY(),blockPos.getZ()),player);
						break;
					}
					if (pos.equals(new BlockPos(-1, -1, -1))) {
						blockPosList.set(i, blockPos);
						MIMessageUtil.send(Component.translatable("message.mystias_izakaya.table.bound",i+1,blockPos.getX(),blockPos.getY(),blockPos.getZ()),player);
						break;
					}
				}
				MIPlayerUtil.setTables(player, blockPosList);
				MIPlayerUtil.syncTables(player);

				return ItemInteractionResult.SUCCESS;
			}
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return new TableEntity(pos, state);
	}

}
