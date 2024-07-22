package org.hiedacamellia.mystiasizakaya.content.block.entities;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;
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
import org.hiedacamellia.mystiasizakaya.content.block.BlockEntities;
import org.hiedacamellia.mystiasizakaya.functionals.inventory.CookingRangeUiMenu;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class CookingRange extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(13, ItemStack.EMPTY);
	private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

	public CookingRange(BlockPos position, BlockState state) {
		super(BlockEntities.COOKING_RANGE.get(), position, state);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
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
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
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
		return Component.literal("cooking_range");
	}

	@Override
	public int getMaxStackSize() {
		return 1;
	}

	@Override
	public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
		return new CookingRangeUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.literal("Cooking Range");
	}

	@Override
	protected @NotNull NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(@NotNull NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, @NotNull ItemStack stack) {
		return switch (index) {
			case 6,7, 8, 9, 10, 11, 12 -> false;
			default -> true;
		};
	}

	@Override
	public int @NotNull [] getSlotsForFace(@NotNull Direction side) {
		if(side==Direction.DOWN)
			return new int[]{6};
		return new int[]{};
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack stack, @Nullable Direction side) {
		if(side!=Direction.DOWN)
			return this.canPlaceItem(index, stack);
		return false;
	}

	@Override
	public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction) {
        return switch (index) {
            case 7, 8, 9, 10, 11, 12 -> false;
            default -> true;
        };
	}


	public SidedInvWrapper getItemHandler() {
		return handler;
	}
}
