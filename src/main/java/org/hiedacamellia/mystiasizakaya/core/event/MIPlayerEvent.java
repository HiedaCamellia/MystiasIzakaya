package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.Config;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class MIPlayerEvent {

    public static double getBalance(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).balance;
    }

    public static void setBalance(Player player, double balance) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.balance = balance);
    }

    public static void changeBalance(Player player, double balance) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.balance += balance);
    }

    public static void addOrder(Player player, String order) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.orders.add(order));
    }

    public static void addOrderBeverages(Player player, String order) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.ordersbeverages.add(order));
    }

    public static void addTurnoverPre(Player player, String turnover) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.turnover_pre.add(turnover));
    }

    public static void addTurnoverCha(Player player, int turnover) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.trunover_cha.add(turnover));
    }

    public static void addTurnover(Player player, String turnover, int turnover_cha) {
        addTurnoverPre(player, turnover);
        addTurnoverCha(player, turnover_cha);
    }



    public static List<String> getOrders(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).orders;
    }

    public static void setOrders(Player player, List<String> orders) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.orders = orders);
    }

    public static List<String> getOrdersBeverages(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).ordersbeverages;
    }

    public static void setOrdersBeverages(Player player, List<String> ordersbeverages) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> variables.ordersbeverages = ordersbeverages);
    }

    public static List<String> getTurnoverPre(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).turnover_pre;
    }

    public static List<Integer> getTurnoverCha(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).trunover_cha;
    }

    public static void syncPlayerVariables(Player player) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(player);
    }

    public static void deleteOverTurnover(Player player) {
        List<String> turnover_pre = getTurnoverPre(player);
        List<Integer> turnover_cha = getTurnoverCha(player);
        while (turnover_pre.size() > Config.MAX_OVERTURN.get()) {
            turnover_pre.remove(0);
            turnover_cha.remove(0);
        }
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        MystiasIzakaya.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            event.getOriginal().revive();
            PlayerVariables original = event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            PlayerVariables clone = event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            clone.balance = original.balance;
            clone.orders = original.orders;
            clone.ordersbeverages = original.ordersbeverages;
            clone.turnover_pre = original.turnover_pre;
            clone.trunover_cha = original.trunover_cha;
        }
    }


    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
    });

    @Mod.EventBusSubscriber
    private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
                event.addCapability(new ResourceLocation("mystias_izakaya", "player_variables"), new PlayerVariablesProvider());
        }

        private final PlayerVariables playerVariables = new PlayerVariables();
        private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerVariables.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            playerVariables.readNBT(nbt);
        }
    }

    public static class PlayerVariables {
        public double balance = 0;
        public List<String> orders = new ArrayList<>(10);
        public List<String> ordersbeverages = new ArrayList<>(10);
        public List<String> turnover_pre = new ArrayList<>(10);
        public List<Integer> trunover_cha = new ArrayList<>(10);

        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer)
                MystiasIzakaya.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putDouble("balance", balance);
            String orders_string = String.join(",", orders);
            String ordersbeverages_string = String.join(",", ordersbeverages);
            nbt.putString("orders", orders_string);
            nbt.putString("ordersbeverages", ordersbeverages_string);
            String turnover_pre_string = String.join(",", turnover_pre);
            nbt.putString("turnover_pre", turnover_pre_string);
            nbt.putIntArray("turnover_cha", trunover_cha);
            return nbt;
        }

        public void readNBT(Tag Tag) {
            CompoundTag nbt = (CompoundTag) Tag;
            balance = nbt.getDouble("balance");
            String orders_string = nbt.getString("orders");
            String ordersbeverages_string = nbt.getString("ordersbeverages");
            orders = new ArrayList<>(List.of(orders_string.split(",")));
            ordersbeverages = new ArrayList<>(List.of(ordersbeverages_string.split(",")));
            String turnover_pre_string = nbt.getString("turnover_pre");
            turnover_pre = new ArrayList<>(List.of(turnover_pre_string.split(",")));
            trunover_cha = Arrays.stream(nbt.getIntArray("turnover_cha")).boxed().toList();
        }
    }

    public static class PlayerVariablesSyncMessage {
        private final PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(buffer.readNbt());
        }

        public PlayerVariablesSyncMessage(PlayerVariables data) {
            this.data = data;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt((CompoundTag) message.data.writeNBT());
        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
                    variables.balance = message.data.balance;
                    variables.orders = message.data.orders;
                    variables.ordersbeverages = message.data.ordersbeverages;
                    variables.turnover_pre = message.data.turnover_pre;
                    variables.trunover_cha = message.data.trunover_cha;
                }
            });
            context.setPacketHandled(true);
        }
    }
}
