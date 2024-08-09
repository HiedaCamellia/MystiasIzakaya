package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class ShenZhiMaiItem extends Beverages {
	public ShenZhiMaiItem() {
		super(4, 0.8f, Rarity.COMMON, "shen_zhi_mai",
				new String[]{"Mid_Alcohol", "Chillable", "Heatable", "Shochu", "Neat"});
	}
}