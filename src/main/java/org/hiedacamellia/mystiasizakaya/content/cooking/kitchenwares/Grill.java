package org.hiedacamellia.mystiasizakaya.content.cooking.kitchenwares;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.integration.youkaihomecoming.IngredientsCompact;
import org.hiedacamellia.mystiasizakaya.util.GetItemStack;

import java.util.ArrayList;
import java.util.List;

public class Grill {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		ItemStack raw = ItemStack.EMPTY;
		double i = 0;
		List<Object> raws = new ArrayList<>();
		List<String> tags = new ArrayList<>();
		List<String> negativetags = new ArrayList<>();
		i = 1;
		while (i <= 5) {
			if (!(GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i).getItem() == ItemStack.EMPTY.getItem())) {
				raw = GetItemStack.getItemStack(world, BlockPos.containing(x, y, z), (int) i);
				raw = IngredientsCompact.execute(raw);
				raws.add((ForgeRegistries.ITEMS.getKey(raw.getItem()).toString()));
			}
			i = i + 1;
		}
		str = "";
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MIAN_FEN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.TU_DOU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.BU_SI_NIAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HE_NIU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.SAN_WEN_YU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.LU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ZI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.PENG_LAI_YU_ZHI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NIU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YANG_CONG.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.NAN_GUA.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.NENG_LIANG_CHUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.HEI_MAO_ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.YE_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ER_TIAN_LIU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.MI_ZHI_CHA_SHAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.ZHU_ROU_ZUN_YU_XUN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.MO_GU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.KAO_MO_GU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(ItemRegistery.BA_MU_MAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(ItemRegistery.KAO_BA_MU_MAN.get()).toString() + "$end%";
		}
		return str;
	}
}
