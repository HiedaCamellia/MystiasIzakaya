package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;

public class IzakayaEvent extends Event {

    private final Player player;

    public IzakayaEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public static class ChangeIzakayaStatus extends IzakayaEvent {

        private final boolean openStatus;

        public ChangeIzakayaStatus(Player player, boolean openStatus) {
            super(player);
            this.openStatus = openStatus;
        }

        public boolean isOpen() {
            return openStatus;
        }

        public boolean isClosed() {
            return !openStatus;
        }
    }

}
