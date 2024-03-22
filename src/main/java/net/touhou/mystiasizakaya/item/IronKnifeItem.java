
package net.touhou.mystiasizakaya.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModTabs;
import java.util.Arrays;
import java.util.List;

public class IronKnifeItem extends Item {
	public IronKnifeItem() {
		super(new Item.Properties().tab(MystiasIzakayaModTabs.MystiasIzakaya).durability(250).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		if (!Screen.hasShiftDown()) {
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			List<String> description = Arrays
					.asList(Component.translatable("tooltip.mystias_izakaya.iron_knife").getString().split("§n"));
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}
}
