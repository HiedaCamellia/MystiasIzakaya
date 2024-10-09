package org.hiedacamellia.mystiasizakaya.content.common.blockitem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GrillBlockItem extends BlockItem {
    public GrillBlockItem() {
        super(MIBlock.GRILL.get(), new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    private String tagprefix = "tag.mystias_izakaya.";
    private List<String> tags = List.of("grill");

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        String tags = stack.getOrCreateTag().getString("tags");
        if (tags.isEmpty()){
            stack.getOrCreateTag().putString("tags", String.join(",",this.tags));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        if (!Screen.hasShiftDown()) {
            List<String> tags = itemstack.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("tags").split(","));
            List<String> ntags = itemstack.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("ntags").split(","));

            for (String tag : tags) {
                list.add(Component.literal("+ ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.GOLD));
            }
            for (String tag : ntags) {
                list.add(Component.literal("- ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.RED));
            }

            list.add(Component.translatable("tooltip.mystias_izakaya.press_shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            String[] description = Component.translatable("tooltip.mystias_izakaya.shao_kao_jia").getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }
}
