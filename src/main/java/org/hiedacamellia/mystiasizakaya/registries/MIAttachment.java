package org.hiedacamellia.mystiasizakaya.registries;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.MICodec;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOrders;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;

import java.util.ArrayList;
import java.util.function.Supplier;

public class MIAttachment {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MystiasIzakaya.MODID);


    public static final Supplier<AttachmentType<MITags>> MI_TAGS = ATTACHMENTS.register(
            "mi_tags", () -> AttachmentType.builder(() -> new MITags(new ArrayList<>(), new ArrayList<>())).serialize(MICodec.MI_TAGS_CODEC).build()
    );

    public static final Supplier<AttachmentType<MIOrders>> MI_ORDERS = ATTACHMENTS.register(
            "mi_orders", () -> AttachmentType.builder(() -> new MIOrders(new ArrayList<>(), new ArrayList<>())).serialize(MICodec.MI_ORDERS_CODEC).build()
    );

    public static final Supplier<AttachmentType<MIBalance>> MI_BALANCE = ATTACHMENTS.register(
            "mi_balance", () -> AttachmentType.builder(() -> new MIBalance(0)).serialize(MICodec.MI_BALANCE_CODEC).build()
    );

    public static final Supplier<AttachmentType<MITurnover>> MI_TURNOVER = ATTACHMENTS.register(
            "mi_turnover", () -> AttachmentType.builder(() -> new MITurnover()).serialize(MICodec.MI_TURNOVER_CODEC).build()
    );
}
