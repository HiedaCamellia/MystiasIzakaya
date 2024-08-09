package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.core.cooking.effects.GiveEffectFromCuisines;
import org.hiedacamellia.mystiasizakaya.core.cooking.effects.GiveEffectFromIngredientsProcedure;
import org.hiedacamellia.mystiasizakaya.core.cooking.effects.GiveEffectFromTagsProcedure;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseItem extends Item {

    private final UseAnim useAnimation;
    private final int useDuration;
    private final String regname;

    public BaseItem(Properties properties,int stacks,int nutrition,float saturation,Rarity rarity,UseAnim useAnimation, int useDuration, String regname, String[] tags, String[] ntags) {


        super(properties.stacksTo(stacks).rarity(rarity)
                .component(MIDatacomponet.MI_TAGS.get(), new MITags(Arrays.asList(tags), Arrays.asList(ntags)))
                .food((new FoodProperties.Builder()).nutrition(nutrition).saturationModifier(saturation).alwaysEdible().build()));

        this.useAnimation = useAnimation;
        this.useDuration = useDuration;
        this.regname = regname;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
        return useAnimation;
    }


    public int getUseDuration(ItemStack itemstack) {
        return useDuration;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Item.@NotNull TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        if (!Screen.hasShiftDown()) {
            MITags mitags = itemstack.getOrDefault(MIDatacomponet.MI_TAGS.get(), new MITags(new ArrayList<>(),new ArrayList<>()) );
            List<String> tags = mitags.tags();
            List<String> ntags = mitags.ntags();

            for (String tag : tags) {
                list.add(Component.literal("§6+ " + Component.translatable(gettagprefix()+tag).getString() + "§r"));
            }
            for (String tag : ntags) {
                list.add(Component.literal("§4- " + Component.translatable(gettagprefix()+tag).getString() + "§r"));
            }
            list.add(Component.literal(
                    "§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
        } else {
            String[] description = Component.translatable("tooltip.mystias_izakaya."+this.regname).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
        super.finishUsingItem(itemstack, world, entity);
        GiveEffectFromTagsProcedure.execute(world, itemstack, entity);
        GiveEffectFromIngredientsProcedure.execute(world, itemstack, entity);
        GiveEffectFromCuisines.execute(world, itemstack, entity);
        return itemstack;
    }

    public String gettagprefix() {
        return "tag.mystias_izakaya.";
    }
}


