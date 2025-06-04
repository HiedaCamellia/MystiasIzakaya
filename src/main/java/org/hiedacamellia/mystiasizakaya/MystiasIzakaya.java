
package org.hiedacamellia.mystiasizakaya;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.core.config.MIClientConfig;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.core.config.json.MIJsonHelper;
import org.hiedacamellia.mystiasizakaya.core.event.MIEvent;
import org.hiedacamellia.mystiasizakaya.registries.*;

@Mod(MystiasIzakaya.MODID)
public class MystiasIzakaya {
	public static final Logger LOGGER = LogManager.getLogger(MystiasIzakaya.class);
	public static final String MODID = "mystias_izakaya";

	public static final boolean kubeJsLoaded = ModList.get().isLoaded("kubejs");

	public MystiasIzakaya(IEventBus modEventBus, ModContainer modContainer)
	{
		modEventBus.addListener(MIEvent::onCommonSetup);

		MIBlock.BLOCKS.register(modEventBus);
		MIBlockEntitiy.REGISTRY.register(modEventBus);
		MIItem.register(modEventBus);
		MITab.REGISTRY.register(modEventBus);
		MIMenu.REGISTRY.register(modEventBus);
		MIRecipeType.RECIPE_SERIALIZERS.register(modEventBus);
		MIRecipeType.RECIPE_TYPES.register(modEventBus);
		MIAttachment.ATTACHMENTS.register(modEventBus);
		MIDatacomponet.DATA_COMPONENTS.register(modEventBus);

		modContainer.registerConfig(ModConfig.Type.COMMON, MICommonConfig.SPEC);
		modContainer.registerConfig(ModConfig.Type.CLIENT, MIClientConfig.SPEC);

		MIJsonHelper.init();

		if(FMLLoader.getDist().isClient())
			modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

	}

	public static ResourceLocation rl(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}
