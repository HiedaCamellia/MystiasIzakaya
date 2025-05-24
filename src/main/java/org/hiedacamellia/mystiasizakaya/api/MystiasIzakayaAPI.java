package org.hiedacamellia.mystiasizakaya.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;

import java.util.List;

public class MystiasIzakayaAPI {

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

    public static List<String> itemGetPositiveTags(ItemStack itemStack){
        return MIItemStackUtil.getPositiveTags(itemStack);
    }
    public static void itemSetPositiveTags(ItemStack itemStack, List<String> tags){
        MIItemStackUtil.setPositiveTags(itemStack, tags);
    }
    public static List<String> itemGetNegativeTags(ItemStack itemStack){
        return MIItemStackUtil.getNegativeTags(itemStack);
    }
    public static void itemSetNegativeTags(ItemStack itemStack, List<String> tags){
        MIItemStackUtil.setNegativeTags(itemStack, tags);
    }
    public static void itemSetTags(ItemStack itemStack, List<String> positive, List<String> negative){
        MIItemStackUtil.setTags(itemStack, positive, negative);
    }


    public int playerGetBalance(Player player){
        return MIPlayerUtil.getBalance(player);
    }
    public void playerSetBalance(Player player, int balance){
        MIPlayerUtil.setBalance(player, balance);
    }
    public static void playerSyncBalance(Player player){
        MIPlayerUtil.syncBalance(player);
    }
    public static void playerChangeBalance(Player player, int change, String type){
        MIBalanceUtil.change(player,change,type);
    }


    public static boolean playerGetOnOpen(Player player){
        return MIPlayerUtil.getOnOpen(player);
    }
    public static void playerSetOnOpen(Player player, boolean onOpen){
        MIPlayerUtil.setOnOpen(player, onOpen);
    }
    public static void playerSyncOnOpen(Player player){
        MIPlayerUtil.syncOnOpen(player);
    }

    public static List<Pair<String, Double>> playerGetTurnover(Player player){
        return MIPlayerUtil.getTurnover(player);
    }
    public static void playerSetTurnover(Player player, List<Pair<String, Double>> turnover){
        MIPlayerUtil.setTurnover(player, turnover);
    }
    public static void playerSyncTurnover(Player player){
        MIPlayerUtil.syncTurnover(player);
    }

    public static List<ItemStack> playerGetIzakayaMenuCuisines(Player player){
        return MIPlayerUtil.getIzakayaMenuCuisines(player);
    }
    public static List<ItemStack> playerGetIzakayaMenuBeverages(Player player){
        return MIPlayerUtil.getIzakayaMenuBeverages(player);
    }
    public static void playerSetIzakayaMenuWithItemStack(Player player, List<ItemStack> cuisines, List<ItemStack> beverages){
        MIPlayerUtil.setIzakayaMenuWithItemStack(player, cuisines, beverages);
    }
    public static void playerSyncIzakayaMenu(Player player){
        MIPlayerUtil.syncIzakayaMenu(player);
    }

    public static int playerGetTeleCooldown(Player player){
        return MIPlayerUtil.getTeleCooldown(player);
    }
    public static void playerSetTeleCooldown(Player player, int cooldown){
        MIPlayerUtil.setTeleCooldown(player, cooldown);
    }
    public static void playerSyncTeleCooldown(Player player){
        MIPlayerUtil.syncTeleCooldown(player);
    }
    
    public static List<BlockPos> playerGetTables(Player player){
        return MIPlayerUtil.getTables(player);
    }
    public static void playerSetTables(Player player, List<BlockPos> tables){
        MIPlayerUtil.setTables(player, tables);
    }
    public static void playerSyncTables(Player player){
        MIPlayerUtil.syncTables(player);
    }

    public static List<ItemStack> playerGetIzakayaOrderCuisines(Player player){
        return MIPlayerUtil.getIzakayaOrderCuisines(player);
    }
    public static List<ItemStack> playerGetIzakayaOrderBeverages(Player player){
        return MIPlayerUtil.getIzakayaOrderBeverages(player);
    }
    public static void playerSetIzakayaOrderWithItemStack(Player player, List<ItemStack> cuisines, List<ItemStack> beverages){
        MIPlayerUtil.setIzakayaOrderWithItemStack(player, cuisines, beverages);
    }
    public static void playerSyncIzakayaOrder(Player player){
        MIPlayerUtil.syncIzakayaOrder(player);
    }
}
