package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class CuttingBoard {
	public static List<String> get(List<String> raws) {
        List<String> rawlist = new ArrayList<>();
		if (raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:nan_gua")
				&& raws.contains("mystias_izakaya:tu_dou") && raws.contains("mystias_izakaya:feng_mi")) {
			rawlist.add("mystias_izakaya:xing_hong_e_mo_dan_gao");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:yang_cong")
				&& raws.contains("mystias_izakaya:huang_you") && raws.contains("mystias_izakaya:feng_mi")) {
			rawlist.add("mystias_izakaya:wu_yi_shi_yao_guai_mu_si");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:ji_dan")
				&& raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:feng_mi")) {
			rawlist.add("mystias_izakaya:mao_yu_san_se_bing_ji_ling");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:niu_rou")
				&& raws.contains("mystias_izakaya:yang_cong") && raws.contains("mystias_izakaya:la_jiao")) {
			rawlist.add("mystias_izakaya:mao_yu_rong_yan_dou_fu");
		}
		if (raws.contains("mystias_izakaya:huang_you") && raws.contains("mystias_izakaya:mian_fen")
				&& raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:yue_guang_cao")) {
			rawlist.add("mystias_izakaya:yue_zhi_lian_ren");
		}
		if (raws.contains("mystias_izakaya:tu_dou") && raws.contains("mystias_izakaya:nan_gua")
				&& raws.contains("mystias_izakaya:yang_cong")) {
			rawlist.add("mystias_izakaya:shu_cai_zhuan_ji");
		}
		if (raws.contains("mystias_izakaya:tao_zi") && raws.contains("mystias_izakaya:xia")
				&& raws.contains("mystias_izakaya:bing_kuai")) {
			rawlist.add("mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la");
		}
		if (raws.contains("mystias_izakaya:nuo_mi") && raws.contains("mystias_izakaya:tao_zi")) {
			rawlist.add("mystias_izakaya:bai_tao_sheng_ba_qiao");
		}
		if (raws.contains("mystias_izakaya:nuo_mi") && raws.contains("mystias_izakaya:yue_guang_cao")) {
			rawlist.add("mystias_izakaya:yue_guang_tuan_zi");
		}
		if (raws.contains("mystias_izakaya:yang_cong") && raws.contains("mystias_izakaya:zun_yu")) {
			rawlist.add("mystias_izakaya:wen_nuan_fan_tuan");
		}
		if (raws.contains("mystias_izakaya:dou_fu") && raws.contains("mystias_izakaya:luo_bu")) {
			rawlist.add("mystias_izakaya:leng_dou_fu");
		}
		if (raws.contains("mystias_izakaya:san_wen_yu") && raws.contains("mystias_izakaya:jin_qiang_yu")) {
			rawlist.add("mystias_izakaya:ci_shen_pin_pan");
		}
		if (raws.contains("mystias_izakaya:mian_fen") && raws.contains("mystias_izakaya:zhu_zi")) {
			rawlist.add("mystias_izakaya:liu_shui_su_mian");
		}
		if (raws.contains("mystias_izakaya:nuo_mi")) {
			rawlist.add("mystias_izakaya:ma_shu");
		}
		if (raws.contains("mystias_izakaya:luo_bu")) {
			rawlist.add("mystias_izakaya:liang_cai_diao_hua");
		}
		if (raws.contains("mystias_izakaya:hai_tai")) {
			rawlist.add("mystias_izakaya:fan_tuan");
		}
		if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")) {
			rawlist.add("mystias_izakaya:ying_luo_xue");
		}
		if (raws.contains("mystias_izakaya:zhu_rou")) {
			rawlist.add("mystias_izakaya:zhi_zhu_rou_fan_tuan");
		}
		if (raws.contains("mystias_izakaya:zun_yu")) {
			rawlist.add("mystias_izakaya:mi_zhi_xiao_yu_gan");
		}
		return rawlist;
	}
}
