
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.*;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class ShuCaiZhuanJiItem extends Cuisines {
	public ShuCaiZhuanJiItem() {
		super(6, 1.2f, Rarity.RARE, "shu_cai_zhuan_ji",
				new String[]{"Vegetarian", "Mild", "Raw", "Refreshing"},
				new String[]{"Meat", "Aquatic", "Hot"});
	}
}
