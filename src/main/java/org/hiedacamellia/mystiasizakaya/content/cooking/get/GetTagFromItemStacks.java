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
		List<String> list = add(raws);
		Set<String> set = new LinkedHashSet<>(list); // 使用LinkedHashSet以保持原始顺序
		list.clear();
		list.addAll(set);
        return new ArrayList<>(list);
	}

	public static List<String> add(List<String> raws) {
		List<String> list = new ArrayList<>();
		if (raws.contains("mystias_izakaya:ba_mu_man")) {
			list.addAll(new BaMuManItem().gettags());
		}
		if (raws.contains("mystias_izakaya:bai_guo")) {
			list.addAll(new BaiGuoItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ban_li")) {
			list.addAll(new BanLiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:bing_kuai")) {
			list.addAll(new BingKuaiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:bing_di_lian")) {
			list.addAll(new BingDiLianItem().gettags());
		}
		if (raws.contains("mystias_izakaya:chan_shui")) {
			list.addAll(new ChanShuiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:di_gua")) {
			list.addAll(new DiGuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:dou_fu")) {
			list.addAll(new DouFuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:feng_mi")) {
			list.addAll(new FengMiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:hai_dan")) {
			list.addAll(new HaiDanItem().gettags());
		}
		if (raws.contains("mystias_izakaya:hai_tai")) {
			list.addAll(new HaiTaiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:he_niu")) {
			list.addAll(new HeNiuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:he_tun")) {
			list.addAll(new HeTunItem().gettags());
		}
		if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
			list.addAll(new HeiMaoZhuRouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:hei_yan")) {
			list.addAll(new HeiYanItem().gettags());
		}
		if (raws.contains("mystias_izakaya:huan_tan_hua")) {
			list.addAll(new HuanTanHuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:huang_gua")) {
			list.addAll(new HuangGuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:huang_you")) {
			list.addAll(new HuangYouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ji_dan")) {
			list.addAll(new JiDanItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")) {
			list.addAll(new JiShangJinQiangYuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:jin_qiang_yu")) {
			list.addAll(new JinQiangYuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:la_jiao")) {
			list.addAll(new LaJiaoItem().gettags());
		}
		if (raws.contains("mystias_izakaya:lian_zi")) {
			list.addAll(new LianZiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:lu_rou")) {
			list.addAll(new LuRouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:lu_shui")) {
			list.addAll(new LuShuiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:luo_bu")) {
			list.addAll(new LuoBuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:mian_fen")) {
			list.addAll(new MianFenItem().gettags());
		}
		if (raws.contains("mystias_izakaya:mo_gu")) {
			list.addAll(new MoGuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:nai_you")) {
			list.addAll(new NaiYouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:nan_gua")) {
			list.addAll(new NanGuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ning_meng")) {
			list.addAll(new NingMengItem().gettags());
		}
		if (raws.contains("mystias_izakaya:niu_rou")) {
			list.addAll(new NiuRouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:nuo_mi")) {
			list.addAll(new NuoMiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:pang_xie")) {
			list.addAll(new PangXieItem().gettags());
		}
		if (raws.contains("mystias_izakaya:pu_tao")) {
			list.addAll(new PuTaoItem().gettags());
		}
		if (raws.contains("mystias_izakaya:san_wen_yu")) {
			list.addAll(new SanWenYuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:song_lu")) {
			list.addAll(new SongLuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:song_zi")) {
			list.addAll(new SongZiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:tao_zi")) {
			list.addAll(new TaoZiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:tu_dou")) {
			list.addAll(new TuDouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:xia")) {
			list.addAll(new XiaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:yang_cong")) {
			list.addAll(new YangCongItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ye_zhu_rou")) {
			list.addAll(new YeZhuRouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:yue_guang_cao")) {
			list.addAll(new YueGuangCaoItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zhang_yu")) {
			list.addAll(new ZhangYuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zhi_shi")) {
			list.addAll(new ZhiShiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			list.addAll(new ZhuRouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_sun")) {
			list.addAll(new ZhuSunItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zhu_zi")) {
			list.addAll(new ZhuZiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:zun_yu")) {
			list.addAll(new ZunYuItem().gettags());
		}
		if (raws.contains("mystias_izakaya:chun_chun")) {
			list.addAll(new ChunChunItem().gettags());
		}
		if (raws.contains("mystias_izakaya:hong_dou")) {
			list.addAll(new HongDouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:ke_ke_dou")) {
			list.addAll(new KeKeDouItem().gettags());
		}
		if (raws.contains("mystias_izakaya:xu_li")) {
			list.addAll(new XuLiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:mei_zi")) {
			list.addAll(new MeiZiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:pu_pu_you_guo")) {
			list.addAll(new PuPuYouGuoItem().gettags());
		}
		if (raws.contains("mystias_izakaya:qiang_xiao_la_jiao_su")) {
			list.addAll(new QiangXiaoLaJiaoSu().gettags());
		}
		if (raws.contains("mystias_izakaya:xi_hong_shi")) {
			list.addAll(new XiHongShiItem().gettags());
		}
		if (raws.contains("mystias_izakaya:xi_lan_hua")) {
			list.addAll(new XiLanHuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:xian_hua")) {
			list.addAll(new XianHuaItem().gettags());
		}
		if (raws.contains("mystias_izakaya:yin_er")) {
			list.addAll(new YinErItem().gettags());
		}
		return list;
	}
}
