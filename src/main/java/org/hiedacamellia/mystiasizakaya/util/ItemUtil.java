package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemUtil {
    public static List<ItemStack> getStacks(List<String> orders_list) {
        List<ItemStack> stacks = new ArrayList<>();
        for (String order : orders_list) {
            if (order.isEmpty())
                stacks.add(ItemStack.EMPTY);
            else
                stacks.add(new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(order))));
        }
        if (stacks.size() < 8) {
            for (int i = stacks.size(); i < 8; i++) {
                stacks.add(ItemStack.EMPTY);
            }
        }
        return stacks;
    }
    public static List<String> fromStacks(List<ItemStack> stacks) {
        List<String> orders_list = new ArrayList<>();
        for (ItemStack stack : stacks) {
            if (stack.isEmpty())
                orders_list.add("");
            else
                orders_list.add(stack.getItem().getDescriptionId());
        }
        return orders_list;
    }
}
