
package net.touhou.mystiasizakaya.item;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.touhou.mystiasizakaya.procedures.RenderTagsFromNbtProcedure;
import net.touhou.mystiasizakaya.procedures.GiveEffectFromTagsProcedure;
import net.touhou.mystiasizakaya.procedures.GiveEffectFromIngredientsProcedure;
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

public class YouDouFuItem extends Item {
	public YouDouFuItem() {
		super(new Item.Properties().tab(MystiasIzakayaModTabs.MystiasIzakaya).stacksTo(64).rarity(Rarity.UNCOMMON)
				.food((new FoodProperties.Builder()).nutrition(8).saturationMod(4.5f).alwaysEat().build()));
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
					.asList(Component.translatable("tooltip.mystias_izakaya.you_dou_fu").getString().split("§n"));
			for (String line : description) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
super.finishUsingItem(itemstack, world, entity);
GiveEffectFromTagsProcedure.execute(itemstack, entity);
GiveEffectFromIngredientsProcedure.execute(itemstack, entity);
return itemstack;
}


public static List<String> gettags() {
		List<String> list = new ArrayList<>();
		list.add("tag.mystias_izakaya.Economical");
		list.add("tag.mystias_izakaya.Vegetarian");
		list.add("tag.mystias_izakaya.Homecooking");
		list.add("tag.mystias_izakaya.Greasy");
		list.add("tag.mystias_izakaya.Japanese");
		return list;
	}

	public static List<String> getnegativetags() {
		List<String> list = new ArrayList<>();
		return list;
	}
}
