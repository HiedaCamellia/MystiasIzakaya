
package net.touhou.mystiasizakaya.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModTabs;
import java.util.List;

public class IconItem extends Item {
	public IconItem() {
		super(new Item.Properties().tab(MystiasIzakayaModTabs.MystiasIzakaya).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}
}
