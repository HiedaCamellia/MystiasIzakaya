package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class YuLuChaItem extends Beverages {
	public YuLuChaItem() {
		super(4, 0.8f, Rarity.COMMON, "yu_lu_cha", new String[]{"no_alcohol", "heatable", "vintage"});
	}
}
