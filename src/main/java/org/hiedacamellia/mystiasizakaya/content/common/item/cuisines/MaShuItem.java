
package org.hiedacamellia.mystiasizakaya.content.common.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Cuisines;

public class MaShuItem extends Cuisines {
	public MaShuItem() {
		super(8, 1.2f, Rarity.UNCOMMON, "ma_shu",
				new String[]{"Japanese", "Sweet", "Small_Portion"},
				new String[]{"Meat", "Aquatic", "Salty", "Fresh"},84);
	}
}
