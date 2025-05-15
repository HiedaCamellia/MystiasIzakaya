package org.hiedacamellia.mystiasizakaya.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.*;
import org.hiedacamellia.mystiasizakaya.integration.jei.categories.*;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@mezz.jei.api.JeiPlugin
public class MIJeiPlugin implements IModPlugin {
	
	static {
		BoilingPotJeiCategory.RECIPE_TYPE = new mezz.jei.api.recipe.RecipeType<>(BoilingPotJeiCategory.UID, BoilingPotRecipe.class);
		CuttingBoardJeiCategory.RECIPE_TYPE = new mezz.jei.api.recipe.RecipeType<>(CuttingBoardJeiCategory.UID, CuttingBoardRecipe.class);
		FryingPanJeiCategory.RECIPE_TYPE = new mezz.jei.api.recipe.RecipeType<>(FryingPanJeiCategory.UID, FryingPanRecipe.class);
		GrillJeiCategory.RECIPE_TYPE = new mezz.jei.api.recipe.RecipeType<>(GrillJeiCategory.UID, GrillRecipe.class);
		SteamerJeiCategory.RECIPE_TYPE = new mezz.jei.api.recipe.RecipeType<>(SteamerJeiCategory.UID, SteamerRecipe.class);
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
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

		List<BoilingPotRecipe> boilingPotRecipes = recipeManager.getAllRecipesFor(MIRecipeType.BOILING_POT.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BoilingPotJeiCategory.RECIPE_TYPE, boilingPotRecipes);
		List<CuttingBoardRecipe> cuttingBoardRecipes = recipeManager.getAllRecipesFor(MIRecipeType.CUTTING_BOARD.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(CuttingBoardJeiCategory.RECIPE_TYPE, cuttingBoardRecipes);
		List<FryingPanRecipe> fryingPanRecipes = recipeManager.getAllRecipesFor(MIRecipeType.FRYING_PAN.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(FryingPanJeiCategory.RECIPE_TYPE, fryingPanRecipes);
		List<GrillRecipe> grillRecipes = recipeManager.getAllRecipesFor(MIRecipeType.GRILL.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(GrillJeiCategory.RECIPE_TYPE, grillRecipes);
		List<SteamerRecipe> steamerRecipes = recipeManager.getAllRecipesFor(MIRecipeType.STEAMER.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(SteamerJeiCategory.RECIPE_TYPE, steamerRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), BoilingPotJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIItem.BOILING_POT.get()), BoilingPotJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), CuttingBoardJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIItem.CUTTING_BOARD.get()), CuttingBoardJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), FryingPanJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIItem.FRYING_PAN.get()), FryingPanJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), GrillJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIItem.GRILL.get()), GrillJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), SteamerJeiCategory.RECIPE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(MIItem.STEAMER.get()), SteamerJeiCategory.RECIPE_TYPE);
	}
}
