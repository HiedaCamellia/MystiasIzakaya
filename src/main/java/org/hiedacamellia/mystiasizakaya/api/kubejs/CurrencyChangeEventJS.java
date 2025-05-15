package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.mystiasizakaya.api.event.CurrencyChangeEvent;

public class CurrencyChangeEventJS implements KubeEvent {

    private final CurrencyChangeEvent event;

    public CurrencyChangeEventJS(CurrencyChangeEvent event) {
        this.event = event;
    }

    public Player getPlayer() {
        return event.getPlayer();
    }

    public int getAmount() {
        return this.event.getAmount();
    }

    public void setAmount(int amount) {
        this.event.setAmount(amount);
    }

    public String getType() {
        return event.getType();
    }

    public void setCanceled(boolean cancel) {
        this.event.setCanceled(cancel);
    }

    public boolean isCanceled() {
        return this.event.isCanceled();
    }
}
