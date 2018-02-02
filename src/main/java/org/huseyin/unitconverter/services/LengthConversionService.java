package org.huseyin.unitconverter.services;

import org.springframework.stereotype.Service;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class LengthConversionService {

    public LengthConversionService() {}

    public double centimetreToInch(double centimetre) {
        delay();
        return centimetre * 0.39370079;
    }

    public double inchToCentimetre(double inch) {
        delay();
        return inch * 2.54;
    }

    private void delay() {
        try {
            SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
