package org.hiedacamellia.mystiasizakaya.core.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;

public class MICodec {
    public static final Codec<MITags> MI_TAGS_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("tags").forGetter(MITags::tags),
                    Codec.list(Codec.STRING).fieldOf("ntags").forGetter(MITags::ntags)
            ).apply(instance, MITags::new)
    );
    public static final StreamCodec<ByteBuf, MITags> MI_TAGS_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MITags::tags,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MITags::ntags,
            MITags::new
    );


    public static final Codec<MIOrders> MI_ORDERS_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("orders").forGetter(MIOrders::orders),
                    Codec.list(Codec.STRING).fieldOf("beverages").forGetter(MIOrders::beverages)
            ).apply(instance, MIOrders::new)
    );
    public static final StreamCodec<ByteBuf, MIOrders> MI_ORDERS_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIOrders::orders,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIOrders::beverages,
            MIOrders::new
    );

    public static final Codec<MIBalance> MI_BALANCE_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("balance").forGetter(MIBalance::balance)
            ).apply(instance, MIBalance::new)
    );
    public static final StreamCodec<ByteBuf, MIBalance> MI_BALANCE_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MIBalance::balance,
            MIBalance::new
    );


    public static final Codec<MICooktime> MI_COOKTIME_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("cooktime").forGetter(MICooktime::cooktime)
            ).apply(instance, MICooktime::new)
    );
    public static final StreamCodec<ByteBuf, MICooktime> MI_COOKTIME_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MICooktime::cooktime,
            MICooktime::new
    );

    public static final Codec<MIIngredient> MI_INGREDIENT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("ingredient").forGetter(MIIngredient::ingredient)
            ).apply(instance, MIIngredient::new)
    );

    public static final StreamCodec<ByteBuf, MIIngredient> MI_INGREDIENT_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIIngredient::ingredient,
            MIIngredient::new
    );

    public static final Codec<MITurnover> MI_TURNOVER_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.unboundedMap(Codec.STRING, Codec.DOUBLE).fieldOf("turnover").forGetter(MITurnover::turnover)
            ).apply(instance, MITurnover::new)
    );

    public static final StreamCodec<ByteBuf, MITurnover> MI_TURNOVER_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.unboundedMap(Codec.STRING, Codec.DOUBLE)), MITurnover::turnover,
            MITurnover::new
    );

}
