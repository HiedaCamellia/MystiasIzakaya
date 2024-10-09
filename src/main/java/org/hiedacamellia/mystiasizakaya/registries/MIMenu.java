package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import org.hiedacamellia.mystiasizakaya.client.screen.*;
import org.hiedacamellia.mystiasizakaya.content.inventory.*;

public class MIMenu {

	public static final MenuType<CookingRangeUiMenu> COOKING_RANGE_UI = new MenuType<>((syncId, inventory) -> new CookingRangeUiMenu(syncId, inventory, null), FeatureFlagSet.of());

	public static final MenuType<KitchenwaresUiMenu> KITCHENWARES_UI =  new MenuType<>((syncId, inventory) -> new KitchenwaresUiMenu(syncId, inventory, null), FeatureFlagSet.of());
	public static final MenuType<DonationUiMenu> Donation_UI = new MenuType<>((syncId, inventory) -> new DonationUiMenu(syncId, inventory, null), FeatureFlagSet.of());
	public static final MenuType<LedgerUiMenu> LEDGER_UI = new MenuType<>((syncId, inventory) -> new LedgerUiMenu(syncId, inventory, null), FeatureFlagSet.of());
	public static final MenuType<TableUiMenu> TABLE_UI = new MenuType<>((syncId, inventory) -> new TableUiMenu(syncId, inventory, null), FeatureFlagSet.of());
	public static final MenuType<TelephoneUiMenu> Telephone_UI = new MenuType<>((syncId, inventory) -> new TelephoneUiMenu(syncId, inventory, null), FeatureFlagSet.of());

	public static void register(){
		MenuScreens.register(COOKING_RANGE_UI, CookingRangeUiScreen::new);
		MenuScreens.register(KITCHENWARES_UI, KitchenwaresUiScreen::new);
		MenuScreens.register(Donation_UI, DonationUiScreen::new);
		MenuScreens.register(LEDGER_UI, LedgerUiScreen::new);
		MenuScreens.register(TABLE_UI, TableUiScreen::new);
		MenuScreens.register(Telephone_UI, TelephoneUiScreen::new);
	}
}
