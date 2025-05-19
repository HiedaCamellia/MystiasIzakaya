
package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;

import java.util.List;

public class CurrencyItem extends Item {

	private final int worth;

	public CurrencyItem(int worth) {
		super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
		this.worth = worth;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
		if (!Screen.hasShiftDown()) {
			list.add(Component.translatable("tooltip.mystias_izakaya.press_shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
		} else {
			String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);

		boolean currency = BalanceUtil.currency(entity, getWorth() * ar.getObject().getCount());
		if(currency) {
			ar.getObject().shrink(ar.getObject().getCount());
			ar.getObject().setCount(0);
		}
		return ar;
	}

    public int getWorth() {
        return worth;
    }
}
