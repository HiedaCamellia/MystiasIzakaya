package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class BoilingPot {
	public static List<String> get(List<String> raws) {
        List<String> rawlist = new ArrayList<>();
		if (raws.contains("mystias_izakaya:dou_fu")) {
			rawlist.add("mystias_izakaya:dou_fu_wei_cheng");
		}
		if (raws.contains("mystias_izakaya:dou_fu")) {
			rawlist.add("mystias_izakaya:dou_fu_guo");
		}
		if (raws.contains("mystias_izakaya:dou_fu")) {
			rawlist.add("mystias_izakaya:zhu_dou_fu");
		}
		if (raws.contains("mystias_izakaya:hai_tai")) {
			rawlist.add("mystias_izakaya:hai_xian_wei_cheng_tang");
		}
		if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:zhu_rou")
				&& raws.contains("mystias_izakaya:ji_dan")) {
			rawlist.add("mystias_izakaya:tun_gu_la_mian");
		}
		if (raws.contains("mystias_izakaya:bai_guo") && raws.contains("mystias_izakaya:zhu_rou")
				&& raws.contains("mystias_izakaya:luo_bu")) {
			rawlist.add("mystias_izakaya:bai_guo_luo_bu_pai_gu_tang");
		}
		if (raws.contains("mystias_izakaya:he_tun") && raws.contains("mystias_izakaya:ba_mu_man")
				&& raws.contains("mystias_izakaya:hai_tai")) {
			rawlist.add("mystias_izakaya:bai_xue");
		}
		if (raws.contains("mystias_izakaya:hei_mao_zhu_rou") && raws.contains("mystias_izakaya:hei_niu")
				&& raws.contains("mystias_izakaya:he_tun")) {
			rawlist.add("mystias_izakaya:da_she_yan");
		}
		if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:ye_zhu_rou")) {
			rawlist.add("mystias_izakaya:li_liang_tang");
		}
		if (raws.contains("mystias_izakaya:niu_rou")) {
			rawlist.add("mystias_izakaya:li_liang_tang");
		}
		if (raws.contains("mystias_izakaya:tao_zi") && raws.contains("mystias_izakaya:lu_shui")
				&& raws.contains("mystias_izakaya:bing_kuai")) {
			rawlist.add("mystias_izakaya:tao_hua_geng");
		}
		if (raws.contains("mystias_izakaya:hei_niu") && raws.contains("mystias_izakaya:he_tun")
				&& raws.contains("mystias_izakaya:song_zi") && raws.contains("mystias_izakaya:niu_rou")) {
			rawlist.add("mystias_izakaya:yan_jiang");
		}
		if (raws.contains("mystias_izakaya:mian_fen")) {
			rawlist.add("mystias_izakaya:shui_jiao");
		}
		if (raws.contains("mystias_izakaya:zun_yu") && raws.contains("mystias_izakaya:la_jiao")) {
			rawlist.add("mystias_izakaya:shui_zhu_yu");
		}
		if (raws.contains("mystias_izakaya:nuo_mi")) {
			rawlist.add("mystias_izakaya:tang_yuan");
		}
		if (raws.contains("mystias_izakaya:tu_dou") && raws.contains("mystias_izakaya:nan_gua")
				&& raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
			rawlist.add("mystias_izakaya:ye_wei_jia_nong");
		}
		if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:dou_fu")
				&& raws.contains("mystias_izakaya:zun_yu")) {
			rawlist.add("mystias_izakaya:za_chui");
		}
		if (raws.contains("mystias_izakaya:san_wen_yu") && raws.contains("mystias_izakaya:zun_yu")) {
			rawlist.add("mystias_izakaya:zhen_hai_xian_wei_cheng_tang");
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			rawlist.add("mystias_izakaya:zhu_rou_gai_jiao_fan");
		}
		if (raws.contains("mystias_izakaya:niu_rou")) {
			rawlist.add("mystias_izakaya:niu_rou_gai_jiao_fan");
		}
		if (raws.contains("mystias_izakaya:song_lu")&& raws.contains("mystias_izakaya:mo_gu")&& raws.contains("mystias_izakaya:lu_shui")) {
			rawlist.add("mystias_izakaya:mi_zhi_xian_jun_bao");
		}
		if (raws.contains("mystias_izakaya:xia")&& raws.contains("mystias_izakaya:mian_fen")) {
			rawlist.add("mystias_izakaya:zha_xia_tian_fu_luo");
		}
		return rawlist;
	}
}
