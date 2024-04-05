
package net.touhou.mystiasizakaya.item;
import net.touhou.mystiasizakaya.procedures.RenderTagsFromNbtProcedure;
import net.touhou.mystiasizakaya.procedures.GiveEffectFromTagsProcedure;
import net.touhou.mystiasizakaya.procedures.GiveEffectFromIngredientsProcedure;
import net.touhou.mystiasizakaya.procedures.GiveEffectFromCuisines;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ShaoKaoJiaItem extends Item {
	public ShaoKaoJiaItem() {
		super(new Item.Properties().tab(MystiasIzakayaModTabs.MystiasIzakaya).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		if (!Screen.hasShiftDown()) {
			List<String> tags = gettags();
			for (String tag : tags) {
				list.add(Component.literal("§6+ " + Component.translatable(tag).getString() + "§r"));
			}
			List<String> tagsfnbt = RenderTagsFromNbtProcedure.execute(itemstack);
			for (String tag : tagsfnbt) {
				list.add(Component.literal("§6+ " + Component.translatable(tag).getString() + "§r"));
			}
			Set<Component> set = new LinkedHashSet<>(list);
			list.clear();
			list.addAll(set);
			List<String> negativetags = getnegativetags();
			for (String tag : negativetags) {
				list.add(Component.literal("§4- " + Component.translatable(tag).getString() + "§r"));
			}
			list.add(Component.literal(
					"§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
		} else {
			List<String> description = Arrays
					.asList(Component.translatable("tooltip.mystias_izakaya.shao_kao_jia").getString().split("§n"));
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}


public static List<String> gettags() {
		List<String> list = new ArrayList<>();
		list.add("tag.mystias_izakaya.grill");
		return list;
	}

	public static List<String> getnegativetags() {
		List<String> list = new ArrayList<>();
		return list;
	}
}
