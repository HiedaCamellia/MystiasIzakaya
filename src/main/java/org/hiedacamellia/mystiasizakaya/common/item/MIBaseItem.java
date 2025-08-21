package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MIBaseItem extends Item {

    private final ItemUseAnimation useAnimation;

    private String tagprefix;

    public MIBaseItem(Properties properties, ItemUseAnimation useAnimation, String tagprefix) {
        super(properties);
        this.useAnimation = useAnimation;
        this.tagprefix = tagprefix;
    }

    @Override
    public ItemUseAnimation getUseAnimation(@NotNull ItemStack itemstack) {
        return useAnimation;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Item.@NotNull TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
        if (!Screen.hasShiftDown()) {
            List<String> tags = MIItemStackUtil.getPositiveTags(itemstack);
            List<String> ntags = MIItemStackUtil.getNegativeTags(itemstack);

            for (String tag : tags) {
                list.add(Component.literal("+ ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.GOLD));
            }
            for (String tag : ntags) {
                list.add(Component.literal("- ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.RED));
            }
            list.add(Component.translatable("tooltip.mystias_izakaya.cost").append(String.valueOf(MIItemStackUtil.getCost(itemstack))).withStyle(ChatFormatting.YELLOW));

            list.add(Component.translatable("tooltip.mystias_izakaya.press_shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }
}
