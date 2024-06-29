package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class JiaoFuItem extends Beverages {
	public JiaoFuItem() {
		super(7, 0.8f, Rarity.COMMON, "jiao_fu", new String[]{"high_alcohol", "chillable", "western", "cocktail",
				"vintage", "bitter"});
	}
}
