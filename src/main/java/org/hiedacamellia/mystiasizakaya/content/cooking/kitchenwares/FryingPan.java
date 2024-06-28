package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class FryingPan {
	public static List<String> get(List<String> raws) {
        List<String> rawlist = new ArrayList<>();
		if (raws.contains("mystias_izakaya:he_niu") && raws.contains("mystias_izakaya:mian_fen")
				&& raws.contains("mystias_izakaya:huang_you") && raws.contains("mystias_izakaya:song_lu")
				&& raws.contains("mystias_izakaya:ji_dan")) {
			rawlist.add("mystias_izakaya:hui_ling_dun_niu_pai");
		}
		if (raws.contains("mystias_izakaya:feng_mi") && raws.contains("mystias_izakaya:mian_fen")
				&& raws.contains("mystias_izakaya:ji_dan")) {
			rawlist.add("mystias_izakaya:re_song_bing");
		}
		if (raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:zhu_sun")
				&& raws.contains("mystias_izakaya:huang_you")) {
			rawlist.add("mystias_izakaya:ban_ni_di_ke_dan");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:zhu_rou")
				&& raws.contains("mystias_izakaya:la_jiao")) {
			rawlist.add("mystias_izakaya:ma_po_dou_fu");
		}
		if (raws.contains("mystias_izakaya:mian_fen") && raws.contains("mystias_izakaya:ji_dan")
				&& raws.contains("mystias_izakaya:luo_bu")) {
			rawlist.add("mystias_izakaya:da_ban_shao");
		}
		if (raws.contains("mystias_izakaya:zhu_rou") && raws.contains("mystias_izakaya:mo_gu")) {
			rawlist.add("mystias_izakaya:mo_gu_rou_pian");
		}
		if (raws.contains("mystias_izakaya:zhu_sun") && raws.contains("mystias_izakaya:san_wen_yu")) {
			rawlist.add("mystias_izakaya:xiang_jian_san_wen_yu");
		}
		if (raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
			rawlist.add("mystias_izakaya:hua_guang_yu_jian_bao");
		}
		if (raws.contains("mystias_izakaya:zhu_sun") && raws.contains("mystias_izakaya:zhu_rou")) {
			rawlist.add("mystias_izakaya:zhu_sun_chao_rou");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:la_jiao")) {
			rawlist.add("mystias_izakaya:chou_dou_fu");
		}
		if (raws.contains("mystias_izakaya:ba_mu_man") && raws.contains("mystias_izakaya:yang_cong")) {
			rawlist.add("mystias_izakaya:hong_shao_man_yu");
		}
		if (raws.contains("mystias_izakaya:he_niu") && raws.contains("mystias_izakaya:huang_you")) {
			rawlist.add("mystias_izakaya:huang_you_niu_pai");
		}
		if (raws.contains("mystias_izakaya:tu_dou")) {
			rawlist.add("mystias_izakaya:tu_dou_ke_le_bing");
		}
		if (raws.contains("mystias_izakaya:ba_mu_man")) {
			rawlist.add("mystias_izakaya:zha_ba_mu_man");
		}
		if (raws.contains("mystias_izakaya:chan_shui")) {
			rawlist.add("mystias_izakaya:xiang_zha_chan_shui");
		}
		if (raws.contains("mystias_izakaya:dou_fu")) {
			rawlist.add("mystias_izakaya:you_dou_fu");
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			rawlist.add("mystias_izakaya:zha_zhu_rou_pai");
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			rawlist.add("mystias_izakaya:chao_rou_si");
		}
		return rawlist;
	}
}
