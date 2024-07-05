package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class ShiSiYeItem extends Beverages {
	public ShiSiYeItem() {
		super(8, 1.2f, Rarity.COMMON, "shi_si_ye",
				new String[]{"Mid_Alcohol", "Chillable", "Heatable", "Sake", "Vintage", "Sweet"});
	}
}
