package org.hiedacamellia.mystiasizakaya.core.cooking.effects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class GiveEffectFromIngredients {
	public static void execute(LevelAccessor world, ItemStack itemstack, LivingEntity entity) {

		List<String> ingredient = itemstack.getOrCreateTag().getString("ingredients").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("ingredients").split(","));

		if (ingredient.isEmpty()) {
			ingredient.add(ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString());
		}

        for (String t : ingredient) {
            switch (t) {
                case "mystias_izakaya:ba_mu_man":
                    entity.removeEffect(MobEffects.DARKNESS);
                    entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0));
                    break;
                case "mystias_izakaya:bai_guo":
                    //
                    break;
                case "mystias_izakaya:ban_li":
                    //
                    break;
                case "mystias_izakaya:bing_kuai":
                    entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0));
                    break;
                case "mystias_izakaya:bing_di_lian":
                    //
                    break;
                case "mystias_izakaya:chan_shui":
                    //
                    break;
                case "mystias_izakaya:di_gua":
                    //
                    break;
                case "mystias_izakaya:dou_fu":
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
                    break;
                case "mystias_izakaya:feng_mi":
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 0));
                    break;
                case "mystias_izakaya:hai_dan":
                    //
                    break;
                case "mystias_izakaya:hai_tai":
                    //
                    break;
                case "mystias_izakaya:he_niu":
                    //
                    break;
                case "mystias_izakaya:he_tun":
                    //
                    break;
                case "mystias_izakaya:hei_mao_zhu_rou":
                    //
                    break;
                case "mystias_izakaya:hei_yan":
                    //
                    break;
                case "mystias_izakaya:huan_tan_hua":
                    //
                    break;
                case "mystias_izakaya:huang_gua":
                    //
                    break;
                case "mystias_izakaya:huang_you":
                    //
                    break;
                case "mystias_izakaya:ji_dan":
                    //
                    break;
                case "mystias_izakaya:ji_shang_jin_qiang_yu":
                    //
                    break;
                case "mystias_izakaya:jin_qiang_yu":
                    //
                    break;
                case "mystias_izakaya:la_jiao":
                    entity.hurt(new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey
                                            .create(Registries.DAMAGE_TYPE, new ResourceLocation("mystias_izakaya:chili")))),
                            2);

                    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0));
                    break;
                case "mystias_izakaya:lian_zi.json":
                    //
                    break;
                case "mystias_izakaya:lu_rou":
                    //
                    break;
                case "mystias_izakaya:lu_shui":
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
                    break;
                case "mystias_izakaya:luo_bu":
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
                    break;
                case "mystias_izakaya:mian_fen":
                    //
                    break;
                case "mystias_izakaya:mo_gu":
                    //
                    break;
                case "mystias_izakaya:nai_you":
                    //
                    break;
                case "mystias_izakaya:nan_gua":
                    //
                    break;
                case "mystias_izakaya:ning_meng":
                    //
                    break;
                case "mystias_izakaya:niu_rou":
                    //
                    break;
                case "mystias_izakaya:nuo_mi":
                    //
                    break;
                case "mystias_izakaya:pang_xie":
                    //
                    break;
                case "mystias_izakaya:pu_tao":
                    //
                    break;
                case "mystias_izakaya:san_wen_yu":
                    //
                    break;
                case "mystias_izakaya:song_lu":
                    //
                    break;
                case "mystias_izakaya:song_zi":
                    //
                    break;
                case "mystias_izakaya:tao_zi":
                    //
                    break;
                case "mystias_izakaya:tu_dou":
                    //
                    break;
                case "mystias_izakaya:xia":
                    //
                    break;
                case "mystias_izakaya:yang_cong":
                    //
                    break;
                case "mystias_izakaya:ye_zhu_rou":
                    //
                    break;
                case "mystias_izakaya:yue_guang_cao":
                    //
                    break;
                case "mystias_izakaya:zhang_yu":
                    //
                    break;
                case "mystias_izakaya:zhi_shi":
                    //
                    break;
                case "mystias_izakaya:zhu_rou":
                    //
                    break;
                case "mystias_izakaya:zhu_sun":
                    //
                    break;
                case "mystias_izakaya:zhu_zi":
                    //
                    break;
                case "mystias_izakaya:zun_yu":
                    //
                    break;
                default:
                    break;
            }
        }
	}
}