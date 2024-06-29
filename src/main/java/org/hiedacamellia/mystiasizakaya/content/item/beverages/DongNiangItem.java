package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;


public class DongNiangItem extends Beverages {
	public DongNiangItem() {
		super(4, 0.8f, Rarity.COMMON, "dong_niang", new String[]{"low_alcohol", "chillable", "heatable", "vintage",
				"sweet"});
	}
}
