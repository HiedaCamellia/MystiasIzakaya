package org.hiedacamellia.mystiasizakaya.integration.rei.draggable;

import me.shedaniel.rei.api.client.gui.drag.DraggableStack;
import me.shedaniel.rei.api.client.gui.drag.DraggableStackVisitor;
import me.shedaniel.rei.api.client.gui.drag.DraggedAcceptorResult;
import me.shedaniel.rei.api.client.gui.drag.DraggingContext;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.LedgerScreen;

public class LedgerScreenDraggableStackVisitor implements DraggableStackVisitor<LedgerScreen> {
    @Override
    public boolean isHandingScreen(Screen screen) {
        return screen instanceof LedgerScreen;
    }

    @Override
    public DraggedAcceptorResult acceptDraggedStack(DraggingContext<LedgerScreen> context, DraggableStack stack) {
        LedgerScreen screen = context.getScreen();
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
