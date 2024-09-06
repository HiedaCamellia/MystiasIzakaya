package org.hiedacamellia.mystiasizakaya.core.event;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;

@EventBusSubscriber
public class MIEvent {

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        Debug.getLogger().debug("Ciallo～(∠・ω< )⌒★");
    }
}
