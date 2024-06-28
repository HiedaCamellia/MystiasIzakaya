package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.content.item.cuisines.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GetTargetNagetivetags {
	public static List<String> execute(ItemStack target , Item util) {
        List<String> list = new ArrayList<>();
		if (util == ItemRegistery.ZHU_GUO.get()) {
			if (ItemRegistery.ZHU_DOU_FU.get() == target.getItem()) {
				list.addAll(ZhuDouFuItem.getnegativetags());
			}
			if (ItemRegistery.DOU_FU_GUO.get() == target.getItem()) {
				list.addAll(DouFuGuoItem.getnegativetags());
			}
			if (ItemRegistery.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				list.addAll(DouFuWeiChengItem.getnegativetags());
			}
			if (ItemRegistery.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(HaiXianWeiChengTangItem.getnegativetags());
			}
			if (ItemRegistery.TUN_GU_LA_MIAN.get() == target.getItem()) {
				list.addAll(TunGuLaMianItem.getnegativetags());
			}
			if (ItemRegistery.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				list.addAll(BaiGuoLuoBuPaiGuTangItem.getnegativetags());
			}
			if (ItemRegistery.BAI_XUE.get() == target.getItem()) {
				list.addAll(BaiXueItem.getnegativetags());
			}
			if (ItemRegistery.DA_SHE_YAN.get() == target.getItem()) {
				list.addAll(DaSheYanItem.getnegativetags());
			}
			if (ItemRegistery.LI_LIANG_TANG.get() == target.getItem()) {
				list.addAll(LiLiangTangItem.getnegativetags());
			}
			if (ItemRegistery.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(NiuRouGaiJiaoFanItem.getnegativetags());
			}
			if (ItemRegistery.SHUI_JIAO.get() == target.getItem()) {
				list.addAll(ShuiJiaoItem.getnegativetags());
			}
			if (ItemRegistery.TAO_HUA_GENG.get() == target.getItem()) {
				list.addAll(TaoHuaGengItem.getnegativetags());
			}
			if (ItemRegistery.YAN_JIANG.get() == target.getItem()) {
				list.addAll(YanJiangItem.getnegativetags());
			}
			if (ItemRegistery.YE_WEI_JIA_NONG.get() == target.getItem()) {
				list.addAll(YeWeiJiaNongItem.getnegativetags());
			}
			if (ItemRegistery.ZA_CHUI.get() == target.getItem()) {
				list.addAll(ZaChuiItem.getnegativetags());
			}
			if (ItemRegistery.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(ZhenHaiXianWeiChengTangItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(ZhuRouGaiJiaoFanItem.getnegativetags());
			}
		}
		if (util == ItemRegistery.ZHENG_GUO.get()) {
			if (ItemRegistery.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				list.addAll(HuanTanHuaGaoItem.getnegativetags());
			}
			if (ItemRegistery.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				list.addAll(LuShuiZhuDanItem.getnegativetags());
			}
			if (ItemRegistery.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				list.addAll(NaiYouTunCaiItem.getnegativetags());
			}
			if (ItemRegistery.SAI_XIONG_ZHANG.get() == target.getItem()) {
				list.addAll(SaiXiongZhangItem.getnegativetags());
			}
			if (ItemRegistery.SHI_LI_YIN_XING.get() == target.getItem()) {
				list.addAll(ShiLiYinXingItem.getnegativetags());
			}
			if (ItemRegistery.SI_KANG_BING.get() == target.getItem()) {
				list.addAll(SiKangBingItem.getnegativetags());
			}
			if (ItemRegistery.YI_SHI_HUI_FAN.get() == target.getItem()) {
				list.addAll(YiShiHuiFanItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_LU_DIE.get() == target.getItem()) {
				list.addAll(ZhuLuDieItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_QU_JI.get() == target.getItem()) {
				list.addAll(ZhuQuJiItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				list.addAll(ZhuTongZhengDanItem.getnegativetags());
			}
		}
		if (util == ItemRegistery.YOU_GUO.get()) {
			if (ItemRegistery.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				list.addAll(BanNiDiKeDanItem.getnegativetags());
			}
			if (ItemRegistery.CHAO_ROU_SI.get() == target.getItem()) {
				list.addAll(ChaoRouSiItem.getnegativetags());
			}
			if (ItemRegistery.CHOU_DOU_FU.get() == target.getItem()) {
				list.addAll(ChouDouFuItem.getnegativetags());
			}
			if (ItemRegistery.DA_BAN_SHAO.get() == target.getItem()) {
				list.addAll(DaBanShaoItem.getnegativetags());
			}
			if (ItemRegistery.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				list.addAll(HongShaoManYuItem.getnegativetags());
			}
			if (ItemRegistery.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				list.addAll(HuaGuangYuJianBaoItem.getnegativetags());
			}
			if (ItemRegistery.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuangYouNiuPaiItem.getnegativetags());
			}
			if (ItemRegistery.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuiLingDunNiuPaiItem.getnegativetags());
			}
			if (ItemRegistery.MA_PO_DOU_FU.get() == target.getItem()) {
				list.addAll(MaPoDouFuItem.getnegativetags());
			}
			if (ItemRegistery.MO_GU_ROU_PIAN.get() == target.getItem()) {
				list.addAll(MoGuRouPianItem.getnegativetags());
			}
			if (ItemRegistery.RE_SONG_BING.get() == target.getItem()) {
				list.addAll(ReSongBingItem.getnegativetags());
			}
			if (ItemRegistery.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				list.addAll(TuDouKeLeBingItem.getnegativetags());
			}
			if (ItemRegistery.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				list.addAll(XiangJianSanWenYuItem.getnegativetags());
			}
			if (ItemRegistery.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				list.addAll(XiangZhaChanShuiItem.getnegativetags());
			}
			if (ItemRegistery.YOU_DOU_FU.get() == target.getItem()) {
				list.addAll(YouDouFuItem.getnegativetags());
			}
			if (ItemRegistery.ZHA_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(ZhaBaMuManItem.getnegativetags());
			}
			if (ItemRegistery.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				list.addAll(ZhaZhuRouPaiItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				list.addAll(ZhuSunChaoRouItem.getnegativetags());
			}
		}
		if (util == ItemRegistery.LIAO_LI_TAI.get()) {
			if (ItemRegistery.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				list.addAll(BaiTaoShengBaQiaoItem.getnegativetags());
			}
			if (ItemRegistery.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				list.addAll(BeiJiTianXiaMiTaoSeLaItem.getnegativetags());
			}
			if (ItemRegistery.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				list.addAll(CiShenPinPanItem.getnegativetags());
			}
			if (ItemRegistery.FAN_TUAN.get() == target.getItem()) {
				list.addAll(FanTuanItem.getnegativetags());
			}
			if (ItemRegistery.LENG_DOU_FU.get() == target.getItem()) {
				list.addAll(LengDouFuItem.getnegativetags());
			}
			if (ItemRegistery.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				list.addAll(LiangCaiDiaoHuaItem.getnegativetags());
			}
			if (ItemRegistery.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				list.addAll(LiuShuiSuMianItem.getnegativetags());
			}
			if (ItemRegistery.MA_SHU.get() == target.getItem()) {
				list.addAll(MaShuItem.getnegativetags());
			}
			if (ItemRegistery.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				list.addAll(MaoYuRongYanDouFuItem.getnegativetags());
			}
			if (ItemRegistery.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				list.addAll(MaoYuSanSeBingJiLingItem.getnegativetags());
			}
			if (ItemRegistery.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				list.addAll(MiZhiXiaoYuGanItem.getnegativetags());
			}
			if (ItemRegistery.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				list.addAll(ShuCaiZhuanJiItem.getnegativetags());
			}
			if (ItemRegistery.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				list.addAll(WenNuanFanTuanItem.getnegativetags());
			}
			if (ItemRegistery.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				list.addAll(WuYiShiYaoGuaiMuSiItem.getnegativetags());
			}
			if (ItemRegistery.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				list.addAll(XingHongEMoDanGaoItem.getnegativetags());
			}
			if (ItemRegistery.YING_LUO_XUE.get() == target.getItem()) {
				list.addAll(YingLuoXueItem.getnegativetags());
			}
			if (ItemRegistery.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				list.addAll(YueGuangTuanZiItem.getnegativetags());
			}
			if (ItemRegistery.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				list.addAll(YueZhiLianRenItem.getnegativetags());
			}
			if (ItemRegistery.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				list.addAll(ZhiZhuRouFanTuanItem.getnegativetags());
			}
		}
		if (util == ItemRegistery.SHAO_KAO_JIA.get()) {
			if (ItemRegistery.BU_SI_NIAO.get() == target.getItem()) {
				list.addAll(BuSiNiaoItem.getnegativetags());
			}
			if (ItemRegistery.ER_TIAN_LIU.get() == target.getItem()) {
				list.addAll(ErTianLiuItem.getnegativetags());
			}
			if (ItemRegistery.KAO_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(KaoBaMuManItem.getnegativetags());
			}
			if (ItemRegistery.KAO_MO_GU.get() == target.getItem()) {
				list.addAll(KaoMoGuItem.getnegativetags());
			}
			if (ItemRegistery.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				list.addAll(MiZhiChaShaoItem.getnegativetags());
			}
			if (ItemRegistery.NENG_LIANG_CHUAN.get() == target.getItem()) {
				list.addAll(NengLiangChuanItem.getnegativetags());
			}
			if (ItemRegistery.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				list.addAll(PengLaiYuZhiItem.getnegativetags());
			}
			if (ItemRegistery.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				list.addAll(ZhuRouZunYuXunItem.getnegativetags());
			}
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
        return new ArrayList<>(list);
	}
}
