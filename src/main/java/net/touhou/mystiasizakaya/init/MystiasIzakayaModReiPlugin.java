
package net.touhou.mystiasizakaya.init;


import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.touhou.mystiasizakaya.rei.BoilingPot;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;

import java.util.Objects;
import java.util.List;

public class MystiasIzakayaModReiPlugin implements REIClientPlugin {
	

	@Override
	public void registerCategories(CategoryRegistry categoryRegistry) {
		categoryRegistry.add();
	}

	@Override
	public void registerDisplays(DisplayRegistry displayRegistry) {
	}

}
