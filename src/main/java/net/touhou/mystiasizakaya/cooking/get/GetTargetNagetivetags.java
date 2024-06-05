package net.touhou.mystiasizakaya.cooking.get;

import net.touhou.mystiasizakaya.item.ZhuTongZhengDanItem;
import net.touhou.mystiasizakaya.item.ZhuSunChaoRouItem;
import net.touhou.mystiasizakaya.item.ZhuRouZunYuXunItem;
import net.touhou.mystiasizakaya.item.ZhuRouGaiJiaoFanItem;
import net.touhou.mystiasizakaya.item.ZhuQuJiItem;
import net.touhou.mystiasizakaya.item.ZhuLuDieItem;
import net.touhou.mystiasizakaya.item.ZhuDouFuItem;
import net.touhou.mystiasizakaya.item.ZhiZhuRouFanTuanItem;
import net.touhou.mystiasizakaya.item.ZhenHaiXianWeiChengTangItem;
import net.touhou.mystiasizakaya.item.ZhaZhuRouPaiItem;
import net.touhou.mystiasizakaya.item.ZhaBaMuManItem;
import net.touhou.mystiasizakaya.item.ZaChuiItem;
import net.touhou.mystiasizakaya.item.YueZhiLianRenItem;
import net.touhou.mystiasizakaya.item.YueGuangTuanZiItem;
import net.touhou.mystiasizakaya.item.YouDouFuItem;
import net.touhou.mystiasizakaya.item.YingLuoXueItem;
import net.touhou.mystiasizakaya.item.YiShiHuiFanItem;
import net.touhou.mystiasizakaya.item.YeWeiJiaNongItem;
import net.touhou.mystiasizakaya.item.YanJiangItem;
import net.touhou.mystiasizakaya.item.XingHongEMoDanGaoItem;
import net.touhou.mystiasizakaya.item.XiangZhaChanShuiItem;
import net.touhou.mystiasizakaya.item.XiangJianSanWenYuItem;
import net.touhou.mystiasizakaya.item.WuYiShiYaoGuaiMuSiItem;
import net.touhou.mystiasizakaya.item.WenNuanFanTuanItem;
import net.touhou.mystiasizakaya.item.TunGuLaMianItem;
import net.touhou.mystiasizakaya.item.TuDouKeLeBingItem;
import net.touhou.mystiasizakaya.item.TaoHuaGengItem;
import net.touhou.mystiasizakaya.item.SiKangBingItem;
import net.touhou.mystiasizakaya.item.ShuiJiaoItem;
import net.touhou.mystiasizakaya.item.ShuCaiZhuanJiItem;
import net.touhou.mystiasizakaya.item.ShiLiYinXingItem;
import net.touhou.mystiasizakaya.item.SaiXiongZhangItem;
import net.touhou.mystiasizakaya.item.ReSongBingItem;
import net.touhou.mystiasizakaya.item.PengLaiYuZhiItem;
import net.touhou.mystiasizakaya.item.NiuRouGaiJiaoFanItem;
import net.touhou.mystiasizakaya.item.NengLiangChuanItem;
import net.touhou.mystiasizakaya.item.NaiYouTunCaiItem;
import net.touhou.mystiasizakaya.item.MoGuRouPianItem;
import net.touhou.mystiasizakaya.item.MiZhiXiaoYuGanItem;
import net.touhou.mystiasizakaya.item.MiZhiChaShaoItem;
import net.touhou.mystiasizakaya.item.MaoYuSanSeBingJiLingItem;
import net.touhou.mystiasizakaya.item.MaoYuRongYanDouFuItem;
import net.touhou.mystiasizakaya.item.MaShuItem;
import net.touhou.mystiasizakaya.item.MaPoDouFuItem;
import net.touhou.mystiasizakaya.item.LuShuiZhuDanItem;
import net.touhou.mystiasizakaya.item.LiuShuiSuMianItem;
import net.touhou.mystiasizakaya.item.LiangCaiDiaoHuaItem;
import net.touhou.mystiasizakaya.item.LiLiangTangItem;
import net.touhou.mystiasizakaya.item.LengDouFuItem;
import net.touhou.mystiasizakaya.item.KaoMoGuItem;
import net.touhou.mystiasizakaya.item.KaoBaMuManItem;
import net.touhou.mystiasizakaya.item.HuiLingDunNiuPaiItem;
import net.touhou.mystiasizakaya.item.HuangYouNiuPaiItem;
import net.touhou.mystiasizakaya.item.HuanTanHuaGaoItem;
import net.touhou.mystiasizakaya.item.HuaGuangYuJianBaoItem;
import net.touhou.mystiasizakaya.item.HongShaoManYuItem;
import net.touhou.mystiasizakaya.item.HaiXianWeiChengTangItem;
import net.touhou.mystiasizakaya.item.FanTuanItem;
import net.touhou.mystiasizakaya.item.ErTianLiuItem;
import net.touhou.mystiasizakaya.item.DouFuWeiChengItem;
import net.touhou.mystiasizakaya.item.DouFuGuoItem;
import net.touhou.mystiasizakaya.item.DaSheYanItem;
import net.touhou.mystiasizakaya.item.DaBanShaoItem;
import net.touhou.mystiasizakaya.item.CiShenPinPanItem;
import net.touhou.mystiasizakaya.item.ChouDouFuItem;
import net.touhou.mystiasizakaya.item.ChaoRouSiItem;
import net.touhou.mystiasizakaya.item.BuSiNiaoItem;
import net.touhou.mystiasizakaya.item.BeiJiTianXiaMiTaoSeLaItem;
import net.touhou.mystiasizakaya.item.BanNiDiKeDanItem;
import net.touhou.mystiasizakaya.item.beverages.BaiXueItem;
import net.touhou.mystiasizakaya.item.BaiTaoShengBaQiaoItem;
import net.touhou.mystiasizakaya.item.BaiGuoLuoBuPaiGuTangItem;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.touhou.mystiasizakaya.util.GetItemStack;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class GetTargetNagetivetags {
	public static ArrayList execute(LevelAccessor world, double x, double y, double z) {
		ItemStack target = ItemStack.EMPTY;
		double time = 0;
		List<String> list = new ArrayList<>();
		target = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHU_GUO.get()) {
			if (MystiasIzakayaModItems.ZHU_DOU_FU.get() == target.getItem()) {
				list.addAll(ZhuDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.DOU_FU_GUO.get() == target.getItem()) {
				list.addAll(DouFuGuoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				list.addAll(DouFuWeiChengItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(HaiXianWeiChengTangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() == target.getItem()) {
				list.addAll(TunGuLaMianItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				list.addAll(BaiGuoLuoBuPaiGuTangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.BAI_XUE.get() == target.getItem()) {
				list.addAll(BaiXueItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.DA_SHE_YAN.get() == target.getItem()) {
				list.addAll(DaSheYanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.LI_LIANG_TANG.get() == target.getItem()) {
				list.addAll(LiLiangTangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(NiuRouGaiJiaoFanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.SHUI_JIAO.get() == target.getItem()) {
				list.addAll(ShuiJiaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.TAO_HUA_GENG.get() == target.getItem()) {
				list.addAll(TaoHuaGengItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YAN_JIANG.get() == target.getItem()) {
				list.addAll(YanJiangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YE_WEI_JIA_NONG.get() == target.getItem()) {
				list.addAll(YeWeiJiaNongItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZA_CHUI.get() == target.getItem()) {
				list.addAll(ZaChuiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(ZhenHaiXianWeiChengTangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(ZhuRouGaiJiaoFanItem.getnegativetags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHENG_GUO.get()) {
			if (MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				list.addAll(HuanTanHuaGaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				list.addAll(LuShuiZhuDanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				list.addAll(NaiYouTunCaiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() == target.getItem()) {
				list.addAll(SaiXiongZhangItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.SHI_LI_YIN_XING.get() == target.getItem()) {
				list.addAll(ShiLiYinXingItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.SI_KANG_BING.get() == target.getItem()) {
				list.addAll(SiKangBingItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() == target.getItem()) {
				list.addAll(YiShiHuiFanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_LU_DIE.get() == target.getItem()) {
				list.addAll(ZhuLuDieItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_QU_JI.get() == target.getItem()) {
				list.addAll(ZhuQuJiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				list.addAll(ZhuTongZhengDanItem.getnegativetags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.YOU_GUO.get()) {
			if (MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				list.addAll(BanNiDiKeDanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.CHAO_ROU_SI.get() == target.getItem()) {
				list.addAll(ChaoRouSiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.CHOU_DOU_FU.get() == target.getItem()) {
				list.addAll(ChouDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.DA_BAN_SHAO.get() == target.getItem()) {
				list.addAll(DaBanShaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				list.addAll(HongShaoManYuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				list.addAll(HuaGuangYuJianBaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuangYouNiuPaiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuiLingDunNiuPaiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MA_PO_DOU_FU.get() == target.getItem()) {
				list.addAll(MaPoDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MO_GU_ROU_PIAN.get() == target.getItem()) {
				list.addAll(MoGuRouPianItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.RE_SONG_BING.get() == target.getItem()) {
				list.addAll(ReSongBingItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				list.addAll(TuDouKeLeBingItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				list.addAll(XiangJianSanWenYuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				list.addAll(XiangZhaChanShuiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YOU_DOU_FU.get() == target.getItem()) {
				list.addAll(YouDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHA_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(ZhaBaMuManItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				list.addAll(ZhaZhuRouPaiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				list.addAll(ZhuSunChaoRouItem.getnegativetags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.LIAO_LI_TAI.get()) {
			if (MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				list.addAll(BaiTaoShengBaQiaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				list.addAll(BeiJiTianXiaMiTaoSeLaItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				list.addAll(CiShenPinPanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.FAN_TUAN.get() == target.getItem()) {
				list.addAll(FanTuanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.LENG_DOU_FU.get() == target.getItem()) {
				list.addAll(LengDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				list.addAll(LiangCaiDiaoHuaItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				list.addAll(LiuShuiSuMianItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MA_SHU.get() == target.getItem()) {
				list.addAll(MaShuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				list.addAll(MaoYuRongYanDouFuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				list.addAll(MaoYuSanSeBingJiLingItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				list.addAll(MiZhiXiaoYuGanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				list.addAll(ShuCaiZhuanJiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				list.addAll(WenNuanFanTuanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				list.addAll(WuYiShiYaoGuaiMuSiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				list.addAll(XingHongEMoDanGaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YING_LUO_XUE.get() == target.getItem()) {
				list.addAll(YingLuoXueItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				list.addAll(YueGuangTuanZiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				list.addAll(YueZhiLianRenItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				list.addAll(ZhiZhuRouFanTuanItem.getnegativetags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.SHAO_KAO_JIA.get()) {
			if (MystiasIzakayaModItems.BU_SI_NIAO.get() == target.getItem()) {
				list.addAll(BuSiNiaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ER_TIAN_LIU.get() == target.getItem()) {
				list.addAll(ErTianLiuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.KAO_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(KaoBaMuManItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.KAO_MO_GU.get() == target.getItem()) {
				list.addAll(KaoMoGuItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				list.addAll(MiZhiChaShaoItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.NENG_LIANG_CHUAN.get() == target.getItem()) {
				list.addAll(NengLiangChuanItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				list.addAll(PengLaiYuZhiItem.getnegativetags());
			}
			if (MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				list.addAll(ZhuRouZunYuXunItem.getnegativetags());
			}
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
		ArrayList<String> arrayList = new ArrayList<>(list);
		return arrayList;
	}
}
