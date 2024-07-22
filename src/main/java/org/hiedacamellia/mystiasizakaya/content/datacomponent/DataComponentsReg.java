package org.hiedacamellia.mystiasizakaya.content.datacomponent;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class DataComponentsReg {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(MystiasIzakaya.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> BASIC_KV = REGISTRAR.registerComponentType(
            "kv",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent( DC.VALUE)
                    // The codec to read/write the data across the network
                    .networkSynchronized(DC.STREAM_VALUE)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> Tags = REGISTRAR.registerComponentType(
            "tags",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent( DC.VALUE)
                    // The codec to read/write the data across the network
                    .networkSynchronized(DC.STREAM_VALUE)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> nTags = REGISTRAR.registerComponentType(
            "ntags",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent( DC.VALUE)
                    // The codec to read/write the data across the network
                    .networkSynchronized(DC.STREAM_VALUE)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> Ingredients = REGISTRAR.registerComponentType(
            "ingredients",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent( DC.VALUE)
                    // The codec to read/write the data across the network
                    .networkSynchronized(DC.STREAM_VALUE)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> Cooktime = REGISTRAR.registerComponentType(
            "cooktime",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent( DC.VALUE)
                    // The codec to read/write the data across the network
                    .networkSynchronized(DC.STREAM_VALUE)
    );







    /// Component will not be saved to disk
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> TRANSIENT_VALUE = REGISTRAR.registerComponentType(
            "transient",
            builder -> builder.networkSynchronized(DC.STREAM_VALUE)
    );

    // No data will be synced across the network
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ValueRecord>> NO_NETWORK_VALUE = REGISTRAR.registerComponentType(
            "no_network",
            builder -> builder
                    .persistent(DC.VALUE)
                    // Note we use a unit stream codec here
                    .networkSynchronized(DC.UNIT_STREAM_VALUE)
    );
}
