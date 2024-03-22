
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.touhou.mystiasizakaya.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

public class MystiasIzakayaModTabs {
	public static CreativeModeTab MystiasIzakaya;
	
	public static void load() {
		MystiasIzakaya = new CreativeModeTab("mystiass_izakaya") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MystiasIzakayaModItems.ICON.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}

			@Override
			public Component getDisplayName() {
				return Component.translatable("item_group.mystias_izakaya.mystiass_izakaya");
			}
		};
	}
}
