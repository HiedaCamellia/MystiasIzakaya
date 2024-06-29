package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class QiItem extends Beverages {
	public QiItem() {
		super(4, 0.8f, Rarity.COMMON, "qi", new String[]{"low_alcohol", "chiilable", "sake", "cocktail", "soda", "sweet", "dry", "bitter"});
	}
}
