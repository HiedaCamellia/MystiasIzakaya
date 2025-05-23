package org.hiedacamellia.mystiasizakaya.core.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;

import java.util.List;

public class MITurnoverUtil {


    public static void addTurnover(Player player, String key, Double value){
        List<Pair<String, Double>> copy = MIPlayerUtil.getTurnover(player);
        copy.add(new Pair<>(key, value));
        deleteOverStack(copy);
        MIPlayerUtil.setTurnover(player, copy);
    }

    public static void deleteTurnover(Player player,String key){
        List<Pair<String, Double>> copy = MIPlayerUtil.getTurnover(player);
        copy.removeIf(pair -> pair.getFirst().equals(key));
        MIPlayerUtil.setTurnover(player, copy);
    }

    public static void deleteOverStack(List<Pair<String, Double>> copy){
        int stack = MICommonConfig.MAX_OVERTURN.get();
        if(copy.size() > stack){
            int size = copy.size();
            if (size - stack > 0) {
                copy.subList(0, size - stack).clear();
            }
        }
    }
}
