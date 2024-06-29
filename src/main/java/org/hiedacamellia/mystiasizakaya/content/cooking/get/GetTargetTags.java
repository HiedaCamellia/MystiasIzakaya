package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.content.item.cuisines.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GetTargetTags {
	public static List<String> execute(ItemStack target , Item util) {
		List<String> list = new ArrayList<>();
		if (util == ItemRegistery.ZHU_GUO.get()) {
			if (ItemRegistery.ZHU_DOU_FU.get() == target.getItem()) {
				list.addAll(new ZhuDouFuItem().gettags());
			}
			if (ItemRegistery.DOU_FU_GUO.get() == target.getItem()) {
				list.addAll(new DouFuGuoItem().gettags());
			}
			if (ItemRegistery.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				list.addAll(new DouFuWeiChengItem().gettags());
			}
			if (ItemRegistery.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(new HaiXianWeiChengTangItem().gettags());
			}
			if (ItemRegistery.TUN_GU_LA_MIAN.get() == target.getItem()) {
				list.addAll(new TunGuLaMianItem().gettags());
			}
			if (ItemRegistery.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				list.addAll(new BaiGuoLuoBuPaiGuTangItem().gettags());
			}
			if (ItemRegistery.BAI_XUE.get() == target.getItem()) {
				list.addAll(new BaiXueItem().gettags());
			}
			if (ItemRegistery.DA_SHE_YAN.get() == target.getItem()) {
				list.addAll(new DaSheYanItem().gettags());
			}
			if (ItemRegistery.LI_LIANG_TANG.get() == target.getItem()) {
				list.addAll(new LiLiangTangItem().gettags());
			}
			if (ItemRegistery.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(new NiuRouGaiJiaoFanItem().gettags());
			}
			if (ItemRegistery.SHUI_JIAO.get() == target.getItem()) {
				list.addAll(new ShuiJiaoItem().gettags());
			}
			if (ItemRegistery.TAO_HUA_GENG.get() == target.getItem()) {
				list.addAll(new TaoHuaGengItem().gettags());
			}
			if (ItemRegistery.YAN_JIANG.get() == target.getItem()) {
				list.addAll(new YanJiangItem().gettags());
			}
			if (ItemRegistery.YE_WEI_JIA_NONG.get() == target.getItem()) {
				list.addAll(new YeWeiJiaNongItem().gettags());
			}
			if (ItemRegistery.ZA_CHUI.get() == target.getItem()) {
				list.addAll(new ZaChuiItem().gettags());
			}
			if (ItemRegistery.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(new ZhenHaiXianWeiChengTangItem().gettags());
			}
			if (ItemRegistery.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(new ZhuRouGaiJiaoFanItem().gettags());
			}
		}
		if (util == ItemRegistery.ZHENG_GUO.get()) {
			if (ItemRegistery.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				list.addAll(new HuanTanHuaGaoItem().gettags());
			}
			if (ItemRegistery.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				list.addAll(new LuShuiZhuDanItem().gettags());
			}
			if (ItemRegistery.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				list.addAll(new NaiYouTunCaiItem().gettags());
			}
			if (ItemRegistery.SAI_XIONG_ZHANG.get() == target.getItem()) {
				list.addAll(new SaiXiongZhangItem().gettags());
			}
			if (ItemRegistery.SHI_LI_YIN_XING.get() == target.getItem()) {
				list.addAll(new ShiLiYinXingItem().gettags());
			}
			if (ItemRegistery.SI_KANG_BING.get() == target.getItem()) {
				list.addAll(new SiKangBingItem().gettags());
			}
			if (ItemRegistery.YI_SHI_HUI_FAN.get() == target.getItem()) {
				list.addAll(new YiShiHuiFanItem().gettags());
			}
			if (ItemRegistery.ZHU_LU_DIE.get() == target.getItem()) {
				list.addAll(new ZhuLuDieItem().gettags());
			}
			if (ItemRegistery.ZHU_QU_JI.get() == target.getItem()) {
				list.addAll(new ZhuQuJiItem().gettags());
			}
			if (ItemRegistery.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				list.addAll(new ZhuTongZhengDanItem().gettags());
			}
		}
		if (util == ItemRegistery.YOU_GUO.get()) {
			if (ItemRegistery.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				list.addAll(new BanNiDiKeDanItem().gettags());
			}
			if (ItemRegistery.CHAO_ROU_SI.get() == target.getItem()) {
				list.addAll(new ChaoRouSiItem().gettags());
			}
			if (ItemRegistery.CHOU_DOU_FU.get() == target.getItem()) {
				list.addAll(new ChouDouFuItem().gettags());
			}
			if (ItemRegistery.DA_BAN_SHAO.get() == target.getItem()) {
				list.addAll(new DaBanShaoItem().gettags());
			}
			if (ItemRegistery.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				list.addAll(new HongShaoManYuItem().gettags());
			}
			if (ItemRegistery.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				list.addAll(new HuaGuangYuJianBaoItem().gettags());
			}
			if (ItemRegistery.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				list.addAll(new HuangYouNiuPaiItem().gettags());
			}
			if (ItemRegistery.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				list.addAll(new HuiLingDunNiuPaiItem().gettags());
			}
			if (ItemRegistery.MA_PO_DOU_FU.get() == target.getItem()) {
				list.addAll(new MaPoDouFuItem().gettags());
			}
			if (ItemRegistery.MO_GU_ROU_PIAN.get() == target.getItem()) {
				list.addAll(new MoGuRouPianItem().gettags());
			}
			if (ItemRegistery.RE_SONG_BING.get() == target.getItem()) {
				list.addAll(new ReSongBingItem().gettags());
			}
			if (ItemRegistery.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				list.addAll(new TuDouKeLeBingItem().gettags());
			}
			if (ItemRegistery.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				list.addAll(new XiangJianSanWenYuItem().gettags());
			}
			if (ItemRegistery.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				list.addAll(new XiangZhaChanShuiItem().gettags());
			}
			if (ItemRegistery.YOU_DOU_FU.get() == target.getItem()) {
				list.addAll(new YouDouFuItem().gettags());
			}
			if (ItemRegistery.ZHA_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(new ZhaBaMuManItem().gettags());
			}
			if (ItemRegistery.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				list.addAll(new ZhaZhuRouPaiItem().gettags());
			}
			if (ItemRegistery.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				list.addAll(new ZhuSunChaoRouItem().gettags());
			}
		}
		if (util == ItemRegistery.LIAO_LI_TAI.get()) {
			if (ItemRegistery.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				list.addAll(new BaiTaoShengBaQiaoItem().gettags());
			}
			if (ItemRegistery.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				list.addAll(new BeiJiTianXiaMiTaoSeLaItem().gettags());
			}
			if (ItemRegistery.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				list.addAll(new CiShenPinPanItem().gettags());
			}
			if (ItemRegistery.FAN_TUAN.get() == target.getItem()) {
				list.addAll(new FanTuanItem().gettags());
			}
			if (ItemRegistery.LENG_DOU_FU.get() == target.getItem()) {
				list.addAll(new LengDouFuItem().gettags());
			}
			if (ItemRegistery.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				list.addAll(new LiangCaiDiaoHuaItem().gettags());
			}
			if (ItemRegistery.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				list.addAll(new LiuShuiSuMianItem().gettags());
			}
			if (ItemRegistery.MA_SHU.get() == target.getItem()) {
				list.addAll(new MaShuItem().gettags());
			}
			if (ItemRegistery.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				list.addAll(new MaoYuRongYanDouFuItem().gettags());
			}
			if (ItemRegistery.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				list.addAll(new MaoYuSanSeBingJiLingItem().gettags());
			}
			if (ItemRegistery.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				list.addAll(new MiZhiXiaoYuGanItem().gettags());
			}
			if (ItemRegistery.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				list.addAll(new ShuCaiZhuanJiItem().gettags());
			}
			if (ItemRegistery.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				list.addAll(new WenNuanFanTuanItem().gettags());
			}
			if (ItemRegistery.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				list.addAll(new WuYiShiYaoGuaiMuSiItem().gettags());
			}
			if (ItemRegistery.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				list.addAll(new XingHongEMoDanGaoItem().gettags());
			}
			if (ItemRegistery.YING_LUO_XUE.get() == target.getItem()) {
				list.addAll(new YingLuoXueItem().gettags());
			}
			if (ItemRegistery.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				list.addAll(new YueGuangTuanZiItem().gettags());
			}
			if (ItemRegistery.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				list.addAll(new YueZhiLianRenItem().gettags());
			}
			if (ItemRegistery.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				list.addAll(new ZhiZhuRouFanTuanItem().gettags());
			}
		}
		if (util == ItemRegistery.SHAO_KAO_JIA.get()) {
			if (ItemRegistery.BU_SI_NIAO.get() == target.getItem()) {
				list.addAll(new BuSiNiaoItem().gettags());
			}
			if (ItemRegistery.ER_TIAN_LIU.get() == target.getItem()) {
				list.addAll(new ErTianLiuItem().gettags());
			}
			if (ItemRegistery.KAO_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(new KaoBaMuManItem().gettags());
			}
			if (ItemRegistery.KAO_MO_GU.get() == target.getItem()) {
				list.addAll(new KaoMoGuItem().gettags());
			}
			if (ItemRegistery.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				list.addAll(new MiZhiChaShaoItem().gettags());
			}
			if (ItemRegistery.NENG_LIANG_CHUAN.get() == target.getItem()) {
				list.addAll(new NengLiangChuanItem().gettags());
			}
			if (ItemRegistery.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				list.addAll(new PengLaiYuZhiItem().gettags());
			}
			if (ItemRegistery.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				list.addAll(new ZhuRouZunYuXunItem().gettags());
			}
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
        return new ArrayList<>(list);
	}
}
