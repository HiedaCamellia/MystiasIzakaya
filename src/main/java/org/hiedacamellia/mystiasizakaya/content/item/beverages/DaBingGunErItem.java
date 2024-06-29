package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class DaBingGunErItem extends Beverages {
	public DaBingGunErItem() {
		super(4, 0.8f, Rarity.COMMON, "da_bing_gun_er", new String[]{"no_alcohol", "stimulating", "modern", "sweet"});
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

}
