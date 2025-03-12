package org.hiedacamellia.mystiasizakaya.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.immersiveui.client.graphic.gui.IUIGuiUtils;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.TelephoneUiMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MICost;
import org.hiedacamellia.mystiasizakaya.core.entry.MICustomButton;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItemButton;
import org.hiedacamellia.mystiasizakaya.core.entry.MIOutButton;
import org.hiedacamellia.mystiasizakaya.core.network.TelephoneUiButton;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.util.RandomItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneUiScreen extends AbstractContainerScreen<TelephoneUiMenu> {
    private final static HashMap<String, Object> guistate = TelephoneUiMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    private List<MIItemButton> select;
    private List<MIOutButton> selected;
    private MICustomButton refresh;
    private MICustomButton confirm;

    private int mode;

    private MIItemButton mode_i;
    private MIItemButton mode_b;

    private List<ItemStack> out;
    private List<Double> rate;
    private int cost;


    public TelephoneUiScreen(TelephoneUiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    //private static final ResourceLocation texture = ResourceLocation.parse("mystias_izakaya:textures/screens/base_ui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.02f, 0xD0ffffff);
        IUIGuiUtils.borderRoundRect(guiGraphics, this.leftPos + this.imageWidth - 86, this.topPos + 87,
                84, this.imageHeight-89, 0.05f, 0xfff0e0b0,0.02f,0x808b4513);
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

        String text = Component.translatable("gui.mystias_izakaya.balance").getString() + new java.text.DecimalFormat("#######")
                .format(entity.getData(MIAttachment.MI_BALANCE).balance()) + " \u5186";

        guiGraphics.drawString(this.font,
                text, 88 - font.width(text) / 2, 10, -12829636, false);

        int cost_all = 0;
        for (ItemStack itemStack : out) {
            cost_all += (int) (itemStack.getCount() * itemStack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost() * rate.get(out.indexOf(itemStack)));
        }
        cost = cost_all;

        Component cost = Component.translatable("gui.mystias_izakaya.telephone_ui.cost").append(String.valueOf(cost_all)).append(" \u5186");

        guiGraphics.drawString(this.font, cost.getString(), 10, 145, -12829636, false);

    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void init() {
        super.init();

        out = new ArrayList<>();
        select = new ArrayList<>();
        selected = new ArrayList<>();
        rate = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int finala = j + i * 4;
                select.add(new MIItemButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.select"), e -> {
                    ItemStack itemStack = select.get(finala).getItemStack();

                    ItemStack copy = itemStack.copy();
                    if(!Screen.hasShiftDown()){
                        copy.setCount(1);
                    }
                    addToOut(copy,select.get(finala).getRate());
                    itemStack.setCount(itemStack.getCount() - copy.getCount());

                    select.get(finala).setItemStack(itemStack);
                    int cost = (int) (itemStack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost()*select.get(finala).getRate());
                    if(!itemStack.isEmpty())
                        select.get(finala).setTooltip(Tooltip.create(Component.literal(itemStack.getHoverName().getString() + "\n" + itemStack.getCount() + "個\n" + cost+" \u5186")));
                    else
                        select.get(finala).setTooltip(null);
                    refreshOut();
                }).pos(leftPos + 10 + 20 * j, topPos + 30 + 20 * i).build());
            }
        }
        refreshItems();

        mode_i = new MIItemButton.builder(Component.empty(), e -> {
            mode = 1;
            mode_i.disableRender();
            mode_b.disableRender();
            refreshItems();
        }).pos(leftPos + 10, topPos + 30).itemStack(RandomItems.getRandomItems(MIItem.Ingredients.getEntries(), 1).getFirst())
                .tooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.telephone_ui.mode_i.desc"))).build();

        mode_b = new MIItemButton.builder(Component.empty(), e -> {
            mode = 2;
            mode_i.disableRender();
            mode_b.disableRender();
            refreshItems();
        }).pos(leftPos + 10, topPos + 50).itemStack(RandomItems.getRandomItems(MIItem.Beverages.getEntries(), 1).getFirst())
                .tooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.telephone_ui.mode_b.desc"))).build();



        refresh = new MICustomButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.refresh"), e -> {
            refreshItems();
            refreshOut();
        }).pos(leftPos + 10, topPos + 10 + 20 * 4).size(54, 20)
                .tooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.telephone_ui.refresh.desc"))).build();

        confirm = new MICustomButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.confirm"), e -> {
            PacketDistributor.sendToServer(new TelephoneUiButton(new ArrayList<>(out), new BlockPos(x, y, z),cost));
            //Debug.send(out.toString());
            out.clear();
            refreshOut();
            entity.closeContainer();
        }).pos(leftPos + 10, topPos + 15 + 20 * 5).size(54, 20)
                .tooltip(Tooltip.create(Component.translatable("gui.mystias_izakaya.telephone_ui.confirm.desc"))).build();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int finala = j + i * 5;
                selected.add(new MIOutButton.builder(Component.translatable("gui.mystias_izakaya.telephone_ui.select"), e -> {
                    ItemStack itemStack = selected.get(finala).getItemStack().copy();

                    ItemStack copy = itemStack.copy();
                    if(!Screen.hasShiftDown()){
                        copy.setCount(1);
                    }

                    addToSelct(copy,selected.get(finala).getRate());
                    deleteFromOut(copy);
                    refreshOut();
                }).pos(leftPos + imageWidth - 20 - 16 * j, topPos + imageHeight - 20 - 20 * i).build());
            }
        }
        refreshOut();

        for (Button button : select) {
            this.addRenderableWidget(button);
        }

        this.addRenderableWidget(refresh);
        this.addRenderableWidget(confirm);
        this.addRenderableWidget(mode_i);
        this.addRenderableWidget(mode_b);

        int size = selected.size();
        for (int i = 0; i < size; i++) {
            this.addRenderableWidget(selected.get(size - i - 1));
        }

    }

    private void refreshItems() {
        List<ItemStack> itemStacksIn = new ArrayList<>();
        switch (mode){
            case 1 -> itemStacksIn = RandomItems.getRandomItems(MIItem.Ingredients.getEntries(), 12);
            case 2 -> itemStacksIn = RandomItems.getRandomItems(MIItem.Beverages.getEntries(), 6);
        }
        if(mode==1){
            //有1.6%的概率
            if(Math.random()<0.016){
                itemStacksIn.set((int)(Math.random()*12),new ItemStack(MIItem.REISEN.get()));
            }
        }

        for (int i = 0; i < itemStacksIn.size(); i++) {
            select.get(i).setItemStack(itemStacksIn.get(i));
            select.get(i).setRate(0.6+0.4*Math.random());
            int cost = (int) (itemStacksIn.get(i).getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost()*select.get(i).getRate());
            select.get(i).setTooltip(Tooltip.create(Component.literal(itemStacksIn.get(i).getHoverName().getString() + "\n" + itemStacksIn.get(i).getCount() + "個\n" + cost+" \u5186")));
            select.get(i).enableRender();
        }
        for (int i = itemStacksIn.size(); i < 12; i++) {
            select.get(i).setItemStack(ItemStack.EMPTY);
            select.get(i).disableRender();
        }
        out.clear();
    }

    private void refreshOut() {
        List<ItemStack> itemStacksIn = out;
        List<Double> rate = this.rate;
        for (int i = 0; i < itemStacksIn.size(); i++) {
            selected.get(i).setItemStack(itemStacksIn.get(i));
            selected.get(i).setRate(rate.get(i));
            int cost = (int) (itemStacksIn.get(i).getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost()*selected.get(i).getRate());
            selected.get(i).setTooltip(Tooltip.create(Component.literal(itemStacksIn.get(i).getHoverName().getString() + "\n" + itemStacksIn.get(i).getCount() + "個\n" + cost+" \u5186")));
            selected.get(i).enableRender();
        }
        for (int i = itemStacksIn.size(); i < 20; i++) {
            selected.get(i).setItemStack(ItemStack.EMPTY);
            selected.get(i).disableRender();
        }
    }

    private void addToSelct(ItemStack stack,double rate) {
        if (ItemStack.isSameItem(stack, ItemStack.EMPTY))
            return;
        for (MIItemButton button : select) {
            if (button.getItemStack().getItem().equals(stack.getItem())) {
                button.getItemStack().setCount(button.getItemStack().getCount() + stack.getCount());
                int cost = (int) (stack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost() *button.getRate());
                button.setTooltip(Tooltip.create(Component.literal(button.getItemStack().getHoverName().getString() + "\n" + button.getItemStack().getCount() + "個\n" + cost+" \u5186")));
                return;
            }
        }
        for (MIItemButton button : select) {
            if (button.getItemStack().isEmpty()) {
                button.setItemStack(stack);
                button.setRate(rate);
                int cost = (int) (stack.getOrDefault(MIDatacomponet.MI_COST, new MICost(0)).cost() *button.getRate());
                button.setTooltip(Tooltip.create(Component.literal(button.getItemStack().getHoverName().getString() + "\n" + button.getItemStack().getCount() + "個\n" + cost+" \u5186")));
                return;
            }
        }
    }

    private void addToOut(ItemStack stack, double r) {
        if (ItemStack.isSameItem(stack, ItemStack.EMPTY))
            return;
        for (ItemStack itemStack : out) {
            if (itemStack.getItem().equals(stack.getItem())) {
                itemStack.setCount(itemStack.getCount() + stack.getCount());
                return;
            }
        }
        ItemStack itemStack = stack.copy();
        out.add(itemStack);
        rate.add(r);
    }

    private void deleteFromOut(ItemStack stack) {
        for (ItemStack itemStack : out) {
            if (itemStack.getItem().equals(stack.getItem())) {
                itemStack.setCount(itemStack.getCount() - stack.getCount());
                if (itemStack.getCount() <= 0) {
                    rate.remove(out.indexOf(itemStack));
                    out.remove(itemStack);
                }
                return;
            }
        }
    }
}
