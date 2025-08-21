package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplayId;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.recipes.CuttingBoardRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CuttingBoardDisplay extends BaseReiDisplay<CuttingBoardRecipe>{

    public static final CategoryIdentifier<CuttingBoardDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "cutting_board");

    private static final DisplaySerializer<CuttingBoardDisplay> SERIALIZER;
    public static final Type<CuttingBoardDisplay> TYPE;
    protected Optional<RecipeDisplayId> id = Optional.empty();

    protected CuttingBoardDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs, MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public CuttingBoardDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs,outputs,result,workstation);
    }

    static {
        SERIALIZER = createSerializer(CuttingBoardDisplay::new);
        TYPE = createType(CuttingBoardDisplay::new);
    }


    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CATEGORY;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public Type<? extends RecipeDisplay> type() {
        return TYPE;
    }

    public CuttingBoardDisplay create(Optional<RecipeDisplayId> recipeDisplayId) {
        CuttingBoardDisplay CuttingBoardDisplay = new CuttingBoardDisplay(inputs, outputs, result, workstation);
        CuttingBoardDisplay.id = recipeDisplayId;
        return CuttingBoardDisplay;
    }

    @Override
    public Optional<RecipeDisplayId> recipeDisplayId() {
        return Optional.empty();
    }
}
