package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.api.event.CookingEvent;
import org.hiedacamellia.mystiasizakaya.common.blockentity.CookingEntity;
import org.jetbrains.annotations.Nullable;

public class CookingEventJS implements KubeEvent {

    protected final CookingEvent event;

    public CookingEventJS(CookingEvent event){
        this.event = event;
    }

    public @Nullable CookingEntity getEntity() {
        return event.getEntity();
    }

    public Level getLevel() {
        return event.getLevel();
    }
}
