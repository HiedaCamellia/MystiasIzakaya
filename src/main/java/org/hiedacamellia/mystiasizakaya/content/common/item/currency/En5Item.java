
package org.hiedacamellia.mystiasizakaya.content.common.item.currency;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.List;

public class En5Item extends Item {
	public En5Item() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		if (!Screen.hasShiftDown()) {
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			String[] description = Component.translatable("tooltip.mystias_izakaya.en_5").getString().split("§n");
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MIBalance miBalance = entity.getData(MIAttachment.MI_BALANCE.get());
		entity.setData(MIAttachment.MI_BALANCE.get(), new MIBalance(miBalance.balance() + 5 * ar.getObject().getCount()));

		ar.getObject().shrink(ar.getObject().getCount());
		ar.getObject().setCount(0);
		return ar;
	}
}
