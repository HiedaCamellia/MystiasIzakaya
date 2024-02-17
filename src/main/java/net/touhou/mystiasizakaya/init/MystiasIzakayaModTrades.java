
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.touhou.mystiasizakaya.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MystiasIzakayaModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 3),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 7),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 9),

					new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 10),

					new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 11),

					new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get()),

					new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2),

					new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 3),

					new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4),

					new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
		}
	}
}
