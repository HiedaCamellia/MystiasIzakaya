package org.hiedacamellia.mystiasizakaya.content.common.item.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseItem;

public class Ingredients extends BaseItem {
    public Ingredients(int nutrition,float saturation,Rarity rarity,String regname, String[] tags) {
        super(new Properties(),64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, new String[]{});
    }
}
