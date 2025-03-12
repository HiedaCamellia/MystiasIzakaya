package org.hiedacamellia.mystiasizakaya.util;

import org.hiedacamellia.immersiveui.client.util.holder.IValueHolder;

public class RateHolder implements IValueHolder<Double> {
    private double rate;

    public void set(Double rate) {
        this.rate = rate;
    }

    public Double get() {
        return rate;
    }

    public RateHolder(){
        this.rate=0;
    }
    public RateHolder(double i){
        this.rate=i;
    }
}
