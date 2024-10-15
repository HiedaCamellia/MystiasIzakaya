
package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.integration.jei.JeiPlugin;
import org.hiedacamellia.mystiasizakaya.core.recipes.CuttingBoardRecipe;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class CuttingBoardTypeRecipeCategory implements IRecipeCategory<CuttingBoardRecipe> {
	public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("mystias_izakaya", "cutting_board_type");
	public final static ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("mystias_izakaya", "textures/screens/recipe_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public CuttingBoardTypeRecipeCategory(IGuiHelper helper) {
		IDrawableBuilder drawableBuilder = helper.drawableBuilder(TEXTURE, 0, 0, 176, 87).setTextureSize(176, 87);
		this.background = drawableBuilder.build();
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MIItem.CUTTING_BOARD.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<CuttingBoardRecipe> getRecipeType() {
		return JeiPlugin.CuttingBoardType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal(Component.translatable("jei.mystias_izakaya.Cutting_Board").getString());
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, CuttingBoardRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 16, 26).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 26).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 70, 26).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 26).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 124, 26).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 151, 44).addItemStack(recipe.getResultItem(null));
	}
}
