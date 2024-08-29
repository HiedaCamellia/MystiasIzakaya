package org.hiedacamellia.mystiasizakaya.content.trades;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIProfessions;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Trades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MIProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 8),

					new ItemStack(MIItem.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3),

					new ItemStack(MIItem.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4)
					.add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 4), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3),

					new ItemStack(MIItem.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MIProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 8),

					new ItemStack(MIItem.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()),

					new ItemStack(MIItem.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 6), new ItemStack(MIItem.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 3),

					new ItemStack(MIItem.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 8), new ItemStack(MIItem.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 5),

					new ItemStack(MIItem.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 4),

					new ItemStack(MIItem.ZHU_SUN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MIProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()),

					new ItemStack(MIItem.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2),

					new ItemStack(MIItem.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 4),

					new ItemStack(MIItem.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MIProfessions.TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 4),

					new ItemStack(MIItem.JI_DAN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()),

					new ItemStack(MIItem.TAO_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 7),

					new ItemStack(MIItem.BAI_GUO.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.FENG_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 5),

					new ItemStack(MIItem.CHAN_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 7),

					new ItemStack(MIItem.HUAN_TAN_HUA.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()),

					new ItemStack(MIItem.LU_SHUI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 8),

					new ItemStack(MIItem.HUANG_YOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()),

					new ItemStack(MIItem.MIAN_FEN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.ZHU_ZI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 5), new ItemStack(MIItem.NUO_MI.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 7),

					new ItemStack(MIItem.YUE_GUANG_CAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 2),

					new ItemStack(MIItem.BING_KUAI.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 2),

					new ItemStack(MIItem.LA_JIAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 5),

					new ItemStack(MIItem.PU_TAO.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_10K.get(), 53),

					new ItemStack(MIItem.REISEN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 8),

					new ItemStack(MIItem.ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.NIU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 6), new ItemStack(MIItem.LU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2),

					new ItemStack(MIItem.YE_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 8), new ItemStack(MIItem.HEI_MAO_ZHU_ROU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.HE_NIU.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 6),

					new ItemStack(MIItem.ZUN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get()), new ItemStack(MIItem.BA_MU_MAN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 9), new ItemStack(MIItem.SAN_WEN_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 7), new ItemStack(MIItem.JI_SHANG_JIN_QIANG_YU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3), new ItemStack(MIItem.EN_1.get(), 3), new ItemStack(MIItem.HE_TUN.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 2), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.XIA.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 6),

					new ItemStack(MIItem.DOU_FU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 8),

					new ItemStack(MIItem.TU_DOU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 9),

					new ItemStack(MIItem.YANG_CONG.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get()), new ItemStack(MIItem.NAN_GUA.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.LUO_BU.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MIItem.EN_1.get(), 2),

					new ItemStack(MIItem.HAI_TAI.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get()), new ItemStack(MIItem.EN_1.get(), 4), new ItemStack(MIItem.MO_GU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 4),

					new ItemStack(MIItem.SONG_LU.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MIItem.EN_10.get(), 3), new ItemStack(MIItem.EN_1.get(), 2), new ItemStack(MIItem.ZHU_SUN.get()), 10, 5, 0.05f));
		}
	}
}
