package org.huseyin.unitconverter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    private String base;
    private Rate rates;

    public Currency() {

    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rate getRates() {
        return rates;
    }

    public void setRates(Rate rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
