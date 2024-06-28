package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming.IngredientsCompact;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;

import java.util.ArrayList;
import java.util.List;

public class Steamer {
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
				raw = IngredientsCompact.execute(raw);
				raws.add((ForgeRegistries.ITEMS.getKey(raw.getItem()).toString()));
			}
			i = i + 1;
		}
		str = "";
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_SUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.SONG_LU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HEI_MAO_ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_GUO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_QU_JI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_SUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MO_GU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUANG_YOU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YI_SHI_HUI_FAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_DAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MO_GU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_TONG_ZHENG_DAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MO_GU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUANG_YOU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.NAI_YOU_TUN_CAI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HEI_MAO_ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_TUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_SUN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SAI_XIONG_ZHANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YE_ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YUE_GUANG_CAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_LU_DIE.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MIAN_FEN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SI_KANG_BING.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_DAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI_ZHU_DAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUAN_TAN_HUA.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.HUAN_TAN_HUA_GAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_GUO.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SHI_LI_YIN_XING.get()).toString() + "$end%";
		}
		return str;
	}
}
