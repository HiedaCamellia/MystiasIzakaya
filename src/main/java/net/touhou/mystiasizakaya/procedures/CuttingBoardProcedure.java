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

public class CuttingBoardProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String str = "";
		ItemStack raw = ItemStack.EMPTY;
		double i = 0;
		List<Object> raws = new ArrayList<>();
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
			}.getItemStack(world, new BlockPos(x, y, z), (int) i)).getItem() == ItemStack.EMPTY.getItem())) {
				raw = (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, new BlockPos(x, y, z), (int) i));
				raw = YHCProcedure.execute(raw);
				raws.add((ForgeRegistries.ITEMS.getKey(raw.getItem()).toString()));
			}
			i = i + 1;
		}
		str = "";
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LU_SHUI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FENG_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NIU_ROU.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LA_JIAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HUANG_YOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_DAN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YUE_GUANG_CAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TU_DOU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NAN_GUA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TAO_ZI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.XIA.get()).toString()))
				&& raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BING_KUAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NUO_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.TAO_ZI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NUO_MI.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YUE_GUANG_CAO.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YANG_CONG.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.DOU_FU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LENG_DOU_FU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.SAN_WEN_YU.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JIN_QIANG_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MIAN_FEN.get()).toString())) && raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ZI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.NUO_MI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MA_SHU.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LUO_BU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.HAI_TAI.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.JI_SHANG_JIN_QIANG_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.YING_LUO_XUE.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHU_ROU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get()).toString() + "$end%";
		}
		if (raws.contains((ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.ZUN_YU.get()).toString()))) {
			str = str + "$start%" + ForgeRegistries.ITEMS.getKey(MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get()).toString() + "$end%";
		}
		return str;
	}
}
