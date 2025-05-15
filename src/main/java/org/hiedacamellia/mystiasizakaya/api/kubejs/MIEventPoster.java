package org.hiedacamellia.mystiasizakaya.api.kubejs;


import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.CookingCollectCuisineEvent;
import org.hiedacamellia.mystiasizakaya.api.event.CookingTagEvent;
import org.hiedacamellia.mystiasizakaya.api.event.CurrencyChangeEvent;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;

public class MIEventPoster {

    public static final MIEventPoster INSTANCE = new MIEventPoster();

    public void post(OrderEvent.Add event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new OrderEventJS.Add(event));
        }
    }
    public void post(OrderEvent.Remove event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new OrderEventJS.Remove(event));
        }
    }
    public void post(OrderEvent.Complete event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new OrderEventJS.Complete(event));
        }
    }
    public void post(CookingCollectCuisineEvent event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new CookingCollectCuisineEventJS(event));
        }
    }
    public void post(CookingTagEvent.Build event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new CookingTagEventJS.Build(event));
        }
    }
    public void post(CookingTagEvent.Check.Pre event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new CookingTagEventJS.Check.Pre(event));
        }
    }
    public void post(CookingTagEvent.Check.Post event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new CookingTagEventJS.Check.Post(event));
        }
    }
    public void post(CurrencyChangeEvent event){
        if(MystiasIzakaya.kubeJsLoaded) {
            post(new CurrencyChangeEventJS(event));
        }
    }



    public void post(OrderEventJS.Add event) {
        MystiasIzakayaJSEvents.ORDER_ADD.post(event);
    }
    public void post(OrderEventJS.Remove event) {
        MystiasIzakayaJSEvents.ORDER_REMOVE.post(event);
    }
    public void post(OrderEventJS.Complete event) {
        MystiasIzakayaJSEvents.ORDER_COMPLETE.post(event);
    }
    public void post(CookingCollectCuisineEventJS event) {
        MystiasIzakayaJSEvents.COOKING_COLLECT_CUISINE.post(event);
    }
    public void post(CookingTagEventJS.Build event) {
        MystiasIzakayaJSEvents.COOKING_TAG_BUILD.post(event);
    }
    public void post(CookingTagEventJS.Check.Pre event) {
        MystiasIzakayaJSEvents.COOKING_TAG_CHECK_PRE.post(event);
    }
    public void post(CookingTagEventJS.Check.Post event) {
        MystiasIzakayaJSEvents.COOKING_TAG_CHECK_POST.post(event);
    }
    public void post(CurrencyChangeEventJS event) {
        MystiasIzakayaJSEvents.CURRENCY_CHANGE.post(event);
    }


}
