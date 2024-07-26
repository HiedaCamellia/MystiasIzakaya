package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTargets;
import org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares.*;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming.IngredientsCompact;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {
    public static void execute(LevelAccessor world, BlockPos pos) {
        double time;
        ItemStack util;
        ItemStack target;
        time = GetValue.getDouble(world, pos, "timeleft");
        if (time > 1) {
            if (!world.isClientSide()) {
                BlockPos _bp = pos;
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("timeleft", (time - 1));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        } else if (time == 1) {
            if (!world.isClientSide()) {
                BlockPos _bp = pos;
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("timeleft", 0);
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            target = GetItemStack.getItemStack(world, pos, 12);
            SetSlotItem.setSlotItem(world, pos, target, 6, 1);
            GetItemStack.getItemStack(world, pos, 6).getOrCreateTag().putString("tags",
                    (GetItemStack.getItemStack(world, pos, 12).getOrCreateTag()
                            .getString("tags")));
            SetSlotItem.setEmptySlot(world, pos, 12);
        } else {
            if (!(GetValue.getBoolean(world, pos, "breaking"))) {

                if (ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 4)
                        && !(ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 5))) {
                    SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, 5), 4, 1);
                    SetSlotItem.setEmptySlot(world, pos, 5);
                    resetpage(world, pos);
                }
                if (ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 3)
                        && !(ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 4))) {
                    SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, 4), 3, 1);
                    SetSlotItem.setEmptySlot(world, pos, 4);
                    resetpage(world, pos);
                }
                if (ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 2)
                        && !(ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 3))) {
                    SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, 3), 2, 1);
                    SetSlotItem.setEmptySlot(world, pos, 3);
                    resetpage(world, pos);
                }
                if (ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 1)
                        && !(ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 2))) {
                    SetSlotItem.setSlotItem(world, pos, GetItemStack.getItemStack(world, pos, 2), 1, 1);
                    SetSlotItem.setEmptySlot(world, pos, 2);
                    resetpage(world, pos);
                }

                util = GetItemStack.getItemStack(world, pos, 0);
                /*
                if (util.getItem() == ItemStack.EMPTY.getItem()) {
                    SetSlotItem.setSlotItem(world, pos, new ItemStack(ItemRegistery.HEI_AN_WU_ZHI.get()), 12, 1);
                }*/

                int page = GetValue.getInt(world, pos, "page");

				List<String> raws = new ArrayList<>();
				List<ItemStack> ingredients = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    if (!(GetItemStack.getItemStack(world, pos, i).getItem() == ItemStack.EMPTY.getItem())) {
                        ItemStack raw = GetItemStack.getItemStack(world, pos, i);
                        raw = IngredientsCompact.execute(raw);
						ingredients.add(raw);
                        raws.add((Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(raw.getItem())).toString()));
                    }else{
                        ingredients.add(ItemStack.EMPTY);
                    }
                }

                List<String> targets = GetTargets.getTargets(raws, util);

                if (!world.isClientSide()) {
                    BlockPos _bp = pos;
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("targets", targets.size());
                    }
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }




                for (int i = 0; i < 5; i++) {
					if (i < targets.size()) {
						ItemStack taget = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((targets.get(i+page))).toLowerCase(Locale.ENGLISH)))));
						SetSlotItem.setSlotItem(world, pos, BuildTags.execute(taget, util, ingredients), 7 + i, 1);
						//SetSlotItem.setSlotItem(world, pos, new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((targets.get((int) i))).toLowerCase(Locale.ENGLISH))))), (int) (7 + i), 1);
					} else {
                        SetSlotItem.setEmptySlot(world, pos, 7 + i);
                    }
                }



            } else {
                SetSlotItem.setEmptySlot(world, pos, 7);
                SetSlotItem.setEmptySlot(world, pos, 8);
                SetSlotItem.setEmptySlot(world, pos, 9);
                SetSlotItem.setEmptySlot(world, pos, 10);
                SetSlotItem.setEmptySlot(world, pos, 11);
                SetSlotItem.setEmptySlot(world, pos, 12);
            }
        }
    }

    private static void resetpage(LevelAccessor world, BlockPos ps){
        if (!world.isClientSide()) {
            BlockEntity _blockEntity = world.getBlockEntity(ps);
            BlockState _bs = world.getBlockState(ps);
            if (_blockEntity != null) {
                _blockEntity.getPersistentData().putInt("page", 0);
            }
            if (world instanceof Level _level)
                _level.sendBlockUpdated(ps, _bs, _bs, 3);
        }
    }
}
