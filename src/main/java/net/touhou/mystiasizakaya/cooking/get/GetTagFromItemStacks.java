package net.touhou.mystiasizakaya.cooking.get;

import net.touhou.mystiasizakaya.item.ZunYuItem;
import net.touhou.mystiasizakaya.item.ZhuZiItem;
import net.touhou.mystiasizakaya.item.ZhuSunItem;
import net.touhou.mystiasizakaya.item.ZhuRouItem;
import net.touhou.mystiasizakaya.item.ZhiShiItem;
import net.touhou.mystiasizakaya.item.ZhangYuItem;
import net.touhou.mystiasizakaya.item.YueGuangCaoItem;
import net.touhou.mystiasizakaya.item.YeZhuRouItem;
import net.touhou.mystiasizakaya.item.YangCongItem;
import net.touhou.mystiasizakaya.item.XiaItem;
import net.touhou.mystiasizakaya.item.TuDouItem;
import net.touhou.mystiasizakaya.item.TaoZiItem;
import net.touhou.mystiasizakaya.item.SongZiItem;
import net.touhou.mystiasizakaya.item.SongLuItem;
import net.touhou.mystiasizakaya.item.SanWenYuItem;
import net.touhou.mystiasizakaya.item.PuTaoItem;
import net.touhou.mystiasizakaya.item.PangXieItem;
import net.touhou.mystiasizakaya.item.NuoMiItem;
import net.touhou.mystiasizakaya.item.NiuRouItem;
import net.touhou.mystiasizakaya.item.NingMengItem;
import net.touhou.mystiasizakaya.item.NanGuaItem;
import net.touhou.mystiasizakaya.item.NaiYouItem;
import net.touhou.mystiasizakaya.item.MoGuItem;
import net.touhou.mystiasizakaya.item.MianFenItem;
import net.touhou.mystiasizakaya.item.LuoBuItem;
import net.touhou.mystiasizakaya.item.LuShuiItem;
import net.touhou.mystiasizakaya.item.LuRouItem;
import net.touhou.mystiasizakaya.item.LianZiItem;
import net.touhou.mystiasizakaya.item.LaJiaoItem;
import net.touhou.mystiasizakaya.item.JinQiangYuItem;
import net.touhou.mystiasizakaya.item.JiShangJinQiangYuItem;
import net.touhou.mystiasizakaya.item.JiDanItem;
import net.touhou.mystiasizakaya.item.HuangYouItem;
import net.touhou.mystiasizakaya.item.HuangGuaItem;
import net.touhou.mystiasizakaya.item.HuanTanHuaItem;
import net.touhou.mystiasizakaya.item.HeiYanItem;
import net.touhou.mystiasizakaya.item.HeiMaoZhuRouItem;
import net.touhou.mystiasizakaya.item.HeTunItem;
import net.touhou.mystiasizakaya.item.HeNiuItem;
import net.touhou.mystiasizakaya.item.HaiTaiItem;
import net.touhou.mystiasizakaya.item.HaiDanItem;
import net.touhou.mystiasizakaya.item.FengMiItem;
import net.touhou.mystiasizakaya.item.DouFuItem;
import net.touhou.mystiasizakaya.item.DiGuaItem;
import net.touhou.mystiasizakaya.item.ChanShuiItem;
import net.touhou.mystiasizakaya.item.BingKuaiItem;
import net.touhou.mystiasizakaya.item.BingDiLianItem;
import net.touhou.mystiasizakaya.item.BanLiItem;
import net.touhou.mystiasizakaya.item.BaiGuoItem;
import net.touhou.mystiasizakaya.item.BaMuManItem;
import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class GetTagFromItemStacks {
	public static ArrayList execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		ItemStack raw = ItemStack.EMPTY;
		double i = 0;
		List<Object> raws = new ArrayList<>();
		List<Object> araws = new ArrayList<>();
		List<String> tags = new ArrayList<>();
		List<String> negativetags = new ArrayList<>();
		araws = (ArrayList) GetRawsFromSelectedFood.execute(world, x, y, z);
		i = 0;
		while (i < araws.size()) {
			raws.add((ForgeRegistries.ITEMS.getKey((araws.get((int) i) instanceof ItemStack _bs ? _bs : ItemStack.EMPTY).getItem()).toString()));
			i = i + 1;
		}
		List<String> list = new ArrayList<>();
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))) {
			list.addAll(DouFuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BA_MU_MAN.get()).toString()))) {
			list.addAll(BaMuManItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAI_GUO.get()).toString()))) {
			list.addAll(BaiGuoItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAN_LI.get()).toString()))) {
			list.addAll(BanLiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BING_KUAI.get()).toString()))) {
			list.addAll(BingKuaiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BING_DI_LIAN.get()).toString()))) {
			list.addAll(BingDiLianItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.CHAN_SHUI.get()).toString()))) {
			list.addAll(ChanShuiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DI_GUA.get()).toString()))) {
			list.addAll(DiGuaItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FENG_MI.get()).toString()))) {
			list.addAll(FengMiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_DAN.get()).toString()))) {
			list.addAll(HaiDanItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString()))) {
			list.addAll(HaiTaiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_NIU.get()).toString()))) {
			list.addAll(HeNiuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_TUN.get()).toString()))) {
			list.addAll(HeTunItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()).toString()))) {
			list.addAll(HeiMaoZhuRouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HEI_YAN.get()).toString()))) {
			list.addAll(HeiYanItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUAN_TAN_HUA.get()).toString()))) {
			list.addAll(HuanTanHuaItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_GUA.get()).toString()))) {
			list.addAll(HuangGuaItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString()))) {
			list.addAll(HuangYouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))) {
			list.addAll(JiDanItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_SHANG_JIN_QIANG_YU.get()).toString()))) {
			list.addAll(JiShangJinQiangYuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JIN_QIANG_YU.get()).toString()))) {
			list.addAll(JinQiangYuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LA_JIAO.get()).toString()))) {
			list.addAll(LaJiaoItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LIAN_ZI.get()).toString()))) {
			list.addAll(LianZiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LU_ROU.get()).toString()))) {
			list.addAll(LuRouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LU_SHUI.get()).toString()))) {
			list.addAll(LuShuiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LUO_BU.get()).toString()))) {
			list.addAll(LuoBuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString()))) {
			list.addAll(MianFenItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MO_GU.get()).toString()))) {
			list.addAll(MoGuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NAI_YOU.get()).toString()))) {
			list.addAll(NaiYouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NAN_GUA.get()).toString()))) {
			list.addAll(NanGuaItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NING_MENG.get()).toString()))) {
			list.addAll(NingMengItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NIU_ROU.get()).toString()))) {
			list.addAll(NiuRouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NUO_MI.get()).toString()))) {
			list.addAll(NuoMiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.PANG_XIE.get()).toString()))) {
			list.addAll(PangXieItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.PU_TAO.get()).toString()))) {
			list.addAll(PuTaoItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SAN_WEN_YU.get()).toString()))) {
			list.addAll(SanWenYuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SONG_LU.get()).toString()))) {
			list.addAll(SongLuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SONG_ZI.get()).toString()))) {
			list.addAll(SongZiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TAO_ZI.get()).toString()))) {
			list.addAll(TaoZiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU.get()).toString()))) {
			list.addAll(TuDouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.XIA.get()).toString()))) {
			list.addAll(XiaItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString()))) {
			list.addAll(YangCongItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YE_ZHU_ROU.get()).toString()))) {
			list.addAll(YeZhuRouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YUE_GUANG_CAO.get()).toString()))) {
			list.addAll(YueGuangCaoItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHANG_YU.get()).toString()))) {
			list.addAll(ZhangYuItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHI_SHI.get()).toString()))) {
			list.addAll(ZhiShiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			list.addAll(ZhuRouItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_SUN.get()).toString()))) {
			list.addAll(ZhuSunItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ZI.get()).toString()))) {
			list.addAll(ZhuZiItem.gettags());
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString()))) {
			list.addAll(ZunYuItem.gettags());
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
		ArrayList<String> arrayList = new ArrayList<>(list);
		return arrayList;
	}
}
