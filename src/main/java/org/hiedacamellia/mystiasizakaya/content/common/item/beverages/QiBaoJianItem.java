package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class QiBaoJianItem extends Beverages {
	public QiBaoJianItem() {
		super(4, 0.8f, Rarity.COMMON, "qi_bao_jian", new String[]{"no_alcohol", "sweet", "neat", "stimulating"});
	}
}