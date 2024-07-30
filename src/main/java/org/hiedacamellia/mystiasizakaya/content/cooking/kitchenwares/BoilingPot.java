package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoilingPot {
    public static List<String> get(List<String> raws) {
        List<String> cuisines = new ArrayList<>();
        if (raws.contains("mystias_izakaya:dou_fu")) {
            cuisines.add("mystias_izakaya:dou_fu_wei_cheng");
        }
        if (raws.contains("mystias_izakaya:dou_fu")) {
            cuisines.add("mystias_izakaya:dou_fu_guo");
        }
        if (raws.contains("mystias_izakaya:dou_fu")) {
            cuisines.add("mystias_izakaya:zhu_dou_fu");
        }
        if (raws.contains("mystias_izakaya:hai_tai")) {
            cuisines.add("mystias_izakaya:hai_xian_wei_cheng_tang");
        }
        if (raws.contains("mystias_izakaya:hai_tai")
                && raws.contains("mystias_izakaya:zhu_rou")
                && raws.contains("mystias_izakaya:ji_dan")) {
            cuisines.add("mystias_izakaya:tun_gu_la_mian");
        }
        if (raws.contains("mystias_izakaya:bai_guo")
                && raws.contains("mystias_izakaya:zhu_rou")
                && raws.contains("mystias_izakaya:luo_bu")) {
            cuisines.add("mystias_izakaya:bai_guo_luo_bu_pai_gu_tang");
        }
        if (raws.contains("mystias_izakaya:he_tun")
                && raws.contains("mystias_izakaya:ba_mu_man")
                && raws.contains("mystias_izakaya:hai_tai")) {
            cuisines.add("mystias_izakaya:bai_xue");
        }
        if (raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:he_niu")
                && raws.contains("mystias_izakaya:he_tun")) {
            cuisines.add("mystias_izakaya:da_she_yan");
        }
        if (raws.contains("mystias_izakaya:hai_tai")
                && raws.contains("mystias_izakaya:ye_zhu_rou")) {
            cuisines.add("mystias_izakaya:li_liang_tang");
        }
        if (raws.contains("mystias_izakaya:niu_rou")) {
            cuisines.add("mystias_izakaya:li_liang_tang");
        }
        if (raws.contains("mystias_izakaya:tao_zi")
                && raws.contains("mystias_izakaya:lu_shui")
                && raws.contains("mystias_izakaya:bing_kuai")) {
            cuisines.add("mystias_izakaya:tao_hua_geng");
        }
        if (raws.contains("mystias_izakaya:he_niu")
                && raws.contains("mystias_izakaya:he_tun")
                && raws.contains("mystias_izakaya:song_zi")
                && raws.contains("mystias_izakaya:niu_rou")) {
            cuisines.add("mystias_izakaya:yan_jiang");
        }
        if (raws.contains("mystias_izakaya:mian_fen")) {
            cuisines.add("mystias_izakaya:shui_jiao");
        }
        if (raws.contains("mystias_izakaya:zun_yu")
                && raws.contains("mystias_izakaya:la_jiao")) {
            cuisines.add("mystias_izakaya:shui_zhu_yu");
        }
        if (raws.contains("mystias_izakaya:nuo_mi")) {
            cuisines.add("mystias_izakaya:tang_yuan");
        }
        if (raws.contains("mystias_izakaya:tu_dou")
                && raws.contains("mystias_izakaya:nan_gua")
                && raws.contains("mystias_izakaya:hei_mao_zhu_rou")) {
            cuisines.add("mystias_izakaya:ye_wei_jia_nong");
        }
        if (raws.contains("mystias_izakaya:hai_tai")
                && raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:zun_yu")) {
            cuisines.add("mystias_izakaya:za_chui");
        }
        if (raws.contains("mystias_izakaya:san_wen_yu")
                && raws.contains("mystias_izakaya:zun_yu")) {
            cuisines.add("mystias_izakaya:zhen_hai_xian_wei_cheng_tang");
        }
        if (raws.contains("mystias_izakaya:zhu_rou")) {
            cuisines.add("mystias_izakaya:zhu_rou_gai_jiao_fan");
        }
        if (raws.contains("mystias_izakaya:niu_rou")) {
            cuisines.add("mystias_izakaya:niu_rou_gai_jiao_fan");
        }
        if (raws.contains("mystias_izakaya:song_lu")
                && raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:mi_zhi_xian_jun_bao");
        }
        if (raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:tu_dou")
                && raws.contains("mystias_izakaya:nai_you")) {
            cuisines.add("mystias_izakaya:nai_xiang_mo_gu_tang");
        }
        if (raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:xia")
                && raws.contains("mystias_izakaya:zhang_yu")
                && raws.contains("mystias_izakaya:la_jiao")) {
            cuisines.add("mystias_izakaya:mo_nv_de_wu_ta_hui");
        }
        if (raws.contains("mystias_izakaya:lu_rou")
                && raws.contains("mystias_izakaya:song_lu")
                && raws.contains("mystias_izakaya:chan_shui")) {
            cuisines.add("mystias_izakaya:ni_jiu_zi_yu");
        }
        if (raws.contains("mystias_izakaya:he_niu")
                && raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:hei_mao_zhu_rou")
                && raws.contains("mystias_izakaya:he_tun")
                && raws.contains("mystias_izakaya:song_lu")) {
            cuisines.add("mystias_izakaya:huan_xiang_fou_tiao_qiang");
        }
        if (raws.contains("mystias_izakaya:niu_rou")) {
            cuisines.add("mystias_izakaya:shi_zi_tou");
        }
        if (raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:luo_bu")
                && raws.contains("mystias_izakaya:dou_fu")
                && Collections.frequency(raws, "mystias_izakaya:la_jiao") == 2) {
            cuisines.add("mystias_izakaya:jue_jiao_guan_dou_zhu");
        }
        if (raws.contains("mystias_izakaya:huan_tan_hua")
                && raws.contains("mystias_izakaya:zhu_sun")
                && raws.contains("mystias_izakaya:song_zi")
                && raws.contains("mystias_izakaya:lian_zi")
                && raws.contains("mystias_izakaya:song_lu")) {
            cuisines.add("mystias_izakaya:luo_han_shang_su");
        }
        if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:luo_bu")
                && raws.contains("mystias_izakaya:ji_dan")
                && raws.contains("mystias_izakaya:bai_guo")) {
            cuisines.add("mystias_izakaya:tai_ji_ba_gua_yu_du");
        }
        if (raws.contains("mystias_izakaya:song_lu")
                && raws.contains("mystias_izakaya:mo_gu")
                && raws.contains("mystias_izakaya:ban_li")) {
            cuisines.add("mystias_izakaya:tian_shi_ban_li_meng_gu");
        }
        if (raws.contains("mystias_izakaya:ba_mu_man")
                && raws.contains("mystias_izakaya:dou_fu")
                && raws.contains("mystias_izakaya:pang_xie")
                && raws.contains("mystias_izakaya:zhu_zi")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:han_gong_chang_jiao");
        }
        if (raws.contains("mystias_izakaya:zhu_zi")
                && raws.contains("mystias_izakaya:zhu_sun")
                && raws.contains("mystias_izakaya:niu_rou")) {
            cuisines.add("mystias_izakaya:shi_guo_zhu_sun_dun_rou");
        }
        if (raws.contains("mystias_izakaya:hai_tai")
                && raws.contains("mystias_izakaya:mei_zi")) {
            cuisines.add("mystias_izakaya:mei_zi_cha_pao_fan");
        }
        if (raws.contains("mystias_izakaya:chun_chun.json")
                && raws.contains("mystias_izakaya:mo_gu")) {
            cuisines.add("mystias_izakaya:lv_ye_xian_gu");
        }
        if (raws.contains("mystias_izakaya:he_tun")
                && raws.contains("mystias_izakaya:mei_zi")
                && raws.contains("mystias_izakaya:ba_mu_man")
                && raws.contains("mystias_izakaya:bai_guo")) {
            cuisines.add("mystias_izakaya:du_zhang_hua_yuan");
        }
        if (raws.contains("mystias_izakaya:la_jiao")
                && raws.contains("mystias_izakaya:luo_bu")
                && raws.contains("mystias_izakaya:song_lu")
                && raws.contains("mystias_izakaya:niu_rou")
                && raws.contains("mystias_izakaya:he_niu")) {
            cuisines.add("mystias_izakaya:niu_rou_yuan_yang_huo_guo");
        }
        if (raws.contains("mystias_izakaya:hai_dan")
                && raws.contains("mystias_izakaya:jin_qiang_yu")
                && raws.contains("mystias_izakaya:yin_er")
                && raws.contains("mystias_izakaya:lu_shui")) {
            cuisines.add("mystias_izakaya:hai_dan_xin_xuan_bing");
        }
        if (raws.contains("mystias_izakaya:yin_er")
                && raws.contains("mystias_izakaya:lian_zi")) {
            cuisines.add("mystias_izakaya:yang_xin_zhou");
        }
        if (raws.contains("mystias_izakaya:ji_shang_jin_qiang_yu")
                && raws.contains("mystias_izakaya:hai_tai")
                && raws.contains("mystias_izakaya:zhang_yu")
                && raws.contains("mystias_izakaya:pang_xie")
                && raws.contains("mystias_izakaya:xia")) {
            cuisines.add("mystias_izakaya:zhi_zhung_hai_xian_mian");
        }
        return cuisines;
    }
}
