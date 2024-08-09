
package org.hiedacamellia.mystiasizakaya.content.common.item.ingredients;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.content.common.item.items.Ingredients;
import org.jetbrains.annotations.NotNull;

public class HeiYanItem extends Ingredients {
	public HeiYanItem() {
		super(1, 0.8f, Rarity.COMMON, "hei_yan", new String[]{"Salty"});
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
