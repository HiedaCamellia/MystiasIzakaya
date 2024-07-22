package org.hiedacamellia.mystiasizakaya.content.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MystiasIzakaya.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MYSTIASS_IZAKAYA = REGISTRY.register("mystiass_izakaya",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.mystias_izakaya.mystiass_izakaya")).icon(() -> new ItemStack(ItemRegistery.ICON.get())).displayItems((parameters, tabData) -> {
                        for (DeferredHolder<Item, ? extends Item> item:ItemRegistery.REGISTRY.getEntries()){
                            tabData.accept(item.get());
                        }
                    })
                    .build());
}
