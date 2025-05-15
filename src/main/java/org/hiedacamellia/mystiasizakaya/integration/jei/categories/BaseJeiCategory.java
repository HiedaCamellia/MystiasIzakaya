package org.hiedacamellia.mystiasizakaya.integration.jei.categories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public abstract class BaseJeiCategory<T extends Recipe<?>> implements IRecipeCategory<T> {

    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable slotDraw;
    private final IDrawableAnimated arrow;

    public BaseJeiCategory(IGuiHelper helper, Component title, Item item) {
        this.title = title;
        this.background = helper.createBlankDrawable(176, 36);
        this.slotDraw = helper.getSlotDrawable();
        this.arrow = helper.createAnimatedRecipeArrow(40);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(item));
    }

    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics);
        this.arrow.draw(guiGraphics,124,10);
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, T recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 10).addIngredients(recipe.getIngredients().get(0)).setBackground(slotDraw, -1, -1);
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 10).addIngredients(recipe.getIngredients().get(1)).setBackground(slotDraw, -1, -1);
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 10).addIngredients(recipe.getIngredients().get(2)).setBackground(slotDraw, -1, -1);
        builder.addSlot(RecipeIngredientRole.INPUT, 78, 10).addIngredients(recipe.getIngredients().get(3)).setBackground(slotDraw, -1, -1);
        builder.addSlot(RecipeIngredientRole.INPUT, 102, 10).addIngredients(recipe.getIngredients().get(4)).setBackground(slotDraw, -1, -1);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 154, 10).addItemStack(recipe.getResultItem(null)).setBackground(slotDraw, -1, -1);
    }
}
