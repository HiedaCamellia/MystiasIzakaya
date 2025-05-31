package org.hiedacamellia.mystiasizakaya.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.immersiveui.client.graphic.util.IUIGuiUtils;
import org.hiedacamellia.immersiveui.client.gui.component.widget.component.UnderLineComponentWidget;
import org.hiedacamellia.immersiveui.client.gui.component.widget.price.SimplePriceWidget;
import org.hiedacamellia.mystiasizakaya.client.gui.widget.MICustomButton;
import org.hiedacamellia.mystiasizakaya.common.menu.ItemPriceAddonMenu;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemPriceAddonScreen extends AbstractContainerScreen<ItemPriceAddonMenu> {

    private ItemPriceAddonMenu menu;

    private int leftPos;
    private int topPos;
    private int imageWidth;
    private int imageHeight;

    private UnderLineComponentWidget title;

    private MICustomButton left;
    private MICustomButton right;

    private List<SimplePriceWidget> list = new ArrayList<>();
    private MICustomButton add;

    private List<Pair<String,Integer>> map = new ArrayList<>();

    private int page = 0;

    private final int sPage = 6;

    public ItemPriceAddonScreen(ItemPriceAddonMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.menu = menu;
        this.imageWidth = 180;
        this.imageHeight = 166;

        Map<String, Integer> itemPriceMap = ItemPriceAddon.getItemPriceMap();
        itemPriceMap.forEach(((s, integer) -> {
            Pair<String, Integer> pair = Pair.of(s, integer);
            map.add(pair);
        }));
    }

    @Override
    public void onClose() {
        setChanged();
        super.onClose();
    }

    public void tryAccept(ItemStack itemStack){
        for (SimplePriceWidget SimplePriceWidget : list) {
            if (SimplePriceWidget.tryAccept(itemStack)) return;
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.enableBlend();
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos-1, this.topPos-1, this.imageWidth, this.imageHeight, 0.05f, 0xFFffffff);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos+1, this.topPos+1, this.imageWidth, this.imageHeight, 0.05f, 0xFF555555);
        IUIGuiUtils.fillRoundRect(guiGraphics, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.05f, 0xFFc6c6c6);
        RenderSystem.disableBlend();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics,mouseX,mouseY,partialTick);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    protected void renderSlot(GuiGraphics guiGraphics, Slot slot) {
        IUIGuiUtils.renderSlotBackground(guiGraphics,slot.x,slot.y);
        super.renderSlot(guiGraphics, slot);
    }

    @Override
    public void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.leftPos = centerX - this.imageWidth / 2;
        this.topPos = centerY - this.imageHeight / 2;

        left = new MICustomButton.builder(Component.literal("<"), button -> {
            setPageChanged();
            if(page>0) {
                page = Math.max(0, page - sPage);
                resetItemPriceWidget();
            }
        }).pos(leftPos + 10, topPos - 20).size(20, 16).build();
        right = new MICustomButton.builder(Component.literal(">"), button -> {
            setPageChanged();
            if(page + sPage <= map.size()){
                page += sPage;
                resetItemPriceWidget();
            }
        }).pos(leftPos + 150, topPos - 20).size(20, 16).build();

        resetItemPriceWidget();

        addRenderableWidget(left);
        addRenderableWidget(right);


        Component titlec = Component.translatable("gui.mystias_izakaya.price_addon_ui.title");
        title = new UnderLineComponentWidget(this.leftPos + imageWidth / 2 - font.width(titlec) / 2, this.topPos - 14, titlec);

        addRenderableWidget(title);
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        ItemStack draggingItem = menu.getCarried();
        tryAccept(draggingItem.copy());

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public void setPageChanged(){
        list.forEach(e->{
            int index = list.indexOf(e)+page;
            if(index!=-1) {
                if(index<map.size()){
                    map.remove(index);
                    map.add(index, Pair.of(MIItemStackUtil.toString(e.getItemStack()), e.getPrice()));
                }else {
                    map.add(Pair.of(MIItemStackUtil.toString(e.getItemStack()), e.getPrice()));
                }
            }else {
                map.add(Pair.of(MIItemStackUtil.toString(e.getItemStack()), e.getPrice()));
            }
        });
    }

    public void setChanged(){
        setPageChanged();
        Map<String, Integer> hashMap = new HashMap<>();
        map.forEach(stringIntegerPair -> hashMap.put(stringIntegerPair.getFirst(), stringIntegerPair.getSecond()));
        hashMap.remove(MIItemStackUtil.toString(ItemStack.EMPTY));
        ItemPriceAddon.setItemPriceMap(hashMap);
        ItemPriceAddon.save();
        ItemPriceAddon.send2Server();
    }

    public void resetItemPriceWidget(){
        list.forEach(this::removeWidget);
        list.clear();
        for (int i = page; i < map.size(); i++) {
            int pos = i-page;
            if(pos>=sPage) break;
            int x = leftPos+5;
            if(pos>=3){
                x += 90;
            }
            int y = topPos+5;
            y+= (pos%3)*25;

            String string = map.get(i).getFirst();
            int price = map.get(i).getSecond();

            SimplePriceWidget SimplePriceWidget = new SimplePriceWidget(x, y, MIItemStackUtil.fromString(string), price);
            list.add(SimplePriceWidget);
        }
        resetAddButton(list.size());
        list.forEach(this::addRenderableWidget);
    }

    public void resetAddButton(int pos){
        int x = leftPos+5;
        if(pos>=3){
            x += 90;
        }
        int y = topPos+5;
        y+= (pos%3)*25;

        removeWidget(add);
        if(pos>=6){
            return;
        }
        add = new MICustomButton.builder(Component.literal("+"), button -> {
            SimplePriceWidget SimplePriceWidget = new SimplePriceWidget(button.getX(), button.getY());
            list.add(SimplePriceWidget);
            addRenderableWidget(SimplePriceWidget);
            resetAddButton(list.size());
        }).pos(x, y).size(80, 20).build();
        addRenderableWidget(add);
    }
}
