package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class KaPeiItem extends Beverages {
	public KaPeiItem() {
		super(5, 0.8f, Rarity.COMMON, "ka_pei", new String[]{"no_alcohol", "bitter", "modern", "heatable", "chillable",
				"stimulating"});
	}
}