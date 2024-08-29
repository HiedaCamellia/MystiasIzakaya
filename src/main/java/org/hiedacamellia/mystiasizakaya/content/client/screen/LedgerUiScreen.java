package org.hiedacamellia.mystiasizakaya.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.LedgerUiMenu;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;

import java.util.HashMap;
import java.util.List;

public class LedgerUiScreen extends AbstractContainerScreen<LedgerUiMenu> {
    private final static HashMap<String, Object> guistate = LedgerUiMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    public LedgerUiScreen(LedgerUiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("mystias_izakaya:textures/screens/donation_ui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        String title = Component.translatable("gui.mystias_izakaya.ledger_ui.ledger").getString();

        guiGraphics.drawString(this.font, title, 88- font.width(title) / 2, 12, -12829636,false);

        String text = Component.translatable("gui.mystias_izakaya.balance").getString() + new java.text.DecimalFormat("#######")
                .format(MIPlayerEvent.getBalance(entity)) + " \u5186";

        guiGraphics.drawString(this.font,
                text, 88 - font.width(text) / 2, 25, -12829636,false);

        List<String> k = MIPlayerEvent.getTurnoverPre(entity);
        List<Integer> v = MIPlayerEvent.getTurnoverCha(entity);
        for(int i = 0; i < k.size(); i++){
            String key = Component.translatable("gui.mystias_izakaya.ledger_ui."+ k.get(i)).getString();
            String value = String.valueOf(Math.abs(v.get(i)));
            double vi = v.get(i);
            String op = Component.translatable("gui.mystias_izakaya.ledger_ui.outcome").getString();
            if(vi>0){
                op = Component.translatable("gui.mystias_izakaya.ledger_ui.income").getString();
            }
            guiGraphics.drawString(this.font,
                    op, 10, 40 + i * 10, -12829636,false);
            guiGraphics.drawString(this.font,
                    key, 40, 40 + i * 10, -12829636,false);
            guiGraphics.drawString(this.font,
                    value, 176 - 10 - font.width(value) , 40 + i * 10, -12829636,false);
        }


    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void init() {
        super.init();
    }
}
