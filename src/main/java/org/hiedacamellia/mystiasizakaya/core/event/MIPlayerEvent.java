package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.orders.Addorder;
import org.hiedacamellia.mystiasizakaya.content.orders.Deleteorder;
import org.hiedacamellia.mystiasizakaya.core.config.CommonConfig;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;
import org.hiedacamellia.mystiasizakaya.core.network.MINetWork;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MIPlayerEvent {

    public static double getBalance(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).balance;
    }

    public static void setBalance(Player player, double balance) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.balance = balance;
            variables.syncPlayerVariables(player);
        });
    }
    public static int getTelecolddown(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).telecolddown;
    }

    public static void setTelecolddown(Player player, int telecolddown) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.telecolddown = telecolddown;
            variables.syncPlayerVariables(player);
        });
    }

    public static void changeBalance(Player player, double balance) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.balance += balance;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addOrder(Player player, String order) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> orders = new ArrayList<>(variables.orders);
            orders.add(order);
            variables.orders = orders;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addOrderBeverages(Player player, String order) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> orders = new ArrayList<>(variables.ordersbeverages);
            orders.add(order);
            variables.ordersbeverages = orders;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addTurnoverPre(Player player, String turnover) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> turnover_pre = new ArrayList<>(variables.turnover_pre);
            turnover_pre.add(turnover);
            variables.turnover_pre = turnover_pre;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addTurnoverCha(Player player, int turnover) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<Integer> turnover_cha = new ArrayList<>(variables.trunover_cha);
            turnover_cha.add(turnover);
            variables.trunover_cha = turnover_cha;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addTurnover(Player player, String turnover, int turnover_cha) {
        addTurnoverPre(player, turnover);
        addTurnoverCha(player, turnover_cha);
    }



    public static List<String> getOrders(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).orders;
    }

    public static void setOrders(Player player, List<String> orders) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.orders = orders;
            variables.syncPlayerVariables(player);
        });
    }

    public static List<String> getOrdersBeverages(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).ordersbeverages;
    }

    public static void setOrdersBeverages(Player player, List<String> ordersbeverages) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(
                variables -> {
                    variables.ordersbeverages = ordersbeverages;
                    variables.syncPlayerVariables(player);
                });
    }

    public static List<String> getTurnoverPre(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).turnover_pre;
    }

    public static List<Integer> getTurnoverCha(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).trunover_cha;
    }

    public static void syncPlayerVariables(Player player) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(
                variables -> variables.syncPlayerVariables(player)
        );
    }

    public static void deleteOverTurnover(Player player) {
        List<String> turnover_pre = getTurnoverPre(player);
        List<Integer> turnover_cha = getTurnoverCha(player);
        while (turnover_pre.size() > CommonConfig.MAX_OVERTURN.get()) {
            turnover_pre.remove(0);
            turnover_cha.remove(0);
        }
    }

    public static void addTable(Player player, BlockPos pos) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<BlockPos> tables = new ArrayList<>(variables.tables);
            tables.add(pos);
            variables.tables = tables;
            variables.syncPlayerVariables(player);
        });
    }

    public static void removeTable(Player player, BlockPos pos) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<BlockPos> tables = new ArrayList<>(variables.tables);
            tables.remove(pos);
            variables.tables = tables;
            variables.syncPlayerVariables(player);
        });
    }

    public static List<BlockPos> getTables(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).tables;
    }

    public static void setTables(Player player, List<BlockPos> tables) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.tables = tables;
            variables.syncPlayerVariables(player);
        });
    }


    public static void addMenu(Player player, BlockPos pos) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<BlockPos> menus = new ArrayList<>(variables.menus);
            menus.add(pos);
            variables.menus = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void removeMenu(Player player, BlockPos pos) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<BlockPos> menus = new ArrayList<>(variables.menus);
            menus.remove(pos);
            variables.menus = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static List<BlockPos> getMenuBlockPos(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).menus;
    }

    public static void setMenuBlockPos(Player player, List<BlockPos> menus) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.menus = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addMenu(Player player, String menu) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> menus = new ArrayList<>(variables.menu);
            menus.add(menu);
            variables.menu = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void removeMenu(Player player, String menu) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> menus = new ArrayList<>(variables.menu);
            menus.remove(menu);
            variables.menu = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static List<String> getMenus(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).menu;
    }

    public static void setMenus(Player player, List<String> menus) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.menu = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void addMenuBeverages(Player player, String menu) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> menus = new ArrayList<>(variables.menubeverages);
            menus.add(menu);
            variables.menubeverages = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void removeMenuBeverages(Player player, String menu) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            List<String> menus = new ArrayList<>(variables.menubeverages);
            menus.remove(menu);
            variables.menubeverages = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static List<String> getMenusBeverages(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).menubeverages;
    }

    public static void setMenusBeverages(Player player, List<String> menus) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.menubeverages = menus;
            variables.syncPlayerVariables(player);
        });
    }

    public static void setOnOpen(Player player, boolean on_open) {
        player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).ifPresent(variables -> {
            variables.on_open = on_open;
            variables.syncPlayerVariables(player);
        });
    }

    public static boolean getOnOpen(Player player) {
        return player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).on_open;
    }



    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        MINetWork.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (event.getEntity() instanceof ServerPlayer serverPlayer)
                serverPlayer.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(serverPlayer);
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (event.getEntity() instanceof ServerPlayer serverPlayer)
                syncPlayerVariables(serverPlayer);
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (event.getEntity() instanceof ServerPlayer serverPlayer)
                syncPlayerVariables(serverPlayer);
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
            clone.tables = original.tables;
            clone.menu = original.menu;
            clone.menubeverages = original.menubeverages;
            clone.menus = original.menus;
            clone.on_open = original.on_open;
        }

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            Player player = event.player;
            if (event.phase == TickEvent.Phase.END) {
                if (player instanceof ServerPlayer serverPlayer) {
                    int telecolddown = getTelecolddown(serverPlayer);
                    if (telecolddown > 0) {
                        setTelecolddown(serverPlayer, telecolddown - 1);
                    }
                }
            }
            //
            if(player instanceof ServerPlayer serverPlayer)
            {

                List<BlockPos> tables = getTables(serverPlayer);
                List<String> cuisineList = getOrders(serverPlayer);
                List<String> beverageList = getOrdersBeverages(serverPlayer);
                if(tables.size()<8||cuisineList.size()<8||beverageList.size()<8){
                    if(tables.size()<8){
                        for(int i=tables.size();i<8;i++){
                            tables.add(new BlockPos(-1,-1,-1));
                        }
                    }
                    if(cuisineList.size()<8){
                        for(int i=cuisineList.size();i<8;i++){
                            cuisineList.add("minecraft:air");
                        }
                    }
                    if(beverageList.size()<8){
                        for(int i=beverageList.size();i<8;i++){
                            beverageList.add("minecraft:air");
                        }
                    }
                    setTables(serverPlayer,tables);
                    setOrders(serverPlayer,cuisineList);
                    setOrdersBeverages(serverPlayer,beverageList);
                }

//
//            Debug.getLogger().debug(player.getData(MIAttachment.MI_ON_OPEN).toString());
//            Debug.getLogger().debug(tables.toString());

                if(getOnOpen(serverPlayer)){

                    Set<ItemStack> beverages = new LinkedHashSet<>();
                    Set<ItemStack> cuisines = new LinkedHashSet<>();
                    getMenus(serverPlayer).forEach(s -> beverages.add(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s)).getDefaultInstance()));
                    getMenusBeverages(serverPlayer).forEach(s -> cuisines.add(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s)).getDefaultInstance()));
                    beverages.remove(ItemStack.EMPTY);
                    cuisines.remove(ItemStack.EMPTY);
                    if(beverages.isEmpty()||cuisines.isEmpty()){
                        return;
                    }

                    List<ItemStack> beverageslist = new ArrayList<>(beverages);
                    List<ItemStack> cuisineslist = new ArrayList<>(cuisines);
