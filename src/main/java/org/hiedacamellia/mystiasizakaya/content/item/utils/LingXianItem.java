
package org.hiedacamellia.mystiasizakaya.content.item.utils;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.hiedacamellia.mystiasizakaya.content.item.items.BaseItem;

public class LingXianItem extends BaseItem {
	public LingXianItem() {
		super(64, 1, 0.8f, Rarity.EPIC, UseAnim.NONE, 0,
				"ling_xian", new String[]{"Photogenic","Signature","Specialty","Wonderful"}, new String[]{});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

}
