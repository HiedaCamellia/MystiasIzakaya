package org.hiedacamellia.mystiasizakaya.core.event;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MIPlayerData implements MIComponent, AutoSyncedComponent {

    public double balance = 0;
    public int telecolddown =0;
    public boolean on_open = false;
    public List<String> orders = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
    public List<String> ordersbeverages = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
    public List<BlockPos> tables = new ArrayList<>();
    public List<String> menu = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
    public List<String> menubeverages = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
    public List<BlockPos> menus = new ArrayList<>();
    public List<String> turnover_pre = List.of();
    public List<Integer> trunover_cha =List.of();

    public MIPlayerData() {
    }


    @Override
    public boolean shouldCopyForRespawn(boolean lossless, boolean keepInventory, boolean sameCharacter) {
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int getTelecolddown() {
        return telecolddown;
    }

    @Override
    public void setTelecolddown(int telecolddown) {
        this.telecolddown = telecolddown;
    }

    @Override
    public boolean getOn_open() {
        return on_open;
    }

    @Override
    public void setOn_open(boolean on_open) {
        this.on_open = on_open;
    }

    @Override
    public List<String> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    @Override
    public List<String> getOrdersbeverages() {
        return ordersbeverages;
    }

    @Override
    public void setOrdersbeverages(List<String> ordersbeverages) {
        this.ordersbeverages = ordersbeverages;
    }

    @Override
    public List<BlockPos> getTables() {
        return tables;
    }

    @Override
    public void setTables(List<BlockPos> tables) {
        this.tables = tables;
    }

    @Override
    public List<String> getMenu() {
        return menu;
    }

    @Override
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    @Override
    public List<String> getMenubeverages() {
        return menubeverages;
    }

    @Override
    public void setMenubeverages(List<String> menubeverages){
        this.menubeverages = menubeverages;
    }

    @Override
    public List<BlockPos> getMenus() {
        return menus;
    }

    @Override
    public void setMenus(List<BlockPos> menus) {
        this.menus = menus;
    }

    @Override
    public List<String> getTurnover_pre() {
        return turnover_pre;
    }

    @Override
    public void setTurnover_pre(List<String> turnover_pre) {
        this.turnover_pre = turnover_pre;
    }

    @Override
    public List<Integer> getTrunover_cha() {
        return trunover_cha;
    }

    @Override
    public void setTrunover_cha(List<Integer> trunover_cha) {
        this.trunover_cha = trunover_cha;
    }

    @Override
    public void readFromNbt(CompoundTag Tag) {
        balance = Tag.getDouble("balance");
        telecolddown = Tag.getInt("telecolddown");
        String orders_string = Tag.getString("orders");
        String ordersbeverages_string = Tag.getString("ordersbeverages");
        orders = new ArrayList<>(List.of(orders_string.split(",")));
        ordersbeverages = new ArrayList<>(List.of(ordersbeverages_string.split(",")));
        String turnover_pre_string = Tag.getString("turnover_pre");
        turnover_pre = new ArrayList<>(List.of(turnover_pre_string.split(",")));
        trunover_cha = Arrays.stream(Tag.getIntArray("turnover_cha")).boxed().toList();
        tables = String2BlockPosList(Tag.getString("tables"));
        menu = new ArrayList<>(List.of(Tag.getString("menu").split(",")));
        menubeverages = new ArrayList<>(List.of(Tag.getString("menubeverages").split(",")));
        menus = String2BlockPosList(Tag.getString("menus"));
        on_open = Tag.getBoolean("on_open");
    }

    @Override
    public void writeToNbt(CompoundTag tag)  {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("balance", balance);
        nbt.putInt("telecolddown", telecolddown);
        String orders_string = String.join(",", orders);
        String ordersbeverages_string = String.join(",", ordersbeverages);
        nbt.putString("orders", orders_string);
        nbt.putString("ordersbeverages", ordersbeverages_string);
        String turnover_pre_string = String.join(",", turnover_pre);
        nbt.putString("turnover_pre", turnover_pre_string);
        nbt.putIntArray("turnover_cha", trunover_cha);
        nbt.putString("tables", BlockPos2String(tables));
        nbt.putString("menu", String.join(",", menu));
        nbt.putString("menubeverages", String.join(",", menubeverages));
        nbt.putString("menus", BlockPos2String(menus));
        nbt.putBoolean("on_open", on_open);
    }

    private static String BlockPos2String(BlockPos pos){
        return pos.getX() + "," + pos.getY() + "," + pos.getZ();
    }
    private static String BlockPos2String(List<BlockPos> pos){
        if(pos.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (BlockPos p : pos){
            sb.append(BlockPos2String(p));
            sb.append(";");
        }
        return sb.toString();
    }
    private static BlockPos String2BlockPos(String str){
        String[] pos = str.split(",");
        return new BlockPos(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]), Integer.parseInt(pos[2]));
    }
    private static List<BlockPos> String2BlockPosList(String str){
        if(str.isEmpty())
            return new ArrayList<>();
        List<BlockPos> pos = new ArrayList<>();
        String[] posList = str.split(";");
        for (String p : posList){
            pos.add(String2BlockPos(p));
        }
        return pos;
    }


}
