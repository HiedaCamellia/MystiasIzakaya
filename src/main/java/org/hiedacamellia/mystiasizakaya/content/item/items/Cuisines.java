package org.hiedacamellia.mystiasizakaya.content.item.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.DataComponentsReg;
import org.hiedacamellia.mystiasizakaya.content.datacomponent.ValueRecord;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Cuisines extends BaseItem{
    public Cuisines(int nutrition, float saturation, Rarity rarity, String regname, String[] tags, String[] ntags,int cooktime) {
        super(64, nutrition, saturation, rarity, UseAnim.EAT, 32, regname, tags, ntags);
        this.cooktime = cooktime;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        String tags = stack.getOrDefault(DataComponentsReg.Tags.get(),  new ValueRecord("")).value();
        if (tags.isEmpty()){
            stack.set(DataComponentsReg.Tags.get(), new ValueRecord(String.join(",", gettags())));

        }
        int cooktime = Integer.parseInt(stack.getOrDefault(DataComponentsReg.Cooktime.get(), new ValueRecord("0")).value());

        if (cooktime == 0){
            stack.set(DataComponentsReg.Cooktime.get(), new ValueRecord(String.valueOf(getcooktime())));
        }

        String ntags = stack.getOrDefault(DataComponentsReg.nTags.get(),  new ValueRecord("")).value();
        if (ntags.isEmpty()){
            stack.set(DataComponentsReg.nTags.get(), new ValueRecord(String.join(",", getnegativetags())));
        }
    }

    private int cooktime;

    public int getcooktime(){
        return this.cooktime;
    }
}
