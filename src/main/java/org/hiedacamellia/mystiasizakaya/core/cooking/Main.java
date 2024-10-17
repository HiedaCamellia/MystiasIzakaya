package org.hiedacamellia.mystiasizakaya.core.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.KitchenwaresEntity;
import org.hiedacamellia.mystiasizakaya.core.cooking.get.GetTargets;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {
    public static void execute(LevelAccessor world, BlockPos pos) {
        ItemStack util;
        //Debug.getLogger().error("execute");
        {
            util = GetItemStack.getItemStack(world, pos, 0);

            //Debug.getLogger().error(util.getDescriptionId());
            if (ItemStack.isSameItem(util,ItemStack.EMPTY)||util.isEmpty()) {
                if(ItemStack.isSameItem(util,MIItem.CUTTING_BOARD.getDefaultInstance())){
                    util = MIItem.CUTTING_BOARD.getDefaultInstance();
                }
                if(ItemStack.isSameItem(util,MIItem.BOILING_POT.getDefaultInstance())){
                    util = MIItem.BOILING_POT.getDefaultInstance();
                }
                if(ItemStack.isSameItem(util,MIItem.FRYING_PAN.getDefaultInstance())){
                    util = MIItem.FRYING_PAN.getDefaultInstance();
                }
                if(ItemStack.isSameItem(util,MIItem.STEAMER.getDefaultInstance())){
                    util = MIItem.STEAMER.getDefaultInstance();
                }
                if(ItemStack.isSameItem(util,new ItemStack(MIItem.GRILL))){
                    util = new ItemStack(MIItem.GRILL);
                }
            }
            //Debug.getLogger().error(util.getDescriptionId());

            List<String> raws = new ArrayList<>();
            List<ItemStack> ingredients = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                if (!(GetItemStack.getItemStack(world, pos, i).getItem() == ItemStack.EMPTY.getItem())) {
                    ItemStack raw = GetItemStack.getItemStack(world, pos, i);
                    ingredients.add(raw);
                    raws.add((Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(raw.getItem())).toString()));
                } else {
                    ingredients.add(ItemStack.EMPTY);
                }
            }

            List<String> targets = GetTargets.getTargets(raws, util);
//            Debug.getLogger().error(targets.toString());
            if (!world.isClientSide()) {
                BlockPos _bp = pos;
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
                        cookingRangeEntity.targets = targets.size();
                    if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
                        kitchenwaresEntity.targets = targets.size();
                }
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            int page =0;

            BlockEntity _blockEntity = world.getBlockEntity(pos);
            if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
                page = cookingRangeEntity.page;
            if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
                page = kitchenwaresEntity.page;

            for (int i = 0; i < 5; i++) {
                if (i < targets.size()) {
                    ItemStack taget = new ItemStack(Objects.requireNonNull(BuiltInRegistries.ITEM.get(new ResourceLocation(((targets.get(i + page))).toLowerCase(Locale.ENGLISH)))));
                    SetSlotItem.setSlotItem(world, pos, BuildTags.execute(taget, util, ingredients), 7 + i, 1);
                } else {
                    SetSlotItem.setEmptySlot(world, pos, 7 + i);
                }
            }

        }
    }

    private static void resetpage(LevelAccessor world, BlockPos ps) {
        if (!world.isClientSide()) {
            BlockEntity _blockEntity = world.getBlockEntity(ps);
            BlockState _bs = world.getBlockState(ps);
            if (_blockEntity != null) {
                if (_blockEntity instanceof CookingRangeEntity cookingRangeEntity)
                    cookingRangeEntity.page = 0;
                if (_blockEntity instanceof KitchenwaresEntity kitchenwaresEntity)
                    kitchenwaresEntity.page = 0;
            }
            if (world instanceof Level _level)
                _level.sendBlockUpdated(ps, _bs, _bs, 3);
        }
    }
}
