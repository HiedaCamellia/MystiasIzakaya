package org.hiedacamellia.mystiasizakaya.content.item.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.*;

public class Cuisines extends BaseItem{
    public Cuisines(int nutrition, float saturation, Rarity rarity, String regname, String[] tags, String[] ntags,int cooktime) {
        super(64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, ntags);
        this.cooktime = cooktime;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        String tags = stack.getOrCreateTag().getString("tags");
        if (tags.isEmpty()){
            stack.getOrCreateTag().putString("tags", String.join(",", gettags()));
        }
        int cooktime = stack.getOrCreateTag().getInt("cooktime");
        if (cooktime == 0){
            stack.getOrCreateTag().putInt("cooktime", getcooktime());
        }
        String ntags = stack.getOrCreateTag().getString("ntags");
        if (ntags.isEmpty()){
            stack.getOrCreateTag().putString("ntags", String.join(",", getnegativetags()));
        }
    }

    private int cooktime;

    public int getcooktime(){
        return this.cooktime;
    }
}
