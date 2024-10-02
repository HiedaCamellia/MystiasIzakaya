package org.hiedacamellia.mystiasizakaya.core.cooking.get;


import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.cooking.kitchenwares.*;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.ArrayList;
import java.util.List;

public class GetTargets {
    public static List<String> getTargets(List<String> raws, ItemStack util) {
        if (util.getItem() == MIItem.CUTTING_BOARD) {
            return CuttingBoard.get(raws);
        }
        if (util.getItem() == MIItem.GRILL) {
            return Grill.get(raws);
        }
        if (util.getItem() == MIItem.FRYING_PAN) {
            return FryingPan.get(raws);
        }
        if (util.getItem() == MIItem.STEAMER) {
            return Steamer.get(raws);
        }
        if (util.getItem() == MIItem.BOILING_POT) {
            return BoilingPot.get(raws);
        }
        return new ArrayList<>();
    }
}
