
package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class IronKnifeItem extends Item {
	public IronKnifeItem(ResourceLocation loc) {
		super(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, loc)).durability(250).rarity(Rarity.COMMON));
	}

	@Override
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
		stack.setDamageValue(stack.getDamageValue() + 1);
		if (stack.getDamageValue() >= stack.getMaxDamage()) {
			stack = ItemStack.EMPTY;
		}
		this.onCraftedPostProcess(stack, level);
	}

	@Override
	public void appendHoverText(ItemStack itemstack,  Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		if (!Screen.hasShiftDown()) {
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			String[] description = Component.translatable("tooltip.mystias_izakaya.iron_knife").getString().split("§n");
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}
}
