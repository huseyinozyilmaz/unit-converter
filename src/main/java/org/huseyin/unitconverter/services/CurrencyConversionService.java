package org.huseyin.unitconverter.services;

import org.huseyin.unitconverter.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConversionService {

    private static final Logger Log = LoggerFactory.getLogger(CurrencyConversionService.class);
    private RestTemplate restTemplate = new RestTemplate();

    public double poundToEuro(double pound) {
        return pound / getConversionRate();
    }

    public double euroToPound(double euro) {
        return euro * getConversionRate();
    }

    private double getConversionRate() {
        Currency currency = restTemplate.getForObject("https://api.fixer.io/latest?symbols=GBP", Currency.class);
        Log.info(currency.toString());

        return currency.getRates().getGbp();
    }
}
