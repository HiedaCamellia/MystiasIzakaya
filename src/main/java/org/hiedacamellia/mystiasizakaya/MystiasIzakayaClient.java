
package org.hiedacamellia.mystiasizakaya;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraftforge.fml.config.ModConfig;
import org.hiedacamellia.mystiasizakaya.core.config.ClientConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntityRenderer;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;


public class MystiasIzakayaClient implements ClientModInitializer {

	public MystiasIzakayaClient() {

		//ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
	}

	@Override
	public void onInitializeClient() {
		MIMenu.register();
		MIBlockEntityRenderer.register();
		ForgeConfigRegistry.INSTANCE.register(MystiasIzakaya.MODID, ModConfig.Type.CLIENT, ClientConfig.SPEC);
	}
}
