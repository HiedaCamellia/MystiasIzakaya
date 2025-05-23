package org.hiedacamellia.mystiasizakaya.content.izakaya;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;

import java.util.ArrayList;
import java.util.List;

public record IzakayaMenu(List<String> cuisines, List<String> beverages) {

    public List<ItemStack> toCuisineStacks() {
        return cuisines().stream().map(MIItemStackUtil::fromString).toList();
    }

    public List<ItemStack> toBeverageStacks() {
        return beverages().stream().map(MIItemStackUtil::fromString).toList();
    }

    public static final Codec<IzakayaMenu> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    MICodecUtil.LIST_STRING_CODEC.fieldOf("cuisines").forGetter(IzakayaMenu::cuisines),
                    MICodecUtil.LIST_STRING_CODEC.fieldOf("beverages").forGetter(IzakayaMenu::beverages)
            ).apply(instance, IzakayaMenu::new)
    );


    public static IzakayaMenu init() {
        List<String> cuisineList = new ArrayList<>();
        List<String> beverageList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cuisineList.add("minecraft:air");
            beverageList.add("minecraft:air");
        }
        return new IzakayaMenu(cuisineList, beverageList);
    }

}
