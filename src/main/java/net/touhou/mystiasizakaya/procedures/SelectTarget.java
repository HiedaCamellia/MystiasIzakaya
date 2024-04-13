package net.touhou.mystiasizakaya.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.procedures.GetItemStack;
import net.touhou.mystiasizakaya.procedures.SetSlotItem;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SelectTarget {
	public static void set(LevelAccessor world, double x, double y, double z,int targetSlot) {
		MainProcedure.execute(world, x, y, z);
        SetSlotItem.setSlotItem(world, x, y, z, GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), targetSlot), 12, 1);
	}
}
