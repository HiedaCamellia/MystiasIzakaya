package org.hiedacamellia.mystiasizakaya.client.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

public class MINumberEditBox extends EditBox {

    public MINumberEditBox(int x, int y, int width, int height, Component message) {
        super(Minecraft.getInstance().font, x, y, width, height, message);
    }

    public int getInt() {
        try {
            return Integer.parseInt(getValue());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    public void setInt(int value) {
        setValue(String.valueOf(value));
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        if (Character.isDigit(codePoint)) {
            return super.charTyped(codePoint, modifiers);
        }
        return false;
    }
}
