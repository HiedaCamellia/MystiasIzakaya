package org.hiedacamellia.mystiasizakaya.content.datacomponent;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValueHolder implements MutableDataComponentHolder {

    private final String data;
    private final PatchedDataComponentMap components;

    public static final Codec<ValueHolder> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("data").forGetter(ValueHolder::getData),
                    DataComponentPatch.CODEC.optionalFieldOf("components", DataComponentPatch.EMPTY).forGetter(holder -> holder.components.asPatch())
            ).apply(instance, ValueHolder::new)
    );

    private String getData() {
        return data;
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, ValueHolder> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ValueHolder::getData,
            DataComponentPatch.STREAM_CODEC, holder -> holder.components.asPatch(),
            ValueHolder::new
    );


    public ValueHolder(String data, DataComponentPatch patch) {
        this.data = data;
        this.components = PatchedDataComponentMap.fromPatch(
                // The prototype map to apply to
                DataComponentMap.EMPTY,
                // The associated patches
                patch
        );
    }

    @Override
    public @NotNull DataComponentMap getComponents() {
        return this.components;
    }

    @Nullable
    @Override
    public <T> T set(@NotNull DataComponentType<? super T> componentType, @Nullable T value) {
        return this.components.set(componentType, value);
    }

    @Nullable
    @Override
    public <T> T remove(@NotNull DataComponentType<? extends T> componentType) {
        return this.components.remove(componentType);
    }

    @Override
    public void applyComponents(@NotNull DataComponentPatch patch) {
        this.components.applyPatch(patch);
    }

    @Override
    public void applyComponents(@NotNull DataComponentMap components) {
        this.components.setAll(components);
    }

    // Other methods
}