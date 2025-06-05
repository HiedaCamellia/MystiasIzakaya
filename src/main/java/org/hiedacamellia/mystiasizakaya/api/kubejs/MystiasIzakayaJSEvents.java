package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface MystiasIzakayaJSEvents {

    EventGroup EVENT_GROUP = EventGroup.of("MystiasIzakayaEvents");

    EventHandler ORDER_ADD = EVENT_GROUP.server("addOrder", ()->OrderEventJS.Add.class);
    EventHandler ORDER_REMOVE = EVENT_GROUP.server("removeOrder", ()->OrderEventJS.Remove.class);
    EventHandler ORDER_COMPLETE = EVENT_GROUP.server("completeOrder", ()->OrderEventJS.Complete.class);

    EventHandler COOKING_COLLECT_CUISINE = EVENT_GROUP.server("collectCuisine", ()->CookingCollectCuisineEventJS.class);

    EventHandler COOKING_TAG_BUILD = EVENT_GROUP.server("buildTag", ()->CookingTagEventJS.Build.class);

    EventHandler COOKING_TAG_CHECK_PRE = EVENT_GROUP.server("checkTagPre", ()->CookingTagEventJS.Check.Pre.class);
    EventHandler COOKING_TAG_CHECK_POST = EVENT_GROUP.server("checkTagPost", ()->CookingTagEventJS.Check.Post.class);

    EventHandler CURRENCY_CHANGE = EVENT_GROUP.server("currencyChange", ()->CurrencyChangeEventJS.class);

    EventHandler IZAKAYA_STATUS_CHANGE = EVENT_GROUP.server("izakayaStatusChange", ()->ChangeIzakayaStatusEventJS.class);
}
