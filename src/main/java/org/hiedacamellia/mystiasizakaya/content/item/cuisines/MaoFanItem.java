
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.*;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class MaoFanItem extends Cuisines {
	public MaoFanItem() {
		super(7, 1.2f, Rarity.RARE, "mao_fan",
				new String[]{"Aquatic", "Fresh", "Small_Portion"},
				new String[]{"Greasy"});
	}
}
