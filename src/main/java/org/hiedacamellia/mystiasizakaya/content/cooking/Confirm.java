package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.ValueRecord;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class Confirm {
	public static void execute(LevelAccessor world, double x, double y, double z) {
        double time;
		time = GetValue.getDouble(world, Pos.get(x, y, z), "timeleft");
		ItemStack target;
        if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, Pos.get(x, y, z), 12).getItem())
				&& time == 0) {

			target = GetItemStack.getItemStack(world, Pos.get(x, y, z), 12);

			if (!world.isClientSide()) {
				BlockPos _bp = Pos.get(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("timeleft", Integer.parseInt(target.getOrDefault(DataComponentsReg.Cooktime.get(), new ValueRecord("0")).value()));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}

			BlockEntity be = world.getBlockEntity(Pos.get(x, y, z));
			SetSlotItem.setEmptySlot(world,Pos.get(x,y,z), new int[]{1,2,3,4,5,6,7,8,9,10,11});
			SetSlotItem.setSlotItem(world, Pos.get(x,y,z),BuildTags.check(target), 12, 1);
		}
	}
}
