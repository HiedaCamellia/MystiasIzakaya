
package org.hiedacamellia.mystiasizakaya.content.common.item.ingredients;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Ingredients;
import org.jetbrains.annotations.NotNull;

public class BingKuaiItem extends Ingredients {
	public BingKuaiItem() {
		super( 1, 0.8f, Rarity.COMMON, "bing_kuai", new String[]{"Refreshing"});
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

}
