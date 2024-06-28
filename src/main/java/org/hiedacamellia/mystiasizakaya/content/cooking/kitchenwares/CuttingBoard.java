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

public class CuttingBoard {
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
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.XING_HONG_E_MO_DAN_GAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.WU_YI_SHI_YAO_GUAI_MU_SI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_DAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.MAO_YU_SAN_SE_BING_JI_LING.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.MAO_YU_RONG_YAN_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MIAN_FEN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_DAN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YUE_GUANG_CAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YUE_ZHI_LIAN_REN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.SHU_CAI_ZHUAN_JI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TAO_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.XIA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BING_KUAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NUO_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TAO_ZI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.BAI_TAO_SHENG_BA_QIAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NUO_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YUE_GUANG_CAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YUE_GUANG_TUAN_ZI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.WEN_NUAN_FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LENG_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.SAN_WEN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JIN_QIANG_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.CI_SHEN_PIN_PAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MIAN_FEN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ZI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LIU_SHUI_SU_MIAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NUO_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.MA_SHU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.LIANG_CAI_DIAO_HUA.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.JI_SHANG_JIN_QIANG_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.YING_LUO_XUE.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHI_ZHU_ROU_FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.MI_ZHI_XIAO_YU_GAN.get()).toString() + "$end%";
		}
		return str;
	}
}
