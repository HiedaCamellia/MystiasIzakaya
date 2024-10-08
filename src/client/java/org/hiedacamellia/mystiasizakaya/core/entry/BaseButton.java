package org.hiedacamellia.mystiasizakaya.core.entry;

import net.minecraft.network.chat.Component;

import java.awt.*;

public class BaseButton extends Button {
    public BaseButton(int i, int j, int k, int l, Component component, OnPress onPress){
        super(i, j, k, l, component, onPress,DEFAULT_NARRATION);
    }
}
