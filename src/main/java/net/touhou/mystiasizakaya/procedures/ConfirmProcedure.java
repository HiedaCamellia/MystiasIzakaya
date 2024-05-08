package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.procedures.GetItemStack;
import net.touhou.mystiasizakaya.procedures.SetSlotItem;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.ArrayList;

public class ConfirmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean bool = false;
		ItemStack target = ItemStack.EMPTY;
		ItemStack Kitchenware = ItemStack.EMPTY;
		double time = 0;
		time = GetValue.getDouble(world, new BlockPos(x, y, z), "timeleft");
		String raws = "";
		if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, new BlockPos(x, y, z), 6).getItem()
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, new BlockPos(x, y, z), 12)
						.getItem())&& time==0) {
			ArrayList<String> rawtags = (ArrayList) GetTagFromItemStacksProcedure.execute(world, x, y, z);
			ArrayList<String> targettags = (ArrayList) GetTargetTagsProcedure.execute(world, x, y, z);
			ArrayList<String> targetntags = (ArrayList) GetTargetNagetivetagsProcedure.execute(world, x, y, z);
			target = GetItemStack.getItemStack(world, new BlockPos(x, y, z), 12);
			Kitchenware = GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0);
			ArrayList<String> combinedList = new ArrayList<String>(rawtags);
			combinedList.addAll(targettags);
			Set<String> set = new LinkedHashSet<String>(combinedList);
			ArrayList<String> resultList = new ArrayList<String>(set);
			if (!(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, new BlockPos(x, y, z), 5).getItem())) {
				resultList.add("tag.mystias_izakaya.Large_Portion");
				if (resultList.contains("tag.mystias_izakaya.Small_Portion")) {
					resultList.remove("tag.mystias_izakaya.Small_Portion");
				}
			}
			if (resultList.contains("tag.mystias_izakaya.Meat")
					&& resultList.contains("tag.mystias_izakaya.Vegetarian")) {
				resultList.remove("tag.mystias_izakaya.Vegetarian");
			}
			if (resultList.contains("tag.mystias_izakaya.Filling")
					&& resultList.contains("tag.mystias_izakaya.Good_with_Alcohol")) {
				resultList.remove("tag.mystias_izakaya.Good_with_Alcohol");
			}
			if (resultList.contains("tag.mystias_izakaya.Greasy") && resultList.contains("tag.mystias_izakaya.Mild")) {
				resultList.remove("tag.mystias_izakaya.Mild");
			}
			if (resultList.contains("tag.mystias_izakaya.Hot")
					&& resultList.contains("tag.mystias_izakaya.Refreshing")) {
				resultList.remove("tag.mystias_izakaya.Refreshing");
			}
			resultList.add(GetKitchenwareTagProcedure.execute(Kitchenware));
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
				rawslist.add(ForgeRegistries.ITEMS.getKey((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, new BlockPos(x, y, z), i)).getItem()).toString());
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
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", GetTimeProcedure.execute(world, x, y, z));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (bool) {
				SetSlotItem.setSlotItem(world, x, y, z, new ItemStack(MystiasIzakayaModItems.HEI_AN_WU_ZHI.get()), 12,
						1);
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
