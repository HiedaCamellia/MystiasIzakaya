
package org.hiedacamellia.mystiasizakaya;

import net.fabricmc.api.ModInitializer;
import org.hiedacamellia.mystiasizakaya.core.config.ClientConfig;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.registies.MIBlockEntityRenderer;
import org.hiedacamellia.mystiasizakaya.registies.MIMenu;
import org.hiedacamellia.mystiasizakaya.registries.*;


public class MystiasIzakayaClient implements ModInitializer {

	public MystiasIzakayaClient() {

		//ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
	}

	@Override
	public void onInitialize() {
		MIMenu.register();
		MIBlockEntityRenderer.register();
	}
}
