package org.hiedacamellia.mystiasizakaya.content.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingUiMenu;
import org.hiedacamellia.mystiasizakaya.content.cooking.CookingUtils;
import org.hiedacamellia.mystiasizakaya.content.cooking.IKitchenware;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.IntStream;

public abstract class CookingEntity extends RandomizableContainerBlockEntity implements WorldlyContainer,IKitchenware {
    protected NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(7, ItemStack.EMPTY);
    private final SidedInvWrapper handler = new SidedInvWrapper(this, null);
    private int cookTime = 0;
    private int cookTimeTotal = 0;
    private ItemStack result = ItemStack.EMPTY;
    private ContainerData containerData = new SimpleContainerData(2);

    public CookingEntity(BlockPos position, BlockState state) {
        super(MIBlockEntitiy.COOKING_RANGE.get(), position, state);
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(compound, lookupProvider);
        if (!this.tryLoadLootTable(compound))
            this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
        cookTime = compound.getInt("CookTime");
        cookTimeTotal = compound.getInt("CookTimeTotal");
        result = ItemStack.parse(lookupProvider, compound.getCompound("Result")).orElse(ItemStack.EMPTY);
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(compound, lookupProvider);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
        }
        compound.putInt("CookTime", cookTime);
        compound.putInt("CookTimeTotal", cookTimeTotal);
        if(!result.isEmpty())
            compound.put("Result", result.save(lookupProvider));
    }

    public void applyRecipe(int id){
        KitchenwareType kitchenwareType = getKitchenwareType();
        List<ItemStack> itemStacks = stacks.subList(1, 6);
        List<ItemStack> availableCuisines = CookingUtils.getAvailableCuisines(level, itemStacks, kitchenwareType);
        if(id<availableCuisines.size()){
            applyRecipe(availableCuisines.get(id));
        }
    }

    protected void applyRecipe(ItemStack stack){
        resetCooking();
        cookTimeTotal = stack.get(MIDatacomponet.MI_COOKTIME).cooktime();
        containerData.set(1, cookTimeTotal);
        containerData.set(0, 0);
        result = stack;
        stacks.get(1).consume(1,null);
        stacks.get(2).consume(1,null);
        stacks.get(3).consume(1,null);
        stacks.get(4).consume(1,null);
        stacks.get(5).consume(1,null);
        setChanged();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CookingEntity blockEntity){
        blockEntity.serverTick();
    }

    protected void serverTick(){
        if(cookTimeTotal==0)return;
        if(cookTime < cookTimeTotal){
            cookTime++;
            containerData.set(0, cookTime);
        } else {
            stacks.set(6, result);
            setChanged();
            resetCooking();
        }
    }

    protected void resetCooking() {
        cookTime = 0;
        cookTimeTotal = 0;
        containerData.set(0, 0);
        containerData.set(1, 0);
        result = ItemStack.EMPTY;
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
        return Component.literal("cooking");
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
        return new CookingUiMenu(id, inventory, null,handler,containerData,this.worldPosition);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Cooking");
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
        return index != 6;
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return index != 6;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction) {
        return true;
    }

    public void dropItems() {
        Containers.dropContents(level, worldPosition, this);
    }

    public SidedInvWrapper getItemHandler() {
        return handler;
    }
}
