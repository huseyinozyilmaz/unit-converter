package org.huseyin.unitconverter.controllers;

import org.huseyin.unitconverter.model.ConversionResult;
import org.huseyin.unitconverter.services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @Autowired
    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @RequestMapping("/gbp/{gbp}")
    public ConversionResult convertToEuro(@PathVariable("gbp") double gbp) {
        return new ConversionResult(gbp, currencyConversionService.poundToEuro(gbp));
    }

    @RequestMapping("/eur/{eur}")
    public ConversionResult convertToPound(@PathVariable("eur") double eur) {
        return new ConversionResult(eur, currencyConversionService.euroToPound(eur));
    }
}
