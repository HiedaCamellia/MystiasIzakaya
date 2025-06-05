package org.hiedacamellia.mystiasizakaya.core.util;


import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.*;

public class MIEventUtil {

    private static final Logger logger = LogManager.getLogger();

    public static void post(OrderEvent.Add event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order add event triggered: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order add event processed: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages());
        }
    }
    public static void post(OrderEvent.Remove event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order remove event triggered: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order remove event processed: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages());
        }
    }
    public static void post(OrderEvent.Complete event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order complete event triggered: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}, Earned: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages(),event.getEarned().get());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Order complete event processed: Order ID: {}, Player: {}, Cuisine: {}, Beverage: {}, Earned: {}",
                    event.getId(), event.getPlayer().getName().getString(), event.getCuisines(),event.getBeverages(),event.getEarned().get());
        }
    }
    public static void post(CookingCollectCuisineEvent event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking collect cuisine event triggered: Ingredients: {}, Util: {}, Result: {}",
                    event.getIngredients(), event.getUtil(), event.getResult());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking collect cuisine event processed: Result: {}", event.getResult());
        }
    }
    public static void post(CookingTagEvent.Build event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag build event triggered: Target: {}",
                    event.getTarget());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag build event processed: Result: {}", event.getTarget());
        }
    }
    public static void post(CookingTagEvent.Check.Pre event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag check pre event triggered: Target: {}",
                    event.getTarget());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag check pre event processed: Result: {}", event.getTarget());
        }
    }
    public static void post(CookingTagEvent.Check.Post event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag check post event triggered: Target: {}",
                    event.getTarget());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Cooking tag check post event processed: Result: {}", event.getTarget());
        }
    }
    public static void post(CurrencyChangeEvent event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Currency change event triggered: Player: {}, Change: {}, Type: {}",
                    event.getPlayer().getName().getString(), event.getAmount(), event.getType());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Currency change event processed: Player: {}, Change: {}, Type: {}",
                    event.getPlayer().getName().getString(), event.getAmount(), event.getType());
        }
    }
    public static void post(IzakayaEvent.ChangeIzakayaStatus event){
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Izakaya status change event triggered: Player: {}, New Status: {}",
                    event.getPlayer().getName().getString(), event.isOpen());
        }
        NeoForge.EVENT_BUS.post(event);
        if(MystiasIzakaya.kubeJsLoaded) {
            MIKubeEventUtil.INSTANCE.post(event);
        }
        if(MystiasIzakaya.isDebugMode()){
            logger.debug("Izakaya status change event processed: New Status: {}", event.isOpen());
        }
    }





}
