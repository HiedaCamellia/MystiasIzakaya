
package org.hiedacamellia.mystiasizakaya;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.core.config.ClientConfig;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.core.data.Data;
import org.hiedacamellia.mystiasizakaya.core.event.MIEvent;
import org.hiedacamellia.mystiasizakaya.registries.*;

@Mod("mystias_izakaya")
public class MystiasIzakaya {
	public static final Logger LOGGER = LogManager.getLogger(MystiasIzakaya.class);
	public static final String MODID = "mystias_izakaya";

	public MystiasIzakaya(IEventBus modEventBus, ModContainer modContainer)
	{
		modEventBus.addListener(Data::onGatherData);
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

		modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
		modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
		if(FMLLoader.getDist().isClient())
			modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

	}
}
