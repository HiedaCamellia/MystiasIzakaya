
package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;

import java.util.List;

public class CurrencyItem extends Item {

	private final int worth;

	public CurrencyItem(int worth,ResourceLocation loc) {
		super(new Properties().setId(ResourceKey.create(Registries.ITEM, loc)).stacksTo(64).rarity(Rarity.COMMON));
		this.worth = worth;
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BLOCK;
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
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		boolean currency = MIBalanceUtil.currency(player, getWorth() * itemStack.getCount());
		if(currency) {
			itemStack.shrink(itemStack.getCount());
			itemStack.setCount(0);
		}
		return InteractionResult.PASS;
	}

    public int getWorth() {
        return worth;
    }
}
