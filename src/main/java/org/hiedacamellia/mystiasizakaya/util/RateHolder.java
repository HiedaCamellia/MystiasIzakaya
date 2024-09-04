package org.hiedacamellia.mystiasizakaya.util;

public class RateHolder {
    private double rate;

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public RateHolder(){
        this.rate=0;
    }
    public RateHolder(double i){
        this.rate=i;
    }
}
