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
import org.hiedacamellia.mystiasizakaya.core.recipes.BoilingPotRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class BoilingPotDisplay extends BaseReiDisplay<BoilingPotRecipe>{

    public static final CategoryIdentifier<BoilingPotDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "boiling_pot");

    private static final DisplaySerializer<BoilingPotDisplay> SERIALIZER;
    public static final Type<BoilingPotDisplay> TYPE;
    protected Optional<RecipeDisplayId> id = Optional.empty();

    protected BoilingPotDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs, MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public BoilingPotDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs,outputs,result,workstation);
    }

    static {
        SERIALIZER = createSerializer(BoilingPotDisplay::new);
        TYPE = createType(BoilingPotDisplay::new);
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

    public BoilingPotDisplay create(Optional<RecipeDisplayId> recipeDisplayId) {
        BoilingPotDisplay boilingPotDisplay = new BoilingPotDisplay(inputs, outputs, result, workstation);
        boilingPotDisplay.id = recipeDisplayId;
        return boilingPotDisplay;
    }

    @Override
    public Optional<RecipeDisplayId> recipeDisplayId() {
        return Optional.empty();
    }
}
