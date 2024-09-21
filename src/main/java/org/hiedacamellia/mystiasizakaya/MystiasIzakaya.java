
package org.hiedacamellia.mystiasizakaya;

import net.fabricmc.api.ModInitializer;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.*;


public class MystiasIzakaya implements ModInitializer {
	public static final String MODID = "mystias_izakaya";

	public MystiasIzakaya() {

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
	}

	@Override
	public void onInitialize() {
		MIBlock.register();
		MIBlockEntitiy.register();
		MIItem.register();
		MITab.register();
		MIRecipeType.register();


	}
}
