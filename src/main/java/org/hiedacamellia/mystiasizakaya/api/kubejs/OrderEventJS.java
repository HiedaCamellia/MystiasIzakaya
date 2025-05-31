package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.immersiveui.util.holder.IntHolder;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;

public abstract class OrderEventJS implements KubeEvent {

    private final OrderEvent event;

    public OrderEventJS(OrderEvent event) {
        this.event = event;
    }

    public Player getPlayer() {
        return event.getPlayer();
    }

    public ItemStack getBeverages() {
        return event.getBeverages();
    }

    public ItemStack getCuisines() {
        return event.getCuisines();
    }

    public int getId() {
        return event.getId();
    }

    public static class Add extends OrderEventJS {
        public Add(OrderEvent.Add event) {
            super(event);
        }
    }
    public static class Remove extends OrderEventJS {
        public Remove(OrderEvent.Remove event) {
            super(event);
        }
    }
    public static class Complete extends OrderEventJS {
        private final IntHolder earned;
        public Complete(OrderEvent.Complete event) {
            super(event);
            this.earned = event.getEarned();
        }
        public int getEarned() {
            return this.earned.get();
        }
        public void setEarned(int earned) {
            this.earned.set(earned);
        }
    }
}
