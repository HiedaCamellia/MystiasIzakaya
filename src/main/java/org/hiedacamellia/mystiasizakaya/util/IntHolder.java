package org.hiedacamellia.mystiasizakaya.util;

import org.hiedacamellia.immersiveui.client.util.holder.IValueHolder;

public class IntHolder implements IValueHolder<Integer> {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }

    @Override
    public void set(Integer value) {
        this.value = value;
    }
}
