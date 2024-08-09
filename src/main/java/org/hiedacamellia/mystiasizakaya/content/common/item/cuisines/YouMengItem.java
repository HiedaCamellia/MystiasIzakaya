
package org.hiedacamellia.mystiasizakaya.content.common.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Cuisines;

public class YouMengItem extends Cuisines {
	public YouMengItem() {
		super(14, 1.2f, Rarity.EPIC, "you_meng",
				new String[]{"Expensive", "Premium", "Mild", "Western", "Sweet", "Photogenic", "Refreshing", "Dreamy"},
				new String[]{"Meat", "Good_With_Alcohol", "Aquatic"},144);
	}
}
