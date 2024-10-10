package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class MITab {

    public static final CreativeModeTab MYSTIASS_IZAKAYA = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, "mystiass_izakaya",
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 9).title(Component.translatable("item_group.mystias_izakaya.mystiass_izakaya")).icon(() -> new ItemStack(MIItem.ICON)).displayItems((parameters, tabData) -> {
                        tabData.accept(MIItem.COOKING_RANGE);
                        tabData.accept(MIItem.BANK);

                        for (Item item : MIItem.common) {
                            tabData.accept(item);
                        }
                        for (Item item : MIItem.ingredients) {
                            tabData.accept(item);
                        }
                        for (Item item : MIItem.cuisines) {
                            tabData.accept(item);
                        }
                        for (Item item : MIItem.beverages) {
                            tabData.accept(item);
                        }


                        tabData.accept(MIItem.HEI_AN_WU_ZHI);
                        tabData.accept(MIItem.REISEN);
                        tabData.accept(MIItem.EN_1);
                        tabData.accept(MIItem.EN_5);
                        tabData.accept(MIItem.EN_10);
                        tabData.accept(MIItem.IRON_KNIFE);
                    })
                    .build());

    public static void register() {
    }
}
