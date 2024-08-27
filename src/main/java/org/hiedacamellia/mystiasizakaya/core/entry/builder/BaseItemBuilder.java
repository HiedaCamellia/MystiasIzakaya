package org.hiedacamellia.mystiasizakaya.core.entry.builder;

import net.minecraft.world.item.Item;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICooktime;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.List;

public class BaseItemBuilder {
    private Item.Properties properties;
    private List<String> tags = new ArrayList<>();
    private List<String> ntags = new ArrayList<>();
    private String tagprefix;

    public BaseItemBuilder(Item.Properties properties) {
        this.properties = properties;
        this.tagprefix = "tag.mystias_izakaya.";
    }

    public Item build(){
        return new MIItem(properties.component(MIDatacomponet.MI_TAGS.get(), new MITags(tags, ntags)), tagprefix);
    }

    public BaseItemBuilder tags(String[] tags){
        this.tags = List.of(tags);
        return this;
    }

    public BaseItemBuilder ntags(String[] ntags){
        this.ntags = List.of(ntags);
        return this;
    }

    public BaseItemBuilder tags(List<String> tags){
        this.tags = tags;
        return this;
    }

    public BaseItemBuilder ntags(List<String> ntags){
        this.ntags = ntags;
        return this;
    }

    public BaseItemBuilder cooktime(int cooktime){
        this.properties.component(MIDatacomponet.MI_COOKTIME.get(), new MICooktime(cooktime));
        return this;
    }

    public BaseItemBuilder cost(int cost){
        this.properties.component(MIDatacomponet.MI_COST.get(), new MICost(cost));
        return this;
    }

    public BaseItemBuilder beverages(){
        this.tagprefix = "tag.mystias_izakaya.beverages.";
        return this;
    }

}
