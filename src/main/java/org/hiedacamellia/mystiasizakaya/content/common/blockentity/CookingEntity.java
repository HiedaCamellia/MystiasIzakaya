package org.hiedacamellia.mystiasizakaya.content.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.CookingProcessW2SWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.ExistW2SWidget;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingMenu;
import org.hiedacamellia.mystiasizakaya.content.cooking.CookingUtils;
import org.hiedacamellia.mystiasizakaya.content.cooking.IKitchenware;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.network.CookingProgressS2SMessage;
import org.hiedacamellia.mystiasizakaya.core.network.CookingRemoveS2SMessage;
import org.hiedacamellia.mystiasizakaya.core.network.CookingStartS2CMessage;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.util.KitchenwareTypeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public abstract class CookingEntity extends RandomizableContainerBlockEntity implements WorldlyContainer,IKitchenware {
    protected NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(7, ItemStack.EMPTY);
    private final SidedInvWrapper handler = new SidedInvWrapper(this, null);
    private int cookTime;
    private int cookTimeTotal;
    private ItemStack result = ItemStack.EMPTY;
    private final ContainerData containerData = new SimpleContainerData(2);
    private UUID w2sUUID;

    private boolean last;

    public void setW2sUUID(UUID w2sUUID) {
        this.w2sUUID = w2sUUID;
    }

    public ItemStack getResult() {
        return result;
    }

    public CookingEntity(BlockEntityType<?> type, BlockPos position, BlockState state) {
        super(type, position, state);
        this.w2sUUID = UUID.randomUUID();
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(compound, lookupProvider);
        ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
        cookTime = compound.getInt("CookTime");
        cookTimeTotal = compound.getInt("CookTimeTotal");
        result = ItemStack.parse(lookupProvider, compound.getCompound("Result")).orElse(ItemStack.EMPTY);
        w2sUUID = compound.getUUID("W2SUUID");
        last = compound.getBoolean("Last");
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(compound, lookupProvider);
        ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
        compound.putInt("CookTime", cookTime);
        compound.putInt("CookTimeTotal", cookTimeTotal);
        if(!result.isEmpty())
            compound.put("Result", result.save(lookupProvider));
        compound.putUUID("W2SUUID", w2sUUID);
        compound.putBoolean("Last", last);
    }

    public void applyRecipe(int id){
        KitchenwareType kitchenwareType = getKitchenwareType();
        List<ItemStack> itemStacks = stacks.subList(1, 6);
        List<ItemStack> availableCuisines = CookingUtils.getAvailableCuisines(this,level, itemStacks, kitchenwareType);
        if(id<availableCuisines.size()){
            applyRecipe(availableCuisines.get(id));
        }
    }

    protected ItemStack getKitchenware(){
        return stacks.get(0);
    }

    protected void applyRecipe(ItemStack stack){
        resetCooking();
        cookTimeTotal = stack.get(MIDatacomponet.MI_COOKTIME).cooktime();
        containerData.set(1, cookTimeTotal);
        containerData.set(0, 0);
        ItemStack util = getKitchenware().isEmpty()?KitchenwareTypeUtil.type2Stack(getKitchenwareType()):getKitchenware();
        result = CookingUtils.buildTag(this,level, stack, util ,stacks.subList(1, 6));
        stacks.get(1).consume(1,null);
        stacks.get(2).consume(1,null);
        stacks.get(3).consume(1,null);
        stacks.get(4).consume(1,null);
        stacks.get(5).consume(1,null);
        setChanged();
        PacketDistributor.sendToAllPlayers(new CookingStartS2CMessage(worldPosition,w2sUUID,BuiltInRegistries.ITEM.getKey(result.getItem())));
    }

    @OnlyIn(Dist.CLIENT)
    public void addW2S(ResourceLocation location){
        CookingProcessW2SWidget widget = new CookingProcessW2SWidget(w2sUUID, this,location);
        ExistW2SWidget.add(w2sUUID,widget);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CookingEntity blockEntity){
        blockEntity.serverTick();
    }

    protected void serverTick(){
        if(cookTimeTotal==0)return;
        if(cookTime < cookTimeTotal){
            cookTime++;
            containerData.set(0, cookTime);
            PacketDistributor.sendToAllPlayers(new CookingProgressS2SMessage(w2sUUID,cookTime,cookTimeTotal));
        } else {
            stacks.set(6, CookingUtils.check(this,level,result));
            last=true;
            setChanged();
            resetCooking();
        }

        if(last&&stacks.get(6).isEmpty()&&result.isEmpty()){
            PacketDistributor.sendToAllPlayers(new CookingRemoveS2SMessage(w2sUUID));
            last=false;
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
        return new CookingMenu(id, inventory, null,handler,containerData,this.worldPosition);
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
