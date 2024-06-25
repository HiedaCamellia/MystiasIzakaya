package net.touhou.mystiasizakaya.content.item;

import net.minecraft.world.item.Item;
import net.touhou.mystiasizakaya.MystiasIzakaya;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.touhou.mystiasizakaya.content.block.ModBlocks;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MystiasIzakaya.MODID);
    public static final RegistryObject<CreativeModeTab> MYSTIASS_IZAKAYA = REGISTRY.register("mystiass_izakaya",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.mystias_izakaya.mystiass_izakaya")).icon(() -> new ItemStack(ItemRegistery.ICON.get())).displayItems((parameters, tabData) -> {
                        for (RegistryObject<Item> item : ItemRegistery.REGISTRY.getEntries()) {
                            tabData.accept(item.get());
                        }
                    })

                    .build());
}
