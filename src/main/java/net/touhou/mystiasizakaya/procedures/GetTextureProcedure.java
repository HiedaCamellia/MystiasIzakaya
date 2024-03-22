package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.ArrayList;

public class GetTextureProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack i = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		String fm = "";
		String rn = "";
		target = itemstack;
		fm = "";
		List<String> list = new ArrayList<>();
		if (ItemStack.EMPTY.getItem() == target.getItem()) {
			return fm;
		}
		if (MystiasIzakayaModItems.ZHU_DOU_FU.get() == target.getItem()) {
			fm = "zhu_dou_fu_";
		}
		if (MystiasIzakayaModItems.DOU_FU_GUO.get() == target.getItem()) {
			fm = "dou_fu_guo_";
		}
		if (MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get() == target.getItem()) {
			fm = "dou_fu_wei_cheng_";
		}
		if (MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
			fm = "hai_xian_wei_cheng_tang_";
		}
		if (MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() == target.getItem()) {
			fm = "tun_gu_la_mian_";
		}
		if (MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
			fm = "bai_guo_luo_bu_pai_gu_tang_";
		}
		if (MystiasIzakayaModItems.BAI_XUE.get() == target.getItem()) {
			fm = "bai_xue_";
		}
		if (MystiasIzakayaModItems.DA_SHE_YAN.get() == target.getItem()) {
			fm = "da_she_yan_";
		}
		if (MystiasIzakayaModItems.LI_LIANG_TANG.get() == target.getItem()) {
			fm = "li_liang_tang_";
		}
		if (MystiasIzakayaModItems.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
			fm = "niu_rou_gai_jiao_fan_";
		}
		if (MystiasIzakayaModItems.SHUI_JIAO.get() == target.getItem()) {
			fm = "shui_jiao_";
		}
		if (MystiasIzakayaModItems.TAO_HUA_GENG.get() == target.getItem()) {
			fm = "tao_hua_geng_";
		}
		if (MystiasIzakayaModItems.YAN_JIANG.get() == target.getItem()) {
			fm = "yan_jiang_";
		}
		if (MystiasIzakayaModItems.YE_WEI_JIA_NONG.get() == target.getItem()) {
			fm = "ye_wei_jia_nong_";
		}
		if (MystiasIzakayaModItems.ZA_CHUI.get() == target.getItem()) {
			fm = "za_chui_";
		}
		if (MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
			fm = "zhen_hai_xian_wei_cheng_tang_";
		}
		if (MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
			fm = "zhu_rou_gai_jiao_fan_";
		}
		if (MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
			fm = "huan_tan_hua_gao_";
		}
		if (MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
			fm = "lu_shui_zhu_dan_";
		}
		if (MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() == target.getItem()) {
			fm = "nai_you_tun_cai_";
		}
		if (MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() == target.getItem()) {
			fm = "sai_xiong_zhang_";
		}
		if (MystiasIzakayaModItems.SHI_LI_YIN_XING.get() == target.getItem()) {
			fm = "shi_li_yin_xing_";
		}
		if (MystiasIzakayaModItems.SI_KANG_BING.get() == target.getItem()) {
			fm = "si_kang_bing_";
		}
		if (MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() == target.getItem()) {
			fm = "yi_shi_hui_fan_";
		}
		if (MystiasIzakayaModItems.ZHU_LU_DIE.get() == target.getItem()) {
			fm = "zhu_lu_die_";
		}
		if (MystiasIzakayaModItems.ZHU_QU_JI.get() == target.getItem()) {
			fm = "zhu_qu_ji_";
		}
		if (MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
			fm = "zhu_tong_zheng_dan_";
		}
		if (MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
			fm = "ban_ni_di_ke_dan_";
		}
		if (MystiasIzakayaModItems.CHAO_ROU_SI.get() == target.getItem()) {
			fm = "chao_rou_si_";
		}
		if (MystiasIzakayaModItems.CHOU_DOU_FU.get() == target.getItem()) {
			fm = "chou_dou_fu_";
		}
		if (MystiasIzakayaModItems.DA_BAN_SHAO.get() == target.getItem()) {
			fm = "da_ban_shao_";
		}
		if (MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get() == target.getItem()) {
			fm = "hong_shao_man_yu_";
		}
		if (MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
			fm = "hua_guang_yu_jian_bao_";
		}
		if (MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
			fm = "huang_you_niu_pai_";
		}
		if (MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
			fm = "hui_ling_dun_niu_pai_";
		}
		if (MystiasIzakayaModItems.MA_PO_DOU_FU.get() == target.getItem()) {
			fm = "ma_po_dou_fu_";
		}
		if (MystiasIzakayaModItems.MO_GU_ROU_PIAN.get() == target.getItem()) {
			fm = "mo_gu_rou_pian_";
		}
		if (MystiasIzakayaModItems.RE_SONG_BING.get() == target.getItem()) {
			fm = "re_song_bing_";
		}
		if (MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get() == target.getItem()) {
			fm = "tu_dou_ke_le_bing_";
		}
		if (MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
			fm = "xiang_jian_san_wen_yu_";
		}
		if (MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
			fm = "xiang_zha_chan_shui_";
		}
		if (MystiasIzakayaModItems.YOU_DOU_FU.get() == target.getItem()) {
			fm = "you_dou_fu_";
		}
		if (MystiasIzakayaModItems.ZHA_BA_MU_MAN.get() == target.getItem()) {
			fm = "zha_ba_mu_man_";
		}
		if (MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
			fm = "zha_zhu_rou_pai_";
		}
		if (MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
			fm = "zhu_sun_chao_rou_";
		}
		if (MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
			fm = "bai_tao_sheng_ba_qiao_";
		}
		if (MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
			fm = "bei_ji_tian_xia_mi_tao_se_la_";
		}
		if (MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get() == target.getItem()) {
			fm = "ci_shen_pin_pan_";
		}
		if (MystiasIzakayaModItems.FAN_TUAN.get() == target.getItem()) {
			fm = "fan_tuan_";
		}
		if (MystiasIzakayaModItems.LENG_DOU_FU.get() == target.getItem()) {
			fm = "leng_dou_fu_";
		}
		if (MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
			fm = "liang_cai_diao_hua_";
		}
		if (MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
			fm = "liu_shui_su_mian_";
		}
		if (MystiasIzakayaModItems.MA_SHU.get() == target.getItem()) {
			fm = "ma_shu_";
		}
		if (MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
			fm = "mao_yu_rong_yan_dou_fu_";
		}
		if (MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
			fm = "mao_yu_san_se_bing_ji_ling_";
		}
		if (MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
			fm = "mi_zhi_xiao_yu_gan_";
		}
		if (MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
			fm = "shu_cai_zhuan_ji_";
		}
		if (MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
			fm = "wen_nuan_fan_tuan_";
		}
		if (MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
			fm = "wu_yi_shi_yao_guai_mu_si_";
		}
		if (MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
			fm = "xing_hong_e_mo_dan_gao_";
		}
		if (MystiasIzakayaModItems.YING_LUO_XUE.get() == target.getItem()) {
			fm = "ying_luo_xue_";
		}
		if (MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
			fm = "yue_guang_tuan_zi_";
		}
		if (MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
			fm = "yue_zhi_lian_ren_";
		}
		if (MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
			fm = "zhi_zhu_rou_fan_tuan_";
		}
		if (MystiasIzakayaModItems.BU_SI_NIAO.get() == target.getItem()) {
			fm = "bu_si_niao_";
		}
		if (MystiasIzakayaModItems.ER_TIAN_LIU.get() == target.getItem()) {
			fm = "er_tian__liu_";
		}
		if (MystiasIzakayaModItems.KAO_BA_MU_MAN.get() == target.getItem()) {
			fm = "kao_ba_mu_man_";
		}
		if (MystiasIzakayaModItems.KAO_MO_GU.get() == target.getItem()) {
			fm = "kao_mo_gu_";
		}
		if (MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
			fm = "mi_zhi_cha_shao_";
		}
		if (MystiasIzakayaModItems.NENG_LIANG_CHUAN.get() == target.getItem()) {
			fm = "neng_liang_chuan_";
		}
		if (MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get() == target.getItem()) {
			fm = "peng_lai_yu_zhi_";
		}
		if (MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
			fm = "zhu_rou_zun_yu_xun_";
		}
		if (MystiasIzakayaModItems.LU_CHA.get() == target.getItem()) {
			fm = "lu_cha_";
		}
		if (MystiasIzakayaModItems.SHUI_TA_JI.get() == target.getItem()) {
			fm = "shui_ta_ji_";
		}
		if (MystiasIzakayaModItems.QUE_JIU.get() == target.getItem()) {
			fm = "que_jiu_";
		}
		if (MystiasIzakayaModItems.GUO_WEI_HIGH_BALL.get() == target.getItem()) {
			fm = "guo_wei_high_ball";
		}
		if (MystiasIzakayaModItems.GUO_WEI_SOUR.get() == target.getItem()) {
			fm = "guo_wei_sour";
		}
		if (MystiasIzakayaModItems.QI.get() == target.getItem()) {
			fm = "qi_";
		}
		if (MystiasIzakayaModItems.MEI_JIU.get() == target.getItem()) {
			fm = "mei_jiu_";
		}
		if (MystiasIzakayaModItems.CHAO_ZUN_PI_JIU.get() == target.getItem()) {
			fm = "chao_zunpi_jiu_";
		}
		if (MystiasIzakayaModItems.RI_YUE_XING.get() == target.getItem()) {
			fm = "ri_yue_xing_";
		}
		if (MystiasIzakayaModItems.NIU_NAI.get() == target.getItem()) {
			fm = "niu_nai_";
		}
		return fm;
	}
}
