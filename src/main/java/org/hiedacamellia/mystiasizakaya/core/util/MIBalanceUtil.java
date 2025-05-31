package org.hiedacamellia.mystiasizakaya.core.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.immersiveui.util.holder.IntHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.CurrencyChangeEvent;
import org.hiedacamellia.mystiasizakaya.api.kubejs.MIEventPoster;

public class MIBalanceUtil {

    public static int getBalance(Player player){
        return MIPlayerUtil.getBalance(player);
    }

    public static boolean command(Player player, int change){
        if(change == 0)return false;
        return change(player, change, "from_command");
    }

    public static boolean currency(Player player, int change){
        if(change == 0)return false;
        return change(player, change, "from_currency");
    }

    public static boolean table(Player player, int change){
        if(change == 0)return false;
        return change(player, change, "from_table");
    }

    public static boolean telephone(Player player, int change){
        if(change == 0)return false;
        return change(player, change, "to_telephone");
    }

    public static boolean donation(Player player, int change){
        if(change == 0)return false;
        return change(player, change, "to_donation");
    }

    public static boolean change(Player player, int change, String type){
        CurrencyChangeEvent event = new CurrencyChangeEvent(player, new IntHolder(change), type);
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(event);

        if(event.isCanceled())return false;
        int result = MIPlayerUtil.getBalance(player) + event.getAmount();
        MIPlayerUtil.setBalance(player,result);


        MITurnoverUtil.addTurnover(player, type, change + 0.0);
        if(player instanceof ServerPlayer serverPlayer) {
            MIPlayerUtil.syncBalance(serverPlayer);
            MIPlayerUtil.syncTurnover(serverPlayer);
        }
        return true;
    }
}
