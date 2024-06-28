package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.item.ingredients.*;

import java.util.*;

public class GetTagFromItemStacks {
	public static List<String> execute(LevelAccessor world, double x, double y, double z) {
        double i;
		List<String> raws = new ArrayList<>();
        List<ItemStack> araws = GetRawsFromSelectedFood.execute(world, x, y, z);
		i = 0;
		while (i < araws.size()) {
			raws.add((Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((araws.get((int) i)).getItem())).toString()));
			i = i + 1;
		}
		List<String> list = new ArrayList<>();
		if (raws.contains("mystias_izakaya:dou_fu")) {
			list.addAll(DouFuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ba_mu_man")) {
			list.addAll(BaMuManItem.gettags());
		}
		if (raws.contains("mystias_izakaya:bai_guo")) {
			list.addAll(BaiGuoItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ban_li")) {
			list.addAll(BanLiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:bing_kuai")) {
			list.addAll(BingKuaiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:bing_di_lian")) {
			list.addAll(BingDiLianItem.gettags());
		}
		if (raws.contains("mystias_izakaya:chan_shui")) {
			list.addAll(ChanShuiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:di_gua")) {
			list.addAll(DiGuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:feng_mi")) {
			list.addAll(FengMiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:hai_dan")) {
			list.addAll(HaiDanItem.gettags());
		}
		if (raws.contains("mystias_izakaya:hai_tai")) {
			list.addAll(HaiTaiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:he_niu")) {
			list.addAll(HeNiuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:he_tun")) {
			list.addAll(HeTunItem.gettags());
		}
		if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
			list.addAll(HeiMaoZhuRouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:hei_yan")) {
			list.addAll(HeiYanItem.gettags());
		}
		if (raws.contains("mystias_izakaya:huan_tan_hua")) {
			list.addAll(HuanTanHuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:huang_gua")) {
			list.addAll(HuangGuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:huang_you")) {
			list.addAll(HuangYouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ji_dan")) {
			list.addAll(JiDanItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")) {
			list.addAll(JiShangJinQiangYuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:jin_qiang_yu")) {
			list.addAll(JinQiangYuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:la_jiao")) {
			list.addAll(LaJiaoItem.gettags());
		}
		if (raws.contains("mystias_izakaya:lian_zi")) {
			list.addAll(LianZiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:lu_rou")) {
			list.addAll(LuRouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:lu_shui")) {
			list.addAll(LuShuiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:luo_bu")) {
			list.addAll(LuoBuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:mian_fen")) {
			list.addAll(MianFenItem.gettags());
		}
		if (raws.contains("mystias_izakaya:mo_gu")) {
			list.addAll(MoGuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:nai_you")) {
			list.addAll(NaiYouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:nan_gua")) {
			list.addAll(NanGuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ning_meng")) {
			list.addAll(NingMengItem.gettags());
		}
		if (raws.contains("mystias_izakaya:niu_rou")) {
			list.addAll(NiuRouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:nuo_mi")) {
			list.addAll(NuoMiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:pang_xie")) {
			list.addAll(PangXieItem.gettags());
		}
		if (raws.contains("mystias_izakaya:pu_tao")) {
			list.addAll(PuTaoItem.gettags());
		}
		if (raws.contains("mystias_izakaya:san_wen_yu")) {
			list.addAll(SanWenYuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:song_lu")) {
			list.addAll(SongLuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:song_zi")) {
			list.addAll(SongZiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:tao_zi")) {
			list.addAll(TaoZiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:tu_dou")) {
			list.addAll(TuDouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:xia")) {
			list.addAll(XiaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:yang_cong")) {
			list.addAll(YangCongItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ye_zhu_rou")) {
			list.addAll(YeZhuRouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:yue_guang_cao")) {
			list.addAll(YueGuangCaoItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zhang_yu")) {
			list.addAll(ZhangYuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zhi_shi")) {
			list.addAll(ZhiShiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			list.addAll(ZhuRouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_sun")) {
			list.addAll(ZhuSunItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_zi")) {
			list.addAll(ZhuZiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:zun_yu")) {
			list.addAll(ZunYuItem.gettags());
		}
		if (raws.contains("mystias_izakaya:chun_chun")) {
			list.addAll(ChunChunItem.gettags());
		}
		if (raws.contains("mystias_izakaya:hong_dou")) {
			list.addAll(HongDouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:ke_ke_dou")) {
			list.addAll(KeKeDouItem.gettags());
		}
		if (raws.contains("mystias_izakaya:xu_li")) {
			list.addAll(XuLiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:mei_zi")) {
			list.addAll(MeiZiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:pu_pu_you_guo")) {
			list.addAll(PuPuYouGuoItem.gettags());
		}
		if (raws.contains("mystias_izakaya:qiang_xiao_la_jiao_su")) {
			list.addAll(QiangXiaoLaJiaoSu.gettags());
		}
		if (raws.contains("mystias_izakaya:xi_hong_shi")) {
			list.addAll(XiHongShiItem.gettags());
		}
		if (raws.contains("mystias_izakaya:xi_lan_hua")) {
			list.addAll(XiLanHuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:xian_hua")) {
			list.addAll(XianHuaItem.gettags());
		}
		if (raws.contains("mystias_izakaya:yin_er")) {
			list.addAll(YinErItem.gettags());
		}
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
        return new ArrayList<>(list);
	}
}
