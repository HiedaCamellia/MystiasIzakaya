package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.*;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;

import java.util.*;

public class Confirm {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean bool = false;
		double time;
		time = GetValue.getDouble(world, BlockPos.containing(x, y, z), "timeleft");
		ItemStack target;
		ItemStack Kitchenware;
		String raws;
		if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12)
				.getItem()) && time == 0) {
			target = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
			Kitchenware = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0);
			List<String> rawtags = GetTagFromItemStacks.execute(world, x, y, z);
			List<String> targettags = GetTargetTags.execute(target,Kitchenware.getItem());
			List<String> targetntags = GetTargetNagetivetags.execute(target,Kitchenware.getItem());

			Set<String> set = new LinkedHashSet<>(rawtags);
			set.addAll(targettags);
			ArrayList<String> resultList = new ArrayList<>(set);


			if (!(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 5)
					.getItem())) {
				resultList.add("tag.mystias_izakaya.Large_Portion");
                resultList.remove("tag.mystias_izakaya.Small_Portion");
			}
			if (resultList.contains("tag.mystias_izakaya.Meat")) {
				resultList.remove("tag.mystias_izakaya.Vegetarian");
			}
			if (resultList.contains("tag.mystias_izakaya.Filling")) {
				resultList.remove("tag.mystias_izakaya.Good_With_Alcohol");
			}
			if (resultList.contains("tag.mystias_izakaya.Greasy")) {
				resultList.remove("tag.mystias_izakaya.Mild");
			}
			if (resultList.contains("tag.mystias_izakaya.Hot")) {
				resultList.remove("tag.mystias_izakaya.Refreshing");
			}
			resultList.add(GetKitchenwareTag.execute(Kitchenware));
			String resultString = String.join(",", resultList);
			Set<String> seti = new HashSet<>(resultList);
			for (String str : targetntags) {
				if (seti.contains(str)) {
					bool = true;
					break;
				}
			}
			ArrayList<String> rawslist = new ArrayList<>();
			for (int i = 1; i < 6; i++) {
				rawslist.add(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), i).getItem())).toString());
			}
			// 使用StringBuilder来构建字符串
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < rawslist.size(); i++) {
				sb.append(rawslist.get(i));
				if (i < rawslist.size() - 1) {
					sb.append(","); // 在最后一个元素之后不添加逗号
				}
			}

			raws = sb.toString();
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", GetTime.execute(target,Kitchenware.getItem()));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (bool) {
				SetSlotItem.setSlotItem(world, x, y, z, new ItemStack(ItemRegistery.HEI_AN_WU_ZHI.get()), 12, 1);
			} else {
				target.getOrCreateTag().putString("tags", resultString);
				target.getOrCreateTag().putString("ingredients", raws);
				SetSlotItem.setSlotItem(world, x, y, z, target, 12, 1);
			}
			SetSlotItem.setEmptySlot(world, x, y, z, 1);
			SetSlotItem.setEmptySlot(world, x, y, z, 2);
			SetSlotItem.setEmptySlot(world, x, y, z, 3);
			SetSlotItem.setEmptySlot(world, x, y, z, 4);
			SetSlotItem.setEmptySlot(world, x, y, z, 5);
			SetSlotItem.setEmptySlot(world, x, y, z, 7);
			SetSlotItem.setEmptySlot(world, x, y, z, 8);
			SetSlotItem.setEmptySlot(world, x, y, z, 9);
			SetSlotItem.setEmptySlot(world, x, y, z, 10);
			SetSlotItem.setEmptySlot(world, x, y, z, 11);
		}
	}
}
