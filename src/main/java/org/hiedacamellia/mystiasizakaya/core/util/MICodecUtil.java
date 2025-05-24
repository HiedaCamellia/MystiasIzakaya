package org.hiedacamellia.mystiasizakaya.core.util;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PairCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MICodecUtil {


    public static final StreamCodec<ByteBuf, List<String>> LIST_STRING_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.<ByteBuf,String>list().apply(ByteBufCodecs.STRING_UTF8),
            (e)->e,
            ArrayList::new
    );

    public static final Codec<List<String>> LIST_STRING_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.STRING).fieldOf("list").forGetter((e)->e)
            ).apply(instance, ArrayList::new)
    );


    public static final Codec<Pair<String,Double>> TURNOVER_CODEC = RecordCodecBuilder.create(pairInstance ->
            pairInstance.group(
                    Codec.STRING.fieldOf("k").forGetter(Pair::getFirst),
                    Codec.DOUBLE.fieldOf("v").forGetter(Pair::getSecond)
            ).apply(pairInstance, Pair::new)
    );
    public static final StreamCodec<ByteBuf,Pair<String,Double>> TURNOVER_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, Pair::getFirst,
            ByteBufCodecs.DOUBLE, Pair::getSecond,
            Pair::of
    );

    public static final StreamCodec<ByteBuf, List<Pair<String,Double>>> LIST_TURNOVER_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.<ByteBuf,Pair<String,Double>>list().apply(MICodecUtil.TURNOVER_STREAM_CODEC),
            (e)->e,
            ArrayList::new
    );
    public static final Codec<LinkedList<Pair<String,Double>>> LIST_TURNOVER_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(MICodecUtil.TURNOVER_CODEC.listOf().fieldOf("list").forGetter((e)->e)).apply(instance, LinkedList::new)
    );



    public static final StreamCodec<ByteBuf, List<BlockPos>> LIST_BLOCK_POS_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.<ByteBuf,BlockPos>list().apply(BlockPos.STREAM_CODEC),
            (e)->e,
            ArrayList::new
    );

    public static final Codec<ArrayList<BlockPos>> LIST_BLOCK_POS_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(BlockPos.CODEC).fieldOf("list").forGetter((e)->e)
            ).apply(instance, ArrayList::new)
    );


}
