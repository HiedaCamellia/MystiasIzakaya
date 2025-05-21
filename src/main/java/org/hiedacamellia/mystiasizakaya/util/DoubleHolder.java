package org.hiedacamellia.mystiasizakaya.util;

import org.hiedacamellia.immersiveui.client.util.holder.IValueHolder;

public class DoubleHolder implements IValueHolder<Double> {
    private double value;

    public void set(Double rate) {
        this.value = rate;
    }

    public Double get() {
        return value;
    }

    public DoubleHolder(){
        this.value =0;
    }
    public DoubleHolder(double i){
        this.value =i;
    }
}
