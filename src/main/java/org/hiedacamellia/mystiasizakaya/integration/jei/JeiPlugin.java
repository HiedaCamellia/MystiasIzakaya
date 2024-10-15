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
import org.hiedacamellia.mystiasizakaya.core.recipes.*;
import org.hiedacamellia.mystiasizakaya.integration.jei.categories.*;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<BoilingPotRecipe> BoilingPotType_Type = new mezz.jei.api.recipe.RecipeType<>(BoilingPotTypeRecipeCategory.UID, BoilingPotRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CuttingBoardRecipe> CuttingBoardType_Type = new mezz.jei.api.recipe.RecipeType<>(CuttingBoardTypeRecipeCategory.UID, CuttingBoardRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FryingPanRecipe> FryingPanType_Type = new mezz.jei.api.recipe.RecipeType<>(FryingPanTypeRecipeCategory.UID, FryingPanRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrillRecipe> GrillType_Type = new mezz.jei.api.recipe.RecipeType<>(GrillTypeRecipeCategory.UID, GrillRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<SteamerRecipe> StreamerType_Type = new mezz.jei.api.recipe.RecipeType<>(SteamerTypeRecipeCategory.UID, SteamerRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("mystias_izakaya:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BoilingPotTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CuttingBoardTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FryingPanTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrillTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new SteamerTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

		List<BoilingPotRecipe> boilingPotRecipes = recipeManager.getAllRecipesFor(MIRecipeType.BOILING_POT.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BoilingPotType_Type, boilingPotRecipes);
		List<CuttingBoardRecipe> cuttingBoardRecipes = recipeManager.getAllRecipesFor(MIRecipeType.CUTTING_BOARD.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(CuttingBoardType_Type, cuttingBoardRecipes);
		List<FryingPanRecipe> fryingPanRecipes = recipeManager.getAllRecipesFor(MIRecipeType.FRYING_PAN.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(FryingPanType_Type, fryingPanRecipes);
		List<GrillRecipe> grillRecipes = recipeManager.getAllRecipesFor(MIRecipeType.GRILL.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(GrillType_Type, grillRecipes);
		List<SteamerRecipe> steamerRecipes = recipeManager.getAllRecipesFor(MIRecipeType.STEAMER.get()).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(StreamerType_Type, steamerRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), BoilingPotType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIItem.BOILING_POT.get()), BoilingPotType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), CuttingBoardType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIItem.CUTTING_BOARD.get()), CuttingBoardType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), FryingPanType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIItem.FRYING_PAN.get()), FryingPanType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), GrillType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIItem.GRILL.get()), GrillType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIBlock.COOKING_RANGE.get().asItem()), StreamerType_Type);
		registration.addRecipeCatalyst(new ItemStack(MIItem.STEAMER.get()), StreamerType_Type);
	}
}
