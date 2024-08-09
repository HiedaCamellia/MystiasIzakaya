package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.MICodec;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICooktime;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIIngredient;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;

public class MIDatacomponet {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(MystiasIzakaya.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MITags>> MI_TAGS = DATA_COMPONENTS.registerComponentType(
            "mi_tags",
            builder -> builder
                    .persistent(MICodec.MI_TAGS_CODEC)
                    .networkSynchronized(MICodec.MI_TAGS_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MICooktime>> MI_COOKTIME = DATA_COMPONENTS.registerComponentType(
            "mi_cooktime",
            builder -> builder
                    .persistent(MICodec.MI_COOKTIME_CODEC)
                    .networkSynchronized(MICodec.MI_COOKTIME_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MIIngredient>> MI_INGREDIENT = DATA_COMPONENTS.registerComponentType(
            "mi_ingredient",
            builder -> builder
                    .persistent(MICodec.MI_INGREDIENT_CODEC)
                    .networkSynchronized(MICodec.MI_INGREDIENT_STREAM_CODEC)
    );
}
