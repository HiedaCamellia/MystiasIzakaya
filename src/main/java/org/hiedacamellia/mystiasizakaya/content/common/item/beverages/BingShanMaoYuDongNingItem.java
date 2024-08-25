package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Cuisines;

public class BingShanMaoYuDongNingItem extends Beverages {
	public BingShanMaoYuDongNingItem() {
		super(4, 1.2f, Rarity.COMMON, "bing_shan_mao_yu_dong_ning",
				new String[]{"no_alcohol", "chillable", "soda", "stimulating", "fruity", "neat", "sweet"});
	}
}