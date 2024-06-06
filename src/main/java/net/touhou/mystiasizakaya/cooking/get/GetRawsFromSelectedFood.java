package net.touhou.mystiasizakaya.cooking.get;

import net.minecraftforge.registries.ForgeRegistries;
import net.touhou.mystiasizakaya.procedures.YHCProcedure;
import net.touhou.mystiasizakaya.util.GetItemStack;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

public class GetRawsFromSelectedFood {
    public static ArrayList execute(LevelAccessor world, double x, double y, double z) {
        ItemStack s = ItemStack.EMPTY;
        ItemStack raw = ItemStack.EMPTY;
        double i = 0;
        List<Object> rawss = new ArrayList<>();
        s = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), 12);
        i = 1;
        while (i <= 5) {
            if (!(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i).getItem() == ItemStack.EMPTY.getItem())) {
                raw = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i);
                raw = YHCProcedure.execute(raw);
                String raws = (ForgeRegistries.ITEMS.getKey(raw.getItem()).toString());
                switch (raws) {
                    case "mystias_izakaya:ba_mu_man":
                        if (!(s.getItem() == MystiasIzakayaModItems.KAO_BA_MU_MAN.get() || s.getItem() == MystiasIzakayaModItems.ZHA_BA_MU_MAN.get()
                                || s.getItem() == MystiasIzakayaModItems.BAI_XUE.get() || s.getItem() == MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:bai_guo":
                        if (!(s.getItem() == MystiasIzakayaModItems.SHI_LI_YIN_XING.get() || s.getItem() == MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() || s.getItem() == MystiasIzakayaModItems.ZHU_QU_JI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:bing_kuai":
                        if (!(s.getItem() == MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() || s.getItem() == MystiasIzakayaModItems.TAO_HUA_GENG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:chan_shui":
                        if (!(s.getItem() == MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:dou_fu":
                        if (!(s.getItem() == MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() || s.getItem() == MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() || s.getItem() == MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get()
                                || s.getItem() == MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.ZA_CHUI.get() || s.getItem() == MystiasIzakayaModItems.MA_PO_DOU_FU.get()
                                || s.getItem() == MystiasIzakayaModItems.CHOU_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.LENG_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.YOU_DOU_FU.get()
                                || s.getItem() == MystiasIzakayaModItems.DOU_FU_GUO.get() || s.getItem() == MystiasIzakayaModItems.ZHU_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:feng_mi":
                        if (!(s.getItem() == MystiasIzakayaModItems.SHI_LI_YIN_XING.get() || s.getItem() == MystiasIzakayaModItems.BU_SI_NIAO.get()
                                || s.getItem() == MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() || s.getItem() == MystiasIzakayaModItems.RE_SONG_BING.get() || s.getItem() == MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get()
                                || s.getItem() == MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() || s.getItem() == MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:hai_tai":
                        if (!(s.getItem() == MystiasIzakayaModItems.FAN_TUAN.get() || s.getItem() == MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get() || s.getItem() == MystiasIzakayaModItems.LI_LIANG_TANG.get()
                                || s.getItem() == MystiasIzakayaModItems.ZA_CHUI.get() || s.getItem() == MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() || s.getItem() == MystiasIzakayaModItems.BAI_XUE.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:he_niu":
                        if (!(s.getItem() == MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get() || s.getItem() == MystiasIzakayaModItems.DA_SHE_YAN.get()
                                || s.getItem() == MystiasIzakayaModItems.YAN_JIANG.get() || s.getItem() == MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get() || s.getItem() == MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:he_tun":
                        if (!(s.getItem() == MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() || s.getItem() == MystiasIzakayaModItems.BAI_XUE.get() || s.getItem() == MystiasIzakayaModItems.DA_SHE_YAN.get()
                                || s.getItem() == MystiasIzakayaModItems.YAN_JIANG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:hei_mao_zhu_rou":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHU_QU_JI.get() || s.getItem() == MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() || s.getItem() == MystiasIzakayaModItems.YE_WEI_JIA_NONG.get()
                                || s.getItem() == MystiasIzakayaModItems.ER_TIAN_LIU.get() || s.getItem() == MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get() || s.getItem() == MystiasIzakayaModItems.DA_SHE_YAN.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:huan_tan_hua":
                        if (!(s.getItem() == MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:huang_you":
                        if (!(s.getItem() == MystiasIzakayaModItems.SI_KANG_BING.get() || s.getItem() == MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get()
                                || s.getItem() == MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() || s.getItem() == MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() || s.getItem() == MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get()
                                || s.getItem() == MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() || s.getItem() == MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() || s.getItem() == MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ji_dan":
                        if (!(s.getItem() == MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() || s.getItem() == MystiasIzakayaModItems.RE_SONG_BING.get()
                                || s.getItem() == MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() || s.getItem() == MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() || s.getItem() == MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get()
                                || s.getItem() == MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() || s.getItem() == MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ji_shang_jin_qiang_yu":
                        if (!(s.getItem() == MystiasIzakayaModItems.YING_LUO_XUE.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:jin_qiang_yu":
                        if (!(s.getItem() == MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:la_jiao":
                        if (!(s.getItem() == MystiasIzakayaModItems.CHOU_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.MA_PO_DOU_FU.get()
                                || s.getItem() == MystiasIzakayaModItems.SHUI_ZHU_YU.get() || s.getItem() == MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:lu_rou":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHU_LU_DIE.get() || s.getItem() == MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:lu_shui":
                        if (!(s.getItem() == MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() || s.getItem() == MystiasIzakayaModItems.TAO_HUA_GENG.get()
                                || s.getItem() == MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() || s.getItem() == MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() || s.getItem() == MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:luo_bu":
                        if (!(s.getItem() == MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get() || s.getItem() == MystiasIzakayaModItems.LENG_DOU_FU.get()
                                || s.getItem() == MystiasIzakayaModItems.DA_BAN_SHAO.get() || s.getItem() == MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() || s.getItem() == MystiasIzakayaModItems.BU_SI_NIAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:mian_fen":
                        if (!(s.getItem() == MystiasIzakayaModItems.SI_KANG_BING.get() || s.getItem() == MystiasIzakayaModItems.RE_SONG_BING.get()
                                || s.getItem() == MystiasIzakayaModItems.DA_BAN_SHAO.get() || s.getItem() == MystiasIzakayaModItems.SHUI_JIAO.get() || s.getItem() == MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get()
                                || s.getItem() == MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() || s.getItem() == MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() || s.getItem() == MystiasIzakayaModItems.BU_SI_NIAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:mo_gu":
                        if (!(s.getItem() == MystiasIzakayaModItems.KAO_MO_GU.get() || s.getItem() == MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() || s.getItem() == MystiasIzakayaModItems.MO_GU_ROU_PIAN.get()
                                || s.getItem() == MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() || s.getItem() == MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() || s.getItem() == MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:nan_gua":
                        if (!(s.getItem() == MystiasIzakayaModItems.NENG_LIANG_CHUAN.get() || s.getItem() == MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get()
                                || s.getItem() == MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() || s.getItem() == MystiasIzakayaModItems.YE_WEI_JIA_NONG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:niu_rou":
                        if (!(s.getItem() == MystiasIzakayaModItems.NIU_ROU_GAI_JIAO_FAN.get() || s.getItem() == MystiasIzakayaModItems.NENG_LIANG_CHUAN.get()
                                || s.getItem() == MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.YAN_JIANG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:nuo_mi":
                        if (!(s.getItem() == MystiasIzakayaModItems.TANG_YUAN.get() || s.getItem() == MystiasIzakayaModItems.MA_SHU.get()
                                || s.getItem() == MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get() || s.getItem() == MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:pang_xie":
                        rawss.add(raw);
                        break;
                    case "mystias_izakaya:san_wen_yu":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() || s.getItem() == MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get()
                                || s.getItem() == MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get() || s.getItem() == MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:song_lu":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHU_QU_JI.get() || s.getItem() == MystiasIzakayaModItems.YAN_JIANG.get() || s.getItem() == MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:tao_zi":
                        if (!(s.getItem() == MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() || s.getItem() == MystiasIzakayaModItems.TAO_HUA_GENG.get() || s.getItem() == MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:tu_dou":
                        if (!(s.getItem() == MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get() || s.getItem() == MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get()
                                || s.getItem() == MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() || s.getItem() == MystiasIzakayaModItems.BU_SI_NIAO.get() || s.getItem() == MystiasIzakayaModItems.YE_WEI_JIA_NONG.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:xia":
                        if (!(s.getItem() == MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:yang_cong":
                        if (!(s.getItem() == MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get() || s.getItem() == MystiasIzakayaModItems.NENG_LIANG_CHUAN.get()
                                || s.getItem() == MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get() || s.getItem() == MystiasIzakayaModItems.BU_SI_NIAO.get() || s.getItem() == MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get()
                                || s.getItem() == MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() || s.getItem() == MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get() || s.getItem() == MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get()
                                || s.getItem() == MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() || s.getItem() == MystiasIzakayaModItems.YI_SHI_HUI_FAN.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:ye_zhu_rou":
                        if (!(s.getItem() == MystiasIzakayaModItems.LI_LIANG_TANG.get() || s.getItem() == MystiasIzakayaModItems.ZHU_LU_DIE.get() || s.getItem() == MystiasIzakayaModItems.ER_TIAN_LIU.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:yue_guang_cao":
                        if (!(s.getItem() == MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() || s.getItem() == MystiasIzakayaModItems.ZHU_LU_DIE.get() || s.getItem() == MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zhu_rou":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get() || s.getItem() == MystiasIzakayaModItems.CHAO_ROU_SI.get() || s.getItem() == MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get()
                                || s.getItem() == MystiasIzakayaModItems.MO_GU_ROU_PIAN.get() || s.getItem() == MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() || s.getItem() == MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get()
                                || s.getItem() == MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() || s.getItem() == MystiasIzakayaModItems.MA_PO_DOU_FU.get() || s.getItem() == MystiasIzakayaModItems.TUN_GU_LA_MIAN.get()
                                || s.getItem() == MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() || s.getItem() == MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() || s.getItem() == MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zhu_sun":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() || s.getItem() == MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() || s.getItem() == MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get()
                                || s.getItem() == MystiasIzakayaModItems.ZHU_QU_JI.get() || s.getItem() == MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() || s.getItem() == MystiasIzakayaModItems.YI_SHI_HUI_FAN.get())) {
                            rawss.add(raw);

                        }
                        break;
                    case "mystias_izakaya:zhu_zi":
                        if (!(s.getItem() == MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() || s.getItem() == MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get()
                                || s.getItem() == MystiasIzakayaModItems.ZHU_QU_JI.get() || s.getItem() == MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get())) {
                            rawss.add(raw);
                        }
                        break;
                    case "mystias_izakaya:zun_yu":
                        if (!(s.getItem() == MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() || s.getItem() == MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get() || s.getItem() == MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get()
                                || s.getItem() == MystiasIzakayaModItems.ZA_CHUI.get() || s.getItem() == MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() || s.getItem() == MystiasIzakayaModItems.SHUI_ZHU_YU.get())) {
                            rawss.add(raw);
                        }
                        break;
                    default:
                        rawss.add(raw);
                        break;
                }
            }
            i = i + 1;
        }
        ArrayList<Object> araws = new ArrayList<>(rawss);
        return araws;
    }
}
