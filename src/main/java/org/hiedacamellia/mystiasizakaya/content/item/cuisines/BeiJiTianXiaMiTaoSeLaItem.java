
package org.hiedacamellia.mystiasizakaya.content.item.cuisines;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.content.item.items.Cuisines;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromCuisines;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromIngredientsProcedure;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromTagsProcedure;
import org.hiedacamellia.mystiasizakaya.util.GetTagsFromNbt;

import java.util.*;

public class BeiJiTianXiaMiTaoSeLaItem extends Cuisines {
	public BeiJiTianXiaMiTaoSeLaItem() {
		super(12, 1.2f, Rarity.UNCOMMON, "bei_ji_tian_xia_mi_tao_se_la",
				new String[]{"Aquatic", "Vegetarian", "Mild", "Sweet", "Photogenic", "Wonderful", "Fruity"},
				new String[]{"Salty", "Meat"});
		}
}
