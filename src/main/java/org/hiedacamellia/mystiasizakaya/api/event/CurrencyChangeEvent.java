package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import org.hiedacamellia.immersiveui.client.util.holder.IValueHolder;

public class CurrencyChangeEvent extends Event implements ICancellableEvent {
    private final Player player;
    private final IValueHolder<Integer> amount;
    private final String type;

    public CurrencyChangeEvent(Player player,IValueHolder<Integer> amount, String type) {
        this.player = player;
        this.amount = amount;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public String getType() {
        return type;
    }
}
