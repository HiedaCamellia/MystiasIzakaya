
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

public class XiangJianShuangGuRouJuanItem extends Cuisines {
	public XiangJianShuangGuRouJuanItem() {
		super(7, 1.2f, Rarity.RARE, "xiang_jian_shuang_gu_rou_juan",
				new String[]{"Expensive", "Fungus", "Good_With_Alcohol", "Greasy", "Homecooking", "Hot", "Meat",
						"Signature"},
				new String[]{"Refreshing"});
	}
}
