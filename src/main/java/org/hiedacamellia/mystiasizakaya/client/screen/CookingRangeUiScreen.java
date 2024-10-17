package org.hiedacamellia.mystiasizakaya.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.content.inventory.CookingRangeUiMenu;
import org.hiedacamellia.mystiasizakaya.core.cooking.ui.Lefttime;
import org.hiedacamellia.mystiasizakaya.core.cooking.ui.Status;
import org.hiedacamellia.mystiasizakaya.core.entry.BaseButton;
import org.hiedacamellia.mystiasizakaya.core.network.CookingRangeUiButton;
import org.hiedacamellia.mystiasizakaya.core.network.MINetWork;
import org.hiedacamellia.mystiasizakaya.util.ButtunShow;
import org.hiedacamellia.mystiasizakaya.util.TargetsText;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Environment(EnvType.CLIENT)
public class CookingRangeUiScreen extends AbstractContainerScreen<CookingRangeUiMenu> {
    private static final HashMap<String, Object> guistate = CookingRangeUiMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final BlockPos pos;
    private final Player entity;
    Button button_confirm;
    List<Button> selects;
    Button button_next;
    Button button_back;
    List<Slot> slots;

    public CookingRangeUiScreen(CookingRangeUiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.pos = Pos.get(x, y, z);
        this.entity = container.entity;
        this.imageWidth = 280;
        this.imageHeight = 166;
        this.slots= container.customSlots;
    }

    private static final ResourceLocation texture = new ResourceLocation(
            "mystias_izakaya:textures/screens/cooking_range_ui.png");

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
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth,
                this.imageHeight);
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
    public void containerTick() {
        super.containerTick();
        for(int i=0;i<5;i++){
            selects.get(i).setMessage(Component.literal(slots.get(7 + i).getItem().getDisplayName().getString()));
            selects.get(i).visible = slots.get(7 + i).hasItem();
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Status.execute(world, pos), 233, 26, -1, false);
        guiGraphics.drawString(this.font, Lefttime.execute(world, pos), 238, 65, -1, false);
    }

    @Override
    public void onClose() {
        super.onClose();
    }



    @Override
    public void init() {
        super.init();
        selects = new ArrayList<>();
        button_confirm = Button
                .builder(Component.translatable("gui.mystias_izakaya.cooking_range_ui.button_confirm"), e -> {
                    if (true) {
                        MINetWork.PACKET_HANDLER.sendToServer(new CookingRangeUiButton(0, x, y, z));
                        CookingRangeUiButton.handleButtonAction(entity, 0, pos);
                    }
                }).bounds(this.leftPos + 94, this.topPos + 60, 90, 20).build();


        for(int i = 0;i<5;i++) {
            int finalI = i;
            selects.add(new BaseButton(this.leftPos + 40, this.topPos + 24 + 27*i, 45, 20, Component.literal(""), e -> {
                MINetWork.PACKET_HANDLER.sendToServer(new CookingRangeUiButton(finalI+1, x, y, z));
                CookingRangeUiButton.handleButtonAction(entity, finalI+1, pos);

            }));
            selects.get(i).visible=false;
        }


        button_next = Button.builder(Component.translatable("gui.mystias_izakaya.cooking_range_ui.button_next"), e -> {
            MINetWork.PACKET_HANDLER.sendToServer(new CookingRangeUiButton(6, x, y, z));
            CookingRangeUiButton.handleButtonAction(entity, 6, pos);

        }).bounds(this.leftPos + 26, this.topPos + 5, 15, 15).build();
        button_back = Button.builder(Component.translatable("gui.mystias_izakaya.cooking_range_ui.button_back"), e -> {
            MINetWork.PACKET_HANDLER.sendToServer(new CookingRangeUiButton(7, x, y, z));
            CookingRangeUiButton.handleButtonAction(entity, 7, pos);

        }).bounds(this.leftPos + 10, this.topPos + 5, 15, 15).build();

        guistate.put("button:button_confirm", button_confirm);
        guistate.put("button:button_next", button_next);
        guistate.put("button:button_back", button_back);
        this.addRenderableWidget(button_confirm);
        this.addRenderableWidget(button_next);
        this.addRenderableWidget(button_back);
        for(int i = 0;i<5;i++) {
            guistate.put("button:button_select"+i, selects.get(i));
            this.addRenderableWidget( selects.get(i));
        }

    }
}
