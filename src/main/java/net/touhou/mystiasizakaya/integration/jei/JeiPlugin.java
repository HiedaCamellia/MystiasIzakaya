package net.touhou.mystiasizakaya.integration.jei;

import net.touhou.mystiasizakaya.content.block.ModBlocks;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.IModPlugin;
import net.touhou.mystiasizakaya.integration.jei.categories.*;
import net.touhou.mystiasizakaya.integration.jei.recipes.*;

import java.util.Objects;
import java.util.List;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<BoilingPotTypeRecipe> BoilingPotType_Type = new mezz.jei.api.recipe.RecipeType<>(BoilingPotTypeRecipeCategory.UID, BoilingPotTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CuttingBoardTypeRecipe> CuttingBoardType_Type = new mezz.jei.api.recipe.RecipeType<>(CuttingBoardTypeRecipeCategory.UID, CuttingBoardTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FryingPanTypeRecipe> FryingPanType_Type = new mezz.jei.api.recipe.RecipeType<>(FryingPanTypeRecipeCategory.UID, FryingPanTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrillTypeRecipe> GrillType_Type = new mezz.jei.api.recipe.RecipeType<>(GrillTypeRecipeCategory.UID, GrillTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<StreamerTypeRecipe> StreamerType_Type = new mezz.jei.api.recipe.RecipeType<>(StreamerTypeRecipeCategory.UID, StreamerTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("mystias_izakaya:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BoilingPotTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CuttingBoardTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FryingPanTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrillTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new StreamerTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<BoilingPotTypeRecipe> BoilingPotTypeRecipes = recipeManager.getAllRecipesFor(BoilingPotTypeRecipe.Type.INSTANCE);
		registration.addRecipes(BoilingPotType_Type, BoilingPotTypeRecipes);
		List<CuttingBoardTypeRecipe> CuttingBoardTypeRecipes = recipeManager.getAllRecipesFor(CuttingBoardTypeRecipe.Type.INSTANCE);
		registration.addRecipes(CuttingBoardType_Type, CuttingBoardTypeRecipes);
		List<FryingPanTypeRecipe> FryingPanTypeRecipes = recipeManager.getAllRecipesFor(FryingPanTypeRecipe.Type.INSTANCE);
		registration.addRecipes(FryingPanType_Type, FryingPanTypeRecipes);
		List<GrillTypeRecipe> GrillTypeRecipes = recipeManager.getAllRecipesFor(GrillTypeRecipe.Type.INSTANCE);
		registration.addRecipes(GrillType_Type, GrillTypeRecipes);
		List<StreamerTypeRecipe> StreamerTypeRecipes = recipeManager.getAllRecipesFor(StreamerTypeRecipe.Type.INSTANCE);
		registration.addRecipes(StreamerType_Type, StreamerTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.COOKING_RANGE.get().asItem()), BoilingPotType_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.COOKING_RANGE.get().asItem()), CuttingBoardType_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.COOKING_RANGE.get().asItem()), FryingPanType_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.COOKING_RANGE.get().asItem()), GrillType_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.COOKING_RANGE.get().asItem()), StreamerType_Type);
	}
}
