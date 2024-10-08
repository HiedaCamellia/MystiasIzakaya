package org.hiedacamellia.mystiasizakaya.core.cooking.effects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;


import java.util.ArrayList;
import java.util.List;

public class GiveEffectFromTags {
	public static void execute(LevelAccessor world, ItemStack itemstack, LivingEntity entity) {

		List<String> ingredient = itemstack.getOrCreateTag().getString("ingredients").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("ingredients").split(","));

		if (ingredient.isEmpty()) {
			ingredient.add(BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString());
		}

        for (String t : ingredient) {
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
                case "tag.mystias_izakaya.Cultural_Heritage":
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
                case "tag.mystias_izakaya.Good_With_Alcohol":
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
                    entity.setRemainingFireTicks(60);
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