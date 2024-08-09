package org.hiedacamellia.mystiasizakaya.content.common.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Beverages;

public class GuiShaItem extends Beverages {
	public GuiShaItem() {
		super(8, 0.8f, Rarity.COMMON, "gui_sha", new String[]{"high_alcohol", "chillable", "shochu", "dry", "vintage"});
	}
}