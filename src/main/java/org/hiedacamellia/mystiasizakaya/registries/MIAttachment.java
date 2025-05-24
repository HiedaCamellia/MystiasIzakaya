package org.hiedacamellia.mystiasizakaya.registries;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Supplier;

public class MIAttachment {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MystiasIzakaya.MODID);

    public static final Supplier<AttachmentType<IzakayaOrder>> IZAKAYA_ORDER = ATTACHMENTS.register(
            "izakaya_order", () -> AttachmentType.builder(IzakayaOrder::init).serialize(IzakayaOrder.CODEC).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<ArrayList<BlockPos>>> IZAKAYA_TABLE = ATTACHMENTS.register(
            "izakaya_table", () -> AttachmentType.builder(() -> new ArrayList<BlockPos>()).serialize(MICodecUtil.LIST_BLOCK_POS_CODEC).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<IzakayaMenu>> IZAKAYA_MENU = ATTACHMENTS.register(
            "izakaya_menu", () -> AttachmentType.builder(IzakayaMenu::init).serialize(IzakayaMenu.CODEC).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<Integer>> MI_BALANCE = ATTACHMENTS.register(
            "mi_balance", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<LinkedList<Pair<String, Double>>>> MI_TURNOVER = ATTACHMENTS.register(
            "mi_turnover", () -> AttachmentType.builder(() -> new LinkedList<Pair<String,Double>>()).serialize(MICodecUtil.LIST_TURNOVER_CODEC).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<Integer>> MI_TELE_COOLDOWN = ATTACHMENTS.register(
            "mi_tele_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<Boolean>> MI_ON_OPEN = ATTACHMENTS.register(
            "mi_on_open", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).copyOnDeath().build()
    );
}
