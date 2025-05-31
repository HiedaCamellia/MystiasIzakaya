package org.hiedacamellia.mystiasizakaya.core.event;

import net.minecraft.core.BlockPos;
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
import org.hiedacamellia.immersiveui.util.holder.IntHolder;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;
import org.hiedacamellia.mystiasizakaya.api.kubejs.MIEventPoster;
import org.hiedacamellia.mystiasizakaya.common.blockentity.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaMenu;
import org.hiedacamellia.mystiasizakaya.content.izakaya.IzakayaOrder;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIPlayerUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber
public class MIPlayerEvent {

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        Player from = event.getOriginal();
        Player to = event.getEntity();
        if (from.hasData(MIAttachment.IZAKAYA_ORDER)) {
            MIPlayerUtil.copyIzakayaOrder(from,to);
        }
        if (from.hasData(MIAttachment.IZAKAYA_MENU)) {
            MIPlayerUtil.copyIzakayaMenu(from, to);
        }
        if (from.hasData(MIAttachment.MI_BALANCE)) {
            MIPlayerUtil.copyBalance(from, to);
        }
        if (from.hasData(MIAttachment.MI_ON_OPEN)) {
            MIPlayerUtil.copyOnOpen(from, to);
        }
        if (from.hasData(MIAttachment.MI_TURNOVER)) {
            MIPlayerUtil.copyTurnover(from,to);
        }
        if (from.hasData(MIAttachment.MI_TELE_COOLDOWN)) {
            MIPlayerUtil.copyTeleCooldown(from,to);
        }
        if (from.hasData(MIAttachment.IZAKAYA_TABLE)) {
            MIPlayerUtil.copyTables(from,to);
        }

    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if(player instanceof ServerPlayer serverPlayer){
            MIPlayerUtil.syncIzakayaMenu(serverPlayer);
            MIPlayerUtil.syncBalance(serverPlayer);
            MIPlayerUtil.syncIzakayaOrder(serverPlayer);
            MIPlayerUtil.syncTurnover(serverPlayer);
            MIPlayerUtil.syncOnOpen(serverPlayer);
            MIPlayerUtil.syncTables(serverPlayer);
            ItemPriceAddon.sync(serverPlayer);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        int tick = MIPlayerUtil.getTeleCooldown(player);
        if(tick>0)
            MIPlayerUtil.setTeleCooldown(player,tick-1);

        if(tick==0)
            MIPlayerUtil.setTeleCooldown(player,-1);

        if(player instanceof ServerPlayer serverPlayer)
        {
            IzakayaOrder izakayaOrder = MIPlayerUtil.getIzakayaOrder(player);
            List<BlockPos> tables = MIPlayerUtil.getTables(player);
            List<ItemStack> cuisineList = izakayaOrder.toCuisineStacks();
            List<ItemStack> beverageList = izakayaOrder.toBeverageStacks();
            if(tables.size()<8||cuisineList.size()<8||beverageList.size()<8){
                if(tables.size()<8){
                    for(int i=tables.size();i<8;i++){
                        tables.add(new BlockPos(-1,-1,-1));
                    }
                }
                IzakayaOrder izakayaOrder1 = IzakayaOrder.init();
                MIPlayerUtil.setTables(player,tables);
                MIPlayerUtil.syncTables(player);

                MIPlayerUtil.setIzakayaOrder(player,izakayaOrder1);
                MIPlayerUtil.syncIzakayaOrder(player);

                cuisineList = izakayaOrder1.toCuisineStacks();
                beverageList = izakayaOrder1.toBeverageStacks();
            }

//
//            Debug.getLogger().debug(player.getData(MIAttachment.MI_ON_OPEN).toString());
//            Debug.getLogger().debug(tables.toString());

            if(player.getData(MIAttachment.MI_ON_OPEN)&& (serverPlayer.level().getGameTime()% MICommonConfig.ORDER_REFRESH_INTERVAL.get()==0)){

                //MystiasIzakaya.LOGGER.debug("Try to add order");

                IzakayaMenu izakayaMenu = MIPlayerUtil.getIzakayaMenu(player);
                Set<ItemStack> beverages = new LinkedHashSet<>(izakayaMenu.toBeverageStacks());
                Set<ItemStack> cuisines = new LinkedHashSet<>(izakayaMenu.toCuisineStacks());

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
                        if(beverageList.get(tables.indexOf(pos)).isEmpty()&&cuisineList.get(tables.indexOf(pos)).isEmpty()){
                            ItemStack beverage = beverageslist.get((int) (Math.random() * beverages.size()));
                            ItemStack cuisine = cuisineslist.get((int) (Math.random() * cuisines.size()));
                            if(beverage.isEmpty()||cuisine.isEmpty()){
                                break;
                            }
                            IzakayaOrder.addOrder(beverage, cuisine, tables.indexOf(pos), serverPlayer);
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

                ItemStack cuisine = cuisineList.get(i);
                ItemStack beverage = beverageList.get(i);
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
                        IzakayaOrder.removeOrder(i,serverPlayer);
                        tableEntity.clearContent();
                        level.setBlockEntity(tableEntity);
//                        level.sendBlockUpdated(tables.get(i),level.getBlockState(tables.get(i)),level.getBlockState(tables.get(i)),3);
                        serverPlayer.closeContainer();
                        int cost = MIItemStackUtil.getCost(cuisine)+ MIItemStackUtil.getCost(beverage);
                        IntHolder intHolder = new IntHolder(cost);
                        OrderEvent.Complete complete = new OrderEvent.Complete(serverPlayer, cuisine, beverage, i, intHolder);
                        NeoForge.EVENT_BUS.post(complete);
                        if(MystiasIzakaya.kubeJsLoaded)
                            MIEventPoster.INSTANCE.post(complete);

                        MIBalanceUtil.table(player, intHolder.get());

                    }
                }
            }
        }
    }

}
