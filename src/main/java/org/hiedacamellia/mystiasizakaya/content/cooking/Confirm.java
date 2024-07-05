package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTagFromItemStacks;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTime;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.*;

public class Confirm {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean bool = false;
		double time;
		time = GetValue.getDouble(world, Pos.get(x, y, z), "timeleft");
		ItemStack target;
		ItemStack Kitchenware;
		String raws;
		if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 12)
				.getItem()) && time == 0) {
			target = GetItemStack.getItemStack(world, Pos.get(x, y, z), 12);
			Kitchenware = GetItemStack.getItemStack(world, Pos.get(x, y, z), 0);

			List<String> rawtags = GetTagFromItemStacks.get(world, x, y, z);
			List<String> targettags = target.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("tags").split(","));
			List<String> targetntags = target.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : Arrays.asList(target.getOrCreateTag().getString("ntags").split(","));

			Set<String> set = new LinkedHashSet<>(rawtags);
			targettags.sort(Comparator.naturalOrder());
			set.addAll(targettags);
			ArrayList<String> resultList = new ArrayList<>(set);


			if (!(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 5).getItem())) {
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
			resultList.addAll(Kitchenware.getOrCreateTag().getString("tags").isEmpty() ? List.of() : List.of(Kitchenware.getOrCreateTag().getString("tags").split(",")));
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
				rawslist.add(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(GetItemStack.getItemStack(world, Pos.get(x, y, z), i).getItem())).toString());
			}
			rawslist.sort(Comparator.naturalOrder());
			raws = String.join(",",rawslist);

			if (!world.isClientSide()) {
				BlockPos _bp = Pos.get(x, y, z);
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
