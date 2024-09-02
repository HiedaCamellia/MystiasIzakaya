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
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.orders.Addorder;
import org.hiedacamellia.mystiasizakaya.content.orders.Deleteorder;
import org.hiedacamellia.mystiasizakaya.core.codec.record.*;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        if (!event.getEntity().hasData(MIAttachment.MI_BALANCE)) {
            event.getEntity().setData(MIAttachment.MI_BALANCE, new MIBalance(0));
        }
        if (!event.getEntity().hasData(MIAttachment.MI_TURNOVER)) {
            event.getEntity().setData(MIAttachment.MI_TURNOVER, new MITurnover(new ArrayList<>(),new ArrayList<>()));
        }
        if(player instanceof ServerPlayer){
            MIBalance miBalance = player.getData(MIAttachment.MI_BALANCE);
            miBalance.sync(player);
            MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
            miOrders.sync(player);
            MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
            miTurnover.sync(player);
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
            MIOrders miOrders = player.getData(MIAttachment.MI_ORDERS);
            List<BlockPos> tables = miOrders.blockPos();
            if(player.getData(MIAttachment.MI_ON_OPEN)){
                MIOrders miBar = player.getData(MIAttachment.MI_BAR);
                ItemStack beverage = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miBar.beverages().get((int)(Math.random()*miBar.beverages().size())).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                ItemStack cuisine = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miBar.orders().get((int)(Math.random()*miBar.orders().size())).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();

                for(BlockPos pos : tables){
                    if(pos==null){
                        continue;
                    }
                    if(Math.random()<0.0029){
                        Addorder.execute(beverage,cuisine,tables.indexOf(pos),serverPlayer);
                        break;
                    }
                }
            }
            for(int i = 0; i < tables.size();i++){
                ItemStack cuisine = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miOrders.orders().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                ItemStack beverage = BuiltInRegistries.ITEM.get(ResourceLocation.parse((miOrders.beverages().get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                Level level = serverPlayer.level();
                BlockEntity blockEntity =  level.getBlockEntity(tables.get(i));
                if(blockEntity instanceof TableEntity tableEntity){
                    List<ItemStack> itemStacks= tableEntity.getItems();
                    if(ItemStack.isSameItem(itemStacks.get(0),cuisine)&&ItemStack.isSameItem(itemStacks.get(1),beverage)){
                        Deleteorder.execute(i,serverPlayer);
                        int cost = cuisine.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost()+beverage.getOrDefault(MIDatacomponet.MI_COST,new MICost(0)).cost();
                        MIBalance miBalance = new MIBalance(serverPlayer.getData(MIAttachment.MI_BALANCE).balance()+cost);
                        serverPlayer.setData(MIAttachment.MI_BALANCE,miBalance);
                        PacketDistributor.sendToPlayer(serverPlayer,miBalance);
                    }
                }
            }
        }
    }
}
