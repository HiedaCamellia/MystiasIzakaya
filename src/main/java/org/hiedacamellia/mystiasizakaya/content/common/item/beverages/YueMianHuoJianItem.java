package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class YueMianHuoJianItem extends Beverages {
	public YueMianHuoJianItem() {
		super(4, 0.8f, Rarity.COMMON, "yue_mian_huo_jian",
				new String[]{"no_alcohol", "chillable", "modern", "soda"});
	}
}