package org.hiedacamellia.mystiasizakaya.client.event;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.w2s.ExistW2SWidget;
import org.hiedacamellia.mystiasizakaya.client.util.MIClientUtil;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;

@EventBusSubscriber(modid = MystiasIzakaya.MODID,value = Dist.CLIENT)
public class MIClientEventsHandler {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        if(stack.isEmpty())return;

        String string = MIItemStackUtil.toString(stack);
        Integer price = ItemPriceAddon.getPrice(string);
        if(price!=null){
            event.getToolTip().add(Component.translatable("tooltip.mystias_izakaya.cost").append(String.valueOf(price)).withStyle(ChatFormatting.YELLOW));
        }
    }

    @SubscribeEvent
    public static void onLoggingOut(final ClientPlayerNetworkEvent.LoggingOut event) {
        ExistW2SWidget.removeALL();
    }

    @SubscribeEvent
    public static void onRecipeReceived(RecipesReceivedEvent event){
        MIClientUtil.setRecipeMap(event.getRecipeMap());
    }
}
