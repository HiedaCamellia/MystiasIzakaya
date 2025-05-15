package org.hiedacamellia.mystiasizakaya.api.kubejs;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.api.event.CookingTagEvent;

import java.util.List;

public class CookingTagEventJS extends CookingEventJS{

    public CookingTagEventJS(CookingTagEvent event) {
        super(event);
    }

    public ItemStack getTarget() {
        return ((CookingTagEvent)event).getTarget();
    }

    public static class Build extends CookingTagEventJS{

        public Build(CookingTagEvent.Build event) {
            super(event);
        }
        public List<String> getTags() {
            return ((CookingTagEvent.Build)event).getTags();
        }

        public List<String> getNegativeTags() {
            return ((CookingTagEvent.Build)event).getNegativeTags();
        }

        public ItemStack getKitchenware() {
            return ((CookingTagEvent.Build)event).getKitchenware();
        }

        public List<ItemStack> getIngredients() {
            return ((CookingTagEvent.Build)event).getIngredients();
        }
    }

    public static abstract class Check extends CookingTagEventJS {


        public Check(CookingTagEvent.Check event) {
            super(event);
        }

        public static class Pre extends Check {

            public Pre(CookingTagEvent.Check.Pre event) {
                super(event);
            }
        }

        public static class Post extends Check {

            public Post(CookingTagEvent.Check.Post event) {
                super(event);
            }
        }

    }

}
