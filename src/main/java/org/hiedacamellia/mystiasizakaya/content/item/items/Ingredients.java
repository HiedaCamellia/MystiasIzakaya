package org.hiedacamellia.mystiasizakaya.content.item.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;

public class Ingredients extends BaseItem{
    public Ingredients(int nutrition,float saturation,Rarity rarity,String regname, String[] tags) {
        super(64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, new String[]{});
    }
}
