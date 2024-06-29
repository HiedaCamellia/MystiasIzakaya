package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class ShuiTaJiItem extends Beverages {
	public ShuiTaJiItem() {
		super(6, 0.8f, Rarity.COMMON, "shui_ta_ji", new String[]{"mid_alcohol", "chillable", "heatable", "sake", "neat"});
	}
}
