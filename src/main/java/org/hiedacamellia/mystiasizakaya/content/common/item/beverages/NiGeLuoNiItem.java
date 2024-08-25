package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class NiGeLuoNiItem extends Beverages {
	public NiGeLuoNiItem() {
		super(6, 0.8f, Rarity.COMMON, "ni_ge_luo_ni",
				new String[]{"mid_alcohol", "chillable", "western", "cocktail", "fruity", "bitter"});
	}
}