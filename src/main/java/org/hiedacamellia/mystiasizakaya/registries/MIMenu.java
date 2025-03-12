package org.hiedacamellia.mystiasizakaya.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.CookingMenu;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.TableMenu;

public class MIMenu {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MystiasIzakaya.MODID);
	public static final DeferredHolder<MenuType<?>,MenuType<TableMenu>> TABLE_UI = REGISTRY.register("table_ui", () -> IMenuTypeExtension.create(TableMenu::new));
	public static final DeferredHolder<MenuType<?>,MenuType<CookingMenu>> COOKING_UI = REGISTRY.register("cooking_ui", () -> IMenuTypeExtension.create(CookingMenu::new));
}
