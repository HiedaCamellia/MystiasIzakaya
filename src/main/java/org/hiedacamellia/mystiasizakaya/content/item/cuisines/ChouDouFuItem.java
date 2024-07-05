
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class ChouDouFuItem extends Cuisines {
	public ChouDouFuItem() {
		super(6, 1.2f, Rarity.UNCOMMON, "chou_dou_fu", new String[]{"Vegetarian", "Chinese", "Peculiar", "Spicy"},
				new String[]{"Sweet", "Fruity"});
	}
}
