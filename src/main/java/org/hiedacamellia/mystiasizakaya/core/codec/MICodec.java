package org.hiedacamellia.mystiasizakaya.core.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
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

    public static final Codec<MIMenu> MI_MENU_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("orders").forGetter(MIMenu::orders),
                    Codec.list(Codec.STRING).fieldOf("beverages").forGetter(MIMenu::beverages),
                    Codec.list(BlockPos.CODEC).fieldOf("blockpos").forGetter(MIMenu::blockPos)
            ).apply(instance, MIMenu::new)
    );
    public static final StreamCodec<ByteBuf, MIMenu> MI_MENU_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIMenu::orders,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIMenu::beverages,
            ByteBufCodecs.fromCodec(Codec.list(BlockPos.CODEC)), MIMenu::blockPos,
            MIMenu::new
    );

    public static final Codec<MIOrders> MI_ORDERS_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("orders").forGetter(MIOrders::orders),
                    Codec.list(Codec.STRING).fieldOf("beverages").forGetter(MIOrders::beverages),
                    Codec.list(BlockPos.CODEC).fieldOf("blockpos").forGetter(MIOrders::blockPos)
            ).apply(instance, MIOrders::new)
    );
    public static final StreamCodec<ByteBuf, MIOrders> MI_ORDERS_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIOrders::orders,
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MIOrders::beverages,
            ByteBufCodecs.fromCodec(Codec.list(BlockPos.CODEC)), MIOrders::blockPos,
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
                    Codec.list(Codec.STRING).fieldOf("k").forGetter(MITurnover::k),
                    Codec.list(Codec.DOUBLE).fieldOf("v").forGetter(MITurnover::v)
            ).apply(instance, MITurnover::new)
    );

    public static final StreamCodec<ByteBuf, MITurnover> MI_TURNOVER_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.STRING)), MITurnover::k,
            ByteBufCodecs.fromCodec(Codec.list(Codec.DOUBLE)), MITurnover::v,
            MITurnover::new
    );

    public static final Codec<MICost> MI_COST_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("cost").forGetter(MICost::cost)
            ).apply(instance, MICost::new)
    );
    public static final StreamCodec<ByteBuf, MICost> MI_COST_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MICost::cost,
            MICost::new
    );

    public static final Codec<MITeleColddown> MI_TELE_COLDDOWN_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("tick").forGetter(MITeleColddown::tick)
            ).apply(instance, MITeleColddown::new)
    );
    public static final StreamCodec<ByteBuf, MITeleColddown> MI_TELE_COLDDOWN_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MITeleColddown::tick,
            MITeleColddown::new
    );

    public static final Codec<MIOnOpen> MI_ON_OPEN_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf("open").forGetter(MIOnOpen::open)
            ).apply(instance, MIOnOpen::new)
    );
    public static final StreamCodec<ByteBuf, MIOnOpen> MI_ON_OPEN_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, MIOnOpen::open,
            MIOnOpen::new
    );
}
