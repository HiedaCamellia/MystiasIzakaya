package net.touhou.mystiasizakaya.content.cooking;

import net.touhou.mystiasizakaya.content.cooking.kitchenwares.*;
import net.touhou.mystiasizakaya.content.item.ItemRegistery;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.util.GetItemStack;
import net.touhou.mystiasizakaya.util.SetSlotItem;
import net.touhou.mystiasizakaya.util.GetValue;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		double i = 0;
		double time = 0;
		ItemStack util = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		List<Object> targets = new ArrayList<>();
		time = GetValue.getDouble(world, BlockPos.containing(x, y, z), "timeleft");
		if (time > 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", (time - 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (time == 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			target = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
			SetSlotItem.setSlotItem(world, x, y, z, target, 6, 1);
			GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 6).getOrCreateTag().putString("tags",
					(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12).getOrCreateTag()
							.getString("tags")));
			SetSlotItem.setEmptySlot(world, x, y, z, 12);
		} else {
			if (!(GetValue.getBoolean(world, BlockPos.containing(x, y, z), "breaking"))) {
				if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 4)
						.getItem()
						&& !(ItemStack.EMPTY.getItem() == GetItemStack
								.getItemStack(world, BlockPos.containing(x, y, z), 5).getItem())) {
					SetSlotItem.setSlotItem(world, x, y, z,
							GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 5), 4, 1);
					SetSlotItem.setEmptySlot(world, x, y, z, 5);
				}
				if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 3)
						.getItem()
						&& !(ItemStack.EMPTY.getItem() == GetItemStack
								.getItemStack(world, BlockPos.containing(x, y, z), 4).getItem())) {
					SetSlotItem.setSlotItem(world, x, y, z,
							GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 4), 3, 1);
					SetSlotItem.setEmptySlot(world, x, y, z, 4);
				}
				if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 2)
						.getItem()
						&& !(ItemStack.EMPTY.getItem() == GetItemStack
								.getItemStack(world, BlockPos.containing(x, y, z), 3).getItem())) {
					SetSlotItem.setSlotItem(world, x, y, z,
							GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 3), 2, 1);
					SetSlotItem.setEmptySlot(world, x, y, z, 3);
				}
				if (ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 1)
						.getItem()
						&& !(ItemStack.EMPTY.getItem() == GetItemStack
								.getItemStack(world, BlockPos.containing(x, y, z), 2).getItem())) {
					SetSlotItem.setSlotItem(world, x, y, z,
							GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 2), 1, 1);
					SetSlotItem.setEmptySlot(world, x, y, z, 2);
				}

				util = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0);
				if (util.getItem() == ItemStack.EMPTY.getItem()) {
					SetSlotItem.setEmptySlot(world, x, y, z, 12);
				}
				if (util.getItem() == ItemRegistery.LIAO_LI_TAI.get()) {
					str = CuttingBoard.execute(world, x, y, z);
				}
				if (util.getItem() == ItemRegistery.SHAO_KAO_JIA.get()) {
					str = Grill.execute(world, x, y, z);
				}
				if (util.getItem() == ItemRegistery.YOU_GUO.get()) {
					str = FryingPan.execute(world, x, y, z);
				}
				if (util.getItem() == ItemRegistery.ZHENG_GUO.get()) {
					str = Steamer.execute(world, x, y, z);
				}
				if (util.getItem() == ItemRegistery.ZHU_GUO.get()) {
					str = BoilingPot.execute(world, x, y, z);
				}
				String longString = str;
				String regex = "\\$start%(.*?)\\$end%"; // 创建 Pattern 对象
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(longString);
				while (matcher.find()) {
					String matchedString = matcher.group(1);
					targets.add(matchedString);
					longString = longString.replace(matcher.group(), "");
				}
				i = 1;
				while (i <= 5) {
					if (i <= targets.size()) {
						SetSlotItem.setSlotItem(world, x, y, z,
								new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(
										((targets.get((int) (i - 1)) instanceof String _s ? _s : ""))
												.toLowerCase(java.util.Locale.ENGLISH)))),
								(int) (6 + i), 1);
					} else {
						SetSlotItem.setEmptySlot(world, x, y, z, (int) (6 + i));
					}
					i = i + 1;
				}
			} else {
				SetSlotItem.setEmptySlot(world, x, y, z, 7);
				SetSlotItem.setEmptySlot(world, x, y, z, 8);
				SetSlotItem.setEmptySlot(world, x, y, z, 9);
				SetSlotItem.setEmptySlot(world, x, y, z, 10);
				SetSlotItem.setEmptySlot(world, x, y, z, 11);
				SetSlotItem.setEmptySlot(world, x, y, z, 12);
			}
		}
	}
}
