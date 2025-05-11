package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;

public class MystiasIzakayaKubeJSPlugin implements KubeJSPlugin {

    @Override
    public void init() {

    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(MystiasIzakayaJSEvents.EVENT_GROUP);
    }


}
