package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Steamer {
    public static List<String> get(List<String> raws) {
        List<String> cuisines = new ArrayList<>();
        if (raws.contains("mystias_izakaya:zhu_zi") && raws.contains("mystias_izakaya:zhu_sun")
                && raws.contains("mystias_izakaya:song_lu") && raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:bai_guo")) {
            cuisines.add("mystias_izakaya:zhu_qu_ji");
        }
        if (raws.contains("mystias_izakaya:yang_cong") && raws.contains("mystias_izakaya:zhu_sun")
                && raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:huang_you")) {
            cuisines.add("mystias_izakaya:yi_shi_hui_fan");
        }
        if (raws.contains("mystias_izakaya:zhu_zi") && raws.contains("mystias_izakaya:ji_dan")
                && raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:hai_tai")) {
            cuisines.add("mystias_izakaya:zhu_tong_zheng_dan");
        }
        if (raws.contains("mystias_izakaya:mo_gu") && raws.contains("mystias_izakaya:yang_cong")
                && raws.contains("mystias_izakaya:huang_you")) {
            cuisines.add("mystias_izakaya:nai_you_tun_cai");
        }
        if (raws.contains("mystias_izakaya:hei_mao_zhu_rou") && raws.contains("mystias_izakaya:he_tun")
                && raws.contains("mystias_izakaya:zhu_sun")) {
            cuisines.add("mystias_izakaya:sai_xiong_zhang");
        }
        if (raws.contains("mystias_izakaya:ye_zhu_rou") && raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:zhu_lu_die");
        }
        if (raws.contains("mystias_izakaya:huang_you") && raws.contains("mystias_izakaya:mian_fen")) {
            cuisines.add("mystias_izakaya:si_kang_bing");
        }
        if (raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:ji_dan")) {
            cuisines.add("mystias_izakaya:lu_shui_zhu_dan");
        }
        if (raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:huan_tan_hua")) {
            cuisines.add("mystias_izakaya:huan_tan_hua_gao");
        }
        if (raws.contains("mystias_izakaya:bai_guo") && raws.contains("mystias_izakaya:feng_mi")) {
            cuisines.add("mystias_izakaya:shi_li_yin_xing");
        }
        if (raws.contains("mystias_izakaya:nan_gua") && raws.contains("mystias_izakaya:xia") && raws.contains("mystias_izakaya:dou_fu")) {
            cuisines.add("mystias_izakaya:nan_gua_xia_zhong");
        }
        if (raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:pu_tao") && raws.contains("mystias_izakaya:nai_you")) {
            cuisines.add("mystias_izakaya:pu_tong_xia_dan_gao");
        }
        if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:pu_tao") && raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:huan_tan_hua")) {
            cuisines.add("mystias_izakaya:qi_she_yang_geng");
        }
        if (raws.contains("mystias_izakaya:feng_mi") && raws.contains("mystias_izakaya:tao_zi")) {
            cuisines.add("mystias_izakaya:yin_hua_bu_ding");
        }
        if (raws.contains("mystias_izakaya:zhi_shi")
                && Collections.frequency(raws, "mystias_izakaya:bai_guo") == 2) {
            cuisines.add("mystias_izakaya:shang_qi_zhi_shi_tiao");
        }
        if (raws.contains("mystias_izakaya:zun_yu")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:tao_zi")) {
            cuisines.add("mystias_izakaya:yang_wang_tian_hua_ban_pai");
        }
        if (raws.contains("mystias_izakaya:ning_meng")
                && Collections.frequency(raws, "mystias_izakaya:pu_tao") == 2) {
            cuisines.add("mystias_izakaya:ti_shen_bu_ding");
        }
        if (raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:feng_mi")
                && Collections.frequency(raws, "mystias_izakaya:ning_meng") == 2) {
            cuisines.add("mystias_izakaya:ran_jing_bu_ding");
        }
        if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:feng_mi")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:chan_shui")) {
            cuisines.add("mystias_izakaya:dou_jia_zheng_gao");
        }
        if (raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:huan_tan_hua")
                && raws.contains("mystias_izakaya:feng_mi")
                && raws.contains("mystias_izakaya:nai_you")) {
            cuisines.add("mystias_izakaya:jin_xia_da_mao_xian");
        }
        if (raws.contains("mystias_izakaya:bai_guo")
                && raws.contains("mystias_izakaya:lian_zi.json")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:huang_you")) {
            cuisines.add("mystias_izakaya:sheng_bai_lian_zi_gao");
        }
        if (raws.contains("mystias_izakaya:nuo_mi")
                && raws.contains("mystias_izakaya:song_zi")) {
            cuisines.add("mystias_izakaya:song_zi_gao");
        }
        if (raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:song_zi")
                && raws.contains("mystias_izakaya:bai_guo")) {
            cuisines.add("mystias_izakaya:bai_lu_zhen_song");
        }
        if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:lian_zi.json")
                && raws.contains("mystias_izakaya:bing_di_lian")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:he_hua_yu_mi_zhan");
        }
        if (raws.contains("mystias_izakaya:zhu_zi")
                && raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
            cuisines.add("mystias_izakaya:zhu_tong_fen_zheng_dan");
        }
        if (raws.contains("mystias_izakaya:huang_gua")
                && raws.contains("mystias_izakaya:ji_dan")
                && raws.contains("mystias_izakaya:luo_bu")
                && raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:chui_zhu_yin_chun");
        }
        if (raws.contains("mystias_izakaya:hai_dan")
                && raws.contains("mystias_izakaya:ji_dan")) {
            cuisines.add("mystias_izakaya:hai_dan_zheng_dan");
        }
        if (raws.contains("mystias_izakaya:xian_hua")
                && raws.contains("mystias_izakaya:yue_guang_cao")
                && raws.contains("mystias_izakaya:nai_you")) {
            cuisines.add("mystias_izakaya:hua_niao_feng_yue");
        }
        if (raws.contains("mystias_izakaya:xian_hua")
                && raws.contains("mystias_izakaya:huan_tan_hua")
                && raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:nai_you")
                && raws.contains("mystias_izakaya:yue_guang_cao")) {
            cuisines.add("mystias_izakaya:you_meng");
        }
        if (raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:huan_tan_hua")
                && raws.contains("mystias_izakaya:nai_you")
                && raws.contains("mystias_izakaya:bai_guo")) {
            cuisines.add("mystias_izakaya:xiao_xiao_de_tian_mi_du_yao");
        }
        if (raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:xia")) {
            cuisines.add("mystias_izakaya:chang_fa_gong_zhu");
        }
        if (raws.contains("mystias_izakaya:tao_zi")
                && raws.contains("mystias_izakaya:hong_dou")
                && raws.contains("mystias_izakaya:xu_li")) {
            cuisines.add("mystias_izakaya:tao_hua_liu_li_juan");
        }
        if (raws.contains("mystias_izakaya:ke_ke_dou")
                && raws.contains("mystias_izakaya:yin_er")
                && raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:sheng_ming_zhi_yuan");
        }
        if (raws.contains("mystias_izakaya:xu_li")
                && raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:pang_xie")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:huo_xing");
        }
        if (raws.contains("mystias_izakaya:ke_ke_dou")
                && raws.contains("mystias_izakaya:nai_you")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:xi_lan_hua")) {
            cuisines.add("mystias_izakaya:feng_mao_zi_cha_hui");
        }
        return cuisines;
    }
}
