package net.touhou.mystiasizakaya.procedures;

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
import net.touhou.mystiasizakaya.item.BaiXueItem;
import net.touhou.mystiasizakaya.item.BaiTaoShengBaQiaoItem;
import net.touhou.mystiasizakaya.item.BaiGuoLuoBuPaiGuTangItem;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.touhou.mystiasizakaya.procedures.GetItemStack;
import net.touhou.mystiasizakaya.procedures.SetSlotItem;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class GetTargetTagsProcedure {
	public static ArrayList execute(LevelAccessor world, double x, double y, double z) {
		ItemStack target = ItemStack.EMPTY;
		double time = 0;
		List<String> list = new ArrayList<>();
		target = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHU_GUO.get()) {
			if (MystiasIzakayaModItems.ZHU_DOU_FU.get() == target.getItem()) {
				list.addAll(ZhuDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.DOU_FU_GUO.get() == target.getItem()) {
				list.addAll(DouFuGuoItem.gettags());
			}
			if (MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				list.addAll(DouFuWeiChengItem.gettags());
			}
			if (MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(HaiXianWeiChengTangItem.gettags());
			}
			if (MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() == target.getItem()) {
				list.addAll(TunGuLaMianItem.gettags());
			}
			if (MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				list.addAll(BaiGuoLuoBuPaiGuTangItem.gettags());
			}
			if (MystiasIzakayaModItems.BAI_XUE.get() == target.getItem()) {
				list.addAll(BaiXueItem.gettags());
			}
			if (MystiasIzakayaModItems.DA_SHE_YAN.get() == target.getItem()) {
				list.addAll(DaSheYanItem.gettags());
			}
			if (MystiasIzakayaModItems.LI_LIANG_TANG.get() == target.getItem()) {
				list.addAll(LiLiangTangItem.gettags());
			}
			if (MystiasIzakayaModItems.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(NiuRouGaiJiaoFanItem.gettags());
			}
			if (MystiasIzakayaModItems.SHUI_JIAO.get() == target.getItem()) {
				list.addAll(ShuiJiaoItem.gettags());
			}
			if (MystiasIzakayaModItems.TAO_HUA_GENG.get() == target.getItem()) {
				list.addAll(TaoHuaGengItem.gettags());
			}
			if (MystiasIzakayaModItems.YAN_JIANG.get() == target.getItem()) {
				list.addAll(YanJiangItem.gettags());
			}
			if (MystiasIzakayaModItems.YE_WEI_JIA_NONG.get() == target.getItem()) {
				list.addAll(YeWeiJiaNongItem.gettags());
			}
			if (MystiasIzakayaModItems.ZA_CHUI.get() == target.getItem()) {
				list.addAll(ZaChuiItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				list.addAll(ZhenHaiXianWeiChengTangItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				list.addAll(ZhuRouGaiJiaoFanItem.gettags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHENG_GUO.get()) {
			if (MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				list.addAll(HuanTanHuaGaoItem.gettags());
			}
			if (MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				list.addAll(LuShuiZhuDanItem.gettags());
			}
			if (MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				list.addAll(NaiYouTunCaiItem.gettags());
			}
			if (MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() == target.getItem()) {
				list.addAll(SaiXiongZhangItem.gettags());
			}
			if (MystiasIzakayaModItems.SHI_LI_YIN_XING.get() == target.getItem()) {
				list.addAll(ShiLiYinXingItem.gettags());
			}
			if (MystiasIzakayaModItems.SI_KANG_BING.get() == target.getItem()) {
				list.addAll(SiKangBingItem.gettags());
			}
			if (MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() == target.getItem()) {
				list.addAll(YiShiHuiFanItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_LU_DIE.get() == target.getItem()) {
				list.addAll(ZhuLuDieItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_QU_JI.get() == target.getItem()) {
				list.addAll(ZhuQuJiItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				list.addAll(ZhuTongZhengDanItem.gettags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.YOU_GUO.get()) {
			if (MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				list.addAll(BanNiDiKeDanItem.gettags());
			}
			if (MystiasIzakayaModItems.CHAO_ROU_SI.get() == target.getItem()) {
				list.addAll(ChaoRouSiItem.gettags());
			}
			if (MystiasIzakayaModItems.CHOU_DOU_FU.get() == target.getItem()) {
				list.addAll(ChouDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.DA_BAN_SHAO.get() == target.getItem()) {
				list.addAll(DaBanShaoItem.gettags());
			}
			if (MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				list.addAll(HongShaoManYuItem.gettags());
			}
			if (MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				list.addAll(HuaGuangYuJianBaoItem.gettags());
			}
			if (MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuangYouNiuPaiItem.gettags());
			}
			if (MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				list.addAll(HuiLingDunNiuPaiItem.gettags());
			}
			if (MystiasIzakayaModItems.MA_PO_DOU_FU.get() == target.getItem()) {
				list.addAll(MaPoDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.MO_GU_ROU_PIAN.get() == target.getItem()) {
				list.addAll(MoGuRouPianItem.gettags());
			}
			if (MystiasIzakayaModItems.RE_SONG_BING.get() == target.getItem()) {
				list.addAll(ReSongBingItem.gettags());
			}
			if (MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				list.addAll(TuDouKeLeBingItem.gettags());
			}
			if (MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				list.addAll(XiangJianSanWenYuItem.gettags());
			}
			if (MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				list.addAll(XiangZhaChanShuiItem.gettags());
			}
			if (MystiasIzakayaModItems.YOU_DOU_FU.get() == target.getItem()) {
				list.addAll(YouDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHA_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(ZhaBaMuManItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				list.addAll(ZhaZhuRouPaiItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				list.addAll(ZhuSunChaoRouItem.gettags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.LIAO_LI_TAI.get()) {
			if (MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				list.addAll(BaiTaoShengBaQiaoItem.gettags());
			}
			if (MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				list.addAll(BeiJiTianXiaMiTaoSeLaItem.gettags());
			}
			if (MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				list.addAll(CiShenPinPanItem.gettags());
			}
			if (MystiasIzakayaModItems.FAN_TUAN.get() == target.getItem()) {
				list.addAll(FanTuanItem.gettags());
			}
			if (MystiasIzakayaModItems.LENG_DOU_FU.get() == target.getItem()) {
				list.addAll(LengDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				list.addAll(LiangCaiDiaoHuaItem.gettags());
			}
			if (MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				list.addAll(LiuShuiSuMianItem.gettags());
			}
			if (MystiasIzakayaModItems.MA_SHU.get() == target.getItem()) {
				list.addAll(MaShuItem.gettags());
			}
			if (MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				list.addAll(MaoYuRongYanDouFuItem.gettags());
			}
			if (MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				list.addAll(MaoYuSanSeBingJiLingItem.gettags());
			}
			if (MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				list.addAll(MiZhiXiaoYuGanItem.gettags());
			}
			if (MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				list.addAll(ShuCaiZhuanJiItem.gettags());
			}
			if (MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				list.addAll(WenNuanFanTuanItem.gettags());
			}
			if (MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				list.addAll(WuYiShiYaoGuaiMuSiItem.gettags());
			}
			if (MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				list.addAll(XingHongEMoDanGaoItem.gettags());
			}
			if (MystiasIzakayaModItems.YING_LUO_XUE.get() == target.getItem()) {
				list.addAll(YingLuoXueItem.gettags());
			}
			if (MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				list.addAll(YueGuangTuanZiItem.gettags());
			}
			if (MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				list.addAll(YueZhiLianRenItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				list.addAll(ZhiZhuRouFanTuanItem.gettags());
			}
		}
		if (GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MystiasIzakayaModItems.SHAO_KAO_JIA.get()) {
			if (MystiasIzakayaModItems.BU_SI_NIAO.get() == target.getItem()) {
				list.addAll(BuSiNiaoItem.gettags());
			}
			if (MystiasIzakayaModItems.ER_TIAN_LIU.get() == target.getItem()) {
				list.addAll(ErTianLiuItem.gettags());
			}
			if (MystiasIzakayaModItems.KAO_BA_MU_MAN.get() == target.getItem()) {
				list.addAll(KaoBaMuManItem.gettags());
			}
			if (MystiasIzakayaModItems.KAO_MO_GU.get() == target.getItem()) {
				list.addAll(KaoMoGuItem.gettags());
			}
			if (MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				list.addAll(MiZhiChaShaoItem.gettags());
			}
			if (MystiasIzakayaModItems.NENG_LIANG_CHUAN.get() == target.getItem()) {
				list.addAll(NengLiangChuanItem.gettags());
			}
			if (MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				list.addAll(PengLaiYuZhiItem.gettags());
			}
			if (MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				list.addAll(ZhuRouZunYuXunItem.gettags());
			}
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
		ArrayList<String> arrayList = new ArrayList<>(list);
		return arrayList;
	}
}
