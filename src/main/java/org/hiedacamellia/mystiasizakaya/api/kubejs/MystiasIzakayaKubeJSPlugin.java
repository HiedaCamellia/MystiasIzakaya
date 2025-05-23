package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import org.hiedacamellia.mystiasizakaya.api.MystiasIzakayaAPI;

public class MystiasIzakayaKubeJSPlugin implements KubeJSPlugin {

    @Override
    public void init() {

    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(MystiasIzakayaJSEvents.EVENT_GROUP);
    }

    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("MystiasIzakayaAPI",MystiasIzakayaAPI.class);
    }
}
