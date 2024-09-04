package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RandomItems {

    public static List<ItemStack> getRandomItems(Collection<RegistryObject<Item>> entries, int num) {
        List<ItemStack> items = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        for(int i=0;i<num;i++){
            int index = (int)(Math.random()*entries.size());
            if(indexs.contains(index)){
                i--;
                continue;
            }
            indexs.add(index);
            ItemStack itemStack = new ItemStack(entries.stream().toList().get(index).get());
            itemStack.setCount((int)(Math.random()*16)+1);
            items.add(itemStack);
        }
        return items;
    }
}