//
//                Debug.getLogger().debug(beveragesList.toString());
//                Debug.getLogger().debug(cuisinesList.toString());

                    for(BlockPos pos : tables){
                        if(pos.equals(new BlockPos(-1,-1,-1))){
                            continue;
                        }
                        if(Math.random()<0.0029){
                            if(beverageList.get(tables.indexOf(pos)).equals("minecraft:air")&&cuisineList.get(tables.indexOf(pos)).equals("minecraft:air")){
                                ItemStack beverage = beverageslist.get((int) (Math.random() * beverages.size()));
                                ItemStack cuisine = cuisineslist.get((int) (Math.random() * cuisines.size()));
                                if(beverage.isEmpty()||cuisine.isEmpty()){
                                    return;
                                }
                                Addorder.execute(beverage, cuisine, tables.indexOf(pos), serverPlayer);
                            }
                            break;
                        }
                    }
                }
                for(int i = 0; i < tables.size();i++){
                    if(tables.get(i).equals(new BlockPos(-1,-1,-1))){
                        continue;
                    }
//                Debug.getLogger().debug(tables.get(i).toString());

                    ItemStack cuisine = ForgeRegistries.ITEMS.getValue(new ResourceLocation((cuisineList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                    ItemStack beverage = ForgeRegistries.ITEMS.getValue(new ResourceLocation((beverageList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                    Level level = serverPlayer.level();
                    if(beverage.isEmpty()||cuisine.isEmpty()){
                        continue;
                    }
                    BlockEntity blockEntity =  level.getBlockEntity(tables.get(i));
                    if (blockEntity != null) {
                        Debug.getLogger().debug(blockEntity.toString());
                    }

                    if(blockEntity instanceof TableEntity tableEntity){
                        List<ItemStack> itemStacks= tableEntity.getItems();
                        Debug.getLogger().debug(itemStacks.toString());
                        Debug.getLogger().debug(cuisine.toString());
                        Debug.getLogger().debug(beverage.toString());

                        if(ItemStack.isSameItem(itemStacks.get(0),cuisine)&&ItemStack.isSameItem(itemStacks.get(1),beverage)){
                            Deleteorder.execute(i,serverPlayer);
                            tableEntity.clearContent();
                            level.setBlockEntity(tableEntity);
//                          level.sendBlockUpdated(tables.get(i),level.getBlockState(tables.get(i)),level.getBlockState(tables.get(i)),3);
                            serverPlayer.closeContainer();
                            int cost = cuisine.getOrCreateTag().getInt("cost")+beverage.getOrCreateTag().getInt("cost");
                            setBalance(serverPlayer,getBalance(serverPlayer)+cost);
                            addTurnover(serverPlayer,"from_table",cost);
                        }
                    }
                }
            }

        }

        @SubscribeEvent
        public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteractSpecific event) {
            Player player = event.getEntity();
            Entity entity = event.getTarget();


            if (player instanceof ServerPlayer serverPlayer && entity instanceof ItemFrame itemFrame) {


                BlockPos blockPos = itemFrame.getPos();
                ItemStack itemStack = itemFrame.getItem();

                if (itemStack.getItem() instanceof MIItem miItem) {
                    ResourceLocation key = ForgeRegistries.ITEMS.getKey(miItem);

                    List<BlockPos> blockPosList = getMenuBlockPos(serverPlayer);
                    List<String> cuisineList = getMenus(serverPlayer);
                    List<String> beverageList = getMenusBeverages(serverPlayer);
                    if (blockPosList.size() < 8) {
                        for (int i = blockPosList.size() - 1; i < 8; i++) {
                            blockPosList.add(new BlockPos(-1, -1, -1));
                            cuisineList.add("minecraft:air");
                            beverageList.add("minecraft:air");
                        }
                    }


                    for (int i = 0; i < blockPosList.size(); i++) {
                        BlockPos pos = blockPosList.get(i);
                        if ((pos.equals(blockPos) || pos.above().equals(blockPos) || pos.below().equals(blockPos)) && serverPlayer.isShiftKeyDown()) {
                            blockPosList.set(i, new BlockPos(-1, -1, -1));
                            cuisineList.set(i, "minecraft:air");
                            beverageList.set(i, "minecraft:air");
                            serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.unbound", i + 1, blockPos.getX(), blockPos.getY(), blockPos.getZ()));
                            break;
                        }
                        if ((pos.equals(blockPos) || pos.above().equals(blockPos) || pos.below().equals(blockPos)) && !serverPlayer.isShiftKeyDown()) {
                            if (itemStack.is(MITag.cuisinesKey) && !cuisineList.contains(key.toString())) {
                                serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.cuisine", itemStack.getDisplayName().getString(), i + 1));
                                cuisineList.set(i, key.toString());
                            }
                            if (itemStack.is(MITag.beveragesKey) && !beverageList.contains(key.toString())) {
                                serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.beverage", itemStack.getDisplayName().getString(), i + 1));
                                beverageList.set(i, key.toString());
                            }
                            break;
                        }
                        if (Objects.equals(pos, new BlockPos(-1, -1, -1)) && !serverPlayer.isShiftKeyDown()) {
                            blockPosList.set(i, blockPos);
                            serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.bound", i + 1, blockPos.getX(), blockPos.getY(), blockPos.getZ()));
                            break;
                        }
                    }
                    setMenuBlockPos(serverPlayer, blockPosList);
                    setMenus(serverPlayer, cuisineList);
                    setMenusBeverages(serverPlayer, beverageList);

                    Debug.getLogger().debug(blockPosList.toString());
                    Debug.getLogger().debug(cuisineList.toString());
                    Debug.getLogger().debug(beverageList.toString());

                    event.setCancellationResult(InteractionResult.SUCCESS);
                }
            }
        }
    }


    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
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
            playerVariables.readNBT((CompoundTag) nbt);
        }
    }

    public static class PlayerVariables {
        public double balance = 0;
        public int telecolddown =0;
        public boolean on_open = false;
        public List<String> orders = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
        public List<String> ordersbeverages = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
        public List<BlockPos> tables = new ArrayList<>();
        public List<String> menu = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
        public List<String> menubeverages = List.of("minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air", "minecraft:air","minecraft:air");
        public List<BlockPos> menus = new ArrayList<>();
        public List<String> turnover_pre = List.of();
        public List<Integer> trunover_cha =List.of();

        public void syncPlayerVariables(Entity entity) {
//            Debug.getLogger().debug("syncPlayerVariables");
//            Debug.getLogger().debug("balance: " + balance);
//            Debug.getLogger().debug("orders: " + orders);
//            Debug.getLogger().debug("ordersbeverages: " + ordersbeverages);
//            Debug.getLogger().debug("turnover_pre: " + turnover_pre);
//            Debug.getLogger().debug("turnover_cha: " + trunover_cha);
            if (entity instanceof ServerPlayer serverPlayer)
                MINetWork.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
        }

        public CompoundTag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putDouble("balance", balance);
            nbt.putInt("telecolddown", telecolddown);
            String orders_string = String.join(",", orders);
            String ordersbeverages_string = String.join(",", ordersbeverages);
            nbt.putString("orders", orders_string);
            nbt.putString("ordersbeverages", ordersbeverages_string);
            String turnover_pre_string = String.join(",", turnover_pre);
            nbt.putString("turnover_pre", turnover_pre_string);
            nbt.putIntArray("turnover_cha", trunover_cha);
            nbt.putString("tables", BlockPos2String(tables));
            nbt.putString("menu", String.join(",", menu));
            nbt.putString("menubeverages", String.join(",", menubeverages));
            nbt.putString("menus", BlockPos2String(menus));
            nbt.putBoolean("on_open", on_open);
            return nbt;
        }

        public void readNBT(CompoundTag Tag) {
            balance = Tag.getDouble("balance");
            telecolddown = Tag.getInt("telecolddown");
            String orders_string = Tag.getString("orders");
            String ordersbeverages_string = Tag.getString("ordersbeverages");
            orders = new ArrayList<>(List.of(orders_string.split(",")));
            ordersbeverages = new ArrayList<>(List.of(ordersbeverages_string.split(",")));
            String turnover_pre_string = Tag.getString("turnover_pre");
            turnover_pre = new ArrayList<>(List.of(turnover_pre_string.split(",")));
            trunover_cha = Arrays.stream(Tag.getIntArray("turnover_cha")).boxed().toList();
            tables = String2BlockPosList(Tag.getString("tables"));
            menu = new ArrayList<>(List.of(Tag.getString("menu").split(",")));
            menubeverages = new ArrayList<>(List.of(Tag.getString("menubeverages").split(",")));
            menus = String2BlockPosList(Tag.getString("menus"));
            on_open = Tag.getBoolean("on_open");
        }
    }

    public static class PlayerVariablesSyncMessage {
        private final PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(Objects.requireNonNull(buffer.readNbt()));
        }

        public PlayerVariablesSyncMessage(PlayerVariables data) {
            this.data = data;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt(message.data.writeNBT());
        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables;
                    if (Minecraft.getInstance().player != null) {
                        variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
                        variables.balance = message.data.balance;
                        variables.telecolddown = message.data.telecolddown;
                        variables.orders = message.data.orders;
                        variables.ordersbeverages = message.data.ordersbeverages;
                        variables.turnover_pre = message.data.turnover_pre;
                        variables.trunover_cha = message.data.trunover_cha;
                        variables.tables = message.data.tables;
                        variables.menu = message.data.menu;
                        variables.menubeverages = message.data.menubeverages;
                        variables.menus = message.data.menus;
                        variables.on_open = message.data.on_open;
                    }
                }
            });
            context.setPacketHandled(true);
        }
    }

    private static String BlockPos2String(BlockPos pos){
        return pos.getX() + "," + pos.getY() + "," + pos.getZ();
    }
    private static String BlockPos2String(List<BlockPos> pos){
        if(pos.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (BlockPos p : pos){
            sb.append(BlockPos2String(p));
            sb.append(";");
        }
        return sb.toString();
    }
    private static BlockPos String2BlockPos(String str){
        String[] pos = str.split(",");
        return new BlockPos(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]), Integer.parseInt(pos[2]));
    }
    private static List<BlockPos> String2BlockPosList(String str){
        if(str.isEmpty())
            return new ArrayList<>();
        List<BlockPos> pos = new ArrayList<>();
        String[] posList = str.split(";");
        for (String p : posList){
            pos.add(String2BlockPos(p));
        }
        return pos;
    }
}
