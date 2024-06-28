package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;

public class GetKitchenwareTag {
	public static String execute(ItemStack Kitchenware) {
		ItemStack util;
		String tag = "";
		util = Kitchenware;
		if (util.getItem() == ItemRegistery.LIAO_LI_TAI.get()) {
			tag = "tag.mystias_izakaya.cutting_board";
		}
		if (util.getItem() == ItemRegistery.SHAO_KAO_JIA.get()) {
			tag = "tag.mystias_izakaya.grill";
		}
		if (util.getItem() == ItemRegistery.YOU_GUO.get()) {
			tag = "tag.mystias_izakaya.frying_pan";
		}
		if (util.getItem() == ItemRegistery.ZHU_GUO.get()) {
			tag = "tag.mystias_izakaya.boiling_pot";
		}
		if (util.getItem() == ItemRegistery.ZHENG_GUO.get()) {
			tag = "tag.mystias_izakaya.streamer";
		}
		return tag;
	}
}
