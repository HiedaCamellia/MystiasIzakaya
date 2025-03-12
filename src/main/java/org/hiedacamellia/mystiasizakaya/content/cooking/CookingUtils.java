package org.hiedacamellia.mystiasizakaya.content.cooking;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.core.recipes.MIRecipeInput;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.ArrayList;
import java.util.List;

public class CookingUtils {

    public static List<ItemStack> getAvailableCuisines(Level level, List<ItemStack> ingredients, KitchenwareType util) {
        RecipeManager recipes = level.getRecipeManager();
        MIRecipeInput miRecipeInput = new MIRecipeInput(new ArrayList<>(ingredients));
        List<ItemStack> targetI = new ArrayList<>();
        switch (util) {
            case BOILING_POT: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.BOILING_POT.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case FRYING_PAN: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.FRYING_PAN.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case GRILL: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.GRILL.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case CUTTING_BOARD: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.CUTTING_BOARD.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
            case STEAMER: {
                var optionals = recipes.getAllRecipesFor(
                        MIRecipeType.STEAMER.get()
                );
                for (var optional : optionals) {
                    if (optional.value().matches(miRecipeInput, level)) {
                        targetI.add(optional.value().assemble(miRecipeInput, level.registryAccess()));
                    }
                }
                return targetI;
            }
        }
        return targetI;
    }
}
