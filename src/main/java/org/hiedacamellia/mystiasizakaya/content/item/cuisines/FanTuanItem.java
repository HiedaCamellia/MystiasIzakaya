
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class FanTuanItem extends Cuisines {
	public FanTuanItem() {
		super(6, 0.8f, Rarity.COMMON, "fan_tuan",
				new String[]{"Economical", "Vegetarian", "Homecooking", "Filling", "Japanese"},
				new String[]{},60);
	}
}
