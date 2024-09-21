
package org.hiedacamellia.mystiasizakaya.content.common.block.blocks;

import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.TableUiMenu;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableBlock extends Block implements EntityBlock {


	public TableBlock() {
		super(Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().pushReaction(PushReaction.IGNORE).noOcclusion());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
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
	public InteractionResult use(BlockState blockstate, Level world, BlockPos blockPos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, blockPos, entity,hand, hit);
		if (entity instanceof ServerPlayer player) {
			if(!ItemStack.isSameItem(player.getMainHandItem(), MIItem.LEDGER.get().getDefaultInstance())) {
				NetworkHooks.openScreen(player,new MenuProvider() {
					@Override
					public @NotNull Component getDisplayName() {
						return Component.literal("Table");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
						return new TableUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
					}
				}, blockPos);
			}
			if(ItemStack.isSameItem(player.getMainHandItem(),MIItem.LEDGER.get().getDefaultInstance())) {
				List<BlockPos> blockPosList = new ArrayList<>(MIPlayerEvent.getTables(player));
				if (blockPosList.size() < 8) {
					blockPosList.add(new BlockPos(-1, -1, -1));
				}

				for (int i = 0; i < blockPosList.size(); i++) {
					BlockPos pos = blockPosList.get(i);
					if (pos.equals(blockPos)) {
						blockPosList.set(i, new BlockPos(-1, -1, -1));
						player.sendSystemMessage(Component.translatable("message.mystias_izakaya.table.unbound",i+1,blockPos.getX(),blockPos.getY(),blockPos.getZ()));
						break;
					}
					if (pos.equals(new BlockPos(-1, -1, -1))) {
						blockPosList.set(i, blockPos);
						player.sendSystemMessage(Component.translatable("message.mystias_izakaya.table.bound",i+1,blockPos.getX(),blockPos.getY(),blockPos.getZ()));
						break;
					}
				}

				MIPlayerEvent.setTables(player, blockPosList);

				//Debug.getLogger().debug("Table: " + blockPosList);

				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}



	@Override
	public MenuProvider getMenuProvider(@NotNull BlockState state, Level worldIn, @NotNull BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return new TableEntity(pos, state);
	}

}
