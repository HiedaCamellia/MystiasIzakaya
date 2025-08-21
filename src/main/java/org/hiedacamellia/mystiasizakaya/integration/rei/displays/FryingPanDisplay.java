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
import org.hiedacamellia.mystiasizakaya.core.recipes.FryingPanRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class FryingPanDisplay extends BaseReiDisplay<FryingPanRecipe>{

    public static final CategoryIdentifier<FryingPanDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "frying_pan");

    private static final DisplaySerializer<FryingPanDisplay> SERIALIZER;
    public static final Type<FryingPanDisplay> TYPE;
    protected Optional<RecipeDisplayId> id = Optional.empty();

    protected FryingPanDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs, MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public FryingPanDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs,outputs,result,workstation);
    }

    static {
        SERIALIZER = createSerializer(FryingPanDisplay::new);
        TYPE = createType(FryingPanDisplay::new);
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

    public FryingPanDisplay create(Optional<RecipeDisplayId> recipeDisplayId) {
        FryingPanDisplay FryingPanDisplay = new FryingPanDisplay(inputs, outputs, result, workstation);
        FryingPanDisplay.id = recipeDisplayId;
        return FryingPanDisplay;
    }

    @Override
    public Optional<RecipeDisplayId> recipeDisplayId() {
        return Optional.empty();
    }
}
