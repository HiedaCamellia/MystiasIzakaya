package org.hiedacamellia.mystiasizakaya.content.cooking;

import com.mojang.serialization.Codec;

public enum KitchenwareType {
    BOILING_POT,
    FRYING_PAN,
    GRILL,
    CUTTING_BOARD,
    STEAMER,
    NONE;

    public static final Codec<KitchenwareType> CODEC = Codec.STRING.xmap(KitchenwareType::valueOf, KitchenwareType::name);
}
