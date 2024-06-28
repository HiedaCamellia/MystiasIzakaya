
package org.hiedacamellia.mystiasizakaya.content.item.ingredients;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromCuisines;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromIngredientsProcedure;
import org.hiedacamellia.mystiasizakaya.functionals.effects.GiveEffectFromTagsProcedure;
import org.hiedacamellia.mystiasizakaya.util.GetTagsFromNbt;

import java.util.*;

public class BingDiLianItem extends Item {
    public BingDiLianItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                .food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.8f).alwaysEat().build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 32;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        if (!Screen.hasShiftDown()) {
            List<String> tags = gettags();
            for (String tag : tags) {
                list.add(Component.literal("§6+ " + Component.translatable(tag).getString() + "§r"));
            }
            List<String> tagsfnbt = GetTagsFromNbt.execute(itemstack);
            for (String tag : tagsfnbt) {
                list.add(Component.literal("§6+ " + Component.translatable(tag).getString() + "§r"));
            }
            Set<Component> set = new LinkedHashSet<>(list);
            list.clear();
            list.addAll(set);
            List<String> negativetags = getnegativetags();
            for (String tag : negativetags) {
                list.add(Component.literal("§4- " + Component.translatable(tag).getString() + "§r"));
            }
            list.add(Component.literal(
                    "§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
        } else {
            List<String> description = Arrays
                    .asList(Component.translatable("tooltip.mystias_izakaya.bing_di_lian").getString().split("§n"));
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }

    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        super.finishUsingItem(itemstack, world, entity);
        GiveEffectFromTagsProcedure.execute(world, itemstack, entity);
        GiveEffectFromIngredientsProcedure.execute(world, itemstack, entity);
        GiveEffectFromCuisines.execute(world, itemstack, entity);
        return itemstack;
    }


    public static List<String> gettags() {
        List<String> list = new ArrayList<>();
        list.add("tag.mystias_izakaya.Cultural_Heritage");
        list.add("tag.mystias_izakaya.Premium");
        list.add("tag.mystias_izakaya.Legendary");
        list.add("tag.mystias_izakaya.Mild");
        list.add("tag.mystias_izakaya.Dreamy");
        return list;
    }

    public static List<String> getnegativetags() {
        List<String> list = new ArrayList<>();
        return list;
    }
}
