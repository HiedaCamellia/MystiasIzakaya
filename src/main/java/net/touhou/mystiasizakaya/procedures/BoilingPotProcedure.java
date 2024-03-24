package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.ArrayList;

public class BoilingPotProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		List<Object> raws = new ArrayList<>();
		double i = 0;
		ItemStack raw = ItemStack.EMPTY;
		List<String> tags = new ArrayList<>();
		List<String> negativetags = new ArrayList<>();
		i = 1;
		while (i <= 5) {
			if (!((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem() == ItemStack.EMPTY.getItem())) {
				raw = (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) i));
				raw = YHCProcedure.execute(raw);
				raws.add((ForgeRegistries.ITEMS.getKey(raw.getItem()).toString()));
			}
			i = i + 1;
		}
		str = "";
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU_GUO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TUN_GU_LA_MIAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAI_GUO.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_TUN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BA_MU_MAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAI_XUE.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_NIU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_TUN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DA_SHE_YAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YE_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LI_LIANG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NIU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LI_LIANG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TAO_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LU_SHUI.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BING_KUAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TAO_HUA_GENG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_NIU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HE_TUN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SONG_LU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NIU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YAN_JIANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SHUI_JIAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SHUI_ZHU_YU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NUO_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TANG_YUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HEI_MAO_ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YE_WEI_JIA_NONG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZA_CHUI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SAN_WEN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get()).toString() + "$end%";
		}
		return str;
	}
}
