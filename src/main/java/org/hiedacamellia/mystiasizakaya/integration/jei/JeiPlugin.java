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
import org.hiedacamellia.mystiasizakaya.integration.jei.categories.*;
import org.hiedacamellia.mystiasizakaya.integration.jei.recipes.*;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<BoilingPotTypeRecipe> BoilingPotType_Type = new mezz.jei.api.recipe.RecipeType<>(BoilingPotTypeRecipeCategory.UID, BoilingPotTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CuttingBoardTypeRecipe> CuttingBoardType_Type = new mezz.jei.api.recipe.RecipeType<>(CuttingBoardTypeRecipeCategory.UID, CuttingBoardTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FryingPanTypeRecipe> FryingPanType_Type = new mezz.jei.api.recipe.RecipeType<>(FryingPanTypeRecipeCategory.UID, FryingPanTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrillTypeRecipe> GrillType_Type = new mezz.jei.api.recipe.RecipeType<>(GrillTypeRecipeCategory.UID, GrillTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<StreamerTypeRecipe> StreamerType_Type = new mezz.jei.api.recipe.RecipeType<>(StreamerTypeRecipeCategory.UID, StreamerTypeRecipe.class);

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
		registration.addRecipeCategories(new StreamerTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

		List<BoilingPotTypeRecipe> BoilingPotTypeRecipes = recipeManager.getAllRecipesFor(BoilingPotTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BoilingPotType_Type, BoilingPotTypeRecipes);
		List<CuttingBoardTypeRecipe> CuttingBoardTypeRecipes = recipeManager.getAllRecipesFor(CuttingBoardTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(CuttingBoardType_Type, CuttingBoardTypeRecipes);
		List<FryingPanTypeRecipe> FryingPanTypeRecipes = recipeManager.getAllRecipesFor(FryingPanTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(FryingPanType_Type, FryingPanTypeRecipes);
		List<GrillTypeRecipe> GrillTypeRecipes = recipeManager.getAllRecipesFor(GrillTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(GrillType_Type, GrillTypeRecipes);
		List<StreamerTypeRecipe> StreamerTypeRecipes = recipeManager.getAllRecipesFor(StreamerTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(StreamerType_Type, StreamerTypeRecipes);
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
