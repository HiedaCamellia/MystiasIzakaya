
package net.touhou.mystiasizakaya.item;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.touhou.mystiasizakaya.procedures.RenderTagsFromNbtProcedure;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModTabs;
import java.util.Arrays;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.List;

public class BuSiNiaoItem extends Item {
	public BuSiNiaoItem() {
		super(new Item.Properties().tab(MystiasIzakayaModTabs.MystiasIzakaya).stacksTo(64).rarity(Rarity.EPIC)
				.food((new FoodProperties.Builder()).nutrition(14).saturationMod(8f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
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
					.asList(Component.translatable("tooltip.mystias_izakaya.bu_si_niao").getString().split("§n"));
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}

	public static List<String> gettags() {
		List<String> list = new ArrayList<>();
		list.add("tag.mystias_izakaya.Expensive");
		list.add("tag.mystias_izakaya.Premium");
		list.add("tag.mystias_izakaya.Legendary");
		list.add("tag.mystias_izakaya.Western");
		list.add("tag.mystias_izakaya.Photogenic");
		list.add("tag.mystias_izakaya.Grilled");
		list.add("tag.mystias_izakaya.Aura_Bursting");
		return list;
	}

	public static List<String> getnegativetags() {
		List<String> list = new ArrayList<>();
		return list;
	}
}
