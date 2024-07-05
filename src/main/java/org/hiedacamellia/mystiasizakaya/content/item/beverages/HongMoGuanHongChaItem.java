package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class HongMoGuanHongChaItem extends Beverages {
	public HongMoGuanHongChaItem() {
		super(3, 0.8f, Rarity.COMMON, "hong_mo_guan_hong_cha",
				new String[]{"no_alcohol", "heatable", "stimulating", "fruity"}	);
	}
}
