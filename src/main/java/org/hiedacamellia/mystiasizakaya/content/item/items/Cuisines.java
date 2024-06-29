package org.hiedacamellia.mystiasizakaya.content.item.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;

public class Cuisines extends BaseItem{
    public Cuisines(int nutrition, float saturation, Rarity rarity, String regname, String[] tags, String[] ntags) {
        super(64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, ntags);
    }
}
