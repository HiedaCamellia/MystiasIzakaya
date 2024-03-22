package net.touhou.mystiasizakaya.rei;

import me.shedaniel.rei.api.common.display.Display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.util.CollectionUtils;
import me.shedaniel.rei.impl.display.DisplaySpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BoilingPotDisplay implements Display {

    @Override
    public List<EntryIngredient> getInputEntries() {
        return null;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return null;
    }

    @Override
    public @Nullable CategoryIdentifier<?> getCategoryIdentifier() {
        return null;
    }
}   
