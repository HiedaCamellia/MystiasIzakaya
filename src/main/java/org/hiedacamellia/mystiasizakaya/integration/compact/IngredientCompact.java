package org.hiedacamellia.mystiasizakaya.integration.compact;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.core.util.Tag2Item;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class IngredientCompact {

    public static ItemStack execute(ItemStack itemstack) {
        for(TagKey<Item> key: MITag.ingredients.values()){
            if(itemstack.is(key)){
                return Tag2Item.regs.get(key).getDefaultInstance();
            }
        }
        return itemstack;
    }

    public static Map<Item,ResourceLocation> MAPPING;

    static {
        MAPPING = new HashMap<>();
        MAPPING.put(MIItem.BA_MU_MAN.get(),mrl("lamprey"));
        MAPPING.put(MIItem.BAI_GUO.get(),mrl("ginko_nut"));
        MAPPING.put(MIItem.BAN_LI.get(),mrl("chestnut"));
        MAPPING.put(MIItem.BING_DI_LIAN.get(),mrl("bingdi_lotus"));
        MAPPING.put(MIItem.BING_KUAI.get(),mrl("ice_cube"));
        MAPPING.put(MIItem.CHAN_TUI.get(),mrl("cicada_slough"));
        MAPPING.put(MIItem.XIANG_CHUN.get(),mrl("red_toon"));
        MAPPING.put(MIItem.DI_GUA.get(),mrl("sweet_potato"));
        MAPPING.put(MIItem.DOU_FU.get(),mrl("tofu"));
        MAPPING.put(MIItem.FENG_MI.get(),mrl("honey"));
        MAPPING.put(MIItem.HAI_DAN.get(),mrl("sea_urchin"));
        MAPPING.put(MIItem.HAI_TAI.get(),mrl("seaweed"));
        MAPPING.put(MIItem.HE_NIU.get(),mrl("wagyo_beef"));
        MAPPING.put(MIItem.HE_TUN.get(),mrl("pufferfish"));
        MAPPING.put(MIItem.HEI_MAO_ZHU_ROU.get(),mrl("iberico_pork"));
        MAPPING.put(MIItem.HEI_YAN.get(),mrl("black_salt"));
        MAPPING.put(MIItem.HONG_DOU.get(),mrl("red_bean"));
        MAPPING.put(MIItem.HUAN_TAN_HUA.get(),mrl("udunmbara"));
        MAPPING.put(MIItem.HUANG_GUA.get(),mrl("cucumber"));
        MAPPING.put(MIItem.HUANG_YOU.get(),mrl("butter"));
        MAPPING.put(MIItem.JI_DAN.get(),mrl("egg"));
        MAPPING.put(MIItem.JI_SHANG_JIN_QIANG_YU.get(),mrl("premium_tuna"));
        MAPPING.put(MIItem.JIN_QIANG_YU.get(),mrl("tuna"));
        MAPPING.put(MIItem.KE_KE_DOU.get(),mrl("cocoa_bean"));
        MAPPING.put(MIItem.LA_JIAO.get(),mrl("chili"));
        MAPPING.put(MIItem.LIAN_ZI.get(),mrl("lotus_seed"));
        MAPPING.put(MIItem.LU_ROU.get(),mrl("venison"));
        MAPPING.put(MIItem.LU_SHUI.get(),mrl("dew"));
        MAPPING.put(MIItem.LUO_BU.get(),mrl("radish"));
        MAPPING.put(MIItem.MEI_ZI.get(),mrl("plum"));
        MAPPING.put(MIItem.MIAN_FEN.get(),mrl("flour"));
        MAPPING.put(MIItem.MO_GU.get(),mrl("mushroom"));
        MAPPING.put(MIItem.NAI_YOU.get(),mrl("cream"));
        MAPPING.put(MIItem.NAN_GUA.get(),mrl("pumpkin"));
        MAPPING.put(MIItem.NING_MENG.get(),mrl("lemon"));
        MAPPING.put(MIItem.NIU_ROU.get(),mrl("beef"));
        MAPPING.put(MIItem.NUO_MI.get(),mrl("sticky_rice"));
        MAPPING.put(MIItem.PANG_XIE.get(),mrl("crab"));
        MAPPING.put(MIItem.SONG_ZI.get(),mrl("song_zi"));
        MAPPING.put(MIItem.PU_TAO.get(),mrl("grapes"));
        MAPPING.put(MIItem.SAN_WEN_YU.get(),mrl("salmon"));
        MAPPING.put(MIItem.SONG_LU.get(),mrl("truffle"));
        MAPPING.put(MIItem.TAO_ZI.get(),mrl("peach"));
        MAPPING.put(MIItem.TU_DOU.get(),mrl("potato"));
        MAPPING.put(MIItem.XI_HONG_SHI.get(),mrl("tomato"));
        MAPPING.put(MIItem.XI_LAN_HUA.get(),mrl("broceoli"));
        MAPPING.put(MIItem.XIA.get(),mrl("shrimp"));
        MAPPING.put(MIItem.XIAN_HUA.get(),mrl("flower"));
        MAPPING.put(MIItem.BI_LI.get(),mrl("creeping_fig"));
        MAPPING.put(MIItem.YANG_CONG.get(),mrl("onion"));
        MAPPING.put(MIItem.YE_ZHU_ROU.get(),mrl("boar_meat"));
        MAPPING.put(MIItem.YIN_ER.get(),mrl("snow_fungus"));
        MAPPING.put(MIItem.YUE_GUANG_CAO.get(),mrl("lunar_herb"));
        MAPPING.put(MIItem.ZHANG_YU.get(),mrl("octopus"));
        MAPPING.put(MIItem.ZHI_SHI.get(),mrl("cheese"));
        MAPPING.put(MIItem.ZHU_ROU.get(),mrl("pork"));
        MAPPING.put(MIItem.ZHU_SUN.get(),mrl("bamboo_shoot"));
        MAPPING.put(MIItem.ZHU_ZI.get(),mrl("bamboo"));
        MAPPING.put(MIItem.ZUN_YU.get(),mrl("trout"));
    }


    public static ResourceLocation mrl(String s){
        return ResourceLocation.fromNamespaceAndPath("mystia_izakaya",s);
    }


}
