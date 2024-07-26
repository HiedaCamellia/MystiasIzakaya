package org.hiedacamellia.mystiasizakaya.content.cooking.get;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares.*;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;

import java.util.ArrayList;
import java.util.List;

public class GetTargets {
    public static List<String> getTargets(List<String> raws, ItemStack util) {
        if (util.getItem() == ItemRegistery.LIAO_LI_TAI.get()) {
            return CuttingBoard.get(raws);
        }
        if (util.getItem() == ItemRegistery.SHAO_KAO_JIA.get()) {
            return Grill.get(raws);
        }
        if (util.getItem() == ItemRegistery.YOU_GUO.get()) {
            return FryingPan.get(raws);
        }
        if (util.getItem() == ItemRegistery.ZHENG_GUO.get()) {
            return Steamer.get(raws);
        }
        if (util.getItem() == ItemRegistery.ZHU_GUO.get()) {
            return BoilingPot.get(raws);
        }
        return new ArrayList<>();
    }
}
