package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.orders.Addorder;
import org.hiedacamellia.mystiasizakaya.content.orders.Deleteorder;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.*;

@EventBusSubscriber
public class MIPlayerEvent {

    @SubscribeEvent
    public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
    }

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        if (event.getOriginal().hasData(MIAttachment.MI_ORDERS)) {
            MIOrders miOrders = event.getOriginal().getData(MIAttachment.MI_ORDERS);
            event.getEntity().setData(MIAttachment.MI_ORDERS, miOrders);
        }
        if (event.getOriginal().hasData(MIAttachment.MI_BALANCE)) {
            MIBalance miBalance = event.getOriginal().getData(MIAttachment.MI_BALANCE);
            event.getEntity().setData(MIAttachment.MI_BALANCE, miBalance);
        }
        if (event.getOriginal().hasData(MIAttachment.MI_TURNOVER)) {
            MITurnover miTurnover = event.getOriginal().getData(MIAttachment.MI_TURNOVER);
            event.getEntity().setData(MIAttachment.MI_TURNOVER, miTurnover);
        }

    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!event.getEntity().hasData(MIAttachment.MI_ORDERS)) {
            event.getEntity().setData(MIAttachment.MI_ORDERS, new MIOrders(new ArrayList<>(10), new ArrayList<>(10), new ArrayList<>(10)));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_MENU)) {
            event.getEntity().setData(MIAttachment.MI_MENU, new MIMenu(new ArrayList<>(10), new ArrayList<>(10), new ArrayList<>(10)));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_BALANCE)) {
            event.getEntity().setData(MIAttachment.MI_BALANCE, new MIBalance(0));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_ON_OPEN)) {
            event.getEntity().setData(MIAttachment.MI_ON_OPEN, new MIOnOpen(false));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_TURNOVER)) {
            event.getEntity().setData(MIAttachment.MI_TURNOVER, new MITurnover(new ArrayList<>(),new ArrayList<>()));
        }
        if(player instanceof ServerPlayer){
            MIMenu miMenu = player.getData(MIAttachment.MI_MENU);
            miMenu.sync(player);
            MIBalance miBalance = player.getData(MIAttachment.MI_BALANCE);
            miBalance.sync(player);
            MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
            miOrders.sync(player);
            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
            miTurnover.sync(player);
            MIOnOpen miOnOpen = player.getData(MIAttachment.MI_ON_OPEN);
            miOnOpen.sync(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        int tick = player.getData(MIAttachment.MI_TELE_COLDDOWN).tick();
        if(tick>0)
            player.setData(MIAttachment.MI_TELE_COLDDOWN,new MITeleColddown(tick-1));



        //TODO：未完成的食堂事件
        if(player instanceof ServerPlayer serverPlayer)
        {
            MIOrders miOrders = serverPlayer.getData(MIAttachment.MI_ORDERS);
            List<BlockPos> tables = new ArrayList<>(miOrders.blockPos());
            List<String> cuisineList = new ArrayList<>(miOrders.orders());
            List<String> beverageList = new ArrayList<>(miOrders.beverages());
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
                MIOrders miOrders1 = new MIOrders(cuisineList,beverageList,tables);
                serverPlayer.setData(MIAttachment.MI_ORDERS,miOrders1);
                PacketDistributor.sendToPlayer(serverPlayer,miOrders1);
            }

//
//            Debug.getLogger().debug(player.getData(MIAttachment.MI_ON_OPEN).toString());
//            Debug.getLogger().debug(tables.toString());

            if(player.getData(MIAttachment.MI_ON_OPEN).open()){
                MIMenu miMenu = player.getData(MIAttachment.MI_MENU);
                Set<ItemStack> beverages = new LinkedHashSet<>();
                Set<ItemStack> cuisines = new LinkedHashSet<>();
                miMenu.beverages().forEach(s -> beverages.add(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s)).getDefaultInstance()));
                miMenu.orders().forEach(s -> cuisines.add(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s)).getDefaultInstance()));
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

                ItemStack cuisine = BuiltInRegistries.ITEM.get(ResourceLocation.parse((cuisineList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                ItemStack beverage = BuiltInRegistries.ITEM.get(ResourceLocation.parse((beverageList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                Level level = serverPlayer.level();
                if(beverage.isEmpty()||cuisine.isEmpty()){
                    return;
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
//                        level.sendBlockUpdated(tables.get(i),level.getBlockState(tables.get(i)),level.getBlockState(tables.get(i)),3);
                        serverPlayer.closeContainer();
                        int cost = cuisine.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost()+beverage.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost();
                        MIBalance miBalance = new MIBalance(serverPlayer.getData(MIAttachment.MI_BALANCE).balance()+cost);
                        serverPlayer.setData(MIAttachment.MI_BALANCE,miBalance);
                        PacketDistributor.sendToPlayer(serverPlayer,miBalance);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        Player player = event.getEntity();
        Entity entity = event.getTarget();


        if(player instanceof ServerPlayer serverPlayer && entity instanceof ItemFrame itemFrame){

//            Debug.getLogger().debug("PlayerEntityInteract");
//            Debug.getLogger().debug(player.toString());
//            Debug.getLogger().debug(entity.toString());

            BlockPos blockPos = itemFrame.getPos();
            ItemStack itemStack = itemFrame.getItem();
//            Debug.getLogger().debug(itemStack.toString());

            if(itemStack.getItem() instanceof MIItem miItem) {
                ResourceLocation key = BuiltInRegistries.ITEM.getKey(miItem);
//                Debug.getLogger().debug(key.toString());

                MIMenu miOrders = serverPlayer.getData(MIAttachment.MI_MENU);
                List<BlockPos> blockPosList = new ArrayList<>(miOrders.blockPos());
                List<String> cuisineList = new ArrayList<>(miOrders.orders());
                List<String> beverageList = new ArrayList<>(miOrders.beverages());
                if(blockPosList.size()<8){
                    for(int i=blockPosList.size()-1;i<8;i++){
                        blockPosList.add(new BlockPos(-1,-1,-1));
                        cuisineList.add("minecraft:air");
                        beverageList.add("minecraft:air");
                    }
                }




                for (int i=0;i<blockPosList.size();i++){
                    BlockPos pos = blockPosList.get(i);
//                    Debug.getLogger().debug(pos.toString());
//                    Debug.getLogger().debug(pos.above().toString());
//                    Debug.getLogger().debug(pos.below().toString());
//                    Debug.getLogger().debug("blockPos{}", blockPos);
                    if ((pos.equals(blockPos)||pos.above().equals(blockPos)||pos.below().equals(blockPos)) && serverPlayer.isShiftKeyDown()) {
                        blockPosList.set(i,new BlockPos(-1, -1, -1));
                        cuisineList.set(i,"minecraft:air");
                        beverageList.set(i,"minecraft:air");
                        break;
                    }
                    if ((pos.equals(blockPos)||pos.above().equals(blockPos)||pos.below().equals(blockPos)) && !serverPlayer.isShiftKeyDown()) {
                        if(itemStack.is(MITag.cuisinesKey)&&!cuisineList.contains(key.toString()))
                            cuisineList.set(i, key.toString());
                        if(itemStack.is(MITag.beveragesKey)&&!beverageList.contains(key.toString()))
                            beverageList.set(i,key.toString());
                        break;
                    }
                    if (Objects.equals(pos, new BlockPos(-1, -1, -1)) && !serverPlayer.isShiftKeyDown()) {
                        blockPosList.set(i,blockPos);
                        break;
                    }
                }
                MIMenu miOrders1 = new MIMenu(cuisineList, beverageList, blockPosList);
                serverPlayer.setData(MIAttachment.MI_MENU, miOrders1);
                PacketDistributor.sendToPlayer(serverPlayer, miOrders1);

                Debug.getLogger().debug(blockPosList.toString());
                Debug.getLogger().debug(cuisineList.toString());
                Debug.getLogger().debug(beverageList.toString());

                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }
}
