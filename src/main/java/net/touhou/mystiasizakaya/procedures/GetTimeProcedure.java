package net.touhou.mystiasizakaya.procedures;

import net.touhou.mystiasizakaya.init.MystiasIzakayaModItems;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.touhou.mystiasizakaya.procedures.GetItemStack;
import java.util.concurrent.atomic.AtomicReference;

public class GetTimeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		ItemStack target = ItemStack.EMPTY;
		double time = 0;
		target = GetItemStack.getItemStack(world, new BlockPos(x, y, z), 12);
		if (GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHU_GUO.get()) {
			if (MystiasIzakayaModItems.ZHU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.DOU_FU_GUO.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.DOU_FU_WEI_CHENG.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.TUN_GU_LA_MIAN.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.BAI_GUO_LUO_BU_PAI_GU_TANG.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.BAI_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.DA_SHE_YAN.get() == target.getItem()) {
				time = 120;
			}
			if (MystiasIzakayaModItems.LI_LIANG_TANG.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.NIU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.SHUI_JIAO.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.TAO_HUA_GENG.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.YAN_JIANG.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.YE_WEI_JIA_NONG.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.ZA_CHUI.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.ZHU_ROU_GAI_JIAO_FAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.TANG_YUAN.get() == target.getItem()) {
				time = 60;
			}
		}
		if (GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0).getItem() == MystiasIzakayaModItems.ZHENG_GUO.get()) {
			if (MystiasIzakayaModItems.HUAN_TAN_HUA_GAO.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.LU_SHUI_ZHU_DAN.get() == target.getItem()) {
				time = 36;
			}
			if (MystiasIzakayaModItems.NAI_YOU_TUN_CAI.get() == target.getItem()) {
				time = 40;
			}
			if (MystiasIzakayaModItems.SAI_XIONG_ZHANG.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.SHI_LI_YIN_XING.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.SI_KANG_BING.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.YI_SHI_HUI_FAN.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.ZHU_LU_DIE.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.ZHU_QU_JI.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.ZHU_TONG_ZHENG_DAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0).getItem() == MystiasIzakayaModItems.YOU_GUO.get()) {
			if (MystiasIzakayaModItems.BAN_NI_DI_KE_DAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.CHAO_ROU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.CHOU_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.DA_BAN_SHAO.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.HONG_SHAO_MAN_YU.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.HUA_GUANG_YU_JIAN_BAO.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.HUANG_YOU_NIU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.HUI_LING_DUN_NIU_PAI.get() == target.getItem()) {
				time = 168;
			}
			if (MystiasIzakayaModItems.MA_PO_DOU_FU.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.MO_GU_ROU_PIAN.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.RE_SONG_BING.get() == target.getItem()) {
				time = 108;
			}
			if (MystiasIzakayaModItems.TU_DOU_KE_LE_BING.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.XIANG_JIAN_SAN_WEN_YU.get() == target.getItem()) {
				time = 120;
			}
			if (MystiasIzakayaModItems.XIANG_ZHA_CHAN_SHUI.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.YOU_DOU_FU.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.ZHA_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.ZHA_ZHU_ROU_PAI.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.ZHU_SUN_CHAO_ROU.get() == target.getItem()) {
				time = 120;
			}
		}
		if (GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0).getItem() == MystiasIzakayaModItems.LIAO_LI_TAI.get()) {
			if (MystiasIzakayaModItems.BAI_TAO_SHENG_BA_QIAO.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get() == target.getItem()) {
				time = 120;
			}
			if (MystiasIzakayaModItems.CI_SHEN_PIN_PAN.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.FAN_TUAN.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.LENG_DOU_FU.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.LIANG_CAI_DIAO_HUA.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.LIU_SHUI_SU_MIAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.MA_SHU.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.MAO_YU_RONG_YAN_DOU_FU.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.MAO_YU_SAN_SE_BING_JI_LING.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.MI_ZHI_XIAO_YU_GAN.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.SHU_CAI_ZHUAN_JI.get() == target.getItem()) {
				time = 60;
			}
			if (MystiasIzakayaModItems.WEN_NUAN_FAN_TUAN.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.WU_YI_SHI_YAO_GUAI_MU_SI.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.XING_HONG_E_MO_DAN_GAO.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.YING_LUO_XUE.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.YUE_GUANG_TUAN_ZI.get() == target.getItem()) {
				time = 96;
			}
			if (MystiasIzakayaModItems.YUE_ZHI_LIAN_REN.get() == target.getItem()) {
				time = 120;
			}
			if (MystiasIzakayaModItems.ZHI_ZHU_ROU_FAN_TUAN.get() == target.getItem()) {
				time = 72;
			}
		}
		if (GetItemStack.getItemStack(world, new BlockPos(x, y, z), 0).getItem() == MystiasIzakayaModItems.SHAO_KAO_JIA.get()) {
			if (MystiasIzakayaModItems.BU_SI_NIAO.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.ER_TIAN_LIU.get() == target.getItem()) {
				time = 216;
			}
			if (MystiasIzakayaModItems.KAO_BA_MU_MAN.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.KAO_MO_GU.get() == target.getItem()) {
				time = 72;
			}
			if (MystiasIzakayaModItems.MI_ZHI_CHA_SHAO.get() == target.getItem()) {
				time = 84;
			}
			if (MystiasIzakayaModItems.NENG_LIANG_CHUAN.get() == target.getItem()) {
				time = 144;
			}
			if (MystiasIzakayaModItems.PENG_LAI_YU_ZHI.get() == target.getItem()) {
				time = 156;
			}
			if (MystiasIzakayaModItems.ZHU_ROU_ZUN_YU_XUN.get() == target.getItem()) {
				time = 84;
			}
		}
		return time;
	}
}
