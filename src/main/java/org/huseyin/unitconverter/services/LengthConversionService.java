package org.huseyin.unitconverter.services;

import org.springframework.stereotype.Service;

@Service
public class LengthConversionService {

    public LengthConversionService() {}

    public double centimetreToInch(double centimetre) {
        return centimetre * 0.39370079;
    }

    public double inchToCentimetre(double inch) {
        return inch * 2.54;
    }

}
