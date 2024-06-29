
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

public class DaJiangHuChuanJiItem extends Cuisines {
	public DaJiangHuChuanJiItem() {
		super(16, 1.2f, Rarity.RARE, "da_jiang_hu_chuan_ji",
				new String[]{"Aquatic", "Cultural_Heritage", "Expensive", "Good_With_Alcohol", "Japanese", "Legendary",
						"Photogenic", "Premium", "Raw", "Fresh", "Sea_Delicacy", "Signature"},
				new String[]{});
	}
}
