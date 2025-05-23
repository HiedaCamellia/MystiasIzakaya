package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.toast.ComponentToastWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MICustomButton;
import org.hiedacamellia.mystiasizakaya.core.network.DonationTakeOutS2SMessage;
import org.hiedacamellia.mystiasizakaya.core.util.MIBalanceUtil;

public class DonationScreen extends Screen {
    protected EditBox input;
    protected Button button_take_out;
    protected ComponentToastWidget toast;

    private int leftPos;
    private int topPos;
    private int imageWidth;
    private int imageHeight;

    public DonationScreen() {
        super(Component.empty());
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        input.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderLabels(guiGraphics, mouseX, mouseY);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        if (input.isFocused())
            return input.keyPressed(key, b, c);
        return super.keyPressed(key, b, c);
    }

    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(leftPos, topPos, 0);

        String title = Component.translatable("gui.mystias_izakaya.donation_ui.donation").getString();

        guiGraphics.drawString(this.font, title, 88- font.width(title) / 2, 24, -12829636,false);

        String text = Component.translatable("gui.mystias_izakaya.balance").getString() + new java.text.DecimalFormat("#######")
                .format(MIBalanceUtil.getBalance(this.minecraft.player)) + " \u5186";

        guiGraphics.drawString(this.font,
                text, 88 - font.width(text) / 2, 42, -12829636,false);
        pose.popPose();
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.leftPos = centerX - this.imageWidth / 2;
        this.topPos = centerY - this.imageHeight / 2;


        input = new EditBox(this.font, this.leftPos + 26, this.topPos + 58, 124, 18, Component.translatable("gui.mystias_izakaya.donation_ui.input")) {
            @Override
            public void insertText(String text) {
                super.insertText(text);
                if (getValue().isEmpty())
                    setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
                else
                    setSuggestion(null);
            }

            @Override
            public void moveCursorTo(int pos, boolean selected) {
                super.moveCursorTo(pos, selected);
                if (getValue().isEmpty())
                    setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
                else
                    setSuggestion(null);
            }
        };
        input.setSuggestion(Component.translatable("gui.mystias_izakaya.donation_ui.input").getString());
        input.setMaxLength(100);
        this.addWidget(this.input);

        button_take_out = new MICustomButton.builder(Component.translatable("gui.mystias_izakaya.donation_ui.button_take_out"), e -> {
            if(!input.getValue().isEmpty()) {
                try {
                    PacketDistributor.sendToServer(new DonationTakeOutS2SMessage(Integer.parseInt(input.getValue())));
                }catch (NumberFormatException ex){
                    toast.reset(Component.translatable("gui.mystias_izakaya.donation_ui.error_input"));
                }
            }
        }).pos(this.leftPos + 33, this.topPos + 100).size( 110, 20).build();
        this.addRenderableWidget(button_take_out);


        this.toast = new ComponentToastWidget(this.leftPos + imageWidth/2, this.topPos + 140, 75, 20,20.0f, Component.empty());
        this.addRenderableWidget(toast);
    }
}
