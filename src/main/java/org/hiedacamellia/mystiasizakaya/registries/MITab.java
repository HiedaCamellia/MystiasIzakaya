package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class MITab {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MystiasIzakaya.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MYSTIASS_IZAKAYA = REGISTRY.register("mystiass_izakaya",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.mystias_izakaya.mystiass_izakaya")).icon(() -> new ItemStack(MIItem.ICON.get())).displayItems((parameters, tabData) -> {
                        for (DeferredHolder<Item, ? extends Item> item: MIItem.REGISTRY.getEntries()){
                            tabData.accept(item.get());
                        }
                        for (DeferredHolder<Item, ? extends Item> item: MIItem.Ingredients.getEntries()){
                            tabData.accept(item.get());
                        }
                        for (DeferredHolder<Item, ? extends Item> item: MIItem.Cuisines.getEntries()){
                            tabData.accept(item.get());
                        }
                        for (DeferredHolder<Item, ? extends Item> item: MIItem.Beverages.getEntries()){
                            tabData.accept(item.get());
                        }
                        tabData.accept(MIItem.HEI_AN_WU_ZHI.get());
                        tabData.accept(MIItem.REISEN.get());
                        tabData.accept(MIItem.EN_1.get());
                        tabData.accept(MIItem.EN_5.get());
                        tabData.accept(MIItem.EN_10.get());
                        tabData.accept(MIItem.IRON_KNIFE.get());
                    })
                    .build());
}
