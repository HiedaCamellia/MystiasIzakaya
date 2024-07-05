package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.cooking.get.GetTime;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.ArrayList;
import java.util.List;

public class Confirm {
	public static void execute(LevelAccessor world, double x, double y, double z) {
        double time;
		time = GetValue.getDouble(world, Pos.get(x, y, z), "timeleft");
		ItemStack target;
		ItemStack Kitchenware;
		List<ItemStack> ingredients = new ArrayList<>();
        if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 12).getItem())
				&& time == 0) {

			Kitchenware = GetItemStack.getItemStack(world, Pos.get(x, y, z), 0);
			for (int i = 0; i < 5; i++) {
				ingredients.add(GetItemStack.getItemStack(world, Pos.get(x, y, z), i));
			}
			target = BuildTags.execute(GetItemStack.getItemStack(world, Pos.get(x, y, z), 12), Kitchenware, ingredients);

			if (!world.isClientSide()) {
				BlockPos _bp = Pos.get(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", GetTime.execute(target,Kitchenware.getItem()));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
			SetSlotItem.setSlotItem(world, x, y, z, BuildTags.check(target), 12, 1);
		}
	}
}
