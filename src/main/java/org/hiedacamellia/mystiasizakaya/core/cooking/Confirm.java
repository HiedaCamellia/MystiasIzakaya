package org.hiedacamellia.mystiasizakaya.core.cooking;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;
import org.hiedacamellia.mystiasizakaya.util.GetValue;
import org.hiedacamellia.mystiasizakaya.util.SetSlotItem;

public class Confirm {
	public static void execute(LevelAccessor world, BlockPos pos) {
        double time;
		time = GetValue.getDouble(world, pos, "timeleft");
		ItemStack target;

		if(ItemStack.EMPTY == GetItemStack.getItemStack(world, pos, 1)){
			return;
		}

        if ((ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, pos, 6).getItem())
				&& !(ItemStack.EMPTY.getItem() == GetItemStack.getItemStack(world, pos, 12).getItem())
				&& time == 0) {

			target = GetItemStack.getItemStack(world, pos, 12);

			try{
				target.inventoryTick(null, null,  0, false);
			}catch (Exception e){
				return;
			}
			//Debug.getLogger().debug("Get data");


			if (!world.isClientSide()) {
                BlockEntity _blockEntity = world.getBlockEntity(pos);
				BlockState _bs = world.getBlockState(pos);
				BlockState _bsb = world.getBlockState(pos.below());

				int cooktime = target.getOrCreateTag().getInt("cooktime");
				Debug.debug("Getted cooktime", cooktime);

				if(_bs.getBlock()== MIBlock.COOKING_RANGE.get()||_bsb.getBlock()== MIBlock.COOKING_RANGE.get()){
					cooktime = (int) (cooktime * 0.6);
				}

				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("totaltime", cooktime);
					_blockEntity.getPersistentData().putDouble("timeleft", cooktime);
					Debug.debug("Getted cooktime", _blockEntity.getPersistentData().getDouble("totaltime"));
				}


				if (world instanceof Level _level)
					_level.sendBlockUpdated(pos, _bs, _bs, 3);
			}

			//Debug.getLogger().debug("Get data");

            SetSlotItem.setEmptySlot(world,pos, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
			SetSlotItem.setSlotItem(world, pos, BuildTags.check(target), 12, 1);
			if (!world.isClientSide()) {
				BlockEntity _blockEntity = world.getBlockEntity(pos);
				BlockState _bs = world.getBlockState(pos);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putInt("page", 0);
				}
				if (world instanceof Level _level) _level.sendBlockUpdated(pos, _bs, _bs, 3);
			}

		}
	}
}
