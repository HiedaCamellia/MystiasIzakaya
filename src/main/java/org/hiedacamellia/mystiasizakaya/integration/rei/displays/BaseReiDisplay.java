package org.hiedacamellia.mystiasizakaya.integration.rei.displays;

import com.mojang.datafixers.util.Function4;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.plugin.client.displays.ClientsidedRecipeBookDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import org.hiedacamellia.mystiasizakaya.core.recipes.MIRecipe;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemUtil;

import java.util.List;

public abstract class BaseReiDisplay<T extends MIRecipe> extends BasicDisplay implements RecipeDisplay, ClientsidedRecipeBookDisplay {


    protected static <I extends BaseReiDisplay<?>> DisplaySerializer<I> createSerializer(
            Function4<List<EntryIngredient>,List<EntryIngredient>,ResourceLocation,ResourceLocation,I> factory
    ) {
        return DisplaySerializer.of(getCodec(factory), getStreamCodec(factory));
    }

    protected static <I extends BaseReiDisplay<?>> Type<I> createType(
            Function4<List<EntryIngredient>,List<EntryIngredient>,ResourceLocation,ResourceLocation,I> factory
    ) {
        return new Type<>(getCodec(factory), getStreamCodec(factory));
    }

    protected static <I extends BaseReiDisplay<?>> MapCodec<I> getCodec(
            Function4<List<EntryIngredient>,List<EntryIngredient>,ResourceLocation,ResourceLocation,I> factory
    ) {
        return RecordCodecBuilder.mapCodec(instance -> instance.group(
                EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(I::getInputEntries),
                EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(I::getOutputEntries),
                ResourceLocation.CODEC.fieldOf("result").forGetter(I::getResultLoc),
                ResourceLocation.CODEC.fieldOf("workstation").forGetter(I::getWorkstationLoc)
        ).apply(instance, factory));
    }

    protected static <I extends BaseReiDisplay<?>> StreamCodec<RegistryFriendlyByteBuf,I> getStreamCodec(
            Function4<List<EntryIngredient>,List<EntryIngredient>,ResourceLocation,ResourceLocation,I> factory
    ) {
        return StreamCodec.composite(
                EntryIngredient.streamCodec().apply(ByteBufCodecs.list()),
                I::getInputEntries,
                EntryIngredient.streamCodec().apply(ByteBufCodecs.list()),
                I::getOutputEntries,
                ResourceLocation.STREAM_CODEC,
                I::getResultLoc,
                ResourceLocation.STREAM_CODEC,
                I::getWorkstationLoc,
                factory
        );
    }


    public ResourceLocation getWorkstationLoc() {
        return MIItemUtil.toResourceLocation(workstation);
    }

    public ResourceLocation getResultLoc() {
        return MIItemUtil.toResourceLocation(result);
    }

    protected final Item result;
    protected final Item workstation;

    protected BaseReiDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, ResourceLocation result, ResourceLocation workstation) {
        this(inputs, outputs,MIItemUtil.fromResourceLocation(result),MIItemUtil.fromResourceLocation(workstation));
    }
    public BaseReiDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Item result, Item workstation) {
        super(inputs, outputs);
        this.result = result;
        this.workstation = workstation;
    }

    @Override
    public SlotDisplay result() {
        return new SlotDisplay.ItemSlotDisplay(result);
    }

    @Override
    public SlotDisplay craftingStation() {
        return new SlotDisplay.ItemSlotDisplay(workstation);
    }
}
