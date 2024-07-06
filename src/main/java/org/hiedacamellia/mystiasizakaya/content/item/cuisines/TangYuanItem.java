
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class TangYuanItem extends Cuisines {
	public TangYuanItem() {
		super(6, 1.2f, Rarity.UNCOMMON, "tang_yuan",
				new String[]{"Vegetarian", "Homecooking", "Chinese", "Cultural_Heritage"},
				new String[]{},60);
	}
}
