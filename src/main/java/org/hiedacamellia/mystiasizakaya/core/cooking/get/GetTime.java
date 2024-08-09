package org.hiedacamellia.mystiasizakaya.core.cooking.get;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class GetTime {
	public static double execute(ItemStack target , Item util) {
		double time = 0;
		if (util == MIItem.ZHU_GUO.get()) {
			if (MIItem.ZHU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.DOU_FU_GUO.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.TUN_GU_LA_MIAN.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.BAI_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.DA_SHE_YAN.get() == target.getItem()) {
				time = 120;
			}
			if (MIItem.LI_LIANG_TANG.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.SHUI_JIAO.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.TAO_HUA_GENG.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.YAN_JIANG.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.YE_WEI_JIA_NONG.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.ZA_CHUI.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.TANG_YUAN.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.SHUI_ZHU_YU.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.MI_ZHI_XIAN_JUN_BAO.get() == target.getItem()) {
				time = 108;
			}
		}
		if (util == MIItem.ZHENG_GUO.get()) {
			if (MIItem.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				time = 36;
			}
			if (MIItem.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				time = 40;
			}
			if (MIItem.SAI_XIONG_ZHANG.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.SHI_LI_YIN_XING.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.SI_KANG_BING.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.YI_SHI_HUI_FAN.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.ZHU_LU_DIE.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.ZHU_QU_JI.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == MIItem.YOU_GUO.get()) {
			if (MIItem.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.CHAO_ROU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.CHOU_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.DA_BAN_SHAO.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				time = 168;
			}
			if (MIItem.MA_PO_DOU_FU.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.MO_GU_ROU_PIAN.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.RE_SONG_BING.get() == target.getItem()) {
				time = 108;
			}
			if (MIItem.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				time = 120;
			}
			if (MIItem.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.YOU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.ZHA_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				time = 120;
			}
			if (MIItem.ZHA_XIA_TIAN_FU_LUO.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == MIItem.LIAO_LI_TAI.get()) {
			if (MIItem.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				time = 120;
			}
			if (MIItem.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.FAN_TUAN.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.LENG_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.MA_SHU.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				time = 60;
			}
			if (MIItem.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.YING_LUO_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				time = 96;
			}
			if (MIItem.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				time = 120;
			}
			if (MIItem.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == MIItem.SHAO_KAO_JIA.get()) {
			if (MIItem.BU_SI_NIAO.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.ER_TIAN_LIU.get() == target.getItem()) {
				time = 216;
			}
			if (MIItem.KAO_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.KAO_MO_GU.get() == target.getItem()) {
				time = 72;
			}
			if (MIItem.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				time = 84;
			}
			if (MIItem.NENG_LIANG_CHUAN.get() == target.getItem()) {
				time = 144;
			}
			if (MIItem.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				time = 156;
			}
			if (MIItem.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				time = 84;
			}
		}
		return time;
	}
}
