package org.hiedacamellia.mystiasizakaya.core.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.network.*;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MIPlayerUtil {

    public static int getBalance(Player player){
        return player.getData(MIAttachment.MI_BALANCE);
    }
    public static void setBalance(Player player, int balance){
        player.setData(MIAttachment.MI_BALANCE, balance);
    }
    public static void copyBalance(Player from, Player to){
        to.setData(MIAttachment.MI_BALANCE, from.getData(MIAttachment.MI_BALANCE));
    }
    public static void syncBalance(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new BalanceSyncS2CMessage(MIPlayerUtil.getBalance(player)));
    }

    public static boolean getOnOpen(Player player){
        return player.getData(MIAttachment.MI_ON_OPEN);
    }
    public static void setOnOpen(Player player, boolean onOpen){
        player.setData(MIAttachment.MI_ON_OPEN, onOpen);
    }
    public static void copyOnOpen(Player from, Player to){
        to.setData(MIAttachment.MI_ON_OPEN, from.getData(MIAttachment.MI_ON_OPEN));
    }
    public static void syncOnOpen(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new OpenIzakayaBIMessage(MIPlayerUtil.getOnOpen(player)));
    }

    public static List<Pair<String, Double>> getTurnover(Player player){
        return new ArrayList<>(player.getData(MIAttachment.MI_TURNOVER));
    }
    public static void setTurnover(Player player, List<Pair<String, Double>> turnover){
        player.setData(MIAttachment.MI_TURNOVER, new LinkedList<>(turnover));
    }
    public static void copyTurnover(Player from, Player to){
        to.setData(MIAttachment.MI_TURNOVER, from.getData(MIAttachment.MI_TURNOVER));
    }
    public static void syncTurnover(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new TurnoverSyncS2CMessage(MIPlayerUtil.getTurnover(player)));
    }

    public static IzakayaMenu getIzakayaMenu(Player player){
        return player.getData(MIAttachment.IZAKAYA_MENU);
    }
    public static List<String> getIzakayaMenuCuisinesOriginal(Player player){
        return player.getData(MIAttachment.IZAKAYA_MENU).cuisines();
    }
    public static List<String> getIzakayaMenuBeveragesOriginal(Player player){
        return player.getData(MIAttachment.IZAKAYA_MENU).beverages();
    }
    public static List<ItemStack> getIzakayaMenuCuisines(Player player){
        return player.getData(MIAttachment.IZAKAYA_MENU).toCuisineStacks();
    }
    public static List<ItemStack> getIzakayaMenuBeverages(Player player){
        return player.getData(MIAttachment.IZAKAYA_MENU).toBeverageStacks();
    }
    public static void setIzakayaMenu(Player player, IzakayaMenu izakayaMenu){
        player.setData(MIAttachment.IZAKAYA_MENU, izakayaMenu);
    }
    public static void setIzakayaMenuWithString(Player player, List<String> cuisines, List<String> beverages){
        player.setData(MIAttachment.IZAKAYA_MENU, new IzakayaMenu(cuisines,beverages));
    }
    public static void setIzakayaMenuWithItemStack(Player player, List<ItemStack> cuisines, List<ItemStack> beverages){
        setIzakayaMenuWithString(player,cuisines.stream().map(MIItemStackUtil::toString).toList(),
                beverages.stream().map(MIItemStackUtil::toString).toList());
    }
    public static void copyIzakayaMenu(Player from, Player to){
        to.setData(MIAttachment.IZAKAYA_MENU, from.getData(MIAttachment.IZAKAYA_MENU));
    }
    public static void syncIzakayaMenu(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, IzakayaMenuSyncBiMessage.fromIzakayaMenu(MIPlayerUtil.getIzakayaMenu(serverPlayer)));
        else
            PacketDistributor.sendToServer(IzakayaMenuSyncBiMessage.fromIzakayaMenu(MIPlayerUtil.getIzakayaMenu(player)));
    }

    public static int getTeleCooldown(Player player){
        return player.getData(MIAttachment.MI_TELE_COOLDOWN);
    }
    public static void setTeleCooldown(Player player, int cooldown){
        player.setData(MIAttachment.MI_TELE_COOLDOWN, cooldown);
    }
    public static void copyTeleCooldown(Player from, Player to){
        to.setData(MIAttachment.MI_TELE_COOLDOWN, from.getData(MIAttachment.MI_TELE_COOLDOWN));
    }
    public static void syncTeleCooldown(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new TelephoneCooldownSyncS2CMessage(MIPlayerUtil.getTeleCooldown(player)));
    }

    public static List<BlockPos> getTables(Player player){
        return new ArrayList<>(player.getData(MIAttachment.IZAKAYA_TABLE));
    }
    public static void setTables(Player player, List<BlockPos> tables){
        player.setData(MIAttachment.IZAKAYA_TABLE, new ArrayList<>(tables));
    }
    public static void copyTables(Player from, Player to){
        to.setData(MIAttachment.IZAKAYA_TABLE, from.getData(MIAttachment.IZAKAYA_TABLE));
    }
    public static void syncTables(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new IzakayaTableSyncS2CMessage(MIPlayerUtil.getTables(player)));
    }

    public static IzakayaOrder getIzakayaOrder(Player player){
        return player.getData(MIAttachment.IZAKAYA_ORDER);
    }
    public static List<String> getIzakayaOrderCuisinesOriginal(Player player){
        return player.getData(MIAttachment.IZAKAYA_ORDER).cuisines();
    }
    public static List<String> getIzakayaOrderBeveragesOriginal(Player player){
        return player.getData(MIAttachment.IZAKAYA_ORDER).beverages();
    }
    public static List<ItemStack> getIzakayaOrderCuisines(Player player){
        return player.getData(MIAttachment.IZAKAYA_ORDER).toCuisineStacks();
    }
    public static List<ItemStack> getIzakayaOrderBeverages(Player player){
        return player.getData(MIAttachment.IZAKAYA_ORDER).toBeverageStacks();
    }
    public static void setIzakayaOrder(Player player, IzakayaOrder izakayaOrder){
        player.setData(MIAttachment.IZAKAYA_ORDER, izakayaOrder);
    }
    public static void setIzakayaOrderWithString(Player player, List<String> cuisines, List<String> beverages){
        player.setData(MIAttachment.IZAKAYA_ORDER, new IzakayaOrder(cuisines,beverages));
    }
    public static void setIzakayaOrderWithItemStack(Player player, List<ItemStack> cuisines, List<ItemStack> beverages){
        setIzakayaOrderWithString(player,cuisines.stream().map(MIItemStackUtil::toString).toList(),
                beverages.stream().map(MIItemStackUtil::toString).toList());
    }
    public static void copyIzakayaOrder(Player from, Player to){
        to.setData(MIAttachment.IZAKAYA_MENU, from.getData(MIAttachment.IZAKAYA_MENU));
    }
    public static void syncIzakayaOrder(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, IzakayaOrderSyncS2CMessage.fromIzakayaOrder(MIPlayerUtil.getIzakayaOrder(serverPlayer)));
    }
}
