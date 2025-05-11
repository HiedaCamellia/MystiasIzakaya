package org.hiedacamellia.mystiasizakaya.api.kubejs;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface MystiasIzakayaJSEvents {

    EventGroup EVENT_GROUP = EventGroup.of("MystiasIzakayaEvents");

    EventHandler ORDER_ADD = EVENT_GROUP.client("addOrder", ()->OrderEventJS.Add.class);
    EventHandler ORDER_REMOVE = EVENT_GROUP.client("removeOrder", ()->OrderEventJS.Remove.class);
    EventHandler ORDER_COMPLETE = EVENT_GROUP.client("completeOrder", ()->OrderEventJS.Complete.class);

    EventHandler COOKING_COLLECT_CUISINE = EVENT_GROUP.client("collectCuisine", ()->CookingCollectCuisineEventJS.class);

    EventHandler COOKING_TAG_BUILD = EVENT_GROUP.client("buildTag", ()->CookingTagEventJS.Build.class);

    EventHandler COOKING_TAG_CHECK_PRE = EVENT_GROUP.client("checkTagPre", ()->CookingTagEventJS.Check.Pre.class);
    EventHandler COOKING_TAG_CHECK_POST = EVENT_GROUP.client("checkTagPost", ()->CookingTagEventJS.Check.Post.class);

}
