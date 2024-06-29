package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class HongWuItem extends Beverages {
	public HongWuItem() {
		super(5, 0.8f, Rarity.COMMON, "hong_wu", new String[]{"mid_alcohol", "heatable", "western"});
	}
}
