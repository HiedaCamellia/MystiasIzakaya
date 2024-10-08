package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIComponents;

import java.util.*;


public class MIPlayerEvent {

    public static double getBalance(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getBalance();
    }

    public static void setBalance(Player player, double balance) {
        MIComponents.PLAYER_DATA.get(player).setBalance(balance);
    }
    public static int getTelecolddown(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getTelecolddown();
    }

    public static void setTelecolddown(Player player, int telecolddown) {
        MIComponents.PLAYER_DATA.get(player).setTelecolddown(telecolddown);
    }

    public static void changeBalance(Player player, double balance) {
        setBalance(player, getBalance(player) + balance);
    }

    public static void addTurnoverPre(Player player, String turnover) {
        List<String> turnover_pre = new ArrayList<>(getTurnoverPre(player));
        turnover_pre.add(turnover);
        MIComponents.PLAYER_DATA.get(player).setTurnover_pre(turnover_pre);
    }

    public static void addTurnoverCha(Player player, int turnover) {
        List<Integer> turnover_cha = new ArrayList<>(getTurnoverCha(player));
        turnover_cha.add(turnover);
        MIComponents.PLAYER_DATA.get(player).setTrunover_cha(turnover_cha);
    }

    public static void addTurnover(Player player, String turnover, int turnover_cha) {
        addTurnoverPre(player, turnover);
        addTurnoverCha(player, turnover_cha);
    }



    public static List<String> getOrders(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getOrders();
    }

    public static void setOrders(Player player, List<String> orders) {
        MIComponents.PLAYER_DATA.get(player).setOrders(orders);
    }

    public static List<String> getOrdersBeverages(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getOrdersbeverages();
    }

    public static void setOrdersBeverages(Player player, List<String> ordersbeverages) {
        MIComponents.PLAYER_DATA.get(player).setOrdersbeverages(ordersbeverages);
    }

    public static List<String> getTurnoverPre(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getTurnover_pre();
    }

    public static List<Integer> getTurnoverCha(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getTrunover_cha();
    }

    public static void deleteOverTurnover(Player player) {
        List<String> turnover_pre = getTurnoverPre(player);
        List<Integer> turnover_cha = getTurnoverCha(player);
        while (turnover_pre.size() > CommonConfig.MAX_OVERTURN.get()) {
            turnover_pre.remove(0);
            turnover_cha.remove(0);
        }
    }

    public static List<BlockPos> getTables(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getTables();
    }

    public static void setTables(Player player, List<BlockPos> tables) {
        MIComponents.PLAYER_DATA.get(player).setTables(tables);
    }


    public static List<BlockPos> getMenuBlockPos(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getMenus();
    }

    public static void setMenuBlockPos(Player player, List<BlockPos> menus) {
        MIComponents.PLAYER_DATA.get(player).setMenus(menus);
    }

    public static List<String> getMenus(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getMenu();
    }

    public static void setMenus(Player player, List<String> menus) {
        MIComponents.PLAYER_DATA.get(player).setMenu(menus);
    }

    public static List<String> getMenusBeverages(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getMenubeverages();
    }

    public static void setMenusBeverages(Player player, List<String> menus) {
        MIComponents.PLAYER_DATA.get(player).setMenubeverages(menus);
    }

    public static void setOnOpen(Player player, boolean on_open) {
        MIComponents.PLAYER_DATA.get(player).setOn_open(on_open);
    }

    public static boolean getOnOpen(Player player) {
        return MIComponents.PLAYER_DATA.get(player).getOn_open();
    }
}
