package org.hiedacamellia.mystiasizakaya.integration.rei.draggable;

import me.shedaniel.rei.api.client.gui.drag.DraggableStack;
import me.shedaniel.rei.api.client.gui.drag.DraggableStackVisitor;
import me.shedaniel.rei.api.client.gui.drag.DraggedAcceptorResult;
import me.shedaniel.rei.api.client.gui.drag.DraggingContext;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.ItemPriceAddonScreen;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.LedgerScreen;

public class ItemPriceAddonScreenDraggableStackVisitor implements DraggableStackVisitor<ItemPriceAddonScreen> {
    @Override
    public boolean isHandingScreen(Screen screen) {
        return screen instanceof ItemPriceAddonScreen;
    }

    @Override
    public DraggedAcceptorResult acceptDraggedStack(DraggingContext<ItemPriceAddonScreen> context, DraggableStack stack) {
        ItemPriceAddonScreen screen = context.getScreen();
        try {
            if (stack.get().castValue() instanceof ItemStack itemStack) {
                screen.tryAccept(itemStack);
                return DraggedAcceptorResult.PASS;
            }
        }catch (ClassCastException ignored) {
            // Ignore
        }

        return DraggedAcceptorResult.PASS;
    }
}
