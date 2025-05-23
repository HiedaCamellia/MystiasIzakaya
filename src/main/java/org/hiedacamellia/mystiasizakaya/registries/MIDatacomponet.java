package org.hiedacamellia.mystiasizakaya.registries;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;

import java.util.List;

public class MIDatacomponet {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE,MystiasIzakaya.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> MI_POSITIVE_TAGS = DATA_COMPONENTS.registerComponentType(
            "mi_positive_tags",
            builder -> builder
                    .persistent(MICodecUtil.LIST_STRING_CODEC)
                    .networkSynchronized(MICodecUtil.LIST_STRING_STREAM_CODEC)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> MI_NEGATIVE_TAGS = DATA_COMPONENTS.registerComponentType(
            "mi_negative_tags",
            builder -> builder
                    .persistent(MICodecUtil.LIST_STRING_CODEC)
                    .networkSynchronized(MICodecUtil.LIST_STRING_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MI_COOKTIME = DATA_COMPONENTS.registerComponentType(
            "mi_cooktime",
            builder -> builder
                    .persistent(Codec.INT)
                    .networkSynchronized(ByteBufCodecs.INT)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> MI_INGREDIENT = DATA_COMPONENTS.registerComponentType(
            "mi_ingredient",
            builder -> builder
                    .persistent(MICodecUtil.LIST_STRING_CODEC)
                    .networkSynchronized(MICodecUtil.LIST_STRING_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MI_COST = DATA_COMPONENTS.registerComponentType(
            "mi_cost",
            builder -> builder
                    .persistent(Codec.INT)
                    .networkSynchronized(ByteBufCodecs.INT)
    );
}
