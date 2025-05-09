package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.component.UnderLineComponentWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.LedgerItemWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MICustomButton;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIOnOpen;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

public class LedgerScreen extends Screen {

    private int leftPos;
    private int topPos;
    private int imageWidth;
    private int imageHeight;

    public LedgerScreen() {
        super(Component.empty());
        this.imageWidth = 120;
        this.imageHeight = 166;
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
    }


    @Override
    public void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.leftPos = centerX - this.imageWidth / 2;
        this.topPos = centerY - this.imageHeight / 2;
        LocalPlayer player = Minecraft.getInstance().player;

        Button on_open = new MICustomButton.builder(getComponent(player.getData(MIAttachment.MI_ON_OPEN).open()), e ->{
            boolean open = player.getData(MIAttachment.MI_ON_OPEN).open();
            Debug.getLogger().debug("on_open: "+!open);
            player.setData(MIAttachment.MI_ON_OPEN,new MIOnOpen(!open));
            PacketDistributor.sendToServer(new MIOnOpen(!open));
            e.setMessage(getComponent(!open));
        }).pos(this.leftPos+10,this.topPos+4).size(40,16).build();
        on_open.setTooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.ledger_ui.on_open")));
        this.addRenderableWidget(on_open);

        MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
        for(int i = 0; i < miTurnover.k().size(); i++){
            this.addRenderableWidget(new LedgerItemWidget(this.leftPos+10, this.topPos + 20 +14*i, miTurnover.k().get(i), miTurnover.v().get(i)));
        }

        Component component = Component.translatable("gui.mystias_izakaya.balance").append(Component.literal(new java.text.DecimalFormat("#######")
                .format(player.getData(MIAttachment.MI_BALANCE).balance())).append(Component.literal(" \u5186")));
        this.addRenderableWidget(new UnderLineComponentWidget(this.leftPos+imageWidth- font.width(component)-10, this.topPos +10, component));

        Component title = Component.translatable("gui.mystias_izakaya.ledger_ui.ledger");
        this.addRenderableWidget(new UnderLineComponentWidget(this.leftPos+imageWidth/2- font.width(title)/2, this.topPos - 14, title));

    }

    private Component getComponent(boolean open){
        if(open)
            return Component.translatable("gui.mystias_izakaya.ledger_ui.open");
        else
            return Component.translatable("gui.mystias_izakaya.ledger_ui.close");
    }
}
