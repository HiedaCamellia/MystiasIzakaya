package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MIItem extends Item {

    private String tagprefix;

    public MIItem(Properties properties,String tagprefix) {
        super(properties);
        this.tagprefix = tagprefix;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Item.@NotNull TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
        if (!Screen.hasShiftDown()) {
            MITags mitags = itemstack.getOrDefault(MIDatacomponet.MI_TAGS.get(), new MITags(new ArrayList<>(),new ArrayList<>()) );
            List<String> tags = mitags.tags();
            List<String> ntags = mitags.ntags();

            for (String tag : tags) {
                list.add(Component.translatable(tagprefix+tag).withStyle(ChatFormatting.GOLD));
            }
            for (String tag : ntags) {
                list.add(Component.translatable(tagprefix+tag).withStyle(ChatFormatting.RED));
            }
            list.add(Component.translatable("tooltip.mystias_izakaya.cost").append(String.valueOf(itemstack.getOrDefault(MIDatacomponet.MI_COST.get(), new MICost(0)).cost())).withStyle(ChatFormatting.YELLOW));

            list.add(Component.translatable("tooltip.mystias_izakaya.press_shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }
}
