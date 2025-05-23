package org.hiedacamellia.mystiasizakaya.client.gui.widget.builder;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.UseAnim;
import org.hiedacamellia.mystiasizakaya.common.item.MIBaseItem;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;

import java.util.ArrayList;
import java.util.List;

public class BaseItemBuilder {
    private final Item.Properties properties;
    private UseAnim useAnimation=UseAnim.EAT;
    private List<String> tags = new ArrayList<>();
    private List<String> ntags = new ArrayList<>();
    private String tagprefix = "tag.mystias_izakaya.";
    private int cooktime=0;
    private int cost=0;

    public BaseItemBuilder(Item.Properties properties) {
        this.properties = properties;
    }

    public Item build(){
        return new MIBaseItem(properties
                .component(MIDatacomponet.MI_POSITIVE_TAGS.get(), tags)
                .component(MIDatacomponet.MI_NEGATIVE_TAGS.get(), ntags)
                .component(MIDatacomponet.MI_COOKTIME.get(), cooktime)
                .component(MIDatacomponet.MI_COST.get(), cost)
                ,useAnimation, tagprefix);
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
        this.cooktime = cooktime;
        return this;
    }

    public BaseItemBuilder cooktimes(int cooktimes){
        return cooktime(cooktimes*20);
    }

    public BaseItemBuilder cost(int cost){
        this.cost = cost;
        return this;
    }

    public BaseItemBuilder beverages(){
        this.tagprefix = "tag.mystias_izakaya.beverages.";
        return this;
    }

    public BaseItemBuilder useAnimation(UseAnim useAnimation){
        this.useAnimation = useAnimation;
        return this;
    }

    public BaseItemBuilder drink(){
        this.useAnimation = UseAnim.DRINK;
        return this;
    }

}
