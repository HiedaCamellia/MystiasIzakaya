package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares.*;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.ValueRecord;
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
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double time;
        ItemStack util;
        ItemStack target;
        List<String> targets = new ArrayList<>();
        time = GetValue.getDouble(world, Pos.get(x, y, z), "timeleft");
        if (time > 1) {
            if (!world.isClientSide()) {
                BlockPos _bp = Pos.get(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("timeleft", (time - 1));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        } else if (time == 1) {
            if (!world.isClientSide()) {
                BlockPos _bp = Pos.get(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("timeleft", 0);
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            target = GetItemStack.getItemStack(world, Pos.get(x, y, z), 12);
            SetSlotItem.setSlotItem(world, Pos.get(x, y, z), target, 6, 1);

            ValueRecord tags = GetItemStack.getItemStack(world, Pos.get(x, y, z), 12).getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord(""));
            GetItemStack.getItemStack(world, Pos.get(x, y, z), 6).set(DataComponentsReg.Tags.get(), tags);
            
            SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 12);
        } else {
            if (!(GetValue.getBoolean(world, Pos.get(x, y, z), "breaking"))) {
                if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 4).getItem()
                        && !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 5).getItem())) {
                    SetSlotItem.setSlotItem(world, Pos.get(x, y, z),
                            GetItemStack.getItemStack(world, Pos.get(x, y, z), 5), 4, 1);
                    SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 5);
                }
                if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 3).getItem()
                        && !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 4).getItem())) {
                    SetSlotItem.setSlotItem(world, Pos.get(x, y, z),
                            GetItemStack.getItemStack(world, Pos.get(x, y, z), 4), 3, 1);
                    SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 4);
                }
                if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 2).getItem()
                        && !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 3).getItem())) {
                    SetSlotItem.setSlotItem(world,Pos.get(x, y, z),
                            GetItemStack.getItemStack(world, Pos.get(x, y, z), 3), 2, 1);
                    SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 3);
                }
                if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 1).getItem()
                        && !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 2).getItem())) {
                    SetSlotItem.setSlotItem(world, Pos.get(x, y, z),
                            GetItemStack.getItemStack(world, Pos.get(x, y, z), 2), 1, 1);
                    SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 2);
                }

                util = GetItemStack.getItemStack(world, Pos.get(x, y, z), 0);
                if (util.getItem() == ItemStack.EMPTY.getItem()) {
                    SetSlotItem.setSlotItem(world, Pos.get(x, y, z), new ItemStack(ItemRegistery.HEI_AN_WU_ZHI.get()), 12, 1);
                }

				List<String> raws = new ArrayList<>();
				List<ItemStack> ingredients = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    if (!(GetItemStack.getItemStack(world, Pos.get(x, y, z), i).getItem() == ItemStack.EMPTY.getItem())) {
                        ItemStack raw = GetItemStack.getItemStack(world, Pos.get(x, y, z), i);
                        raw = IngredientsCompact.execute(raw);
						ingredients.add(raw);
                        raws.add((Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(raw.getItem())).toString()));
                    }else{
                        ingredients.add(ItemStack.EMPTY);
                    }
                }
                if (util.getItem() == ItemRegistery.LIAO_LI_TAI.get()) {
                    targets = CuttingBoard.get(raws);
                }
                if (util.getItem() == ItemRegistery.SHAO_KAO_JIA.get()) {
                    targets = Grill.get(raws);
                }
                if (util.getItem() == ItemRegistery.YOU_GUO.get()) {
                    targets = FryingPan.get(raws);
                }
                if (util.getItem() == ItemRegistery.ZHENG_GUO.get()) {
                    targets = Steamer.get(raws);
                }
                if (util.getItem() == ItemRegistery.ZHU_GUO.get()) {
                    targets = BoilingPot.get(raws);
                }



                for (int i = 0; i < 5; i++) {
					if (i < targets.size()) {
						ItemStack taget = new ItemStack(Objects.requireNonNull(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((targets.get(i))).toLowerCase(Locale.ENGLISH)))));
						SetSlotItem.setSlotItem(world,Pos.get(x, y, z), BuildTags.execute(taget, util, ingredients), 7 + i, 1);
						//SetSlotItem.setSlotItem(world, x, y, z, new ItemStack(Objects.requireNonNull(BuiltInRegistries.ITEM.getValue(new ResourceLocation(((targets.get((int) i))).toLowerCase(Locale.ENGLISH))))), (int) (7 + i), 1);
					} else {
                        SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 7 + i);
                    }
                }
                SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), 12);

//				ItemStack cuisine = GetItemStack.getItemStack(world, Pos.get(x, y, z), 12);
//				try {
//					cuisine.inventoryTick(null, null, 0, false);
//				} catch (Exception e) {
//                    MystiasIzakaya.LOGGER.atTrace().log("Failed to execute inventoryTick for {}", Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(cuisine.getItem())));
//					MystiasIzakaya.LOGGER.atTrace().log(e);
//				}
//				SetSlotItem.setSlotItem(world, x, y, z, cuisine, 12, 1);


            } else {
                SetSlotItem.setEmptySlot(world, Pos.get(x, y, z), new int[]{7,8,9,10,11,12});
            }
        }
    }
}
