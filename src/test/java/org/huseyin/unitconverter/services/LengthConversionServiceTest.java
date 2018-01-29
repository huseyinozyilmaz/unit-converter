package org.huseyin.unitconverter.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LengthConversionServiceTest {

    @Autowired
    LengthConversionService lengthConversionService;

    @Test
    public void centimetreToInch() throws Exception {
        double expected = 0.39370079;
        assertEquals("Centimetre to Inch conversion", expected, lengthConversionService.centimetreToInch(1), 0.01);
    }

    @Test
    public void inchToCentimetre() throws Exception {
        double expected = 2.54;
        assertEquals("Inch to Centimetre conversion", expected, lengthConversionService.inchToCentimetre(1), 0.01);
    }

}