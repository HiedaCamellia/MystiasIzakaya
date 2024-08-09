package org.hiedacamellia.mystiasizakaya.core.cooking.get;


import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.cooking.kitchenwares.*;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.ArrayList;
import java.util.List;

public class GetTargets {
    public static List<String> getTargets(List<String> raws, ItemStack util) {
        if (util.getItem() == MIItem.LIAO_LI_TAI.get()) {
            return CuttingBoard.get(raws);
        }
        if (util.getItem() == MIItem.SHAO_KAO_JIA.get()) {
            return Grill.get(raws);
        }
        if (util.getItem() == MIItem.YOU_GUO.get()) {
            return FryingPan.get(raws);
        }
        if (util.getItem() == MIItem.ZHENG_GUO.get()) {
            return Steamer.get(raws);
        }
        if (util.getItem() == MIItem.ZHU_GUO.get()) {
            return BoilingPot.get(raws);
        }
        return new ArrayList<>();
    }
}
