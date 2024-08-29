package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.KitchenwaresUiMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.LedgerUiMenu;

public class MIMenu {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MystiasIzakaya.MODID);
	public static final RegistryObject<MenuType<CookingRangeUiMenu>> COOKING_RANGE_UI = REGISTRY.register("cooking_range_ui", () -> IForgeMenuType.create(CookingRangeUiMenu::new));
	public static final RegistryObject<MenuType<KitchenwaresUiMenu>> KITCHENWARES_UI = REGISTRY.register("kitchenwares_ui", () -> IForgeMenuType.create(KitchenwaresUiMenu::new));
	public static final RegistryObject<MenuType<DonationUiMenu>> Donation_UI = REGISTRY.register("donation_ui", () -> IForgeMenuType.create(DonationUiMenu::new));
	public static final RegistryObject<MenuType<LedgerUiMenu>> LEDGER_UI = REGISTRY.register("ledger_ui", () -> IForgeMenuType.create(LedgerUiMenu::new));
}
