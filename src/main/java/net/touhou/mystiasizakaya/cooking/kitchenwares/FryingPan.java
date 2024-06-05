package net.touhou.mystiasizakaya.cooking.kitchenwares;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.procedures.YHCProcedure;
import net.touhou.mystiasizakaya.util.GetItemStack;

import java.util.List;
import java.util.ArrayList;

public class FryingPan {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		ItemStack raw = ItemStack.EMPTY;
		double i = 0;
		List<Object> raws = new ArrayList<>();
		List<String> tags = new ArrayList<>();
		List<String> negativetags = new ArrayList<>();
		i = 1;
		while (i <= 5) {
			if (!(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i).getItem() == ItemStack.EMPTY.getItem())) {
				raw = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i);
				raw = YHCProcedure.execute(raw);
				raws.add((ForgeRegistries.ITEMS.getKey(raw.getItem()).toString()));
			}
			i = i + 1;
		}
		str = "";
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_NIU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SONG_LU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FENG_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.RE_SONG_BING.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_SUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MA_PO_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DA_BAN_SHAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MO_GU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MO_GU_ROU_PIAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_SUN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SAN_WEN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MO_GU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_SUN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.CHOU_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BA_MU_MAN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_NIU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BA_MU_MAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHA_BA_MU_MAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.CHAN_SHUI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YOU_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.CHAO_ROU_SI.get()).toString() + "$end%";
		}
		return str;
	}
}
