package org.hiedacamellia.mystiasizakaya.content.common.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.HashMap;
import java.util.Map;

public class CookingMenu extends BaseMenu {

    private int size = 7;
    private BlockEntity boundEntity;
    public final Map<Integer, Slot> customSlots = new HashMap<>();
    public BlockPos pos;
    public Level level;
    public ContainerData data;

    public CookingMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
        this(containerId, inventory, ContainerLevelAccess.NULL,buf.readBlockPos());
    }

    public CookingMenu(int containerId, Inventory inventory, BlockPos pos) {
        this(containerId, inventory, ContainerLevelAccess.NULL,pos);
    }

    public CookingMenu(int containerId, Inventory inventory, ContainerLevelAccess access, BlockPos pos) {
        this(containerId, inventory, access, new ItemStackHandler(10), new SimpleContainerData(9),pos);
    }

    public CookingMenu(int id, Inventory inv, ContainerLevelAccess access, IItemHandler itemHandler, ContainerData containerData, BlockPos pos) {
        super(MIMenu.COOKING_UI.get(), id);
        this.level = inv.player.level();
        this.boundEntity = level.getBlockEntity(pos);
        this.pos = pos;
        this.data = containerData;

        int start_x =  200 / 2 - 18 * 9 / 2 ;
        int start_y = 100;

        if(showKitchenWare()) {
            this.customSlots.put(0, this.addSlot(new SlotItemHandler(itemHandler, 0, start_x + 7 * 18, start_y - 22) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.is(MITag.kitchenwaresKey);
                }
            }));
            size = 7;
        }

        this.customSlots.put(1, this.addSlot(new SlotItemHandler(itemHandler, 1, start_x, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey)|| MICommonConfig.ENABLE_ALL_INGREDIENTS.get();
            }
        }));
        this.customSlots.put(2, this.addSlot(new SlotItemHandler(itemHandler, 2, start_x + 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey)|| MICommonConfig.ENABLE_ALL_INGREDIENTS.get();
            }
        }));
        this.customSlots.put(3, this.addSlot(new SlotItemHandler(itemHandler, 3, start_x + 2 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey)|| MICommonConfig.ENABLE_ALL_INGREDIENTS.get();
            }
        }));
        this.customSlots.put(4, this.addSlot(new SlotItemHandler(itemHandler, 4, start_x + 3 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey)|| MICommonConfig.ENABLE_ALL_INGREDIENTS.get();
            }
        }));
        this.customSlots.put(5, this.addSlot(new SlotItemHandler(itemHandler, 5, start_x + 4 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.ingredientsKey)|| MICommonConfig.ENABLE_ALL_INGREDIENTS.get();
            }
        }));

        this.customSlots.put(6, this.addSlot(new SlotItemHandler(itemHandler, 6, start_x + 9 * 18, start_y - 22){
            @Override public boolean mayPlace(ItemStack stack) {
                return false;
            }
        }));


        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(inv, sj + (si + 1) * 9, start_x + sj * 18,  start_y + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(inv, si, start_x + si * 18, 2 + start_y + 3 * 18));

        this.addDataSlots(data);
    }

    public boolean showKitchenWare() {
        return boundEntity instanceof CookingRangeEntity;
    }

    public KitchenwareType getKitchenwareType() {
        if(boundEntity instanceof CookingEntity cookingEntity){
            return cookingEntity.getKitchenwareType();
        }
        return KitchenwareType.NONE;
    }

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    public boolean stillValid(Player player) {
        return !this.boundEntity.isRemoved();
    }
}
