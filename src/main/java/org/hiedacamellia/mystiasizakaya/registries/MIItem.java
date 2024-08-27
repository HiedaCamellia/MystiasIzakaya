package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.item.beverages.*;
import org.hiedacamellia.mystiasizakaya.content.common.item.cuisines.*;
import org.hiedacamellia.mystiasizakaya.content.common.item.currency.En10Item;
import org.hiedacamellia.mystiasizakaya.content.common.item.currency.En10kItem;
import org.hiedacamellia.mystiasizakaya.content.common.item.currency.En1Item;
import org.hiedacamellia.mystiasizakaya.content.common.item.currency.En5Item;
import org.hiedacamellia.mystiasizakaya.content.common.item.utils.LedgerItem;
import org.hiedacamellia.mystiasizakaya.content.common.item.utils.IconItem;
import org.hiedacamellia.mystiasizakaya.content.common.item.utils.IronKnifeItem;
import org.hiedacamellia.mystiasizakaya.content.common.item.utils.LingXianItem;
import org.hiedacamellia.mystiasizakaya.content.common.blockitem.*;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseItem;
import org.hiedacamellia.mystiasizakaya.core.entry.builder.BaseItemBuilder;

import java.util.List;

public class MIItem {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MystiasIzakaya.MODID);

    public static final DeferredItem<BlockItem> COOKING_RANGE = REGISTRY.registerSimpleBlockItem("cooking_range", MIBlock.COOKING_RANGE);
    public static final DeferredItem<BlockItem> BANK = REGISTRY.registerSimpleBlockItem("donation", MIBlock.DONATION);

    //kictenwires
    public static final DeferredItem<BlockItem> CUTTING_BOARD = REGISTRY.register("cutting_board", CuttingBoardBlockItem::new);
    public static final DeferredItem<BlockItem> BOILING_POT = REGISTRY.register("boiling_pot", BoilingPotBlockItem::new);
    public static final DeferredItem<BlockItem> FRYING_PAN = REGISTRY.register("frying_pan", FryingPanBlockItem::new);
    public static final DeferredItem<BlockItem> STEAMER = REGISTRY.register("steamer", SteamerBlockItem::new);
    public static final DeferredItem<BlockItem> GRILL = REGISTRY.register("grill", GrillBlockItem::new);

    //Util
    public static final DeferredItem<Item> LEDGER = REGISTRY.register("ledger", LedgerItem::new);

    public static final DeferredRegister.Items Ingredients = DeferredRegister.createItems(MystiasIzakaya.MODID);
    //ingredients
    public static final DeferredItem<Item> BA_MU_MAN = Ingredients.register("ba_mu_man", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
                    .tags(List.of("Aquatic", "Signature", "Fresh"))
                    .cost(14).build());
    public static final DeferredItem<Item> BAI_GUO = Ingredients.register("bai_guo", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
                    .tags(List.of("Photogenic"))
                    .cost(7).build());
    public static final DeferredItem<Item> BAN_LI = Ingredients.register("ban_li", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
                    .tags(List.of("Homecooking", "Vegetarian"))
                    .cost(10).build());
    public static final DeferredItem<Item> BING_DI_LIAN = Ingredients.register("bing_di_lian", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
                    .tags(List.of("Cultural_Heritage", "Premium", "Legendary", "Mild", "Dreamy"))
                    .cost(36).build());
    public static final DeferredItem<Item> BING_KUAI = Ingredients.register("bing_kuai", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
                    .tags(List.of("Refreshing"))
                    .cost(2).build());
    public static final DeferredItem<Item> CHAN_SHUI = Ingredients.register("chan_shui", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
                    .tags(List.of("Peculiar"))
                    .cost(5).build());
    public static final DeferredItem<Item> CHUN_CHUN = Ingredients.register("chun_chun", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
                    .tags(List.of("Poison", "Vegetarian"))
                    .cost(20).build());
    public static final DeferredItem<Item> DI_GUA = Ingredients.register("di_gua", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
                    .tags(List.of("Filling"))
                    .cost(8).build());
    public static final DeferredItem<Item> DOU_FU = Ingredients.register("dou_fu", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
                    .tags(List.of("Vegetarian", "Homecooking", "Mild"))
                    .cost(8).build());
    public static final DeferredItem<Item> FENG_MI = Ingredients.register("feng_mi", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()))
                    .tags(List.of("Sweet"))
                    .cost(15).build());
    public static final DeferredItem<Item> HAI_DAN = Ingredients.register("hai_dan", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
                    .tags(List.of("Aquatic", "Sea_Delicacy", "Fresh", "Legendary", "Premium"))
                    .cost(18).build());
    public static final DeferredItem<Item> HAI_TAI = Ingredients.register("hai_tai", () ->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
                    .tags(List.of("Aquatic", "Sea_Delicacy", "Fresh", "Legendary", "Premium"))
                    .cost(3).build());
    public static final DeferredItem<Item> HEI_MAO_ZHU_ROU = Ingredients.register("hei_mao_zhu_rou",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.UNCOMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Meat","Legendary","Mountain_Delicacy"))
					.cost(35).build());
    public static final DeferredItem<Item> HEI_YAN = Ingredients.register("hei_yan", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.UNCOMMON))
					.tags(List.of("Salty"))
					.cost(3).build());
    public static final DeferredItem<Item> HE_NIU = Ingredients.register("he_niu", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.UNCOMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Meat","Legendary","Premium"))
					.cost(40).build());
    public static final DeferredItem<Item> HE_TUN = Ingredients.register("he_tun",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
					.tags(List.of("Aquatic","Sea_Delicacy","Fresh"))
					.cost(3).build());
    public static final DeferredItem<Item> HONG_DOU = Ingredients.register("hong_dou", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Homecooking"))
					.cost(18).build());
    public static final DeferredItem<Item> HUANG_GUA = Ingredients.register("huang_gua",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian", "Homecooking", "Mild"))
					.cost(7).build());
    public static final DeferredItem<Item> HUANG_YOU = Ingredients.register("huang_you", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Greasy"))
					.cost(8).build());
    public static final DeferredItem<Item> HUAN_TAN_HUA = Ingredients.register("huan_tan_hua",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Premium", "Legendary", "Dreamy", "Wonderful"))
					.cost(70).build());
    public static final DeferredItem<Item> JIN_QIANG_YU = Ingredients.register("jin_qiang_yu", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic", "Premium", "Fresh"))
					.cost(30).build());
    public static final DeferredItem<Item> JI_DAN = Ingredients.register("ji_dan", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
					.tags(List.of("Raw"))
					.cost(4).build());
    public static final DeferredItem<Item> JI_SHANG_JIN_QIANG_YU = Ingredients.register("ji_shang_jin_qiang_yu",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.UNCOMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic", "Premium", "Legendary", "Sea_Delicacy", "Fresh"))
					.cost(34).build());
    public static final DeferredItem<Item> KE_KE_DOU = Ingredients.register("ke_ke_dou",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Sweet", "Wonderful"))
					.cost(22).build());
    public static final DeferredItem<Item> LA_JIAO = Ingredients.register("la_jiao",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Spicy"))
					.cost(2).build());
    public static final DeferredItem<Item> LIAN_ZI = Ingredients.register("lian_zi", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Signature", "Mild", "Cultural_Heritage"))
					.cost(22).build());
    public static final DeferredItem<Item> LUO_BU = Ingredients.register("luo_bu", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Good_With_Alcohol"))
					.cost(16).build());
    public static final DeferredItem<Item> LU_ROU = Ingredients.register("lu_rou",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Meat"))
					.cost(20).build());
    public static final DeferredItem<Item> LU_SHUI = Ingredients.register("lu_shui", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
					.tags(List.of("Mild"))
					.cost(10).build());
    public static final DeferredItem<Item> MEI_ZI = Ingredients.register("mei_zi", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Salty", "Small_Portion"))
					.cost(12).build());
    public static final DeferredItem<Item> MIAN_FEN = Ingredients.register("mian_fen", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Filling"))
					.cost(10).build());
    public static final DeferredItem<Item> MO_GU = Ingredients.register("mo_gu",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Fresh","Fungi"))
					.cost(18).build());
    public static final DeferredItem<Item> NAI_YOU = Ingredients.register("nai_you", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Homecooking","Sweet","Western"))
					.cost(9).build());
    public static final DeferredItem<Item> NAN_GUA = Ingredients.register("nan_gua", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Filling"))
					.cost(14).build());
    public static final DeferredItem<Item> NING_MENG = Ingredients.register("ning_meng",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Sour","Fruity"))
					.cost(8).build());
    public static final DeferredItem<Item> NIU_ROU = Ingredients.register("niu_rou",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Meat"))
					.cost(15).build());
    public static final DeferredItem<Item> NUO_MI = Ingredients.register("nuo_mi", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.cost(15).build());
    public static final DeferredItem<Item> PANG_XIE = Ingredients.register("pang_xie", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Fresh","Premium"))
					.cost(10).build());
    public static final DeferredItem<Item> PU_PU_YOU_GUO = Ingredients.register("pu_pu_you_guo",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Divine_Punishment"))
					.cost(10).build());
    public static final DeferredItem<Item> PU_TAO = Ingredients.register("pu_tao",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Fruity","Sweet"))
					.cost(5).build());
    public static final DeferredItem<Item> QIANG_XIAO_LA_JIAO_SU = Ingredients.register("qiang_xiao_la_jiao_su", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON))
					.tags(List.of("Divine_Punishment"))
					.cost(0).build());
    public static final DeferredItem<Item> SAN_WEN_YU = Ingredients.register("san_wen_yu", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Premium","Fresh"))
					.cost(24).build());
    public static final DeferredItem<Item> SONG_LU = Ingredients.register("song_lu",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.UNCOMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Fresh","Fungi","Premium","Legendary","Mountain_Delicacy"))
					.cost(24).build());
    public static final DeferredItem<Item> SONG_ZI = Ingredients.register("song_zi",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Premium","Fresh"))
					.cost(50).build());
    public static final DeferredItem<Item> TAO_ZI = Ingredients.register("tao_zi", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Sweet","Fruity"))
					.cost(10).build());
    public static final DeferredItem<Item> TU_DOU = Ingredients.register("tu_dou", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Homecooking"))
					.cost(10).build());
    public static final DeferredItem<Item> XIA = Ingredients.register("xia",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Fresh"))
					.cost(30).build());
    public static final DeferredItem<Item> XIAN_HUA = Ingredients.register("xian_hua",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Dreamy","Photogenic"))
					.cost(45).build());
    public static final DeferredItem<Item> XI_HONG_SHI = Ingredients.register("xi_hong_shi",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian"))
					.cost(8).build());
    public static final DeferredItem<Item> XI_LAN_HUA = Ingredients.register("xi_lan_hua", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian", "Homecooking"))
					.cost(18).build());
    public static final DeferredItem<Item> XU_LI = Ingredients.register("xu_li",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Refreshing","Dreamy"))
					.cost(21).build());
    public static final DeferredItem<Item> YANG_CONG = Ingredients.register("yang_cong", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Fresh"))
					.cost(12).build());
    public static final DeferredItem<Item> YE_ZHU_ROU = Ingredients.register("ye_zhu_rou",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Meat"))
					.cost(35).build());
    public static final DeferredItem<Item> YIN_ER = Ingredients.register("yin_er", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Fungus", "Mild"))
					.cost(14).build());
    public static final DeferredItem<Item> YUE_GUANG_CAO = Ingredients.register("yue_guang_cao", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Mild","Dreamy","Cultural_Heritage","Wonderful"))
					.cost(70).build());
    public static final DeferredItem<Item> ZHANG_YU = Ingredients.register("zhang_yu",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Fresh","Sea_Delicacy"))
					.cost(12).build());
    public static final DeferredItem<Item> ZHI_SHI = Ingredients.register("zhi_shi", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Premium","Salty","Fresh"))
					.cost(18).build());
    public static final DeferredItem<Item> ZHU_ROU = Ingredients.register("zhu_rou",  () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Meat"))
					.cost(10).build());
    public static final DeferredItem<Item> ZHU_SUN = Ingredients.register("zhu_sun", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
					.tags(List.of("Vegetarian","Mild"))
					.cost(40).build());
    public static final DeferredItem<Item> ZHU_ZI = Ingredients.register("zhu_zi",() ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.8f).build()))
					.tags(List.of("Photogenic"))
					.cost(15).build());
    public static final DeferredItem<Item> ZUN_YU = Ingredients.register("zun_yu", () ->
			new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
					.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
					.tags(List.of("Aquatic","Fresh"))
					.cost(8).build());

    public static final DeferredRegister.Items Cuisines = DeferredRegister.createItems(MystiasIzakaya.MODID);
    //cuisines
    public static final DeferredItem<Item> BAI_GUO_LUO_BU_PAI_GU_TANG = Cuisines.register("bai_guo_luo_bu_pai_gu_tang", BaiGuoLuoBuPaiGuTangItem::new);
    public static final DeferredItem<Item> BAI_LU_ZHEN_SONG = Cuisines.register("bai_lu_zhen_song", BaiLuZhenSongItem::new);
    public static final DeferredItem<Item> BAI_TAO_SHENG_BA_QIAO = Cuisines.register("bai_tao_sheng_ba_qiao", BaiTaoShengBaQiaoItem::new);
    public static final DeferredItem<Item> BAI_XUE = Cuisines.register("bai_xue", BaiXueItem::new);
    public static final DeferredItem<Item> BAN_NI_DI_KE_DAN = Cuisines.register("ban_ni_di_ke_dan", BanNiDiKeDanItem::new);
    public static final DeferredItem<Item> BA_SI_DI_GUA = Cuisines.register("ba_si_di_gua", BaSiDiGuaItem::new);
    public static final DeferredItem<Item> BEI_JI_TIAN_XIA_MI_TAO_SE_LA = Cuisines.register("bei_ji_tian_xia_mi_tao_se_la", BeiJiTianXiaMiTaoSeLaItem::new);
    public static final DeferredItem<Item> BI_SI_KAI_WAN_BING_GAN = Cuisines.register("bi_si_kai_wan_bing_gan", BiSiKaiWanBingGanItem::new);
    public static final DeferredItem<Item> BU_SI_NIAO = Cuisines.register("bu_si_niao", BuSiNiaoItem::new);
    public static final DeferredItem<Item> CHANG_FA_GONG_ZHU = Cuisines.register("chang_fa_gong_zhu", ChangFaGongZhuItem::new);
    public static final DeferredItem<Item> CHAO_ROU_SI = Cuisines.register("chao_rou_si", ChaoRouSiItem::new);
    public static final DeferredItem<Item> CHOU_DOU_FU = Cuisines.register("chou_dou_fu", ChouDouFuItem::new);
    public static final DeferredItem<Item> CHUI_XUAN_FENG = Cuisines.register("chui_xuan_feng", ChuiXuanFengItem::new);
    public static final DeferredItem<Item> CHUI_ZHU_YIN_CHUN = Cuisines.register("chui_zhu_yin_chun", ChuiZhuYinChunItem::new);
    public static final DeferredItem<Item> CI_SHEN_PIN_PAN = Cuisines.register("ci_shen_pin_pan", CiShenPinPanItem::new);
    public static final DeferredItem<Item> DA_BAN_SHAO = Cuisines.register("da_ban_shao", DaBanShaoItem::new);
    public static final DeferredItem<Item> DA_JIANG_HU_CHUAN_JI = Cuisines.register("da_jiang_hu_chuan_ji", DaJiangHuChuanJiItem::new);
    public static final DeferredItem<Item> DA_SHE_YAN = Cuisines.register("da_she_yan", DaSheYanItem::new);
    public static final DeferredItem<Item> DI_YU_JI_XIN_JIN_GAO = Cuisines.register("di_yu_ji_xin_jin_gao", DiYuJiXinJinGaoItem::new);
    public static final DeferredItem<Item> DOU_FU_GUO = Cuisines.register("dou_fu_guo", DouFuGuoItem::new);
    public static final DeferredItem<Item> DOU_FU_WEI_CHENG = Cuisines.register("dou_fu_wei_cheng", DouFuWeiChengItem::new);
    public static final DeferredItem<Item> DOU_JIA_ZHENG_GAO = Cuisines.register("dou_jia_zheng_gao", DouJiaZhengGaoItem::new);
    public static final DeferredItem<Item> DU_ZHANG_HUA_YUAN = Cuisines.register("du_zhang_hua_yuan", DuZhangHuaYuanItem::new);
    public static final DeferredItem<Item> ER_TIAN_LIU = Cuisines.register("er_tian_liu", ErTianLiuItem::new);
    public static final DeferredItem<Item> FAN_TUAN = Cuisines.register("fan_tuan", FanTuanItem::new);
    public static final DeferredItem<Item> FENG_MAO_ZI_CHA_HUI = Cuisines.register("feng_mao_zi_cha_hui", FengMaoZiChaHuiItem::new);
    public static final DeferredItem<Item> FENG_ZI_DAN = Cuisines.register("feng_zi_dan", FengZiDanItem::new);
    public static final DeferredItem<Item> HAI_DAN_CI_SHEN = Cuisines.register("hai_dan_ci_shen", HaiDanCiShenItem::new);
    public static final DeferredItem<Item> HAI_DAN_XIN_XUAN_BING = Cuisines.register("hai_dan_xin_xuan_bing", HaiDanXinXuanBingItem::new);
    public static final DeferredItem<Item> HAI_DAN_ZHENG_DAN = Cuisines.register("hai_dan_zheng_dan", HaiDanZhengDanItem::new);
    public static final DeferredItem<Item> HAI_DAO_XUN_ROU = Cuisines.register("hai_dao_xun_rou", HaiDaoXunRouItem::new);
    public static final DeferredItem<Item> HAI_XIAN_WEI_CHENG_TANG = Cuisines.register("hai_xian_wei_cheng_tang", HaiXianWeiChengTangItem::new);
    public static final DeferredItem<Item> HAN_GONG_CHANG_JIAO = Cuisines.register("han_gong_chang_jiao", HanGongChangJiaoItem::new);
    public static final DeferredItem<Item> HE_HUA_YU_MI_ZHAN = Cuisines.register("he_hua_yu_mi_zhan", HeHuaYuMiZhanItem::new);
    public static final DeferredItem<Item> HE_TANG_YUE_SHE = Cuisines.register("he_tang_yue_she", HeTangYueSheItem::new);
    public static final DeferredItem<Item> HONG_DOU_DA_FU = Cuisines.register("hong_dou_da_fu", HongDouDaFuItem::new);
    public static final DeferredItem<Item> HONG_SHAO_MAN_YU = Cuisines.register("hong_shao_man_yu", HongShaoManYuItem::new);
    public static final DeferredItem<Item> HUANG_YOU_NIU_PAI = Cuisines.register("huang_you_niu_pai", HuangYouNiuPaiItem::new);
    public static final DeferredItem<Item> HUAN_JIN_SHU_YU_BIN = Cuisines.register("huan_jin_shu_yu_bin", HuanJinShuYuBinItem::new);
    public static final DeferredItem<Item> HUAN_TAN_HUA_GAO = Cuisines.register("huan_tan_hua_gao", HuanTanHuaGaoItem::new);
    public static final DeferredItem<Item> HUAN_XIANG_FENG_MI = Cuisines.register("huan_xiang_feng_mi", HuanXiangFengMiItem::new);
    public static final DeferredItem<Item> HUAN_XIANG_FOU_TIAO_QIANG = Cuisines.register("huan_xiang_fou_tiao_qiang", HuanXiangFouTiaoQiangItem::new);
    public static final DeferredItem<Item> HUAN_XIANG_XING_LIAN_CHUAN = Cuisines.register("huan_xiang_xing_lian_chuan", HuanXiangXingLianChuanItem::new);
    public static final DeferredItem<Item> HUA_GUANG_YU_JIAN_BAO = Cuisines.register("hua_guang_yu_jian_bao", HuaGuangYuJianBaoItem::new);
    public static final DeferredItem<Item> HUA_NIAO_FENG_YUE = Cuisines.register("hua_niao_feng_yue", HuaNiaoFengYueItem::new);
    public static final DeferredItem<Item> HUI_LING_DUN_NIU_PAI = Cuisines.register("hui_ling_dun_niu_pai", HuiLingDunNiuPaiItem::new);
    public static final DeferredItem<Item> HUO_XING = Cuisines.register("huo_xing", HuoXingItem::new);
    public static final DeferredItem<Item> HU_LA_TANG = Cuisines.register("hu_la_tang", HuLaTangItem::new);
    public static final DeferredItem<Item> JIN_XIA_DA_MAO_XIAN = Cuisines.register("jin_xia_da_mao_xian", JinXiaDaMaoXianItem::new);
    public static final DeferredItem<Item> JUE_JIAO_GUAN_DOU_ZHU = Cuisines.register("jue_jiao_guan_dou_zhu", JueJiaoGuanDouZhuItem::new);
    public static final DeferredItem<Item> JU_REN_YU_ZI_SHAO = Cuisines.register("ju_ren_yu_zi_shao", JuRenYuZiShaoItem::new);
    public static final DeferredItem<Item> KAO_BA_MU_MAN = Cuisines.register("kao_ba_mu_man", KaoBaMuManItem::new);
    public static final DeferredItem<Item> KAO_DI_GUA = Cuisines.register("kao_di_gua", KaoDiGuaItem::new);
    public static final DeferredItem<Item> KAO_MO_GU = Cuisines.register("kao_mo_gu", KaoMoGuItem::new);
    public static final DeferredItem<Item> LENG_DOU_FU = Cuisines.register("leng_dou_fu", LengDouFuItem::new);
    public static final DeferredItem<Item> LIANG_CAI_DIAO_HUA = Cuisines.register("liang_cai_diao_hua", LiangCaiDiaoHuaItem::new);
    public static final DeferredItem<Item> LIU_SHUI_SU_MIAN = Cuisines.register("liu_shui_su_mian", LiuShuiSuMianItem::new);
    public static final DeferredItem<Item> LI_LIANG_TANG = Cuisines.register("li_liang_tang", LiLiangTangItem::new);
    public static final DeferredItem<Item> LONG_YIN_TAO_ZI = Cuisines.register("long_yin_tao_zi", LongYinTaoZiItem::new);
    public static final DeferredItem<Item> LUO_HAN_SHANG_SU = Cuisines.register("luo_han_shang_su", LuoHanShangSuItem::new);
    public static final DeferredItem<Item> LU_SHUI_ZHU_DAN = Cuisines.register("lu_shui_zhu_dan", LuShuiZhuDanItem::new);
    public static final DeferredItem<Item> LV_YE_XIAN_GU = Cuisines.register("lv_ye_xian_gu", LvYeXianGuItem::new);
    public static final DeferredItem<Item> MAN_YU_NENG_DAN_JING = Cuisines.register("man_yu_neng_dan_jing", ManYuNengDanJingItem::new);
    public static final DeferredItem<Item> MAO_FAN = Cuisines.register("mao_fan", MaoFanItem::new);
    public static final DeferredItem<Item> MAO_MI_KE_LU_LI = Cuisines.register("mao_mi_ke_lu_li", MaoMiKeLuLiItem::new);
    public static final DeferredItem<Item> MAO_MI_PI_SHA = Cuisines.register("mao_mi_pi_sha", MaoMiPiShaItem::new);
    public static final DeferredItem<Item> MAO_MI_XI_SHUI = Cuisines.register("mao_mi_xi_shui", MaoMiXiShuiItem::new);
    public static final DeferredItem<Item> MAO_YU_RONG_YAN_DOU_FU = Cuisines.register("mao_yu_rong_yan_dou_fu", MaoYuRongYanDouFuItem::new);
    public static final DeferredItem<Item> MAO_YU_SAN_SE_BING_JI_LING = Cuisines.register("mao_yu_san_se_bing_ji_ling", MaoYuSanSeBingJiLingItem::new);
    public static final DeferredItem<Item> MA_PO_DOU_FU = Cuisines.register("ma_po_dou_fu", MaPoDouFuItem::new);
    public static final DeferredItem<Item> MA_SHU = Cuisines.register("ma_shu", MaShuItem::new);
    public static final DeferredItem<Item> MEI_ZI_CHA_PAO_FAN = Cuisines.register("mei_zi_cha_pao_fan", MeiZiChaPaoFanItem::new);
    public static final DeferredItem<Item> MI_QIAN_LI_ZI = Cuisines.register("mi_qian_li_zi", MiQianLiZiItem::new);
    public static final DeferredItem<Item> MI_TAO_HONG_SHAO_ROU = Cuisines.register("mi_tao_hong_shao_rou", MiTaoHongShaoRouItem::new);
    public static final DeferredItem<Item> MI_ZHI_CHA_SHAO = Cuisines.register("mi_zhi_cha_shao", MiZhiChaShaoItem::new);
    public static final DeferredItem<Item> MI_ZHI_XIAN_JUN_BAO = Cuisines.register("mi_zhi_xian_jun_bao", MiZhiXianJunBaoItem::new);
    public static final DeferredItem<Item> MI_ZHI_XIAO_YU_GAN = Cuisines.register("mi_zhi_xiao_yu_gan", MiZhiXiaoYuGanItem::new);
    public static final DeferredItem<Item> MO_GU_ROU_PIAN = Cuisines.register("mo_gu_rou_pian", MoGuRouPianItem::new);
    public static final DeferredItem<Item> MO_NV_DE_WU_TA_HUI = Cuisines.register("mo_nv_de_wu_ta_hui", MoNvDeWuTaHuiItem::new);
    public static final DeferredItem<Item> NAI_XIANG_MO_GU_TANG = Cuisines.register("nai_xiang_mo_gu_tang", NaiXiangMoGuTangItem::new);
    public static final DeferredItem<Item> NAI_YOU_JU_XIE = Cuisines.register("nai_you_ju_xie", NaiYouJuXieItem::new);
    public static final DeferredItem<Item> NAI_YOU_TUN_CAI = Cuisines.register("nai_you_tun_cai", NaiYouTunCaiItem::new);
    public static final DeferredItem<Item> NAN_GUA_XIA_ZHONG = Cuisines.register("nan_gua_xia_zhong", NanGuaXiaZhongItem::new);
    public static final DeferredItem<Item> NENG_LIANG_CHUAN = Cuisines.register("neng_liang_chuan", NengLiangChuanItem::new);
    public static final DeferredItem<Item> NIU_ROU_GAI_JIAO_FAN = Cuisines.register("niu_rou_gai_jiao_fan", NiuRouGaiJiaoFanItem::new);
    public static final DeferredItem<Item> NIU_ROU_YUAN_YANG_HUO_GUO = Cuisines.register("niu_rou_yuan_yang_huo_guo", NiuRouYuanYangHuoGuoItem::new);
    public static final DeferredItem<Item> NI_JIU_ZI_YU = Cuisines.register("ni_jiu_zi_yu", NiJiuZiYuItem::new);
    public static final DeferredItem<Item> NI_ZHUAN_TIAN_DI = Cuisines.register("ni_zhuan_tian_di", NiZhuanTianDiItem::new);
    public static final DeferredItem<Item> PENG_LAI_YU_ZHI = Cuisines.register("peng_lai_yu_zhi", PengLaiYuZhiItem::new);
    public static final DeferredItem<Item> PU_TONG_XIA_DAN_GAO = Cuisines.register("pu_tong_xia_dan_gao", PuTongXiaDanGaoItem::new);
    public static final DeferredItem<Item> QI_SHE_YANG_GENG = Cuisines.register("qi_she_yang_geng", QiSheYangGengItem::new);
    public static final DeferredItem<Item> QUAN_ROU_SHENG_YAN = Cuisines.register("quan_rou_sheng_yan", QuanRouShengYanItem::new);
    public static final DeferredItem<Item> RAN_JING_BU_DING = Cuisines.register("ran_jing_bu_ding", RanJingBuDingItem::new);
    public static final DeferredItem<Item> RE_SONG_BING = Cuisines.register("re_song_bing", ReSongBingItem::new);
    public static final DeferredItem<Item> SAI_XIONG_ZHANG = Cuisines.register("sai_xiong_zhang", SaiXiongZhangItem::new);
    public static final DeferredItem<Item> SAN_WEN_YU_TIAN_FU_LUO = Cuisines.register("san_wen_yu_tian_fu_luo", SanWenYuTianFuLuoItem::new);
    public static final DeferredItem<Item> SHANG_QI_ZHI_SHI_TIAO = Cuisines.register("shang_qi_zhi_shi_tiao", ShangQiZhiShiTiaoItem::new);
    public static final DeferredItem<Item> SHENG_BAI_LIAN_ZI_GAO = Cuisines.register("sheng_bai_lian_zi_gao", ShengBaiLianZiGaoItem::new);
    public static final DeferredItem<Item> SHENG_MING_ZHI_YUAN = Cuisines.register("sheng_ming_zhi_yuan", ShengMingZhiYuanItem::new);
    public static final DeferredItem<Item> SHI_GUO_ZHU_SUN_DUN_ROU = Cuisines.register("shi_guo_zhu_sun_dun_rou", ShiGuoZhuSunDunRouItem::new);
    public static final DeferredItem<Item> SHI_JIN_TIAN_FU_LUO = Cuisines.register("shi_jin_tian_fu_luo", ShiJinTianFuLuoItem::new);
    public static final DeferredItem<Item> SHI_LI_YIN_XING = Cuisines.register("shi_li_yin_xing", ShiLiYinXingItem::new);
    public static final DeferredItem<Item> SHI_ZI_TOU = Cuisines.register("shi_zi_tou", ShiZiTouItem::new);
    public static final DeferredItem<Item> SHUI_JIAO = Cuisines.register("shui_jiao", ShuiJiaoItem::new);
    public static final DeferredItem<Item> SHUI_ZHU_YU = Cuisines.register("shui_zhu_yu", ShuiZhuYuItem::new);
    public static final DeferredItem<Item> SHU_CAI_ZHUAN_JI = Cuisines.register("shu_cai_zhuan_ji", ShuCaiZhuanJiItem::new);
    public static final DeferredItem<Item> SI_KANG_BING = Cuisines.register("si_kang_bing", SiKangBingItem::new);
    public static final DeferredItem<Item> SONG_ZI_GAO = Cuisines.register("song_zi_gao", SongZiGaoItem::new);
    public static final DeferredItem<Item> SOU_MA_TUAN_ZI = Cuisines.register("sou_ma_tuan_zi", SouMaTuanZiItem::new);
    public static final DeferredItem<Item> TAI_JI_BA_GUA_YU_DU = Cuisines.register("tai_ji_ba_gua_yu_du", TaiJiBaGuaYuDuItem::new);
    public static final DeferredItem<Item> TANG_YUAN = Cuisines.register("tang_yuan", TangYuanItem::new);
    public static final DeferredItem<Item> TAO_HUA_GENG = Cuisines.register("tao_hua_geng", TaoHuaGengItem::new);
    public static final DeferredItem<Item> TAO_HUA_LIU_LI_JUAN = Cuisines.register("tao_hua_liu_li_juan", TaoHuaLiuLiJuanItem::new);
    public static final DeferredItem<Item> TIAN_SHI_BAN_LI_MENG_GU = Cuisines.register("tian_shi_ban_li_meng_gu", TianShiBanLiMengGuItem::new);
    public static final DeferredItem<Item> TI_SHEN_BU_DING = Cuisines.register("ti_shen_bu_ding", TiShenBuDingItem::new);
    public static final DeferredItem<Item> TONG_LUO_SHAO = Cuisines.register("tong_luo_shao", TongLuoShaoItem::new);
    public static final DeferredItem<Item> TUN_GU_LA_MIAN = Cuisines.register("tun_gu_la_mian", TunGuLaMianItem::new);
    public static final DeferredItem<Item> TU_DOU_KE_LE_BING = Cuisines.register("tu_dou_ke_le_bing", TuDouKeLeBingItem::new);
    public static final DeferredItem<Item> WEN_NUAN_FAN_TUAN = Cuisines.register("wen_nuan_fan_tuan", WenNuanFanTuanItem::new);
    public static final DeferredItem<Item> WU_YI_SHI_YAO_GUAI_MU_SI = Cuisines.register("wu_yi_shi_yao_guai_mu_si", WuYiShiYaoGuaiMuSiItem::new);
    public static final DeferredItem<Item> XIANG_CHUN_JIAN_BING = Cuisines.register("xiang_chun_jian_bing", XiangChunJianBingItem::new);
    public static final DeferredItem<Item> XIANG_JIAN_SAN_WEN_YU = Cuisines.register("xiang_jian_san_wen_yu", XiangJianSanWenYuItem::new);
    public static final DeferredItem<Item> XIANG_JIAN_SHUANG_GU_ROU_JUAN = Cuisines.register("xiang_jian_shuang_gu_rou_juan", XiangJianShuangGuRouJuanItem::new);
    public static final DeferredItem<Item> XIANG_ZHA_CHAN_SHUI = Cuisines.register("xiang_zha_chan_shui", XiangZhaChanShuiItem::new);
    public static final DeferredItem<Item> XIAO_XIAO_DE_TIAN_MI_DU_YAO = Cuisines.register("xiao_xiao_de_tian_mi_du_yao", XiaoXiaoDeTianMiDuYaoItem::new);
    public static final DeferredItem<Item> XING_HONG_E_MO_DAN_GAO = Cuisines.register("xing_hong_e_mo_dan_gao", XingHongEMoDanGaoItem::new);
    public static final DeferredItem<Item> YANG_WANG_TIAN_HUA_BAN_PAI = Cuisines.register("yang_wang_tian_hua_ban_pai", YangWangTianHuaBanPaiItem::new);
    public static final DeferredItem<Item> YANG_XIN_ZHOU = Cuisines.register("yang_xin_zhou", YangXinZhouItem::new);
    public static final DeferredItem<Item> YAN_HUANG_GUA = Cuisines.register("yan_huang_gua", YanHuangGuaItem::new);
    public static final DeferredItem<Item> YAN_JIANG = Cuisines.register("yan_jiang", YanJiangItem::new);
    public static final DeferredItem<Item> YE_WEI_JIA_NONG = Cuisines.register("ye_wei_jia_nong", YeWeiJiaNongItem::new);
    public static final DeferredItem<Item> YING_LUO_XUE = Cuisines.register("ying_luo_xue", YingLuoXueItem::new);
    public static final DeferredItem<Item> YIN_HUA_BU_DING = Cuisines.register("yin_hua_bu_ding", YinHuaBuDingItem::new);
    public static final DeferredItem<Item> YIN_YU_SHUI_GUO_PAI = Cuisines.register("yin_yu_shui_guo_pai", YinYuShuiGuoPaiItem::new);
    public static final DeferredItem<Item> YI_JI_BI_SHA = Cuisines.register("yi_ji_bi_sha", YiJiBiShaItem::new);
    public static final DeferredItem<Item> YI_SHI_HUI_FAN = Cuisines.register("yi_shi_hui_fan", YiShiHuiFanItem::new);
    public static final DeferredItem<Item> YOU_DOU_FU = Cuisines.register("you_dou_fu", YouDouFuItem::new);
    public static final DeferredItem<Item> YOU_MENG = Cuisines.register("you_meng", YouMengItem::new);
    public static final DeferredItem<Item> YUE_BING = Cuisines.register("yue_bing", YueBingItem::new);
    public static final DeferredItem<Item> YUE_GUANG_TUAN_ZI = Cuisines.register("yue_guang_tuan_zi", YueGuangTuanZiItem::new);
    public static final DeferredItem<Item> YUE_ZHI_LIAN_REN = Cuisines.register("yue_zhi_lian_ren", YueZhiLianRenItem::new);
    public static final DeferredItem<Item> YUN_SHAN_MIAO_HUA_TANG = Cuisines.register("yun_shan_miao_hua_tang", YunShanMiaoHuaTangItem::new);
    public static final DeferredItem<Item> YU_YUE_LONG_MEN = Cuisines.register("yu_yue_long_men", YuYueLongMenItem::new);
    public static final DeferredItem<Item> ZA_CHUI = Cuisines.register("za_chui", ZaChuiItem::new);
    public static final DeferredItem<Item> ZHANG_YU_SHAO = Cuisines.register("zhang_yu_shao", ZhangYuShaoItem::new);
    public static final DeferredItem<Item> ZHA_BA_MU_MAN = Cuisines.register("zha_ba_mu_man", ZhaBaMuManItem::new);
    public static final DeferredItem<Item> ZHA_FAN_QIE_TIAO = Cuisines.register("zha_fan_qie_tiao", ZhaFanQieTiaoItem::new);
    public static final DeferredItem<Item> ZHA_XIA_TIAN_FU_LUO = Cuisines.register("zha_xia_tian_fu_luo", ZhaXiaTianFuLuoItem::new);
    public static final DeferredItem<Item> ZHA_ZHU_ROU_PAI = Cuisines.register("zha_zhu_rou_pai", ZhaZhuRouPaiItem::new);
    public static final DeferredItem<Item> ZHEN_HAI_XIAN_WEI_CHENG_TANG = Cuisines.register("zhen_hai_xian_wei_cheng_tang", ZhenHaiXianWeiChengTangItem::new);
    public static final DeferredItem<Item> ZHI_SHI_DAN = Cuisines.register("zhi_shi_dan", ZhiShiDanItem::new);
    public static final DeferredItem<Item> ZHI_ZHUNG_HAI_XIAN_MIAN = Cuisines.register("zhi_zhung_hai_xian_mian", ZhiZhungHaiXianMianItem::new);
    public static final DeferredItem<Item> ZHI_ZHU_ROU_FAN_TUAN = Cuisines.register("zhi_zhu_rou_fan_tuan", ZhiZhuRouFanTuanItem::new);
    public static final DeferredItem<Item> ZHU_DOU_FU = Cuisines.register("zhu_dou_fu", ZhuDouFuItem::new);
    public static final DeferredItem<Item> ZHU_LU_DIE = Cuisines.register("zhu_lu_die", ZhuLuDieItem::new);
    public static final DeferredItem<Item> ZHU_QU_JI = Cuisines.register("zhu_qu_ji", ZhuQuJiItem::new);
    public static final DeferredItem<Item> ZHU_ROU_GAI_JIAO_FAN = Cuisines.register("zhu_rou_gai_jiao_fan", ZhuRouGaiJiaoFanItem::new);
    public static final DeferredItem<Item> ZHU_ROU_ZUN_YU_XUN = Cuisines.register("zhu_rou_zun_yu_xun", ZhuRouZunYuXunItem::new);
    public static final DeferredItem<Item> ZHU_SUN_CHAO_ROU = Cuisines.register("zhu_sun_chao_rou", ZhuSunChaoRouItem::new);
    public static final DeferredItem<Item> ZHU_TONG_FEN_ZHENG_DAN = Cuisines.register("zhu_tong_fen_zheng_dan", ZhuTongFenZhengDanItem::new);
    public static final DeferredItem<Item> ZHU_TONG_SHAO_ZUI_XIA = Cuisines.register("zhu_tong_shao_zui_xia", ZhuTongShaoZuiXiaItem::new);
    public static final DeferredItem<Item> ZHU_TONG_ZHENG_DAN = Cuisines.register("zhu_tong_zheng_dan", ZhuTongZhengDanItem::new);


    public static final DeferredRegister.Items Beverages = DeferredRegister.createItems(MystiasIzakaya.MODID);
    //beverages
    public static final DeferredItem<Item> A_FU_JIA_DUO = Beverages.register("a_fu_jia_duo", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("chillable", "stimulating", "sweet", "bitter")).beverages().cost(35).build());
    public static final DeferredItem<Item> BING_SHAN_MAO_YU_DONG_NING = Beverages.register("bing_shan_mao_yu_dong_ning", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "chillable", "soda", "stimulating", "fruity", "neat", "sweet")).beverages().cost(45).build());
    public static final DeferredItem<Item> BO_ZI_QI_SHUI = Beverages.register("bo_zi_qi_shui", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "soda", "modern")).beverages().cost(30).build());
    public static final DeferredItem<Item> CHAO_ZUN_PI_JIU = Beverages.register("chao_zun_pi_jiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "beer", "bitter")).beverages().cost(18).build());
    public static final DeferredItem<Item> DA_BING_GUN_ER = Beverages.register("da_bing_gun_er", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "stimulating", "modern", "sweet")).beverages().cost(35).build());
    public static final DeferredItem<Item> DA_YIN_NIANG = Beverages.register("da_yin_niang", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "sake", "vintage", "chillable", "fruity", "neat", "sweet")).beverages().cost(210).build());
    public static final DeferredItem<Item> DONG_NIANG = Beverages.register("dong_niang", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "heatable", "vintage", "sweet")).beverages().cost(60).build());;
    public static final DeferredItem<Item> FENG_ZHU = Beverages.register("feng_zhu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "cocktail", "modern", "sweet")).beverages().cost(130).build());
    public static final DeferredItem<Item> GUI_SHA = Beverages.register("gui_sha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "chillable", "shochu", "dry", "vintage")).beverages().cost(320).build());
    public static final DeferredItem<Item> GUO_WEI_HIGH_BALL = Beverages.register("guo_wei_high_ball", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "western", "cocktail", "fruity", "sweet", "bitter")).beverages().cost(12).build());
    public static final DeferredItem<Item> GUO_WEI_SOUR = Beverages.register("guo_wei_sour", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "shochu", "cocktail", "fruity", "sweet", "bitter")).beverages().cost(12).build());
    public static final DeferredItem<Item> GU_FA_NAI_YOU_BING_SHA = Beverages.register("gu_fa_nai_you_bing_sha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "chillable", "vintage")).beverages().cost(42).build());
    public static final DeferredItem<Item> GU_MING_DI_BING_JI_LING = Beverages.register("gu_ming_di_bing_ji_ling", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "fruity", "modern")).beverages().cost(35).build());
    public static final DeferredItem<Item> HAI_DE_NV_ER = Beverages.register("hai_de_nv_er", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "fruity", "modern")).beverages().cost(80).build());
    public static final DeferredItem<Item> HONG_MO_GUAN_HONG_CHA = Beverages.register("hong_mo_guan_hong_cha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "heatable", "stimulating", "fruity")).beverages().cost(25).build());
    public static final DeferredItem<Item> HONG_WU = Beverages.register("hong_wu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "heatable", "western")).beverages().cost(75).build());
    public static final DeferredItem<Item> HONG_YOU_GUO_ZHI = Beverages.register("hong_you_guo_zhi", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "fruity")).beverages().cost(24).build());
    public static final DeferredItem<Item> HUO_SHU_QIU = Beverages.register("huo_shu_qiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "heatable", "shochu", "dry")).beverages().cost(420).build());
    public static final DeferredItem<Item> JIAO_FU = Beverages.register("jiao_fu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "chillable", "western", "cocktail", "vintage", "bitter")).beverages().cost(180).build());
    public static final DeferredItem<Item> KA_PEI = Beverages.register("ka_pei", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "bitter", "modern", "heatable", "chillable", "stimulating")).beverages().cost(62).build());
    public static final DeferredItem<Item> LIN_REN_ZHUI = Beverages.register("lin_ren_zhui", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "neat", "fruity", "vintage", "sweet")).beverages().cost(100).build());
    public static final DeferredItem<Item> LU_CHA = Beverages.register("lu_cha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol")).beverages().cost(1).build());
    public static final DeferredItem<Item> MEI_JIU = Beverages.register("mei_jiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "heatable", "liquor", "fruity")).beverages().cost(32).build());
    public static final DeferredItem<Item> MO_JIE_KA_PEI = Beverages.register("mo_jie_ka_pei", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "stimulating", "heatable", "western")).beverages().cost(210).build());
    public static final DeferredItem<Item> MO_JI_TUO_BAO_JIANG_QIU = Beverages.register("mo_ji_tuo_bao_jiang_qiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "soda", "modern", "cocktail")).beverages().cost(300).build());
    public static final DeferredItem<Item> NIU_NAI = Beverages.register("niu_nai", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "neat")).beverages().cost(16).build());
    public static final DeferredItem<Item> NI_GE_LUO_NI = Beverages.register("ni_ge_luo_ni", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "western", "cocktail", "fruity", "bitter")).beverages().cost(100).build());
    public static final DeferredItem<Item> PU_TONG_JIAN_SHEN_CHA = Beverages.register("pu_tong_jian_shen_cha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "bitter", "soda", "liquor")).beverages().cost(32).build());
    public static final DeferredItem<Item> QI = Beverages.register("qi", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "sake", "cocktail", "soda", "sweet", "dry", "bitter")).beverages().cost(18).build());
    public static final DeferredItem<Item> QI_BAO_JIAN = Beverages.register("qi_bao_jian", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "neat", "stimulating")).beverages().cost(45).build());
    public static final DeferredItem<Item> QI_LIN = Beverages.register("qi_lin", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "beer", "neat")).beverages().cost(180).build());
    public static final DeferredItem<Item> QUE_JIU = Beverages.register("que_jiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "heatable", "sake", "dry")).beverages().cost(50).build());
    public static final DeferredItem<Item> RI_YUE_XING = Beverages.register("ri_yue_xing", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "heatable", "sake", "neat")).beverages().cost(34).build());
    public static final DeferredItem<Item> SHEN_ZHI_MAI = Beverages.register("shen_zhi_mai", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_Alcohol", "chillable", "heatable", "shochu", "neat")).beverages().cost(45).build());
    public static final DeferredItem<Item> SHI_SI_YE = Beverages.register("shi_si_ye", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "heatable", "sake", "vintage", "sweet")).beverages().cost(440).build());
    public static final DeferredItem<Item> SHUI_TA_JI = Beverages.register("shui_ta_ji", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol", "chillable", "heatable", "sake", "neat")).beverages().cost(130).build());
    public static final DeferredItem<Item> TAI_KONG_PI_JIU = Beverages.register("tai_kong_pi_jiu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("mid_alcohol","modern", "fruity", "beer")).beverages().cost(42).build());
    public static final DeferredItem<Item> TIAN_DI_WU_YON = Beverages.register("tian_di_wu_yon", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "shochu")).beverages().cost(150).build());
    public static final DeferredItem<Item> TIAN_GOU_YONG = Beverages.register("tian_gou_yong", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "chillable", "heatable", "sake", "neat")).beverages().cost(70).build());
    public static final DeferredItem<Item> WEI_XIN_BING_KA_PEI = Beverages.register("wei_xin_bing_ka_pei", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "modern", "stimulating", "bitter")).beverages().cost(70).build());
    public static final DeferredItem<Item> XIAO = Beverages.register("xiao", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()))
                    .tags(List.of("high_alcohol", "chillable", "western", "neat")).beverages().cost(400).build());
    public static final DeferredItem<Item> XING_HONG_E_MO = Beverages.register("xing_hong_e_mo", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("low_alcohol", "chillable", "cocktail")).beverages().cost(45).build());
    public static final DeferredItem<Item> YANG_ZHI_GAN_LU = Beverages.register("yang_zhi_gan_lu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "chillable", "fruity")).beverages().cost(50).build());
    public static final DeferredItem<Item> YAO_JING_YU_LU = Beverages.register("yao_jing_yu_lu", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "chillable")).beverages().cost(80).build());
    public static final DeferredItem<Item> YUE_MIAN_HUO_JIAN = Beverages.register("yue_mian_huo_jian", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "sweet", "chillable")).beverages().cost(45).build());
    public static final DeferredItem<Item> YU_LU_CHA = Beverages.register("yu_lu_cha", ()->
            new BaseItemBuilder(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8f).build()))
                    .tags(List.of("no_alcohol", "heatable", "vintage")).beverages().cost(50).build());


    public static final DeferredRegister.Items Others = DeferredRegister.createItems(MystiasIzakaya.MODID);
    //others
    public static final DeferredItem<Item> HEI_AN_WU_ZHI = Others.register("hei_an_wu_zhi", HeiAnWuZhiItem::new);
    public static final DeferredItem<Item> ICON = Others.register("icon", IconItem::new);
    public static final DeferredItem<Item> REISEN = Others.register("reisen", LingXianItem::new);
    public static final DeferredItem<Item> EN_1 = Others.register("en_1", En1Item::new);
    public static final DeferredItem<Item> EN_5 = Others.register("en_5", En5Item::new);
    public static final DeferredItem<Item> EN_10 = Others.register("en_10", En10Item::new);
    public static final DeferredItem<Item> EN_10K = Others.register("en_10k", En10kItem::new);
    public static final DeferredItem<Item> IRON_KNIFE = Others.register("iron_knife", IronKnifeItem::new);

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
        Ingredients.register(eventBus);
        Cuisines.register(eventBus);
        Beverages.register(eventBus);
        Others.register(eventBus);
    }
}