package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

public class Confirm {
	public static void execute(LevelAccessor world, BlockPos pos) {
        double time;
		time = GetValue.getDouble(world, pos, "timeleft");
		ItemStack target;
        if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, pos, 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, pos, 12).getItem())
				&& time == 0) {

			target = GetItemStack.getItemStack(world, pos, 12);

			if (!world.isClientSide()) {
				BlockPos _bp = pos;
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
					_blockEntity.getPersistentData().putInt("page", 0);
                    _blockEntity.getPersistentData().putDouble("timeleft", target.getOrCreateTag().getInt("cooktime"));
                }
                if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}

			BlockEntity be = world.getBlockEntity(pos);
			SetSlotItem.setEmptySlot(be, new int[]{1,2,3,4,5,6,7,8,9,10,11});
			SetSlotItem.setSlotItem(be, BuildTags.check(target), 12, 1);
		}
	}
}
