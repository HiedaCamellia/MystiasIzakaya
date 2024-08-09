package org.hiedacamellia.mystiasizakaya.content.common.item.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseItem;

public class Kitchenwares extends BaseItem {

    public Kitchenwares(String regname, String[] tags) {
        super(new Properties(),1, 0, 0, Rarity.RARE, UseAnim.NONE, 0, regname, tags, new String[]{});
    }

}
