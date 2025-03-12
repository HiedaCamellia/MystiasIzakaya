package org.hiedacamellia.mystiasizakaya.content.common.blockitem;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GrillBlockItem extends KitchenwareBlockItem {
    public GrillBlockItem() {
        super(MIBlock.GRILL.get(), new Properties().stacksTo(1).rarity(Rarity.RARE)
                .component(MIDatacomponet.MI_TAGS.get(),new MITags( List.of("grill"),new ArrayList<>())));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Item.@NotNull TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        if (Screen.hasShiftDown()) {
            String[] description = Component.translatable("tooltip.mystias_izakaya.shao_kao_jia").getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }

    @Override
    public KitchenwareType getKitchenwareType() {
        return KitchenwareType.CUTTING_BOARD;
    }
}
