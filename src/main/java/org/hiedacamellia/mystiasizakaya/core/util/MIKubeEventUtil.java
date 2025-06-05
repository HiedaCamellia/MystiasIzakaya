package org.hiedacamellia.mystiasizakaya.core.util;


import org.hiedacamellia.mystiasizakaya.api.event.*;
import org.hiedacamellia.mystiasizakaya.api.kubejs.*;

public class MIKubeEventUtil {

    public static final MIKubeEventUtil INSTANCE = new MIKubeEventUtil();

    public void post(OrderEvent.Add event) {
        MystiasIzakayaJSEvents.ORDER_ADD.post(new OrderEventJS.Add(event));
    }
    public void post(OrderEvent.Remove event) {
        MystiasIzakayaJSEvents.ORDER_REMOVE.post(new OrderEventJS.Remove(event));
    }
    public void post(OrderEvent.Complete event) {
        MystiasIzakayaJSEvents.ORDER_COMPLETE.post(new OrderEventJS.Complete(event));
    }
    public void post(CookingCollectCuisineEvent event) {
        MystiasIzakayaJSEvents.COOKING_COLLECT_CUISINE.post(new CookingCollectCuisineEventJS(event));
    }
    public void post(CookingTagEvent.Build event) {
        MystiasIzakayaJSEvents.COOKING_TAG_BUILD.post(new CookingTagEventJS.Build(event));
    }
    public void post(CookingTagEvent.Check.Pre event) {
        MystiasIzakayaJSEvents.COOKING_TAG_CHECK_PRE.post(new CookingTagEventJS.Check.Pre(event));
    }
    public void post(CookingTagEvent.Check.Post event) {
        MystiasIzakayaJSEvents.COOKING_TAG_CHECK_POST.post(new CookingTagEventJS.Check.Post(event));
    }
    public void post(CurrencyChangeEvent event) {
        MystiasIzakayaJSEvents.CURRENCY_CHANGE.post(new CurrencyChangeEventJS(event));
    }
    public void post(IzakayaEvent.ChangeIzakayaStatus event) {
        MystiasIzakayaJSEvents.IZAKAYA_STATUS_CHANGE.post(new ChangeIzakayaStatusEventJS(event));
    }


}
