package net.touhou.mystiasizakaya.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class Show3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ItemStack.EMPTY.getItem() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem()) {
			return false;
		}
		return true;
	}
}
