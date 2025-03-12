package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.component.ComponentWidget;


public class LedgerItemWidget extends AbstractWidget {

    private static final Component income = Component.translatable("gui.mystias_izakaya.ledger_ui.income");
    private static final Component outcome = Component.translatable("gui.mystias_izakaya.ledger_ui.outcome");

    private GridLayout gridLayout;

    public LedgerItemWidget(int x,int y,String type, double amount) {
        this(x, y, 100, 12);
        amount = Math.abs(amount);
        GridLayout layout = new GridLayout();
        layout.defaultCellSetting().paddingTop(2).paddingBottom(2).paddingLeft(4);
        layout.addChild(new ComponentWidget(x,y,Component.translatable("gui.mystias_izakaya.ledger_ui."+type)),1,1);
        layout.addChild(new ComponentWidget(x,y,amount > 0?income:outcome),1,2);
        layout.addChild(new ComponentWidget(x,y,Component.literal(String.valueOf(amount))),1,3);
        layout.setPosition(x, y);
        layout.arrangeElements();
        gridLayout = layout;
    }

    private LedgerItemWidget(int x, int y, int width, int height) {
        super(x, y, width, height, Component.literal("LedgerItem"));
    }


    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float tick) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.getX(), this.getY()+this.height-4, this.width, 4, 0.02f, 0xFF523629);
        this.gridLayout.visitWidgets((widget) -> widget.render(guiGraphics, mouseX, mouseY, tick));
        RenderSystem.disableBlend();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
