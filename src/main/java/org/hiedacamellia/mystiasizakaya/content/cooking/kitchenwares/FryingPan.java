package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.Collections;
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
        if (raws.contains("mystias_izakaya:xia") && raws.contains("mystias_izakaya:mian_fen")) {
            rawlist.add("mystias_izakaya:zha_xia_tian_fu_luo");
        }
        if (raws.contains("mystias_izakaya:zun_yu") && raws.contains("mystias_izakaya:mian_fen") && raws.contains("mystias_izakaya:fen_mi")) {
            rawlist.add("mystias_izakaya:huan_jin_shu_yu_bin");
        }
        if (raws.contains("mystias_izakaya:nai_you") && raws.contains("mystias_izakaya:pang_xie")) {
            rawlist.add("mystias_izakaya:nai_you_ju_xie");
        }
        if (raws.contains("mystias_izakaya:hai_tai") && raws.contains("mystias_izakaya:mian_fen") && raws.contains("mystias_izakaya:zhang_yu")) {
            rawlist.add("mystias_izakaya:zhang_yu_shao");
        }
        if (raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:zhi_shi")) {
            rawlist.add("mystias_izakaya:zhi_shi_dan");
        }
        if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:huang_you")
                && raws.contains("mystias_izakaya:ji_dan") && raws.contains("mystias_izakaya:mian_fen")) {
            rawlist.add("mystias_izakaya:san_wen_yu_tian_fu_luo");
        }
        if (Collections.frequency(raws, "mystias_izakaya:mian_fen") == 2
                && Collections.frequency(raws, "mystias_izakaya:ji_dan") == 2) {
            rawlist.add("mystias_izakaya:ju_ren_yu_zi_shao");
        }
        if (raws.contains("mystias_izakaya:zhi_shi")
                && raws.contains("mystias_izakaya:niu_rou")
                && Collections.frequency(raws, "mystias_izakaya:la_jiao") == 3) {
            rawlist.add("mystias_izakaya:di_yu_ji_xin_jin_gao");
        }
        return rawlist;
    }
}
