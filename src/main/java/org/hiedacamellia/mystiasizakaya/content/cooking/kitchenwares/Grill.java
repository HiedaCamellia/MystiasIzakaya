package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class Grill {
	public static List<String> get(List<String> raws) {
        List<String> rawlist = new ArrayList<>();
		if (raws.contains("mystias_izakaya:mian_fen") && raws.contains("mystias_izakaya:yang_cong")
				&& raws.contains("mystias_izakaya:feng_mi") && raws.contains("mystias_izakaya:tu_dou")
				&& raws.contains("mystias_izakaya:luo_bu")) {
			rawlist.add("mystias_izakaya:bu_si_niao");
		}
		if (raws.contains("mystias_izakaya:he_niu") && raws.contains("mystias_izakaya:san_wen_yu")
				&& raws.contains("mystias_izakaya:zhu_rou") && raws.contains("mystias_izakaya:lu_rou")
				&& raws.contains("mystias_izakaya:zhu_zi")) {
			rawlist.add("mystias_izakaya:peng_lai_yu_zhi");
		}
		if (raws.contains("mystias_izakaya:niu_rou") && raws.contains("mystias_izakaya:yang_cong")
				&& raws.contains("mystias_izakaya:nan_gua")) {
			rawlist.add("mystias_izakaya:neng_liang_chuan");
		}
		if (raws.contains("mystias_izakaya:hei_mao_zhu_rou") && raws.contains("mystias_izakaya:ye_zhu_rou")) {
			rawlist.add("mystias_izakaya:er_tian_liu");
		}
		if (raws.contains("mystias_izakaya:zhu_rou") && raws.contains("mystias_izakaya:feng_mi")) {
			rawlist.add("mystias_izakaya:mi_zhi_cha_shao");
		}
		if (raws.contains("mystias_izakaya:zhu_rou") && raws.contains("mystias_izakaya:zun_yu")) {
			rawlist.add("mystias_izakaya:zhu_rou_zun_yu_xun");
		}
		if (raws.contains("mystias_izakaya:mo_gu")) {
			rawlist.add("mystias_izakaya:kao_mo_gu");
		}
		if (raws.contains("mystias_izakaya:ba_mu_man")) {
			rawlist.add("mystias_izakaya:kao_ba_mu_man");
		}
		return rawlist;
	}
}
