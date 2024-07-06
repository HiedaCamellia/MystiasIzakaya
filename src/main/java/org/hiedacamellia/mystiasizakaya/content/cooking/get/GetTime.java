package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;

public class GetTime {
	public static double execute(ItemStack target , Item util) {
		double time = 0;
		if (util == ItemRegistery.ZHU_GUO.get()) {
			if (ItemRegistery.ZHU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.DOU_FU_GUO.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.TUN_GU_LA_MIAN.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.BAI_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.DA_SHE_YAN.get() == target.getItem()) {
				time = 120;
			}
			if (ItemRegistery.LI_LIANG_TANG.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.SHUI_JIAO.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.TAO_HUA_GENG.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.YAN_JIANG.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.YE_WEI_JIA_NONG.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.ZA_CHUI.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.TANG_YUAN.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.SHUI_ZHU_YU.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.MI_ZHI_XIAN_JUN_BAO.get() == target.getItem()) {
				time = 108;
			}
		}
		if (util == ItemRegistery.ZHENG_GUO.get()) {
			if (ItemRegistery.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				time = 36;
			}
			if (ItemRegistery.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				time = 40;
			}
			if (ItemRegistery.SAI_XIONG_ZHANG.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.SHI_LI_YIN_XING.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.SI_KANG_BING.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.YI_SHI_HUI_FAN.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.ZHU_LU_DIE.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.ZHU_QU_JI.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == ItemRegistery.YOU_GUO.get()) {
			if (ItemRegistery.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.CHAO_ROU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.CHOU_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.DA_BAN_SHAO.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				time = 168;
			}
			if (ItemRegistery.MA_PO_DOU_FU.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.MO_GU_ROU_PIAN.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.RE_SONG_BING.get() == target.getItem()) {
				time = 108;
			}
			if (ItemRegistery.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				time = 120;
			}
			if (ItemRegistery.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.YOU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.ZHA_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				time = 120;
			}
			if (ItemRegistery.ZHA_XIA_TIAN_FU_LUO.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == ItemRegistery.LIAO_LI_TAI.get()) {
			if (ItemRegistery.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				time = 120;
			}
			if (ItemRegistery.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.FAN_TUAN.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.LENG_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.MA_SHU.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				time = 60;
			}
			if (ItemRegistery.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.YING_LUO_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				time = 96;
			}
			if (ItemRegistery.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				time = 120;
			}
			if (ItemRegistery.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (util == ItemRegistery.SHAO_KAO_JIA.get()) {
			if (ItemRegistery.BU_SI_NIAO.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.ER_TIAN_LIU.get() == target.getItem()) {
				time = 216;
			}
			if (ItemRegistery.KAO_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.KAO_MO_GU.get() == target.getItem()) {
				time = 72;
			}
			if (ItemRegistery.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				time = 84;
			}
			if (ItemRegistery.NENG_LIANG_CHUAN.get() == target.getItem()) {
				time = 144;
			}
			if (ItemRegistery.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				time = 156;
			}
			if (ItemRegistery.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				time = 84;
			}
		}
		return time;
	}
}
