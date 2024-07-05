
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class RanJingBuDingItem extends Cuisines {
	public RanJingBuDingItem() {
		super(7, 1.2f, Rarity.RARE, "ran_jing_bu_ding",
				new String[]{"Refreshing", "Dreamy", "Expensive", "Fruity", "Signature", "Small_Portion", "Sour",
						"Strength_Boosting", "Sweet"},
				new String[]{"Greasy", "Salty"});
	}
}
