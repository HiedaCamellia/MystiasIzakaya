package net.touhou.mystiasizakaya.procedures;

import org.checkerframework.checker.units.qual.s;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.ArrayList;

public class GiveEffectFromIngredientsProcedure {
	public static void execute(ItemStack itemstack, LivingEntity entity) {
		String s = "";
		s = itemstack.getOrCreateTag().getString("ingredients");
		if (s.isEmpty()) {
			s=ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString();
		}
		String[] tags = s.split(",");
		for (int i = 0; i < tags.length; i++) {
			String t = tags[i];
			switch (t) {
				case "tag.mystias_izakaya.ba_mu_man":
					entity.removeEffect(MobEffects.DARKNESS);
					entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0));
					break;
				case "tag.mystias_izakaya.bai_guo":
					//
					break;
				case "tag.mystias_izakaya.ban_li":
					//
					break;
				case "tag.mystias_izakaya.bing_kuai":
					entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0));
					break;
				case "tag.mystias_izakaya.bing_di_lian":
					//
					break;
				case "tag.mystias_izakaya.chan_shui":
					//
					break;
				case "tag.mystias_izakaya.di_gua":
					//
					break;
				case "tag.mystias_izakaya.dou_fu":
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
					break;
				case "tag.mystias_izakaya.feng_mi":
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 0));
					break;
				case "tag.mystias_izakaya.hai_dan":
					//
					break;
				case "tag.mystias_izakaya.hai_tai":
					//
					break;
				case "tag.mystias_izakaya.he_niu":
					//
					break;
				case "tag.mystias_izakaya.he_tun":
					//
					break;
				case "tag.mystias_izakaya.hei_mao_zhu_rou":
					//
					break;
				case "tag.mystias_izakaya.hei_yan":
					//
					break;
				case "tag.mystias_izakaya.huan_tan_hua":
					//
					break;
				case "tag.mystias_izakaya.huang_gua":
					//
					break;
				case "tag.mystias_izakaya.huang_you":
					//
					break;
				case "tag.mystias_izakaya.ji_dan":
					//
					break;
				case "tag.mystias_izakaya.ji_shang_jin_qiang_yu":
					//
					break;
				case "tag.mystias_izakaya.jin_qiang_yu":
					//
					break;
				case "tag.mystias_izakaya.la_jiao":
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0));
					break;
				case "tag.mystias_izakaya.lian_zi":
					//
					break;
				case "tag.mystias_izakaya.lu_rou":
					//
					break;
				case "tag.mystias_izakaya.lu_shui":
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
					break;
				case "tag.mystias_izakaya.luo_bu":
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
					break;
				case "tag.mystias_izakaya.mian_fen":
					//
					break;
				case "tag.mystias_izakaya.mo_gu":
					//
					break;
				case "tag.mystias_izakaya.nai_you":
					//
					break;
				case "tag.mystias_izakaya.nan_gua":
					//
					break;
				case "tag.mystias_izakaya.ning_meng":
					//
					break;
				case "tag.mystias_izakaya.niu_rou":
					//
					break;
				case "tag.mystias_izakaya.nuo_mi":
					//
					break;
				case "tag.mystias_izakaya.pang_xie":
					//
					break;
				case "tag.mystias_izakaya.pu_tao":
					//
					break;
				case "tag.mystias_izakaya.san_wen_yu":
					//
					break;
				case "tag.mystias_izakaya.song_lu":
					//
					break;
				case "tag.mystias_izakaya.song_zi":
					//
					break;
				case "tag.mystias_izakaya.tao_zi":
					//
					break;
				case "tag.mystias_izakaya.tu_dou":
					//
					break;
				case "tag.mystias_izakaya.xia":
					//
					break;
				case "tag.mystias_izakaya.yang_cong":
					//
					break;
				case "tag.mystias_izakaya.ye_zhu_rou":
					//
					break;
				case "tag.mystias_izakaya.yue_guang_cao":
					//
					break;
				case "tag.mystias_izakaya.zhang_yu":
					//
					break;
				case "tag.mystias_izakaya.zhi_shi":
					//
					break;
				case "tag.mystias_izakaya.zhu_rou":
					//
					break;
				case "tag.mystias_izakaya.zhu_sun":
					//
					break;
				case "tag.mystias_izakaya.zhu_zi":
					//
					break;
				case "tag.mystias_izakaya.zun_yu":
					//
					break;
				default:
					break;
			}
		}
	}
}
/*
 * "mystias_izakaya:dou_fu",
 * "mystias_izakaya:ba_mu_man",
 * "mystias_izakaya:bai_guo",
 * "mystias_izakaya:ban_li",
 * "mystias_izakaya:bing_kuai",
 * "mystias_izakaya:bing_di_lian",
 * "mystias_izakaya:chan_shui",
 * "mystias_izakaya:di_gua",
 * "mystias_izakaya:feng_mi",
 * "mystias_izakaya:hai_dan",
 * "mystias_izakaya:hai_tai",
 * "mystias_izakaya:he_niu",
 * "mystias_izakaya:he_tun",
 * "mystias_izakaya:hei_mao_zhu_rou",
 * "mystias_izakaya:hei_yan",
 * "mystias_izakaya:huan_tan_hua",
 * "mystias_izakaya:huang_gua",
 * "mystias_izakaya:huang_you",
 * "mystias_izakaya:ji_dan",
 * "mystias_izakaya:ji_shang_jin_qiang_yu",
 * "mystias_izakaya:jin_qiang_yu",
 * "mystias_izakaya:la_jiao",
 * "mystias_izakaya:lian_zi",
 * "mystias_izakaya:lu_rou",
 * "mystias_izakaya:lu_shui",
 * "mystias_izakaya:luo_bu",
 * "mystias_izakaya:mian_fen",
 * "mystias_izakaya:mo_gu",
 * "mystias_izakaya:nai_you",
 * "mystias_izakaya:nan_gua",
 * "mystias_izakaya:ning_meng",
 * "mystias_izakaya:niu_rou",
 * "mystias_izakaya:nuo_mi",
 * "mystias_izakaya:pang_xie",
 * "mystias_izakaya:pu_tao",
 * "mystias_izakaya:san_wen_yu",
 * "mystias_izakaya:song_lu",
 * "mystias_izakaya:song_zi",
 * "mystias_izakaya:tao_zi",
 * "mystias_izakaya:tu_dou",
 * "mystias_izakaya:xia",
 * "mystias_izakaya:yang_cong",
 * "mystias_izakaya:ye_zhu_rou",
 * "mystias_izakaya:yue_guang_cao",
 * "mystias_izakaya:zhang_yu",
 * "mystias_izakaya:zhi_shi",
 * "mystias_izakaya:zhu_rou",
 * "mystias_izakaya:zhu_sun",
 * "mystias_izakaya:zhu_zi",
 * "mystias_izakaya:zun_yu"
 */