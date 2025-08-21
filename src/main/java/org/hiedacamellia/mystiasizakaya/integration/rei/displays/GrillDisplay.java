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
import org.hiedacamellia.mystiasizakaya.core.recipes.GrillRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class GrillDisplay extends BaseReiDisplay<GrillRecipe>{

    public static final CategoryIdentifier<GrillDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "grill");

    private static final DisplaySerializer<GrillDisplay> SERIALIZER;
    public static final Type<GrillDisplay> TYPE;
    protected Optional<RecipeDisplayId> id = Optional.empty();

    protected GrillDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs, MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public GrillDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs,outputs,result,workstation);
    }

    static {
        SERIALIZER = createSerializer(GrillDisplay::new);
        TYPE = createType(GrillDisplay::new);
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

    public GrillDisplay create(Optional<RecipeDisplayId> recipeDisplayId) {
        GrillDisplay GrillDisplay = new GrillDisplay(inputs, outputs, result, workstation);
        GrillDisplay.id = recipeDisplayId;
        return GrillDisplay;
    }

    @Override
    public Optional<RecipeDisplayId> recipeDisplayId() {
        return Optional.empty();
    }
}
