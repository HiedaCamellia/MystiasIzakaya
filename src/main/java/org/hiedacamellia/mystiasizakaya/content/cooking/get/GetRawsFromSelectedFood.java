package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming.IngredientsCompact;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetRawsFromSelectedFood {
    public static List<ItemStack> execute(LevelAccessor world, double x, double y, double z) {
        ItemStack s;
        ItemStack raw;
        double i;
        List<ItemStack> rawss = new ArrayList<>();
        s = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
        i = 1;
        while (i <= 5) {
            if (!(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i).getItem() == ItemStack.EMPTY.getItem())) {
                raw = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i);
                raw = IngredientsCompact.execute(raw);
                String raws = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(raw.getItem())).toString();
                String ss = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(s.getItem())).toString();
                switch (raws) {
                    case "mystias_izakaya:ba_mu_man":
                        if (!(ss.equals("mystias_izakaya:kao_ba_mu_man") || ss.equals("mystias_izakaya:zha_ba_mu_man")
                                || ss.equals("mystias_izakaya:bai_xue") || ss.equals("mystias_izakaya:hong_shao_man_yu"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:bai_guo":
                        if (!(ss.equals("mystias_izakaya:shi_li_yin_xing") || ss.equals("mystias_izakaya:bai_guo_luo_bu_pai_gu_tang") || ss.equals("mystias_izakaya:zhu_qu_ji"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:bing_kuai":
                        if (!(ss.equals("mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la") || ss.equals("mystias_izakaya:tao_hua_geng"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:chan_shui":
                        if (!(ss.equals("mystias_izakaya:xiang_zha_chan_shui"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:dou_fu":
                        if (!(ss.equals("mystias_izakaya:tun_gu_la_mian") || ss.equals("mystias_izakaya:wu_yi_shi_yao_guai_mu_si") || ss.equals("mystias_izakaya:mao_yu_san_se_bing_ji_ling")
                                || ss.equals("mystias_izakaya:mao_yu_rong_yan_dou_fu") || ss.equals("mystias_izakaya:za_chui") || ss.equals("mystias_izakaya:ma_po_dou_fu")
                                || ss.equals("mystias_izakaya:chou_dou_fu") || ss.equals("mystias_izakaya:leng_dou_fu") || ss.equals("mystias_izakaya:you_dou_fu")
                                || ss.equals("mystias_izakaya:DOU_FU_GUO") || ss.equals("mystias_izakaya:zhu_dou_fu") || ss.equals("mystias_izakaya:dou_fu_wei_cheng"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:feng_mi":
                        if (!(ss.equals("mystias_izakaya:shi_li_yin_xing") || ss.equals("mystias_izakaya:bu_si_niao")
                                || ss.equals("mystias_izakaya:mi_zhi_cha_shao") || ss.equals("mystias_izakaya:re_song_bing") || ss.equals("mystias_izakaya:wu_yi_shi_yao_guai_mu_si")
                                || ss.equals("mystias_izakaya:mao_yu_san_se_bing_ji_ling") || ss.equals("mystias_izakaya:xing_hong_e_mo_dan_gao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:hai_tai":
                        if (!(ss.equals("mystias_izakaya:fan_tuan") || ss.equals("mystias_izakaya:HAI_XIAN_WEI_CHENG_TANG") || ss.equals("mystias_izakaya:li_liang_tang")
                                || ss.equals("mystias_izakaya:za_chui") || ss.equals("mystias_izakaya:zhu_tong_zheng_dan") || ss.equals("mystias_izakaya:bai_xue"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:he_niu":
                        if (!(ss.equals("mystias_izakaya:huang_you_niu_pai") || ss.equals("mystias_izakaya:da_she_yan")
                                || ss.equals("mystias_izakaya:yan_jiang") || ss.equals("mystias_izakaya:peng_lai_yu_zhi") || ss.equals("mystias_izakaya:hui_ling_dun_niu_pai"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:he_tun":
                        if (!(ss.equals("mystias_izakaya:sai_xiong_zhang") || ss.equals("mystias_izakaya:bai_xue") || ss.equals("mystias_izakaya:da_she_yan")
                                || ss.equals("mystias_izakaya:yan_jiang"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:hei_mao_zhu_rou":
                        if (!(ss.equals("mystias_izakaya:zhu_qu_ji") || ss.equals("mystias_izakaya:sai_xiong_zhang") || ss.equals("mystias_izakaya:ye_wei_jia_nong")
                                || ss.equals("mystias_izakaya:er_tian_liu") || ss.equals("mystias_izakaya:hua_guang_yu_jian_bao") || ss.equals("mystias_izakaya:da_she_yan"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:huan_tan_hua":
                        if (!(ss.equals("mystias_izakaya:huan_tan_hua_gao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:huang_you":
                        if (!(ss.equals("mystias_izakaya:si_kang_bing") || ss.equals("mystias_izakaya:nai_you_tun_cai")
                                || ss.equals("mystias_izakaya:ban_ni_di_ke_dan") || ss.equals("mystias_izakaya:wu_yi_shi_yao_guai_mu_si") || ss.equals("mystias_izakaya:huang_you_niu_pai")
                                || ss.equals("mystias_izakaya:yue_zhi_lian_ren") || ss.equals("mystias_izakaya:yi_shi_hui_fan") || ss.equals("mystias_izakaya:hui_ling_dun_niu_pai"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ji_dan":
                        if (!(ss.equals("mystias_izakaya:lu_shui_zhu_dan") || ss.equals("mystias_izakaya:re_song_bing")
                                || ss.equals("mystias_izakaya:ban_ni_di_ke_dan") || ss.equals("mystias_izakaya:zhu_tong_zheng_dan") || ss.equals("mystias_izakaya:yue_zhi_lian_ren")
                                || ss.equals("mystias_izakaya:mao_yu_san_se_bing_ji_ling") || ss.equals("mystias_izakaya:hui_ling_dun_niu_pai"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ji_shang_jin_qiang_yu":
                        if (!(ss.equals("mystias_izakaya:ying_luo_xue"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:jin_qiang_yu":
                        if (!(ss.equals("mystias_izakaya:ci_shen_pin_pan"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:la_jiao":
                        if (!(ss.equals("mystias_izakaya:chou_dou_fu") || ss.equals("mystias_izakaya:ma_po_dou_fu")
                                || ss.equals("mystias_izakaya:shui_zhu_yu") || ss.equals("mystias_izakaya:mao_yu_rong_yan_dou_fu"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:lu_rou":
                        if (!(ss.equals("mystias_izakaya:zhu_lu_die") || ss.equals("mystias_izakaya:peng_lai_yu_zhi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:lu_shui":
                        if (!(ss.equals("mystias_izakaya:lu_shui_zhu_dan") || ss.equals("mystias_izakaya:tao_hua_geng")
                                || ss.equals("mystias_izakaya:xing_hong_e_mo_dan_gao") || ss.equals("mystias_izakaya:mao_yu_san_se_bing_ji_ling") || ss.equals("mystias_izakaya:huan_tan_hua_gao")|| ss.equals("mystias_izakaya:mi_zhi_xian_jun_bao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:luo_bu":
                        if (!(ss.equals("mystias_izakaya:liang_cai_diao_hua") || ss.equals("mystias_izakaya:leng_dou_fu")
                                || ss.equals("mystias_izakaya:da_ban_shao") || ss.equals("mystias_izakaya:bai_guo_luo_bu_pai_gu_tang") || ss.equals("mystias_izakaya:bu_si_niao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:mian_fen":
                        if (!(ss.equals("mystias_izakaya:si_kang_bing") || ss.equals("mystias_izakaya:re_song_bing")|| ss.equals("mystias_izakaya:zha_xia_tian_fu_luo")
                                || ss.equals("mystias_izakaya:da_ban_shao") || ss.equals("mystias_izakaya:shui_jiao") || ss.equals("mystias_izakaya:hui_ling_dun_niu_pai")
                                || ss.equals("mystias_izakaya:yue_zhi_lian_ren") || ss.equals("mystias_izakaya:liu_shui_su_mian") || ss.equals("mystias_izakaya:bu_si_niao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:mo_gu":
                        if (!(ss.equals("mystias_izakaya:kao_mo_gu") || ss.equals("mystias_izakaya:nai_you_tun_cai") || ss.equals("mystias_izakaya:mo_gu_rou_pian") || ss.equals("mystias_izakaya:nai_xiang_mo_gu_tang")
                                || ss.equals("mystias_izakaya:zhu_tong_zheng_dan") || ss.equals("mystias_izakaya:yi_shi_hui_fan") || ss.equals("mystias_izakaya:hua_guang_yu_jian_bao")|| ss.equals("mystias_izakaya:mi_zhi_xian_jun_bao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:nan_gua":
                        if (!(ss.equals("mystias_izakaya:neng_liang_chuan") || ss.equals("mystias_izakaya:shu_cai_zhuan_ji")
                                || ss.equals("mystias_izakaya:xing_hong_e_mo_dan_gao") || ss.equals("mystias_izakaya:ye_wei_jia_nong"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:nai_you":
                        if (!(ss.equals("mystias_izakaya:nai_xiang_mo_gu_tang"))){
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:niu_rou":
                        if (!(ss.equals("mystias_izakaya:niu_rou_gai_jiao_fan") || ss.equals("mystias_izakaya:neng_liang_chuan")
                                || ss.equals("mystias_izakaya:mao_yu_rong_yan_dou_fu") || ss.equals("mystias_izakaya:yan_jiang"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:nuo_mi":
                        if (!(ss.equals("mystias_izakaya:TANG_YUAN") || ss.equals("mystias_izakaya:ma_shu")
                                || ss.equals("mystias_izakaya:bai_tao_sheng_ba_qiao") || ss.equals("mystias_izakaya:yue_guang_tuan_zi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:san_wen_yu":
                        if (!(ss.equals("mystias_izakaya:zhen_hai_xian_wei_cheng_tang") || ss.equals("mystias_izakaya:xiang_jian_san_wen_yu")
                                || ss.equals("mystias_izakaya:ci_shen_pin_pan") || ss.equals("mystias_izakaya:peng_lai_yu_zhi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:song_lu":
                        if (!(ss.equals("mystias_izakaya:zhu_qu_ji") || ss.equals("mystias_izakaya:yan_jiang") || ss.equals("mystias_izakaya:hui_ling_dun_niu_pai")|| ss.equals("mystias_izakaya:mi_zhi_xian_jun_bao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:tao_zi":
                        if (!(ss.equals("mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la") || ss.equals("mystias_izakaya:tao_hua_geng") || ss.equals("mystias_izakaya:bai_tao_sheng_ba_qiao"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:tu_dou":
                        if (!(ss.equals("mystias_izakaya:tu_dou_ke_le_bing") || ss.equals("mystias_izakaya:shu_cai_zhuan_ji") || ss.equals("mystias_izakaya:nai_xiang_mo_gu_tang")
                                || ss.equals("mystias_izakaya:xing_hong_e_mo_dan_gao") || ss.equals("mystias_izakaya:bu_si_niao") || ss.equals("mystias_izakaya:ye_wei_jia_nong"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:xia":
                        if (!(ss.equals("mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la")|| ss.equals("mystias_izakaya:zha_xia_tian_fu_luo"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:yang_cong":
                        if (!(ss.equals("mystias_izakaya:hong_shao_man_yu") || ss.equals("mystias_izakaya:neng_liang_chuan")
                                || ss.equals("mystias_izakaya:shu_cai_zhuan_ji") || ss.equals("mystias_izakaya:bu_si_niao") || ss.equals("mystias_izakaya:mao_yu_rong_yan_dou_fu")
                                || ss.equals("mystias_izakaya:nai_you_tun_cai") || ss.equals("mystias_izakaya:wen_nuan_fan_tuan") || ss.equals("mystias_izakaya:wu_yi_shi_yao_guai_mu_si")
                                || ss.equals("mystias_izakaya:tun_gu_la_mian") || ss.equals("mystias_izakaya:yi_shi_hui_fan"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ye_zhu_rou":
                        if (!(ss.equals("mystias_izakaya:li_liang_tang") || ss.equals("mystias_izakaya:zhu_lu_die") || ss.equals("mystias_izakaya:er_tian_liu"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:yue_guang_cao":
                        if (!(ss.equals("mystias_izakaya:yue_zhi_lian_ren") || ss.equals("mystias_izakaya:zhu_lu_die") || ss.equals("mystias_izakaya:yue_guang_tuan_zi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zhu_rou":
                        if (!(ss.equals("mystias_izakaya:zhi_zhu_rou_fan_tuan") || ss.equals("mystias_izakaya:chao_rou_si") || ss.equals("mystias_izakaya:zhu_rou_gai_jiao_fan")
                                || ss.equals("mystias_izakaya:mo_gu_rou_pian") || ss.equals("mystias_izakaya:zhu_sun_chao_rou") || ss.equals("mystias_izakaya:zha_zhu_rou_pai")
                                || ss.equals("mystias_izakaya:zhu_rou_zun_yu_xun") || ss.equals("mystias_izakaya:ma_po_dou_fu") || ss.equals("mystias_izakaya:tun_gu_la_mian")
                                || ss.equals("mystias_izakaya:bai_guo_luo_bu_pai_gu_tang") || ss.equals("mystias_izakaya:mi_zhi_cha_shao") || ss.equals("mystias_izakaya:peng_lai_yu_zhi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zhu_sun":
                        if (!(ss.equals("mystias_izakaya:zhu_sun_chao_rou") || ss.equals("mystias_izakaya:ban_ni_di_ke_dan") || ss.equals("mystias_izakaya:xiang_jian_san_wen_yu")
                                || ss.equals("mystias_izakaya:zhu_qu_ji") || ss.equals("mystias_izakaya:sai_xiong_zhang") || ss.equals("mystias_izakaya:yi_shi_hui_fan"))) {
                            rawss.add(raw);

                        }
                        break;
                    case "mystias_izakaya:zhu_zi":
                        if (!(ss.equals("mystias_izakaya:liu_shui_su_mian") || ss.equals("mystias_izakaya:zhu_tong_zheng_dan")
                                || ss.equals("mystias_izakaya:zhu_qu_ji") || ss.equals("mystias_izakaya:peng_lai_yu_zhi"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zun_yu":
                        if (!(ss.equals("mystias_izakaya:zhu_rou_zun_yu_xun") || ss.equals("mystias_izakaya:mi_zhi_xiao_yu_gan") || ss.equals("mystias_izakaya:wen_nuan_fan_tuan")
                                || ss.equals("mystias_izakaya:za_chui") || ss.equals("mystias_izakaya:zhen_hai_xian_wei_cheng_tang") || ss.equals("mystias_izakaya:shui_zhu_yu"))) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:pang_xie":
                    default:
                        rawss.add(raw);
                        break;
                }
            }
            i = i + 1;
        }
        return new ArrayList<>(rawss);
    }
}
