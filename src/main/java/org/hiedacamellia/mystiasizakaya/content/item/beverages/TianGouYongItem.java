package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class TianGouYongItem extends Beverages {
	public TianGouYongItem() {
		super(5, 0.8f, Rarity.COMMON, "tian_gou_yong", new String[]{"high_alcohol", "chillable", "heatable", "sake", "neat"});
	}
}
