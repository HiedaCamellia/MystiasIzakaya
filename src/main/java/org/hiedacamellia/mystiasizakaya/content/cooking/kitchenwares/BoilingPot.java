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

public class BoilingPot {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		List<Object> raws = new ArrayList<>();
		double i = 0;
		ItemStack raw = ItemStack.EMPTY;
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
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU_WEI_CHENG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU_GUO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_XIAN_WEI_CHENG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_DAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.TUN_GU_LA_MIAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_GUO.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_GUO_LUO_BU_PAI_GU_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_TUN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BA_MU_MAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_XUE.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HEI_MAO_ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_NIU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_TUN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.DA_SHE_YAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YE_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LI_LIANG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LI_LIANG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TAO_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BING_KUAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.TAO_HUA_GENG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_NIU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_TUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.SONG_LU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YAN_JIANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MIAN_FEN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SHUI_JIAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SHUI_ZHU_YU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NUO_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.TANG_YUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HEI_MAO_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YE_WEI_JIA_NONG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZA_CHUI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.SAN_WEN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU_GAI_JIAO_FAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU_GAI_JIAO_FAN.get()).toString() + "$end%";
		}
		return str;
	}
}
