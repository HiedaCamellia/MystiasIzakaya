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
import java.util.ArrayList;

public class GiveEffectFromTagsProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack, LivingEntity entity) {
		String s = "";
		s = itemstack.getOrCreateTag().getString("tags");
		if (s.isEmpty()) {
			s = ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString();
		}
		String[] tags = s.split(",");
		for (int i = 0; i < tags.length; i++) {
			String t = tags[i];
			switch (t) {
				case "tag.mystias_izakaya.Aquatic":
					entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2400, 0));
					break;
				case "tag.mystias_izakaya.Aura_Bursting":
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 1));
					break;
				case "tag.mystias_izakaya.beverages.beer":
					// Beer
					break;
				case "tag.mystias_izakaya.beverages.bitter":
					// Bitter
					break;
				case "tag.mystias_izakaya.beverages.chillable":
					// Chillable
					break;
				case "tag.mystias_izakaya.beverages.cocktail":
					// Cocktail
					break;
				case "tag.mystias_izakaya.beverages.dry":
					// Dry
					break;
				case "tag.mystias_izakaya.beverages.fruity":
					// Fruity
					break;
				case "tag.mystias_izakaya.beverages.heatable":
					// Heatable
					break;
				case "tag.mystias_izakaya.beverages.high_alcohol":
					// High Alcohol
					break;
				case "tag.mystias_izakaya.beverages.liquor":
					// Liquor
					break;
				case "tag.mystias_izakaya.beverages.low_alcohol":
					// Low Alcohol
					break;
				case "tag.mystias_izakaya.beverages.mid_alcohol":
					// Mid Alcohol
					break;
				case "tag.mystias_izakaya.beverages.modern":
					// Modern
					break;
				case "tag.mystias_izakaya.beverages.neat":
					// Neat
					break;
				case "tag.mystias_izakaya.beverages.no_alcohol":
					// No Alcohol
					break;
				case "tag.mystias_izakaya.beverages.sake":
					// Sake
					break;
				case "tag.mystias_izakaya.beverages.shochu":
					// Shochu
					break;
				case "tag.mystias_izakaya.beverages.soda":
					// Soda
					break;
				case "tag.mystias_izakaya.beverages.stimulating":
					// Stimulating
					break;
				case "tag.mystias_izakaya.beverages.sweet":
					// Sweet
					break;
				case "tag.mystias_izakaya.beverages.vintage":
					// Vintage
					break;
				case "tag.mystias_izakaya.beverages.western":
					// Western
					break;
				case "tag.mystias_izakaya.boiling_pot":
					// Boiling Pot
					break;
				case "tag.mystias_izakaya.Chinese":
					// Chinese
					break;
				case "tag.mystias_izakaya.Cultural_Background":
					// Cultural Background
					break;
				case "tag.mystias_izakaya.cutting_board":
					// Cutting Board
					break;
				case "tag.mystias_izakaya.Dreamy":
					entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0));
					break;
				case "tag.mystias_izakaya.Economical":
					// Economical
					break;
				case "tag.mystias_izakaya.Expensive":
					// Expensive
					break;
				case "tag.mystias_izakaya.Filling":
					entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1200, 0));
					break;
				case "tag.mystias_izakaya.Fresh":
					entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 1200, 0));
					break;
				case "tag.mystias_izakaya.Fruity":
					// Fruity
					break;
				case "tag.mystias_izakaya.frying_pan":
					// Frying Pan
					break;
				case "tag.mystias_izakaya.Fungi":
					// Fungi
					break;
				case "tag.mystias_izakaya.Fungus":
					// Fungus
					break;
				case "tag.mystias_izakaya.Good_with_Alcohol":
					// Good with Alcohol
					break;
				case "tag.mystias_izakaya.Greasy":
					// Greasy
					break;
				case "tag.mystias_izakaya.grill":
					// Grill
					break;
				case "tag.mystias_izakaya.Grilled":
					// Grilled
					break;
				case "tag.mystias_izakaya.Homecooking":
					// Homecooking
					break;
				case "tag.mystias_izakaya.Hot":
					entity.setSecondsOnFire(3);
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0));
					break;
				case "tag.mystias_izakaya.Japanese":
					// Japanese
					break;
				case "tag.mystias_izakaya.Large_Portion":
					// Large Portion
					break;
				case "tag.mystias_izakaya.Legendary":
					// Legendary
					break;
				case "tag.mystias_izakaya.Meat":
					// Meat
					break;
				case "tag.mystias_izakaya.Mild":
					entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0));
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
					break;
				case "tag.mystias_izakaya.Mountain_Delicacy":
					// Mountain Delicacy
					break;
				case "tag.mystias_izakaya.Peculiar":
					// Peculiar
					break;
				case "tag.mystias_izakaya.Photogenic":
					// Photogenic
					break;
				case "tag.mystias_izakaya.Premium":
					entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1));
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1));
					break;
				case "tag.mystias_izakaya.Raw":
					// Raw
					break;
				case "tag.mystias_izakaya.Refreshing":
					entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0));
					break;
				case "tag.mystias_izakaya.Salty":
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0));
					break;
				case "tag.mystias_izakaya.Sea_Delicacy":
					// Sea Delicacy
					break;
				case "tag.mystias_izakaya.Signature":
					// Signature
					break;
				case "tag.mystias_izakaya.Small_Portion":
					// Small Portion
					break;
				case "tag.mystias_izakaya.Soup":
					// Soup
					break;
				case "tag.mystias_izakaya.Sour":
					// Sour
					break;
				case "tag.mystias_izakaya.Specialty":
					// Specialty
					break;
				case "tag.mystias_izakaya.Spicy":
					// Spicy
					break;
				case "tag.mystias_izakaya.streamer":
					// Streamer
					break;
				case "tag.mystias_izakaya.Strength_Boosting":
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1));
					break;
				case "tag.mystias_izakaya.Sweet":
					// Sweet
					break;
				case "tag.mystias_izakaya.trend_popular":
					// Trend - Popular
					break;
				case "tag.mystias_izakaya.trend_unpopular":
					// Trend - Unpopular
					break;
				case "tag.mystias_izakaya.Vegetarian":
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
					break;
				case "tag.mystias_izakaya.Western":
					// Western
					break;
				case "tag.mystias_izakaya.Wonderful":
					entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1));
					break;
				default:
					break;
			}
		}
	}
}
/*
 * tag.mystias_izakaya.Aquatic,水产,Aquatic
 * tag.mystias_izakaya.Aura_Bursting,燃起来了,Aura Bursting
 * tag.mystias_izakaya.beverages.beer,啤酒,Beer
 * tag.mystias_izakaya.beverages.bitter,苦,Bitter
 * tag.mystias_izakaya.beverages.chillable,可加冰,Chillable
 * tag.mystias_izakaya.beverages.cocktail,鸡尾酒,Cocktail
 * tag.mystias_izakaya.beverages.dry,辛,Dry
 * tag.mystias_izakaya.beverages.fruity,水果,Fruity
 * tag.mystias_izakaya.beverages.heatable,可加热,Heatable
 * tag.mystias_izakaya.beverages.high_alcohol,高酒精,High Alcohol
 * tag.mystias_izakaya.beverages.liquor,利口酒,Liquor
 * tag.mystias_izakaya.beverages.low_alcohol,低酒精,Low Alcohol
 * tag.mystias_izakaya.beverages.mid_alcohol,中酒精,Mid Alcohol
 * tag.mystias_izakaya.beverages.modern,现代,Modern
 * tag.mystias_izakaya.beverages.neat,直饮,Neat
 * tag.mystias_izakaya.beverages.no_alcohol,无酒精,No Alcohol
 * tag.mystias_izakaya.beverages.sake,清酒,Sake
 * tag.mystias_izakaya.beverages.shochu,烧酒,Shochu
 * tag.mystias_izakaya.beverages.soda,气泡,Soda
 * tag.mystias_izakaya.beverages.stimulating,提神,Stimulating
 * tag.mystias_izakaya.beverages.sweet,甘,Sweet
 * tag.mystias_izakaya.beverages.vintage,古典,Vintage
 * tag.mystias_izakaya.beverages.western,西洋酒,Western
 * tag.mystias_izakaya.boiling_pot,煮锅,Boiling Pot
 * tag.mystias_izakaya.Chinese,中华,Chinese
 * tag.mystias_izakaya.Cultural_Background,文化底蕴,Cultural Background
 * tag.mystias_izakaya.cutting_board,料理台,Cutting Board
 * tag.mystias_izakaya.Dreamy,梦幻,Dreamy
 * tag.mystias_izakaya.Economical,实惠,Economical
 * tag.mystias_izakaya.Expensive,昂贵,Expensive
 * tag.mystias_izakaya.Filling,饱腹,Filling
 * tag.mystias_izakaya.Fresh,鲜,Fresh
 * tag.mystias_izakaya.Fruity,果味,Fruity
 * tag.mystias_izakaya.frying_pan,油锅,Frying Pan
 * tag.mystias_izakaya.Fungi,菌类,Fungi
 * tag.mystias_izakaya.Fungus,菌类,Fungus
 * tag.mystias_izakaya.Good_with_Alcohol,下酒,Good with Alcohol
 * tag.mystias_izakaya.Greasy,重油,Greasy
 * tag.mystias_izakaya.grill,烧烤架,Grill
 * tag.mystias_izakaya.Grilled,烧烤,Grilled
 * tag.mystias_izakaya.Homecooking,家常,Homecooking
 * tag.mystias_izakaya.Hot,灼热,Hot
 * tag.mystias_izakaya.Japanese,和风,Japanese
 * tag.mystias_izakaya.Large_Portion,大份,Large Portion
 * tag.mystias_izakaya.Legendary,传说,Legendary
 * tag.mystias_izakaya.Meat,肉,Meat
 * tag.mystias_izakaya.Mild,清淡,Mild
 * tag.mystias_izakaya.Mountain_Delicacy,山珍,Mountain Delicacy
 * tag.mystias_izakaya.Peculiar,猎奇,Peculiar
 * tag.mystias_izakaya.Photogenic,适合拍照,Photogenic
 * tag.mystias_izakaya.Premium,高级,Premium
 * tag.mystias_izakaya.Raw,生,Raw
 * tag.mystias_izakaya.Refreshing,凉爽,Refreshing
 * tag.mystias_izakaya.Salty,咸,Salty
 * tag.mystias_izakaya.Sea_Delicacy,海味,Sea Delicacy
 * tag.mystias_izakaya.Signature,招牌,Signature
 * tag.mystias_izakaya.Small_Portion,小巧,Small Portion
 * tag.mystias_izakaya.Soup,汤羹,Soup
 * tag.mystias_izakaya.Sour,酸,Sour
 * tag.mystias_izakaya.Specialty,特产,Specialty
 * tag.mystias_izakaya.Spicy,辣,Spicy
 * tag.mystias_izakaya.streamer,蒸锅,Streamer
 * tag.mystias_izakaya.Strength_Boosting,力量涌现,Strength Boosting
 * tag.mystias_izakaya.Sweet,甜,Sweet
 * tag.mystias_izakaya.trend_popular,趋势-流行,Trend - Popular
 * tag.mystias_izakaya.trend_unpopular,趋势-厌恶,Trend - Unpopular
 * tag.mystias_izakaya.Vegetarian,素,Vegetarian
 * tag.mystias_izakaya.Western,西式,Western
 * tag.mystias_izakaya.Wonderful,不可思议,Wonderful
 */