package org.hiedacamellia.mystiasizakaya.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

import java.util.List;

public class MystiasIzakayaAPI {

    public int playerGetBalance(Player player){
        return MIPlayerUtil.getBalance(player);
    }
    public void playerSetBalance(Player player, int balance){
        MIPlayerUtil.setBalance(player, balance);
    }

    public int itemGetCost(ItemStack itemStack){
        return MIItemStackUtil.getCost(itemStack);
    }

    public void itemSetCost(ItemStack itemStack, int cost){
        MIItemStackUtil.setCost(itemStack, cost);
    }

    public static int itemGetCookTime(ItemStack itemStack){
        return MIItemStackUtil.getCookTime(itemStack);
    }

    public static void itemSetCookTime(ItemStack itemStack, int cost){
        MIItemStackUtil.setCookTime(itemStack, cost);
    }

    public static List<ItemStack> itemGetIngredient(ItemStack itemStack){
        return MIItemStackUtil.getIngredient(itemStack);
    }
    public static void itemSetIngredient(ItemStack itemStack, List<ItemStack> ingredient){
        MIItemStackUtil.setIngredient(itemStack, ingredient);
    }
}
