package org.hiedacamellia.mystiasizakaya.content.common.block.entities;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.TableUiMenu;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class TableEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
	private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

	public TableEntity(BlockPos position, BlockState state) {
		super(MIBlockEntitiy.TABLE.get(), position, state);
	}

	@Override
	public void loadAdditional(@NotNull CompoundTag compound, HolderLookup.@NotNull Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
	}

	@Override
	public void saveAdditional(@NotNull CompoundTag compound, HolderLookup.@NotNull Provider lookupProvider) {
		super.saveAdditional(compound, lookupProvider);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
		}
	}


	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}


	@Override
	public @NotNull Component getDefaultName() {
		return Component.literal("table");
	}

	@Override
	public int getMaxStackSize() {
		return 1;
	}

	@Override
	public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
		return new TableUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.literal("Table");
	}

	@Override
	public @NotNull NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(@NotNull NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}


	public SidedInvWrapper getItemHandler() {
		return handler;
	}

	@Override
	public int[] getSlotsForFace(Direction direction) {
		return new int[]{0, 1};
	}

	@Override
	public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
		return true;
	}

	@Override
	public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
		return true;
	}
}
