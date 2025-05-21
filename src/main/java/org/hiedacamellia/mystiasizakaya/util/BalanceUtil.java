package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.util.holder.IntHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.CurrencyChangeEvent;
import org.hiedacamellia.mystiasizakaya.api.kubejs.MIEventPoster;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

public class BalanceUtil {

    public static int getBalance(Player player){
        return player.getData(MIAttachment.MI_BALANCE).balance();
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

    private static boolean change(Player player, int change, String type){
        CurrencyChangeEvent event = new CurrencyChangeEvent(player, new IntHolder(change), type);
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded)
            MIEventPoster.INSTANCE.post(event);

        if(event.isCanceled())return false;
        int result = player.getData(MIAttachment.MI_BALANCE).balance() + event.getAmount();
        player.setData(MIAttachment.MI_BALANCE, new MIBalance(result));

        MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
        miTurnover = miTurnover.addTurnover(type,change + 0.0);
        miTurnover = miTurnover.deleteOverStack();
        player.setData(MIAttachment.MI_TURNOVER, miTurnover);
        if(player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
            PacketDistributor.sendToPlayer(serverPlayer, miTurnover);
        }
        return true;
    }
}
