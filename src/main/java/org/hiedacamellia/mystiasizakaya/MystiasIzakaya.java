
package org.hiedacamellia.mystiasizakaya;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.hiedacamellia.mystiasizakaya.core.config.ClientConfig;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.*;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod(MystiasIzakaya.MODID)
public class MystiasIzakaya {
	public static final String MODID = "mystias_izakaya";

	public MystiasIzakaya() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		MIBlock.BLOCKS.register(bus);
		MIBlockEntitiy.REGISTRY.register(bus);
		MIItem.register(bus);
		MITab.REGISTRY.register(bus);
		MIMenu.REGISTRY.register(bus);
		MIRecipeType.SERIALIZERS.register(bus);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
	}

}
