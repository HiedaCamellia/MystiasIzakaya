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
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.KitchenwaresUiMenu;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public abstract class KitchenwaresEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(13, ItemStack.EMPTY);
    private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

    public KitchenwaresEntity(BlockEntityType<?> type, BlockPos position, BlockState state) {
        super(type, position, state);
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
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
        return new KitchenwaresUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
    }

    @Override
    @NotNull
    public NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

    @Override
    public boolean canPlaceItem(int index, @NotNull ItemStack stack) {
        return switch (index) {
            case 0,6, 7, 8, 9, 10, 11, 12 -> false;
            default -> true;
        };
    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction side) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack stack, @Nullable Direction side) {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction) {
        return switch (index) {
            case 0,7, 8, 9, 10, 11, 12 -> false;
            default -> true;
        };
    }


    public SidedInvWrapper getItemHandler() {
        return handler;
    }

    public ItemStack getItem(int index) {
        return this.stacks.get(index);
    }

}
