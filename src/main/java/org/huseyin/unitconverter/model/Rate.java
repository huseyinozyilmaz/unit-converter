package org.huseyin.unitconverter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {

    @JsonProperty("GBP")
    private double gbp;

    public Rate() {

    }

    public double getGbp() {
        return gbp;
    }

    public void setGbp(double gbp) {
        this.gbp = gbp;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "gbp=" + gbp +
                '}';
    }
}
