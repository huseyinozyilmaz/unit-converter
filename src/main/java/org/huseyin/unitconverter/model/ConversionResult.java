package org.huseyin.unitconverter.model;

public class ConversionResult {
    private double from;
    private double to;

    public ConversionResult(double from, double to) {
        this.setFrom(from);
        this.setTo(to);
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }
}
