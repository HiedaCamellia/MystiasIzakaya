package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CuttingBoard {
    public static List<String> get(List<String> raws) {
        List<String> cuisines = new ArrayList<>();
        if (raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:tu_dou")
                && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:xing_hong_e_mo_dan_gao");
        }
        if (raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:huang_you")
                && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:wu_yi_shi_yao_guai_mu_si");
        }
        if (raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:ji_dan")
                && raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:mao_yu_san_se_bing_ji_ling");
        }
        if (raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:la_jiao")) {
            cuisines.add("mystias_izakaya:mao_yu_rong_yan_dou_fu");
        }
        if (raws.contains("mystias_izakaya:huang_you")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:ji_dan")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:yue_zhi_lian_ren");
        }
        if (raws.contains("mystias_izakaya:tu_dou")
                && raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:yang_cong")) {
            cuisines.add("mystias_izakaya:shu_cai_zhuan_ji");
        }
        if (raws.contains("mystias_izakaya:tao_zi")
                && raws.contains("mystias_izakaya:xia")
                && raws.contains("mystias_izakaya:bing_kuai")) {
            cuisines.add("mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la");
        }
        if (raws.contains("mystias_izakaya:nuo_mi")
                && raws.contains("mystias_izakaya:tao_zi")) {
            cuisines.add("mystias_izakaya:bai_tao_sheng_ba_qiao");
        }
        if (raws.contains("mystias_izakaya:nuo_mi")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:yue_guang_tuan_zi");
        }
        if (raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:zun_yu")) {
            cuisines.add("mystias_izakaya:wen_nuan_fan_tuan");
        }
        if (raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:luo_bu")) {
            cuisines.add("mystias_izakaya:leng_dou_fu");
        }
        if (raws.contains("mystias_izakaya:san_wen_yu")
                && raws.contains("mystias_izakaya:jin_qiang_yu")) {
            cuisines.add("mystias_izakaya:ci_shen_pin_pan");
        }
        if (raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:zhu_zi")) {
            cuisines.add("mystias_izakaya:liu_shui_su_mian");
        }
        if (raws.contains("mystias_izakaya:nuo_mi")) {
            cuisines.add("mystias_izakaya:ma_shu");
        }
        if (raws.contains("mystias_izakaya:luo_bu")) {
            cuisines.add("mystias_izakaya:liang_cai_diao_hua");
        }
        if (raws.contains("mystias_izakaya:hai_tai")) {
            cuisines.add("mystias_izakaya:fan_tuan");
        }
        if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")) {
            cuisines.add("mystias_izakaya:ying_luo_xue");
        }
        if (raws.contains("mystias_izakaya:zhu_rou")) {
            cuisines.add("mystias_izakaya:zhi_zhu_rou_fan_tuan");
        }
        if (raws.contains("mystias_izakaya:zun_yu")) {
            cuisines.add("mystias_izakaya:mi_zhi_xiao_yu_gan");
        }
        if (raws.contains("mystias_izakaya:huang_gua")
                && raws.contains("mystias_izakaya:hei_yan")) {
            cuisines.add("mystias_izakaya:yan_huang_gua");
        }
        if (raws.contains("mystias_izakaya:hai_dan")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:hai_dan_ci_shen");
        }
        if (raws.contains("mystias_izakaya:zun_yu")
                && raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:mian_fen")) {
            cuisines.add("mystias_izakaya:mao_fan");
        }
        if (raws.contains("mystias_izakaya:chan_shui")
                && raws.contains("mystias_izakaya:feng_mi")
                && raws.contains("mystias_izakaya:mian_fen")) {
            cuisines.add("mystias_izakaya:chui_xuan_feng");
        }
        if (raws.contains("mystias_izakaya:san_wen_yu")
                && raws.contains("mystias_izakaya:jin_qiang_yu")
                && raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:zun_yu")
                && raws.contains("mystias_izakaya:bing_kuai")) {
            cuisines.add("mystias_izakaya:da_jiang_hu_chuan_ji");
        }
        if (raws.contains("mystias_izakaya:ning_meng")
                && raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:zhi_shi")) {
            cuisines.add("mystias_izakaya:yin_yu_shui_guo_pai");
        }
        if (Collections.frequency(raws, "mystias_izakaya:nuo_mi") == 2) {
            cuisines.add("mystias_izakaya:sou_ma_tuan_zi");
        }
        if (raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:lian_zi")
                && raws.contains("mystias_izakaya:jin_qiang_yu")
                && raws.contains("mystias_izakaya:bing_di_lian")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:huan_xiang_xing_lian_chuan");
        }
        if (raws.contains("mystias_izakaya:fen_mi")
                && raws.contains("mystias_izakaya:ban_li")) {
            cuisines.add("mystias_izakaya:mi_qian_li_zi");
        }
        if (raws.contains("mystias_izakaya:zhu_zi")
                && raws.contains("mystias_izakaya:xian_hua")
                && raws.contains("mystias_izakaya:mei_zi")
                && raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:song_lu")) {
            cuisines.add("mystias_izakaya:ni_zhuan_tian_di");
        }
        if (raws.contains("mystias_izakaya:hong_dou")
                && raws.contains("mystias_izakaya:nuo_mi")) {
            cuisines.add("mystias_izakaya:hong_dou_da_fu");
        }
        if (raws.contains("mystias_izakaya:zhu_zi")
                && raws.contains("mystias_izakaya:xia")
                && raws.contains("mystias_izakaya:xi_lan_hua")) {
            cuisines.add("mystias_izakaya:zhu_tong_shao_zui_xia");
        }
        if (raws.contains("mystias_izakaya:tao_zi")
                && raws.contains("mystias_izakaya:xu_li")
                && raws.contains("mystias_izakaya:nai_you")
                && raws.contains("mystias_izakaya:ke_ke_dou")
                && raws.contains("mystias_izakaya:mian_fen")) {
            cuisines.add("mystias_izakaya:mao_mi_xi_shui");
        }
        if (raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:xu_li")
                && raws.contains("mystias_izakaya:nai_you")
                && raws.contains("mystias_izakaya:yin_er")) {
            cuisines.add("mystias_izakaya:he_tang_yue_she");
        }
        if (raws.contains("mystias_izakaya:ke_ke_dou")
                &&Collections.frequency(raws, "mystias_izakaya:tao_zi") == 4) {
            cuisines.add("mystias_izakaya:long_yin_tao_zi");
        }
        if (raws.contains("mystias_izakaya:ke_ke_dou")
                && raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:nai_you")) {
            cuisines.add("mystias_izakaya:feng_zi_dan");
        }
        return cuisines;
    }
}
