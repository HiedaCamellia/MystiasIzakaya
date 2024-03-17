
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.touhou.mystiasizakaya.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MystiasIzakayaModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3),

					new ItemStack(MystiasIzakayaModItems.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4)
					.add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 4), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3),

					new ItemStack(MystiasIzakayaModItems.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()),

					new ItemStack(MystiasIzakayaModItems.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6), new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 3),

					new ItemStack(MystiasIzakayaModItems.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8), new ItemStack(MystiasIzakayaModItems.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 5),

					new ItemStack(MystiasIzakayaModItems.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 4),

					new ItemStack(MystiasIzakayaModItems.ZHU_SUN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2),

					new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 4),

					new ItemStack(MystiasIzakayaModItems.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MystiasIzakayaModVillagerProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4),

					new ItemStack(MystiasIzakayaModItems.JI_DAN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()),

					new ItemStack(MystiasIzakayaModItems.TAO_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 7),

					new ItemStack(MystiasIzakayaModItems.BAI_GUO.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.FENG_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5),

					new ItemStack(MystiasIzakayaModItems.CHAN_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 7),

					new ItemStack(MystiasIzakayaModItems.HUAN_TAN_HUA.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()),

					new ItemStack(MystiasIzakayaModItems.LU_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.HUANG_YOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()),

					new ItemStack(MystiasIzakayaModItems.MIAN_FEN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.ZHU_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5), new ItemStack(MystiasIzakayaModItems.NUO_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 7),

					new ItemStack(MystiasIzakayaModItems.YUE_GUANG_CAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2),

					new ItemStack(MystiasIzakayaModItems.BING_KUAI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2),

					new ItemStack(MystiasIzakayaModItems.LA_JIAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 5),

					new ItemStack(MystiasIzakayaModItems.PU_TAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10K.get(), 53),

					new ItemStack(MystiasIzakayaModItems.REISEN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6), new ItemStack(MystiasIzakayaModItems.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2),

					new ItemStack(MystiasIzakayaModItems.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8), new ItemStack(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6),

					new ItemStack(MystiasIzakayaModItems.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get()), new ItemStack(MystiasIzakayaModItems.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 9), new ItemStack(MystiasIzakayaModItems.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 7), new ItemStack(MystiasIzakayaModItems.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 3), new ItemStack(MystiasIzakayaModItems.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 2), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 6),

					new ItemStack(MystiasIzakayaModItems.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 8),

					new ItemStack(MystiasIzakayaModItems.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 9),

					new ItemStack(MystiasIzakayaModItems.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get()), new ItemStack(MystiasIzakayaModItems.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2),

					new ItemStack(MystiasIzakayaModItems.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get()), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 4), new ItemStack(MystiasIzakayaModItems.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 4),

					new ItemStack(MystiasIzakayaModItems.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MystiasIzakayaModItems.EN_10.get(), 3), new ItemStack(MystiasIzakayaModItems.EN_1.get(), 2), new ItemStack(MystiasIzakayaModItems.ZHU_SUN.get()), 10, 5, 0.05f));
		}
	}
}
