package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class MeiJiuItem extends Beverages {
	public MeiJiuItem() {
		super(4, 0.8f, Rarity.COMMON, "mei_jiu", new String[]{"mid_alcohol", "chillable", "heatable", "liquor", "fruity"});
	}
}
