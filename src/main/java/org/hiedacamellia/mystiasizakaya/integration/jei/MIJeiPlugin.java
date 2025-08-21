package org.hiedacamellia.mystiasizakaya.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.util.MIClientUtil;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;
import org.hiedacamellia.mystiasizakaya.integration.jei.categories.*;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class MIJeiPlugin implements IModPlugin {
	
	static {
		BoilingPotJeiCategory.RECIPE_TYPE = new MIBaseJeiRecipeType<>(BoilingPotJeiCategory.UID, BoilingPotRecipe.class);
		CuttingBoardJeiCategory.RECIPE_TYPE = new MIBaseJeiRecipeType<>(CuttingBoardJeiCategory.UID, CuttingBoardRecipe.class);
		FryingPanJeiCategory.RECIPE_TYPE = new MIBaseJeiRecipeType<>(FryingPanJeiCategory.UID, FryingPanRecipe.class);
		GrillJeiCategory.RECIPE_TYPE = new MIBaseJeiRecipeType<>(GrillJeiCategory.UID, GrillRecipe.class);
		SteamerJeiCategory.RECIPE_TYPE = new MIBaseJeiRecipeType<>(SteamerJeiCategory.UID, SteamerRecipe.class);
	}
	
	@Override
	public ResourceLocation getPluginUid() {
		return MystiasIzakaya.rl("jei");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BoilingPotJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CuttingBoardJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FryingPanJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrillJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new SteamerJeiCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {

		RecipeMap recipeMap = MIClientUtil.getRecipeMap();
		ClientLevel level = Minecraft.getInstance().level;

		List<BoilingPotRecipe> boilingPotRecipes = recipeMap.getRecipesFor(MIRecipeType.BOILING_POT.get(),MIRecipeInput.EMPTY,level).map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BoilingPotJeiCategory.RECIPE_TYPE, boilingPotRecipes);
		List<CuttingBoardRecipe> cuttingBoardRecipes = recipeMap.getRecipesFor(MIRecipeType.CUTTING_BOARD.get(),MIRecipeInput.EMPTY,level).map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(CuttingBoardJeiCategory.RECIPE_TYPE, cuttingBoardRecipes);
		List<FryingPanRecipe> fryingPanRecipes = recipeMap.getRecipesFor(MIRecipeType.FRYING_PAN.get(),MIRecipeInput.EMPTY,level).map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(FryingPanJeiCategory.RECIPE_TYPE, fryingPanRecipes);
		List<GrillRecipe> grillRecipes = recipeMap.getRecipesFor(MIRecipeType.GRILL.get(),MIRecipeInput.EMPTY,level).map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(GrillJeiCategory.RECIPE_TYPE, grillRecipes);
		List<SteamerRecipe> steamerRecipes = recipeMap.getRecipesFor(MIRecipeType.STEAMER.get(),MIRecipeInput.EMPTY,level).map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(SteamerJeiCategory.RECIPE_TYPE, steamerRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addCraftingStation(BoilingPotJeiCategory.RECIPE_TYPE, new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), new ItemStack(MIItem.BOILING_POT.get()));
		registration.addCraftingStation(CuttingBoardJeiCategory.RECIPE_TYPE, new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), new ItemStack(MIItem.CUTTING_BOARD.get()));
		registration.addCraftingStation(FryingPanJeiCategory.RECIPE_TYPE, new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), new ItemStack(MIItem.FRYING_PAN.get()));
		registration.addCraftingStation(GrillJeiCategory.RECIPE_TYPE, new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), new ItemStack(MIItem.GRILL.get()));
		registration.addCraftingStation(SteamerJeiCategory.RECIPE_TYPE, new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), new ItemStack(MIItem.STEAMER.get()));
	}
}
