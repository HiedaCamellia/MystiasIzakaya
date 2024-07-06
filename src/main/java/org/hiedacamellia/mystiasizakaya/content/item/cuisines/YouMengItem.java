
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class YouMengItem extends Cuisines {
	public YouMengItem() {
		super(7, 1.2f, Rarity.RARE, "you_meng",
				new String[]{"Expensive", "Premium", "Mild", "Western", "Sweet", "Photogenic", "Refreshing", "Dreamy"},
				new String[]{"Meat", "Good_With_Alcohol", "Aquatic"},0);
	}
}
