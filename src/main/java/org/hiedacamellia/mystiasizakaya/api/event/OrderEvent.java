package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import org.hiedacamellia.mystiasizakaya.util.IntHolder;

public abstract class OrderEvent extends Event {

    private final Player player;
    private final ItemStack beverages;
    private final ItemStack cuisines;
    private final int id;

    public OrderEvent(Player player, ItemStack cuisines, ItemStack beverages,int id) {
        this.player = player;
        this.beverages = beverages;
        this.cuisines = cuisines;
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemStack getBeverages() {
        return beverages;
    }

    public ItemStack getCuisines() {
        return cuisines;
    }

    public int getId() {
        return id;
    }

    public static class Add extends OrderEvent {
        public Add(Player player, ItemStack cuisines, ItemStack beverages,int id) {
            super(player,cuisines,beverages,id);
        }
    }
    public static class Remove extends OrderEvent {
        public Remove(Player player, ItemStack cuisines, ItemStack beverages, int id) {
            super(player,cuisines,beverages,id);
        }
    }
    public static class Complete extends OrderEvent {
        private final IntHolder earned;
        public Complete(Player player, ItemStack cuisines, ItemStack beverages, int id, IntHolder earned) {
            super(player,cuisines,beverages,id);
            this.earned = earned;
        }
        public IntHolder getEarned() {
            return earned;
        }
    }
}
