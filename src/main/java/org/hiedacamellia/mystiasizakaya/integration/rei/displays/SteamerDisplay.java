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
import org.hiedacamellia.mystiasizakaya.core.recipes.SteamerRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class SteamerDisplay extends BaseReiDisplay<SteamerRecipe>{

    public static final CategoryIdentifier<SteamerDisplay> CATEGORY =  CategoryIdentifier.of(MystiasIzakaya.MODID, "steamer");

    private static final DisplaySerializer<SteamerDisplay> SERIALIZER;
    public static final Type<SteamerDisplay> TYPE;
    protected Optional<RecipeDisplayId> id = Optional.empty();

    protected SteamerDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs, MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public SteamerDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs,outputs,result,workstation);
    }

    static {
        SERIALIZER = createSerializer(SteamerDisplay::new);
        TYPE = createType(SteamerDisplay::new);
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

    public SteamerDisplay create(Optional<RecipeDisplayId> recipeDisplayId) {
        SteamerDisplay SteamerDisplay = new SteamerDisplay(inputs, outputs, result, workstation);
        SteamerDisplay.id = recipeDisplayId;
        return SteamerDisplay;
    }

    @Override
    public Optional<RecipeDisplayId> recipeDisplayId() {
        return Optional.empty();
    }
}
