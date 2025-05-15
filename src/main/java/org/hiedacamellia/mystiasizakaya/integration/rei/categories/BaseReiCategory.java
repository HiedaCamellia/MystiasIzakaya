package org.hiedacamellia.mystiasizakaya.integration.rei.categories;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseReiCategory<T extends BasicDisplay> implements DisplayCategory<T> {

    private final Component title;
    private final Renderer icon;

    public BaseReiCategory(Component title, Item item) {
        this.title = title;
        this.icon = EntryStacks.of(item);
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public Renderer getIcon() {
        return icon;
    }

    @Override
    public List<Widget> setupDisplay(T display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getMinX()+6, bounds.getMinY()+10);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        for (int i = 0; i < 5; i++) {
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 24 * i, startPoint.y )).entries(display.getInputEntries().get(i)).markInput());
        }
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 118, startPoint.y )));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 148, startPoint.y)).entries(display.getOutputEntries().get(0)).markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }

    @Override
    public int getDisplayWidth(T display) {
        return 176;
    }
}
