
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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LuShuiZhuDanItem extends Cuisines {
	public LuShuiZhuDanItem() {
		super(3, 0.8f, Rarity.UNCOMMON, "lu_shui_zhu_dan",
				new String[]{"Economical", "Mild", "Raw"},
				new String[]{"Meat", "Aquatic", "Greasy"});
	}
}
