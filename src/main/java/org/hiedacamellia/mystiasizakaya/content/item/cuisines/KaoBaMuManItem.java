
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;

public class KaoBaMuManItem extends Cuisines {
	public KaoBaMuManItem() {
		super(8, 1.2f, Rarity.UNCOMMON, "kao_ba_mu_man",
				new String[]{"Aquatic", "Signature", "Grilled"},
				new String[]{"Meat", "Vegetarian"});
	}
}
