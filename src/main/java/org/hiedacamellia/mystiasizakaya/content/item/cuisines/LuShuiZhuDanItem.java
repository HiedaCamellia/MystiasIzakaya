
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class LuShuiZhuDanItem extends Cuisines {
	public LuShuiZhuDanItem() {
		super(3, 0.8f, Rarity.UNCOMMON, "lu_shui_zhu_dan",
				new String[]{"Economical", "Mild", "Raw"},
				new String[]{"Meat", "Aquatic", "Greasy"});
	}
}
