package org.hiedacamellia.mystiasizakaya.core.command;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.mystiasizakaya.common.menu.ItemPriceAddonMenu;

@EventBusSubscriber
public class ItemPriceAddonCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mystiasizakaya").then(Commands.literal("price_addon")
                .then(Commands.literal("open").executes(
                        context -> {
                            ServerPlayer serverPlayer = context.getSource().getPlayer();
                            if (serverPlayer != null) {
                                serverPlayer.openMenu(new SimpleMenuProvider(ItemPriceAddonMenu::new,Component.empty()));
                            }
                            return 1;
                        }
                        ))));
    }
}
