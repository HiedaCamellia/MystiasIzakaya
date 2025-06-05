package org.hiedacamellia.mystiasizakaya.core.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.PacketDistributor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.network.*;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MIPlayerUtil {

    private static final Logger logger = LogManager.getLogger();


    private static void warnNotServerPlayer(Player player) {
        logger.warn("Player {} is not a server player, cannot perform operation", player.getName().getString());
    }

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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new BalanceSyncS2CMessage(MIPlayerUtil.getBalance(player)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing balance for player {}: {}", player.getName().getString(), MIPlayerUtil.getBalance(player));
            }
        }else {
            warnNotServerPlayer(player);
        }
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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new OpenIzakayaBIMessage(MIPlayerUtil.getOnOpen(player)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing onOpen for player {}: {}", player.getName().getString(), MIPlayerUtil.getOnOpen(player));
            }
        }else {
            warnNotServerPlayer(player);
        }
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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new TurnoverSyncS2CMessage(MIPlayerUtil.getTurnover(player)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing turnover for player {}: {}", player.getName().getString(), MIPlayerUtil.getTurnover(player));
            }
        }else {
            warnNotServerPlayer(player);
        }
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
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Syncing izakaya menu for player {}: {}", player.getName().getString(), MIPlayerUtil.getIzakayaMenu(player));
        }
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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new TelephoneCooldownSyncS2CMessage(MIPlayerUtil.getTeleCooldown(player)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing tele cooldown for player {}: {}", player.getName().getString(), MIPlayerUtil.getTeleCooldown(player));
            }
        }else {
            warnNotServerPlayer(player);
        }
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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new IzakayaTableSyncS2CMessage(MIPlayerUtil.getTables(player)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing tables for player {}: {}", player.getName().getString(), MIPlayerUtil.getTables(player));
            }
        }else {
            warnNotServerPlayer(player);
        }
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
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, IzakayaOrderSyncS2CMessage.fromIzakayaOrder(MIPlayerUtil.getIzakayaOrder(serverPlayer)));
            if(MystiasIzakaya.isDebugMode()){
                logger.debug("Syncing izakaya order for player {}: {}", player.getName().getString(), MIPlayerUtil.getIzakayaOrder(player));
            }
        } else {
            warnNotServerPlayer(player);
        }
    }

    public static void giveItemToPlayer(ItemLike item,int count, Player player){
        giveItemToPlayer(item.asItem(), count,player);
    }
    public static void giveItemToPlayer(ItemLike item, Player player){
        giveItemToPlayer(item.asItem(), player);
    }
    public static void giveItemToPlayer(Item item,Player player){
        giveItemToPlayer(item.getDefaultInstance(), player);
    }
    public static void giveItemToPlayer(ItemStack itemStack,Player player){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Giving item {} to player {}", itemStack, player.getName().getString());
        }
        ItemHandlerHelper.giveItemToPlayer(player,itemStack);
    }
    public static void giveItemToPlayer(Item item,int count,Player player){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Giving {} items of {} to player {}", count, item, player.getName().getString());
        }
        int j = count;
        if(j>=64*36){
            logger.warn("Player {} tried to gain {} items, which is too many!", player.getName().getString(), j);
        }
        while(j>0){
            if(j>64){
                j -= 64;
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(item,64));
            }else{
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(item,j));
                break;
            }
        }
    }
}
