package org.hiedacamellia.mystiasizakaya.content.item.beverages;

import net.minecraft.world.item.Rarity;
import org.hiedacamellia.mystiasizakaya.content.item.items.Beverages;

public class LinRenZhuiItem extends Beverages {
    public LinRenZhuiItem() {
        super(4, 0.8f, Rarity.COMMON, "lin_ren_zhui", new String[]{"neat", "fruity", "vintage", "sweet"});
    }
}
