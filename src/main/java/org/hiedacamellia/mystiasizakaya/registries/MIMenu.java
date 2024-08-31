package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.*;

public class MIMenu {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MystiasIzakaya.MODID);
	public static final DeferredHolder<MenuType<?>,MenuType<CookingRangeUiMenu>> COOKING_RANGE_UI = REGISTRY.register("cooking_range_ui", () -> IMenuTypeExtension.create(CookingRangeUiMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<KitchenwaresUiMenu>> KITCHENWARES_UI = REGISTRY.register("kitchenwares_ui", () -> IMenuTypeExtension.create(KitchenwaresUiMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<DonationUiMenu>> Donation_UI = REGISTRY.register("donation_ui", () -> IMenuTypeExtension.create(DonationUiMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<LedgerUiMenu>> LEDGER_UI = REGISTRY.register("ledger_ui", () -> IMenuTypeExtension.create(LedgerUiMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<TelephoneUiMenu>> Telephone_UI = REGISTRY.register("telephone_ui", () -> IMenuTypeExtension.create(TelephoneUiMenu::new));
}
