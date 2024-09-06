
package org.hiedacamellia.mystiasizakaya;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.core.data.Data;
import org.hiedacamellia.mystiasizakaya.registries.*;

@Mod("mystias_izakaya")
public class MystiasIzakaya {
	public static final Logger LOGGER = LogManager.getLogger(MystiasIzakaya.class);
	public static final String MODID = "mystias_izakaya";

	public MystiasIzakaya(IEventBus modEventBus, ModContainer modContainer)
	{
		modEventBus.addListener(Data::onGatherData);
		NeoForge.EVENT_BUS.register(this);

		MIBlock.BLOCKS.register(modEventBus);
		MIBlockEntitiy.REGISTRY.register(modEventBus);
		MIItem.register(modEventBus);
		MITab.REGISTRY.register(modEventBus);
		MIMenu.REGISTRY.register(modEventBus);
		MIRecipeType.SERIALIZERS.register(modEventBus);
		MIAttachment.ATTACHMENTS.register(modEventBus);
		MIDatacomponet.DATA_COMPONENTS.register(modEventBus);

		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}
}
