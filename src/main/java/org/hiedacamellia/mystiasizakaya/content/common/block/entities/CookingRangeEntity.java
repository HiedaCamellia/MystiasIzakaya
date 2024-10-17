package org.hiedacamellia.mystiasizakaya.content.common.block.entities;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.Main;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class CookingRangeEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	public NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(13, ItemStack.EMPTY);
	public int timeLeft ;
	public int page ;
	public int targets ;
	public int totalTime;

	public CookingRangeEntity(BlockPos position, BlockState state) {
		super(MIBlockEntitiy.COOKING_RANGE, position, state);
		timeLeft = 0;
		page = 0;
		targets = 0;
		totalTime = 0;
	}

	public void tick(ServerLevel world){
		Main.execute(world, this.worldPosition);
		if(timeLeft>1)
			timeLeft--;
		if(timeLeft==1){
			timeLeft=0;
			stacks.set(6,stacks.get(12));
			stacks.set(12,ItemStack.EMPTY);
		}
	}



	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		timeLeft = compound.getInt("timeLeft");
		page = compound.getInt("page");
		targets = compound.getInt("targets");
		totalTime = compound.getInt("totalTime");
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putInt("timeLeft", timeLeft);
		compound.putInt("page", page);
		compound.putInt("targets", targets);
		compound.putInt("totalTime", totalTime);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
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
	public Component getDefaultName() {
		return Component.literal("cooking_range");
	}

	@Override
	public int getMaxStackSize() {
		return 1;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new CookingRangeUiMenu(id, inventory, this.worldPosition, this);
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Cooking Range");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		switch (index){
			case 6,7,8,9,10,11,12 -> {
				return false;
			}
			default -> {
				return true;
			}
		}
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		//if(index==0)

		return false;

		//return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return index == 6;
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
	}
}
