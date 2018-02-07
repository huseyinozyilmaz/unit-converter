package org.huseyin.unitconverter.controllers;

import org.huseyin.unitconverter.model.ConversionResult;
import org.huseyin.unitconverter.services.LengthConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LengthConversionController {

    private final LengthConversionService lengthConversionService;

    @Autowired
    public LengthConversionController(LengthConversionService lengthConversionService) {
        this.lengthConversionService = lengthConversionService;
    }

    @RequestMapping("/centimetre/{centimetre}")
    public ConversionResult convertToInch(@PathVariable("centimetre") double centimetre) {
        return new ConversionResult(centimetre, lengthConversionService.centimetreToInch(centimetre));
    }

    @RequestMapping("/inch/{inch}")
    public ConversionResult convertToCentimetre(@PathVariable("inch") double inch) {
        return new ConversionResult(inch, lengthConversionService.inchToCentimetre(inch));
    }
}
