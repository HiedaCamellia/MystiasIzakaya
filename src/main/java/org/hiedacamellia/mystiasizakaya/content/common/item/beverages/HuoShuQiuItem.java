package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Cuisines;

public class HuoShuQiuItem extends Beverages {
	public HuoShuQiuItem() {
		super(8, 0.8f, Rarity.COMMON, "huo_shu_qiu",
				new String[]{"high_alcohol", "heatable", "shochu", "dry"});
	}
}