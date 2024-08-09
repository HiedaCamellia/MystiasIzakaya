package org.hiedacamellia.mystiasizakaya.core.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.List;

public class Grill {
    public static List<String> get(List<String> raws) {
        List<String> cuisines = new ArrayList<>();
        if (raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:feng_mi")
                && raws.contains("mystias_izakaya:tu_dou")
                && raws.contains("mystias_izakaya:luo_bu")) {
            cuisines.add("mystias_izakaya:bu_si_niao");
        }
        if (raws.contains("mystias_izakaya:he_niu")
                && raws.contains("mystias_izakaya:san_wen_yu")
                && raws.contains("mystias_izakaya:zhu_rou")
                && raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:zhu_zi")) {
            cuisines.add("mystias_izakaya:peng_lai_yu_zhi");
        }
        if (raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:nan_gua")) {
            cuisines.add("mystias_izakaya:neng_liang_chuan");
        }
        if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:ye_zhu_rou")) {
            cuisines.add("mystias_izakaya:er_tian_liu");
        }
        if (raws.contains("mystias_izakaya:zhu_rou")
                && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:mi_zhi_cha_shao");
        }
        if (raws.contains("mystias_izakaya:zhu_rou")
                && raws.contains("mystias_izakaya:zun_yu")) {
            cuisines.add("mystias_izakaya:zhu_rou_zun_yu_xun");
        }
        if (raws.contains("mystias_izakaya:mo_gu")) {
            cuisines.add("mystias_izakaya:kao_mo_gu");
        }
        if (raws.contains("mystias_izakaya:ba_mu_man")) {
            cuisines.add("mystias_izakaya:kao_ba_mu_man");
        }
        if (raws.contains("mystias_izakaya:ye_zhu_rou")
                && raws.contains("mystias_izakaya:he_niu")
                && raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
            cuisines.add("mystias_izakaya:quan_rou_sheng_yan");
        }
        if (raws.contains("mystias_izakaya:ye_zhu_rou")
                && raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:yang_cong")) {
            cuisines.add("mystias_izakaya:yi_ji_bi_sha");
        }
        if (raws.contains("mystias_izakaya:di_gua")) {
            cuisines.add("mystias_izakaya:kao_di_gua");
        }
        if (raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:zhi_shi")) {
            cuisines.add("mystias_izakaya:bi_si_kai_wan_bing_gan");
        }
        if (raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:hei_yan")
                && raws.contains("mystias_izakaya:la_jiao")
                && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:hai_dao_xun_rou");
        }
        if (raws.contains("mystias_izakaya:ye_zhu_rou")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:song_lu")
                && raws.contains("mystias_izakaya:xi_hong_shi")) {
            cuisines.add("mystias_izakaya:huan_xiang_feng_mi");
        }
        if (raws.contains("mystias_izakaya:ke_ke_dou")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:ji_dan")) {
            cuisines.add("mystias_izakaya:mao_mi_ke_lu_li");
        }
        if (raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:xi_lan_hua")
                && raws.contains("mystias_izakaya:ye_zhu_rou")) {
            cuisines.add("mystias_izakaya:mao_mi_pi_sha");
        }
        return cuisines;
    }
}
