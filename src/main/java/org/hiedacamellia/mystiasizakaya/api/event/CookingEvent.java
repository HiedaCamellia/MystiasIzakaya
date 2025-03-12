package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;
import org.jetbrains.annotations.Nullable;

public abstract class CookingEvent extends Event {

    @Nullable
    private final CookingEntity entity;
    private final Level level;

    public CookingEvent(@Nullable CookingEntity entity, Level level) {
        this.entity = entity;
        this.level = level;
    }

    public @Nullable CookingEntity getEntity() {
        return entity;
    }

    public Level getLevel() {
        return level;
    }
}
