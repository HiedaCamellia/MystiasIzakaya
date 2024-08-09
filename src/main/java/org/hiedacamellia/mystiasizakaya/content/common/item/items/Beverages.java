package org.hiedacamellia.mystiasizakaya.content.common.item.items;


import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseItem;

public class Beverages extends BaseItem {
    public Beverages( int nutrition, float saturation, Rarity rarity, String regname, String[] tags) {
        super(new Properties(),16, nutrition, saturation, rarity, UseAnim.DRINK, 32, regname, tags, new String[]{});
    }

    @Override
    public String gettagprefix() {
        return "tag.mystias_izakaya.beverages.";
    }
}
