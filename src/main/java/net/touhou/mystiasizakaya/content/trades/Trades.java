
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.touhou.mystiasizakaya.content.trades;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.touhou.mystiasizakaya.content.item.ItemRegistery;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Trades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == Professions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 8),

					new ItemStack(ItemRegistery.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3),

					new ItemStack(ItemRegistery.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4)
					.add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 4), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3),

					new ItemStack(ItemRegistery.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == Professions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 8),

					new ItemStack(ItemRegistery.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()),

					new ItemStack(ItemRegistery.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 6), new ItemStack(ItemRegistery.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 3),

					new ItemStack(ItemRegistery.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 8), new ItemStack(ItemRegistery.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 5),

					new ItemStack(ItemRegistery.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 4),

					new ItemStack(ItemRegistery.ZHU_SUN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == Professions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()),

					new ItemStack(ItemRegistery.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2),

					new ItemStack(ItemRegistery.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 4),

					new ItemStack(ItemRegistery.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == Professions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 4),

					new ItemStack(ItemRegistery.JI_DAN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()),

					new ItemStack(ItemRegistery.TAO_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 7),

					new ItemStack(ItemRegistery.BAI_GUO.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.FENG_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 5),

					new ItemStack(ItemRegistery.CHAN_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 7),

					new ItemStack(ItemRegistery.HUAN_TAN_HUA.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()),

					new ItemStack(ItemRegistery.LU_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 8),

					new ItemStack(ItemRegistery.HUANG_YOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()),

					new ItemStack(ItemRegistery.MIAN_FEN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.ZHU_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 5), new ItemStack(ItemRegistery.NUO_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 7),

					new ItemStack(ItemRegistery.YUE_GUANG_CAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 2),

					new ItemStack(ItemRegistery.BING_KUAI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 2),

					new ItemStack(ItemRegistery.LA_JIAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 5),

					new ItemStack(ItemRegistery.PU_TAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10K.get(), 53),

					new ItemStack(ItemRegistery.REISEN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 8),

					new ItemStack(ItemRegistery.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 6), new ItemStack(ItemRegistery.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2),

					new ItemStack(ItemRegistery.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 8), new ItemStack(ItemRegistery.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 6),

					new ItemStack(ItemRegistery.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get()), new ItemStack(ItemRegistery.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 9), new ItemStack(ItemRegistery.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 7), new ItemStack(ItemRegistery.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3), new ItemStack(ItemRegistery.EN_1.get(), 3), new ItemStack(ItemRegistery.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 2), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 6),

					new ItemStack(ItemRegistery.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 8),

					new ItemStack(ItemRegistery.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 9),

					new ItemStack(ItemRegistery.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get()), new ItemStack(ItemRegistery.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_1.get(), 2),

					new ItemStack(ItemRegistery.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get()), new ItemStack(ItemRegistery.EN_1.get(), 4), new ItemStack(ItemRegistery.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 4),

					new ItemStack(ItemRegistery.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ItemRegistery.EN_10.get(), 3), new ItemStack(ItemRegistery.EN_1.get(), 2), new ItemStack(ItemRegistery.ZHU_SUN.get()), 10, 5, 0.05f));
		}
	}
}
