package org.hiedacamellia.mystiasizakaya.content.common.item.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICooktime;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseItem;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

public class Cuisines extends BaseItem {
    public Cuisines(int nutrition, float saturation, Rarity rarity, String regname, String[] tags, String[] ntags,int cooktime) {
        super(new Properties().component(MIDatacomponet.MI_COOKTIME,new MICooktime(cooktime)),64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, ntags);

    }

}
