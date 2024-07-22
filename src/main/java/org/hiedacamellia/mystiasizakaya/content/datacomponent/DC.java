package org.hiedacamellia.mystiasizakaya.content.datacomponent;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.codec.ByteBufCodecs;

public class DC {

    // Basic codec
    public static final Codec<ValueRecord> VALUE = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("value").forGetter(ValueRecord::value)
            ).apply(instance, ValueRecord::new)
    );

    public static final StreamCodec<ByteBuf, ValueRecord> STREAM_VALUE = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ValueRecord::value,
            ValueRecord::new
    );

    // Unit stream codec if nothing should be sent across the network
    public static final StreamCodec<ByteBuf, ValueRecord> UNIT_STREAM_VALUE = StreamCodec.unit(new ValueRecord(""));
}
