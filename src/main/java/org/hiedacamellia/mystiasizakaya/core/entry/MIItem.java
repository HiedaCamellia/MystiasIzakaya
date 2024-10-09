package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MIItem extends Item {

    private final UseAnim useAnimation;
    private final List<String> tags;
    private final List<String> ntags;
    private final String tagprefix;
    private int cooktime=0;
    private int cost=0;

    public MIItem(Properties properties, UseAnim useAnimation, String tagprefix,List<String> tags,List<String> ntags,int cost,int cooktime) {
        super(properties);
        this.useAnimation = useAnimation;
        this.tagprefix = tagprefix;
        this.tags = tags;
        this.ntags = ntags;
        this.cost = cost;
        this.cooktime = cooktime;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        String tags = stack.getOrCreateTag().getString("tags");
        if (tags.isEmpty()){
            stack.getOrCreateTag().putString("tags", String.join(",", this.tags));
        }
        String ntags = stack.getOrCreateTag().getString("ntags");
        if (ntags.isEmpty()){
            stack.getOrCreateTag().putString("ntags", String.join(",", this.ntags));
        }
        int cost = stack.getOrCreateTag().getInt("cost");
        if (cost == 0){
            stack.getOrCreateTag().putInt("cost", this.cost);
        }
        int cooktime = stack.getOrCreateTag().getInt("cooktime");
        if (cooktime == 0){
            stack.getOrCreateTag().putInt("cooktime", this.cooktime);
        }
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
        return useAnimation;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
        if (!Screen.hasShiftDown()) {
            List<String> tags = itemstack.getOrCreateTag().getString("tags").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("tags").split(","));
            List<String> ntags = itemstack.getOrCreateTag().getString("ntags").isEmpty() ? new ArrayList<>() : List.of(itemstack.getOrCreateTag().getString("ntags").split(","));

            for (String tag : tags) {
                list.add(Component.literal("+ ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.GOLD));
            }
            for (String tag : ntags) {
                list.add(Component.literal("- ").append(Component.translatable(tagprefix+tag)).withStyle(ChatFormatting.RED));
            }

            //int cost = itemstack.getOrCreateTag().getInt("cost");
            list.add(Component.translatable("tooltip.mystias_izakaya.cost").append(String.valueOf(this.cost)).withStyle(ChatFormatting.YELLOW));

            list.add(Component.translatable("tooltip.mystias_izakaya.press_shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }
}
