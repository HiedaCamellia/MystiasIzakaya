package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class Steamer {
	public static List<String> get(List<String> raws) {
        List<String> rawlist = new ArrayList<>();
		if (raws.contains("mystias_izakaya:zhu_zi") && raws.contains("mystias_izakaya:zhu_sun")
				&& raws.contains("mystias_izakaya:song_lu") && raws.contains("mystias_izakaya:hei_mao_zhu_rou")
				&& raws.contains("mystias_izakaya:bai_guo")) {
			rawlist.add("mystias_izakaya:zhu_qu_ji");
		}
		if (raws.contains("mystias_izakaya:yang_cong") && raws.contains("mystias_izakaya:zhu_sun")
				&& raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:huang_you")) {
			rawlist.add("mystias_izakaya:yi_shi_hui_fan");
		}
		if (raws.contains("mystias_izakaya:zhu_zi") && raws.contains("mystias_izakaya:ji_dan")
				&& raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:hai_tai")) {
			rawlist.add("mystias_izakaya:zhu_tong_zheng_dan");
		}
		if (raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:yang_cong")
				&& raws.contains("mystias_izakaya:huang_you")) {
			rawlist.add("mystias_izakaya:nai_you_tun_cai");
		}
		if (raws.contains("mystias_izakaya:hei_mao_zhu_rou") && raws.contains("mystias_izakaya:he_tun")
				&& raws.contains("mystias_izakaya:zhu_sun")) {
			rawlist.add("mystias_izakaya:sai_xiong_zhang");
		}
		if (raws.contains("mystias_izakaya:ye_zhu_rou") && raws.contains("mystias_izakaya:lu_rou")
				&& raws.contains("mystias_izakaya:yue_guang_cao")) {
			rawlist.add("mystias_izakaya:zhu_lu_die");
		}
		if (raws.contains("mystias_izakaya:huang_you") && raws.contains("mystias_izakaya:mian_fen")) {
			rawlist.add("mystias_izakaya:si_kang_bing");
		}
		if (raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:ji_dan")) {
			rawlist.add("mystias_izakaya:lu_shui_zhu_dan");
		}
		if (raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:huan_tan_hua")) {
			rawlist.add("mystias_izakaya:huan_tan_hua_gao");
		}
		if (raws.contains("mystias_izakaya:bai_guo") && raws.contains("mystias_izakaya:feng_mi")) {
			rawlist.add("mystias_izakaya:shi_li_yin_xing");
		}
		return rawlist;
	}
}
