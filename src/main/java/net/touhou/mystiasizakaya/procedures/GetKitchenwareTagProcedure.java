package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraft.world.item.ItemStack;

public class GetKitchenwareTagProcedure {
	public static String execute(ItemStack Kitchenware) {
		ItemStack util = ItemStack.EMPTY;
		String tag = "";
		util = Kitchenware;
		if (util.getItem() == MystiasIzakayaModItems.LIAO_LI_TAI.get()) {
			tag = "tag.mystias_izakaya.cutting_board";
		}
		if (util.getItem() == MystiasIzakayaModItems.SHAO_KAO_JIA.get()) {
			tag = "tag.mystias_izakaya.grill";
		}
		if (util.getItem() == MystiasIzakayaModItems.YOU_GUO.get()) {
			tag = "tag.mystias_izakaya.frying_pan";
		}
		if (util.getItem() == MystiasIzakayaModItems.ZHU_GUO.get()) {
			tag = "tag.mystias_izakaya.boiling_pot";
		}
		if (util.getItem() == MystiasIzakayaModItems.ZHENG_GUO.get()) {
			tag = "tag.mystias_izakaya.streamer";
		}
		return tag;
	}
}
