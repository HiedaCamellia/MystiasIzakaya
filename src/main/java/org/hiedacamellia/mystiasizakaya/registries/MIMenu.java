package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.BankUiMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingRangeUiMenu;

public class MIMenu {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MystiasIzakaya.MODID);
	public static final DeferredHolder<MenuType<?>,MenuType<CookingRangeUiMenu>> COOKING_RANGE_UI = REGISTRY.register("cooking_range_ui", () -> IMenuTypeExtension.create(CookingRangeUiMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<BankUiMenu>> BANK_UI = REGISTRY.register("bank_ui", () -> IMenuTypeExtension.create(BankUiMenu::new));
}
