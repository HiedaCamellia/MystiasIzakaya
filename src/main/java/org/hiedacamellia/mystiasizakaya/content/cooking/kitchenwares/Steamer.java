package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.Collections;
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
        if (raws.contains("mystias_izakaya:nan_gua") && raws.contains("mystias_izakaya:xia") && raws.contains("mystias_izakaya:dou_fu")) {
            rawlist.add("mystias_izakaya:nan_gua_xia_zhong");
        }
        if (raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:pu_tao") && raws.contains("mystias_izakaya:nai_you")) {
            rawlist.add("mystias_izakaya:pu_tong_xia_dan_gao");
        }
        if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:pu_tao") && raws.contains("mystias_izakaya:lu_shui") && raws.contains("mystias_izakaya:huan_tan_hua")) {
            rawlist.add("mystias_izakaya:qi_she_yang_geng");
        }
        if (raws.contains("mystias_izakaya:fen_mi") && raws.contains("mystias_izakaya:tao_zi")) {
            rawlist.add("mystias_izakaya:yin_hua_bu_ding");
        }
        if (raws.contains("mystias_izakaya:zhi_shi")
                && Collections.frequency(raws, "mystias_izakaya:bai_guo") == 2) {
            rawlist.add("mystias_izakaya:shang_qi_zhi_shi_tiao");
        }
        if (raws.contains("mystias_izakaya:zun_yu")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:tao_zi")) {
            rawlist.add("mystias_izakaya:yang_wang_tian_hua_ban_pai");
        }
        if (raws.contains("mystias_izakaya:ning_meng")
                && Collections.frequency(raws, "mystias_izakaya:pu_tao") == 2) {
            rawlist.add("mystias_izakaya:ti_shen_bu_ding");
        }
        if (raws.contains("mystias_izakaya:pu_tao")
                && raws.contains("mystias_izakaya:fen_mi")
                && Collections.frequency(raws, "mystias_izakaya:ning_meng") == 2) {
            rawlist.add("mystias_izakaya:ran_jing_bu_ding");
        }
        if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:fen_mi")
                && raws.contains("mystias_izakaya:mian_fen")
                && raws.contains("mystias_izakaya:chan_shui")) {
            rawlist.add("mystias_izakaya:dou_jia_zheng_gao");
        }
        return rawlist;
    }
}
