package org.hiedacamellia.mystiasizakaya.core.event;


import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;

public interface MIComponent extends PlayerComponent {
    double getBalance();
    void setBalance(double balance);
    int getTelecolddown();
    void setTelecolddown(int telecolddown);
    boolean getOn_open();
    void setOn_open(boolean on_open);
    List<String> getOrders();
    void setOrders(List<String> orders);
    List<String> getOrdersbeverages();
    void setOrdersbeverages(List<String> ordersbeverages);
    List<BlockPos> getTables();
    void setTables(List<BlockPos> tables);
    List<String> getMenu();
    void setMenu(List<String> menu);
    List<String> getMenubeverages();
    void setMenubeverages(List<String> menubeverages);
    List<BlockPos> getMenus();
    void setMenus(List<BlockPos> menus);
    List<String> getTurnover_pre();
    void setTurnover_pre(List<String> turnover_pre);
    List<Integer> getTrunover_cha();
    void setTrunover_cha(List<Integer> trunover_cha);
}

