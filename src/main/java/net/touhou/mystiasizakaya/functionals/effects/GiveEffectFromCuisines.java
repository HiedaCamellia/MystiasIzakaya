package net.touhou.mystiasizakaya.functionals.effects;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class GiveEffectFromCuisines {
	public static void execute(LevelAccessor world, ItemStack itemstack, LivingEntity entity) {
		String s = ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString();
		switch (s) {
			case "mystias_izakaya:bai_guo_luo_bu_pai_gu_tang":
				break;
			case "mystias_izakaya:bai_tao_sheng_ba_qiao":
				break;
			case "mystias_izakaya:bai_xue":
				break;
			case "mystias_izakaya:ban_ni_di_ke_dan":
				break;
			case "mystias_izakaya:bei_ji_tian_xia_mi_tao_se_la":
				entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 1));
				break;
			case "mystias_izakaya:bu_si_niao":
				break;
			case "mystias_izakaya:chao_rou_si":
				break;
			case "mystias_izakaya:chou_dou_fu":
				break;
			case "mystias_izakaya:ci_shen_pin_pan":
				break;
			case "mystias_izakaya:da_ban_shao":
				break;
			case "mystias_izakaya:da_she_yan":
				break;
			case "mystias_izakaya:dou_fu_guo":
				break;
			case "mystias_izakaya:dou_fu_wei_cheng":
				break;
			case "mystias_izakaya:er_tian_liu":
				break;
			case "mystias_izakaya:fan_tuan":
				break;
			case "mystias_izakaya:hai_xian_wei_cheng_tang":
				break;
			case "mystias_izaka:hong_shao_manyu":
				break;
			case "mystias_izakaya:hua_guang_yu_jian_bao":
				break;
			case "mystias_izakaya:huan_tan_hua_gao":
				break;
			case "mystias_izakaya:huang_you_niu_pai":
				break;
			case "mystias_izakaya:hui_ling_dun_niu_pai":
				break;
			case "mystias_izakaya:kao_ba_mu_man":
				entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0));
				break;
			case "mystias_izakaya:kao_mo_gu":
				break;
			case "mystias_izakaya:leng_dou_fu":
				break;
			case "mystias_izakaya:li_liang_tang":
				entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1));
				break;
			case "mystias_izakaya:liang_cai_diao_hua":
				break;
			case "mystias_izakaya:liu_shui_su_mian":
				break;
			case "mystias_izakaya:lu_shui_zhu_dan":
				break;
			case "mystias_izakaya:ma_po_dou_fu":
				break;
			case "mystias_izakaya:ma_shu":
				break;
			case "mystias_izakaya:mao_yu_rong_yan_dou_fu":
				break;
			case "mystias_izakaya:mao_yu_san_se_bing_ji_ling":
				break;
			case "mystias_izakaya:mi_zhi_xiao_yu_gan":
				break;
			case "mystias_izakaya:mi_zhi_cha_shao":
				break;
			case "mystias_izakaya:mo_gu_rou_pian":
				break;
			case "mystias_izakaya:nai_you_tun_cai":
				break;
			case "mystias_izakaya:neng_liang_chuan":
				break;
			case "mystias_izakaya:niu_rou_gai_jiao_fan":
				break;
			case "mystias_izakaya:peng_lai_yu_zhi":
				break;
			case "mystias_izakaya:re_song_bing":
				break;
			case "mystias_izakaya:sai_xiong_zhang":
				break;
			case "mystias_izakaya:shi_li_yin_xing":
				break;
			case "mystias_izakaya:shu_cai_zhuan_ji":
				break;
			case "mystias_izakaya:shui_jiao":
				break;
			case "mystias_izakaya:shui_zhu_yu":
				entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0));
				break;
			case "mystias_izakaya:si_kang_bing":
				break;
			case "mystias_izakaya:tang_yuan":
				break;
			case "mystias_izakaya:tao_hua_geng":
				entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 1));
				break;
			case "mystias_izakaya:tu_dou_ke_le_bing":
				break;
			case "mystias_izakaya:tun_gu_la_mian":
				break;
			case "mystias_izakaya:wen_nuan_fan_tuan":
				break;
			case "mystias_izakaya:wu_yi_shi_yao_guai_mu_si":
				break;
			case "mystias_izakaya:xiang_jian_san_wen_yu":
				break;
			case "mystias_izakaya:xiang_zha_chan_shui":
				entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0));
				entity.hurt(new DamageSource(
						world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(
								ResourceKey.create(Registries.DAMAGE_TYPE,
										new ResourceLocation("mystias_izakaya:chili")))),
						2);
				break;
			case "mystias_izakaya:xing_hong_e_mo_dan_gao":
				break;
			case "mystias_izakaya:yan_jiang":
				break;
			case "mystias_izakaya:ye_wei_jia_nong":
				break;
			case "mystias_izakaya:yi_shi_hui_fan":
				break;
			case "mystias_izakaya:ying_luo_xue":
				break;
			case "mystias_izakaya:you_dou_fu":
				break;
			case "mystias_izakaya:yue_guang_tuan_zi":
				break;
			case "mystias_izakaya:yue_zhi_lian_ren":
				break;
			case "mystias_izakaya:za_chui":
				break;
			case "mystias_izakaya:zha_ba_mu_man":
				entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0));
				break;
			case "mystias_izakaya:zha_zhu_rou_pai":
				break;
			case "mystias_izakaya:zhen_hai_xian_wei_cheng_tang":
				break;
			case "mystias_izakaya:zhi_zhu_rou_fan_tuan":
				break;
			case "mystias_izakaya:zhu_lu_die":
				break;
			case "mystias_izakaya:zhu_rou_gai_jiao_fan":
				break;
			case "mystias_izakaya:zhu_rou_zun_yu_xun":
				break;
			case "mystias_izakaya:zhu_qu_ji":
				break;
			case "mystias_izakaya:zhu_sun_chao_rou":
				break;
			case "mystias_izakaya:zhu_tong_zheng_dan":
				break;
			case "mystias_izakaya:zhu_dou_fu":
				break;
			default:
				break;

		}
	}
}
/*
 * "mystias_izakaya:xiang_zha_chan_shui",
 * "mystias_izakaya:xing_hong_e_mo_dan_gao",
 * "mystias_izakaya:yan_jiang",
 * "mystias_izakaya:ye_wei_jia_nong",
 * "mystias_izakaya:yi_shi_hui_fan",
 * "mystias_izakaya:ying_luo_xue",
 * "mystias_izakaya:you_dou_fu",
 * "mystias_izakaya:yue_guang_tuan_zi",
 * "mystias_izakaya:yue_zhi_lian_ren",
 * "mystias_izakaya:za_chui",
 * "mystias_izakaya:zha_ba_mu_man",
 * "mystias_izakaya:zha_zhu_rou_pai",
 * "mystias_izakaya:zhen_hai_xian_wei_cheng_tang",
 * "mystias_izakaya:zhi_zhu_rou_fan_tuan",
 * "mystias_izakaya:zhu_lu_die",
 * "mystias_izakaya:zhu_rou_gai_jiao_fan",
 * "mystias_izakaya:zhu_rou_zun_yu_xun",
 * "mystias_izakaya:zhu_qu_ji",
 * "mystias_izakaya:zhu_sun_chao_rou",
 * "mystias_izakaya:zhu_tong_zheng_dan",
 * "mystias_izakaya:zhu_dou_fu"
 */