package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.api.event.IzakayaEvent;

public class ChangeIzakayaStatusEventJS implements KubeEvent {

    private final IzakayaEvent.ChangeIzakayaStatus event;

    public ChangeIzakayaStatusEventJS(IzakayaEvent.ChangeIzakayaStatus event) {
        this.event = event;
    }

    public Player getPlayer() {
        return event.getPlayer();
    }

    public boolean isOpen() {
        return event.isOpen();
    }

    public boolean isClosed() {
        return event.isClosed();
    }
}
