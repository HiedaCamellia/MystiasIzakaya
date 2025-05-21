package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;
import org.hiedacamellia.mystiasizakaya.api.kubejs.MIEventPoster;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.order.OrderUtils;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.util.BalanceUtil;
import org.hiedacamellia.immersiveui.client.util.holder.IntHolder;

import java.util.*;

@EventBusSubscriber
public class MIPlayerEvent {

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        if (event.getOriginal().hasData(MIAttachment.MI_ORDERS)) {
            MIOrders miOrders = event.getOriginal().getData(MIAttachment.MI_ORDERS);
            event.getEntity().setData(MIAttachment.MI_ORDERS, miOrders);
        }
        if (event.getOriginal().hasData(MIAttachment.MI_MENU)) {
            MIMenu miMenu = event.getOriginal().getData(MIAttachment.MI_MENU);
            event.getEntity().setData(MIAttachment.MI_MENU, miMenu);
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
            event.getEntity().setData(MIAttachment.MI_ORDERS, MIOrders.init());
        }
        if (!event.getEntity().hasData(MIAttachment.MI_MENU)) {
            event.getEntity().setData(MIAttachment.MI_MENU, MIMenu.init());
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
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        int tick = player.getData(MIAttachment.MI_TELE_COLDDOWN).tick();
        if(tick>0)
            player.setData(MIAttachment.MI_TELE_COLDDOWN,new MITeleColddown(tick-1));

        if(player instanceof ServerPlayer serverPlayer)
        {
            MIOrders miOrders = serverPlayer.getData(MIAttachment.MI_ORDERS);
            List<BlockPos> tables = new ArrayList<>(miOrders.blockPos());
            List<String> cuisineList = new ArrayList<>(miOrders.cuisines());
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

            if(player.getData(MIAttachment.MI_ON_OPEN).open()&&serverPlayer.level().getGameTime()% MICommonConfig.ORDER_REFRESH_INTERVAL.get()==0){
                MIMenu miMenu = player.getData(MIAttachment.MI_MENU);
                Set<ItemStack> beverages = new LinkedHashSet<>();
                Set<ItemStack> cuisines = new LinkedHashSet<>();
                miMenu.beverages().forEach(s -> beverages.add(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s)).getDefaultInstance()));
                miMenu.cuisines().forEach(s -> cuisines.add(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s)).getDefaultInstance()));
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
                    if(Math.random()< MICommonConfig.ORDER_REFRESH_PROBABILITY.get()){
                        if(beverageList.get(tables.indexOf(pos)).equals("minecraft:air")&&cuisineList.get(tables.indexOf(pos)).equals("minecraft:air")){
                            ItemStack beverage = beverageslist.get((int) (Math.random() * beverages.size()));
                            ItemStack cuisine = cuisineslist.get((int) (Math.random() * cuisines.size()));
                            if(beverage.isEmpty()||cuisine.isEmpty()){
                                break;
                            }
                            OrderUtils.add(beverage, cuisine, tables.indexOf(pos), serverPlayer);
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


//                Debug.getLogger().debug(cuisine.toString());
//                Debug.getLogger().debug(beverage.toString());

                if(beverage.isEmpty()||cuisine.isEmpty()){
                    continue;
                }
                BlockEntity blockEntity =  level.getBlockEntity(tables.get(i));
                if (blockEntity != null) {
//                    Debug.getLogger().debug(blockEntity.toString());
                }

                if(blockEntity instanceof TableEntity tableEntity){
                    List<ItemStack> itemStacks= tableEntity.getItems();
//                    Debug.getLogger().debug(itemStacks.toString());

                    if(ItemStack.isSameItem(itemStacks.get(0),cuisine)&&ItemStack.isSameItem(itemStacks.get(1),beverage)){
                        OrderUtils.remove(i,serverPlayer);
                        tableEntity.clearContent();
                        level.setBlockEntity(tableEntity);
//                        level.sendBlockUpdated(tables.get(i),level.getBlockState(tables.get(i)),level.getBlockState(tables.get(i)),3);
                        serverPlayer.closeContainer();
                        int cost = cuisine.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost()+beverage.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost();
                        IntHolder intHolder = new IntHolder(cost);
                        OrderEvent.Complete complete = new OrderEvent.Complete(serverPlayer, cuisine, beverage, i, intHolder);
                        NeoForge.EVENT_BUS.post(complete);
                        if(MystiasIzakaya.kubeJsLoaded)
                            MIEventPoster.INSTANCE.post(complete);

                        BalanceUtil.table(player, intHolder.get());

                    }
                }
            }
        }
    }

}
