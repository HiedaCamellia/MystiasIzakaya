package org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s;

import org.hiedacamellia.immersiveui.client.gui.component.w2s.World2ScreenWidget;
import org.hiedacamellia.immersiveui.client.gui.layer.World2ScreenWidgetLayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExistW2SWidget {

    private static final Map<UUID, World2ScreenWidget> map= new HashMap<>();

    public static void removeALL(){
        map.keySet().forEach(World2ScreenWidgetLayer.INSTANCE::remove);
        map.clear();
    }

    public static void add(UUID uuid, World2ScreenWidget widget){
        map.put(uuid, widget);
        World2ScreenWidgetLayer.INSTANCE.addWorldPositionObject(uuid,widget);
    }

    public static void remove(UUID uuid){
        map.remove(uuid);
        World2ScreenWidgetLayer.INSTANCE.remove(uuid);
    }

    public static World2ScreenWidget get(UUID uuid){
        return map.get(uuid);
    }
}
