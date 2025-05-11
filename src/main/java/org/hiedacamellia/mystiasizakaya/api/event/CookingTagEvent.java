package org.hiedacamellia.mystiasizakaya.api.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;

import java.util.List;

public abstract class CookingTagEvent extends CookingEvent{

    private final ItemStack target;

    public CookingTagEvent(CookingEntity entity, Level level,ItemStack target) {
        super(entity, level);
        this.target = target;
    }

    public ItemStack getTarget() {
        return target;
    }
    public static class Build extends CookingTagEvent {

        private final List<String> tags;
        private final List<String> ntags;
        private final ItemStack Kitchenware;
        private final List<ItemStack> ingredients;

        public Build(CookingEntity entity, Level level, ItemStack target, ItemStack Kitchenware, List<ItemStack> ingredients, List<String> tags, List<String> ntags) {
            super(entity, level,target);
            this.tags = tags;
            this.ntags = ntags;
            this.Kitchenware = Kitchenware;
            this.ingredients = ingredients;
        }

        public List<String> getTags() {
            return tags;
        }

        public List<String> getNegativeTags() {
            return ntags;
        }


        public ItemStack getKitchenware() {
            return Kitchenware;
        }

        public List<ItemStack> getIngredients() {
            return ingredients;
        }
    }

    public static abstract class Check extends CookingTagEvent {

        public Check(CookingEntity entity, Level level, ItemStack target) {
            super(entity, level, target);
        }

        public static class Pre extends Check {
            public Pre(CookingEntity entity, Level level, ItemStack target) {
                super(entity, level, target);
            }
        }

        public static class Post extends Check {
            public Post(CookingEntity entity, Level level, ItemStack target) {
                super(entity, level, target);
            }
        }

    }
}
